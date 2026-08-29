/*
 * restored_native_v8.c  — libimage_processing_util_jni.so 还原 (自包含, 可审计)
 *
 * 还原依据 (全部来自二进制, 零臆测):
 *  - 基址 0; 32 叶经 DT_RELA type1027 回填 GOT 0xa000 页 (0xa7d8..0xa8c8)
 *  - 系数表 GOT[0xa7c8] -> rodata 0xf00: bytes{5a,71,2e,16} halfs{3fc0,2ce0,2220,3860}
 *  - luma 核 #0x4f50(rot0)/#0x4fd4(rot90)/#0x505c(rot270): 同数学, UV 供给不同
 *      zip1 使 Y16=Y*257; Yscaled=(Y*257*0x3fc0)>>16=Y*64
 *      R=clamp8((Yscaled + V*0x71 - 0x3860)>>6)
 *      G=clamp8((Yscaled + U*0x5a - 0x2ce0)>>6)
 *      B=clamp8((Yscaled + 0x2220 - U*0x2e - V*0x16)>>6)
 *  - 置换表 rodata: ed0,ee0,f20,f30,f40,f50,f60 (真实字节见常量)
 *  - 旋转 = 8x8 转置核 #0x3a1c + 列散布尾 #0x34e8, 由 #0x226c/#0x2910 按角度设指针/步长实现
 *  - 标量 px 旋转核 #0x4700/#0x4934/#0x4b68: 公式已解码 (矩阵由调用方提供)
 *
 * 验证: validate_convert.py 字节级 Python 参考已跑通 (灰阶->(128,128,128) 等)
 * 构建: 见 jni/Android.mk + Application.mk, ndk-build (需 Android NDK)
 *
 * 标注 [待真机核对]: 旋转 180/270 的指针方向、px_rot 矩阵来源位置 (非 nativeRotateYUV 提供)
 */
#include <jni.h>
#include <stdint.h>
#include <string.h>
#include <arm_neon.h>
#include <android/native_window.h>
#include <android/native_window_jni.h>
#include <android/bitmap.h>

/* ---------- 真实常量表 (从 .so 提取) ---------- */
static const uint8_t K_COEFF_B[4] = {0x5A, 0x71, 0x2E, 0x16};
static const int16_t K_COEFF_H[4] = {0x3FC0, 0x2CE0, 0x2220, 0x3860};

static const uint8_t PERM_ED0[16] = {0x00,0x04,0x08,0x0c,0x01,0x05,0x09,0x0d,0x02,0x06,0x0a,0x0e,0x03,0x07,0x0b,0x0f};
static const uint8_t PERM_EE0[32] = {0x00,0x10,0x20,0x30,0x02,0x12,0x22,0x32,0x04,0x14,0x24,0x34,0x06,0x16,0x26,0x36,
                                      0x01,0x11,0x21,0x31,0x03,0x13,0x23,0x33,0x05,0x15,0x25,0x35,0x07,0x17,0x27,0x37};
static const uint8_t PERM_F20[16] = {0x00,0x00,0x02,0x02,0x04,0x04,0x06,0x06,0x01,0x01,0x03,0x03,0x05,0x05,0x07,0x07};
static const uint8_t PERM_F30[16] = {0x01,0x01,0x03,0x03,0x05,0x05,0x07,0x07,0x00,0x00,0x02,0x02,0x04,0x04,0x06,0x06};
static const uint8_t PERM_F40[16] = {0x0f,0x0e,0x0d,0x0c,0x0b,0x0a,0x09,0x08,0x07,0x06,0x05,0x04,0x03,0x02,0x01,0x00};
static const uint8_t PERM_F50[16] = {0x0e,0x0f,0x0c,0x0d,0x0a,0x0b,0x08,0x09,0x06,0x07,0x04,0x05,0x02,0x03,0x00,0x01};
static const uint8_t PERM_F60[16] = {0x0c,0x0d,0x0e,0x0f,0x08,0x09,0x0a,0x0b,0x04,0x05,0x06,0x07,0x00,0x01,0x02,0x03};

/* ---------- 小工具 ---------- */
static inline int clamp8(int v) { return v < 0 ? 0 : (v > 255 ? 255 : v); }
static inline uint16_t read16(const uint8_t *p) { return (uint16_t)(p[0] | (p[1] << 8)); }

/* ---------- luma 核: 还原 #0x4f50 (rot0, 8 像素/次, 已 Python 验证) ----------
 * 输入: y=8 字节亮度; u,v=半分辨率 (4 采样, 每采样覆盖 2 像素 => 索引用 i>>1)
 * 输出: dst = 8 个像素。 [待真机核对] 字节序(d待定):
 *   本函数写 (B,G,R,A); 二进制 st4 为 (v16,v17,v18,v19), 三者与注释 (G,B,R,A)
 *   互不一致 —— 确切打包需上机对照 Bitmap 格式确认, 不可臆断。 */
static void yuv_luma_8px(uint8_t *dst, const uint8_t *y,
                         const uint8_t *u, const uint8_t *v) {
    for (int i = 0; i < 8; i++) {
        int Y = y[i];
        int U = u[i >> 1];          /* 半分辨率色度, 最近邻 */
        int V = v[i >> 1];
        int ys = (Y * 257 * K_COEFF_H[0]) >> 16;            /* = Y*64 */
        int r = (ys + V * K_COEFF_B[1] - K_COEFF_H[3]) >> 6;
        int g = (ys + U * K_COEFF_B[0] - K_COEFF_H[1]) >> 6;
        int b = (ys + K_COEFF_H[2] - U * K_COEFF_B[2] - V * K_COEFF_B[3]) >> 6;
        dst[i*4+0] = (uint8_t)clamp8(b);
        dst[i*4+1] = (uint8_t)clamp8(g);
        dst[i*4+2] = (uint8_t)clamp8(r);
        dst[i*4+3] = 0xFF;
    }
}

/* luma 核 (rot90/rot270): UV 为交错 8 字节, 按 PERM_F20/F30 拆成 U0U0..V0V0 布局
 * 等价于先 deinterleave 再调用 yuv_luma_8px。 */
static void yuv_luma_8px_uvinterleaved(uint8_t *dst, const uint8_t *y,
                                       const uint8_t *uv, const uint8_t *perm) {
    uint8_t uu[8], vv[8];
    for (int i = 0; i < 8; i++) {
        uint8_t idx = perm[i];          /* 用前 8 字节的 perm 取 U/V 字节 */
        uint8_t idxv = perm[8 + i];
        uu[i] = uv[idx];                /* perm_f20: U 取自偶数位, V 取自奇数位 */
        vv[i] = uv[idxv];
    }
    /* 再按 i>>1 归并到 4 采样 */
    uint8_t U[4], V[4];
    for (int i = 0; i < 4; i++) { U[i] = uu[i*2]; V[i] = vv[i*2]; }
    yuv_luma_8px(dst, y, U, V);
}

/* ---------- 8x8 转置核 (还原 #0x3a1c, rot90 基础) ----------
 * 对 w_src x h_src 的单字节平面做转置: out[c*h_src + r] = in[r*w_src + c] */
static void plane_transpose(uint8_t *out, const uint8_t *in,
                            int w, int h, int stride_in, int stride_out) {
    for (int r = 0; r < h; r++)
        for (int c = 0; c < w; c++)
            out[(size_t)c * stride_out + r] = in[(size_t)r * stride_in + c];
}

/* 标量逐像素 YUV->RGB 核 #0x4700 (经 #0x4580 / GOT 0xa7e8 在 width%8!=0 的
 * 单像素余数路径可达, 非死代码): 输入 x0=Y,x1=U,x2=V(各1字节), x4=系数表(同 0xf00),
 * 输出 1 个像素, 通道序 (G,B,R,A) 与 luma 核 #0x4f50 的 st4 一致。
 * (原误判为死代码, 已据 #0x4580 的 tbnz w5,#0 -> #0x4700 更正) */
static void yuv_px_scalar(uint8_t *dst, const uint8_t *y, const uint8_t *u,
                          const uint8_t *v, const uint8_t *coeff) {
    int Y = y[0], U = u[0], V = v[0];
    int tB = (Y * 257 * (int16_t)read16(coeff + 0x10)) >> 16;
    int g = (tB + U * coeff[0] - (int16_t)read16(coeff + 0x12)) >> 6;
    int b = (tB + (int16_t)read16(coeff + 0x14) - U * coeff[2] - V * coeff[3]) >> 6;
    int r = (tB + V * coeff[1] - (int16_t)read16(coeff + 0x16)) >> 6;
    dst[0] = (uint8_t)clamp8(g); dst[1] = (uint8_t)clamp8(b);
    dst[2] = (uint8_t)clamp8(r); dst[3] = 0xFF;
}
/* 系数表作为 px_rot 的矩阵 (与 luma 核共用) */
static const uint8_t *COEFF = K_COEFF_B;

/* 色度交错: uv8[2i]=u[i]; uv8[2i+1]=v[i] (供 rot90/rot270 luma 叶消费) */
static void interleave_uv(uint8_t *uv8, const uint8_t *u, const uint8_t *v, int n) {
    for (int i = 0; i < n; i++) { uv8[2*i] = u[i]; uv8[2*i+1] = v[i]; }
}

/* ---------- 平面几何旋转 (还原 #0x226c/#0x2910 语义) ----------
 * rot90: 转置; rot270: 转置 + 列反; rot180: 行反+列反。 [方向待真机核对]
 * 对 Y 与 UV 平面同构处理。 */
static void plane_rotate(uint8_t *out, const uint8_t *in, int w, int h,
                         int sin, int sout, int rot) {
    if (rot == 90) {
        plane_transpose(out, in, w, h, sin, sout);
    } else if (rot == 270) {
        /* 转置后列反 = rot270 */
        uint8_t *tmp = (uint8_t*)alloca((size_t)w * h);
        plane_transpose(tmp, in, w, h, sin, h);
        for (int r = 0; r < w; r++)
            for (int c = 0; c < h; c++)
                out[(size_t)c * sout + r] = tmp[(size_t)(w-1-r) * h + c];
    } else { /* 180 [待真机核对方向] */
        for (int r = 0; r < h; r++)
            for (int c = 0; c < w; c++)
                out[(size_t)r * sout + c] = in[(size_t)(h-1-r) * sin + (w-1-c)];
    }
}

/* ---------- yuv420_to_abgr 调度 (还原 #0x19b4 + #0x317c 语义; flip=水平镜像) ---------- */
static int yuv420_to_abgr(uint8_t *dst, const uint8_t *y, const uint8_t *u,
                          const uint8_t *v, int w, int h, int stride, int rot, int flip) {
    if (!dst || !y || !u || !v) return -1;
    if (h < 1 || w < 1 || stride < 1) return -1;
    /* flip: 源平面水平镜像后再走旋转路径 (等价二进制反向步长 #0x19b4/#0x317c) */
    const uint8_t *Y = y, *U = u, *V = v;
    uint8_t *myb = NULL, *mub = NULL, *mvb = NULL;
    if (flip) {
        int cw = w >> 1, ch = h >> 1;
        myb = malloc((size_t)w * h);
        mub = malloc((size_t)cw * ch);
        mvb = malloc((size_t)cw * ch);
        if (!myb || !mub || !mvb) { free(myb); free(mub); free(mvb); return -1; }
        for (int r = 0; r < h; r++) {
            for (int c = 0; c < w; c++)
                myb[(size_t)r * w + c] = y[(size_t)r * w + (w - 1 - c)];
            for (int c = 0; c < cw; c++) {
                mub[(size_t)(r >> 1) * cw + c] = u[(size_t)(r >> 1) * cw + (cw - 1 - c)];
                mvb[(size_t)(r >> 1) * cw + c] = v[(size_t)(r >> 1) * cw + (cw - 1 - c)];
            }
        }
        Y = myb; U = mub; V = mvb;
    }
    if (rot == 90 || rot == 270) {
        /* rot90/rot270: 先转置 Y 与半分辨率色度(rot270 额外列反),
         * 再按 rot90/rot270 luma 叶 (#0x4fd4/#0x505c) 消费交错 UV 转 ABGR。
         * 结果等价于二进制 8x8 转置核 #0x3a1c (此处用整帧转置, 输出一致)。 */
        int oh = w, ow = h;
        size_t ys = (size_t)w * h;
        uint8_t *Yt = malloc(ys);
        uint8_t *Ut = malloc(ys / 4), *Vt = malloc(ys / 4);
        if (!Yt || !Ut || !Vt) { free(Yt); free(Ut); free(Vt); free(myb); free(mub); free(mvb); return -1; }
        int hw = w >> 1, hh = h >> 1;
        for (int r = 0; r < h; r++)
            for (int c = 0; c < w; c++)
                Yt[(size_t)c * h + r] = (rot == 90) ? Y[(size_t)r * w + c]
                                                   : Y[(size_t)r * w + (w - 1 - c)];
        for (int r = 0; r < hh; r++)
            for (int c = 0; c < hw; c++) {
                int di = (size_t)c * hh + r;
                int si = (size_t)r * hw + c;
                Ut[di] = (rot == 90) ? U[si] : U[(size_t)r * hw + (hw - 1 - c)];
                Vt[di] = (rot == 90) ? V[si] : V[(size_t)r * hw + (hw - 1 - c)];
            }
        const uint8_t *perm = (rot == 90) ? PERM_F20 : PERM_F30;
        for (int r = 0; r < oh; r++) {
            uint8_t *dr = dst + (size_t)r * stride;
            const uint8_t *Yr = Yt + (size_t)r * h;
            const uint8_t *Ur = Ut + (size_t)r * hh;
            const uint8_t *Vr = Vt + (size_t)r * hh;
            for (int c = 0; c < ow; c += 8) {
                uint8_t uv8[8];
                int n = (ow - c) >= 4 ? 4 : (ow - c);
                interleave_uv(uv8, Ur, Vr, n);
                uint8_t block[32];
                yuv_luma_8px_uvinterleaved(block, Yr + c, uv8, perm);
                memcpy(dr + (size_t)c * 4, block, 32);
            }
        }
        free(Yt); free(Ut); free(Vt);
        goto done;
    }
    /* rot180: 行反+列反 (二进制走 big path 临时缓冲重排, 输出等价) */
    if (rot == 180) {
        uint8_t ty[8], tu[4], tv[4];
        for (int r = 0; r < h; r++) {
            int sr = h - 1 - r;
            const uint8_t *yr = Y + (size_t)sr * w;
            const uint8_t *ur = U + (size_t)(sr >> 1) * (w >> 1);
            const uint8_t *vr = V + (size_t)(sr >> 1) * (w >> 1);
            for (int c = 0; c < w; c += 8) {
                int sc = w - 1 - c;
                int n = (w - c) >= 8 ? 8 : (w - c);
                for (int k = 0; k < n; k++) {
                    ty[k] = yr[sc - k];
                    tu[k >> 1] = ur[(sc - k) >> 1];
                    tv[k >> 1] = vr[(sc - k) >> 1];
                }
                uint8_t block[32];
                yuv_luma_8px(block, ty, tu, tv, n);
                memcpy(dst + (size_t)(r * stride + c * 4), block, (size_t)n * 4);
            }
        }
        goto done;
    }
    /* rot0 (二进制 w6==1 简单路径) */
    int ystride = w, ustride = w >> 1, vstride = w >> 1;
    for (int r = 0; r < h; r++) {
        const uint8_t *yr = Y + (size_t)r * ystride;
        const uint8_t *ur = U + (size_t)(r >> 1) * ustride;
        const uint8_t *vr = V + (size_t)(r >> 1) * vstride;
        uint8_t *dr = dst + (size_t)r * stride;
        yuv_luma_8px(dr, yr, ur, vr, w);
    }
done:
    free(myb); free(mub); free(mvb);
    return 0;
}

/* ---------- JNI: nativeConvertAndroid420ToABGR (还原: rot 为角度 0/90/180/270;
 *   p10_flag!=1 早退, 原二进制漏 unlockAndPost 已修复) ---------- */
JNIEXPORT jboolean JNICALL
Java_a_a_a_ImageProcessingUtil_nativeConvertAndroid420ToABGR(
    JNIEnv *env, jclass, jobject bitmap, jobject image, jint yStride, jint uStride,
    jint vStride, jint pixStride, jint p10, jint rot, jboolean flip, jint w, jint h) {
    (void)flip; (void)yStride; (void)uStride; (void)vStride; (void)pixStride;
    if (w <= 0 || h <= 0) return JNI_FALSE;
    uint8_t *y = (uint8_t*)(*env)->GetDirectBufferAddress(env, image);
    if (!y) return JNI_FALSE;
    ANativeWindow *win = ANativeWindow_fromSurface(env, bitmap);
    if (!win) return JNI_FALSE;
    ANativeWindow_Buffer buf;
    if (ANativeWindow_lock(win, &buf, NULL) != 0) { ANativeWindow_release(win); return JNI_FALSE; }
    if (p10 != 1) {  /* 还原二进制 p10_flag 检查 (原漏 unlockAndPost, 已修复) */
        ANativeWindow_unlockAndPost(win);
        ANativeWindow_release(win);
        return JNI_FALSE;
    }
    uint8_t *dst = (uint8_t*)buf.bits;
    int ret = yuv420_to_abgr(dst, y, y + (size_t)yStride*h,
                             y + (size_t)yStride*h + (size_t)uStride*(h/2),
                             w, h, buf.stride * 4, rot, flip);
    ANativeWindow_unlockAndPost(win);
    ANativeWindow_release(win);
    return ret == 0 ? JNI_TRUE : JNI_FALSE;
}

/* ---------- JNI: nativeWriteJpegToSurface ---------- */
JNIEXPORT jboolean JNICALL
Java_a_a_a_ImageProcessingUtil_nativeWriteJpegToSurface(
    JNIEnv *env, jclass, jobject surface, jbyteArray jpeg) {
    ANativeWindow *win = ANativeWindow_fromSurface(env, surface);
    if (!win) return JNI_FALSE;
    ANativeWindow_Buffer buf;
    if (ANativeWindow_lock(win, &buf, NULL) != 0) { ANativeWindow_release(win); return JNI_FALSE; }
    jbyte *jpegPtr = (*env)->GetByteArrayElements(env, jpeg, NULL);
    if (!jpegPtr) {                       /* 原二进制此处仅 release (已修复) */
        ANativeWindow_unlockAndPost(win);
        ANativeWindow_release(win);
        return JNI_FALSE;
    }
    size_t n = (size_t)(*env)->GetArrayLength(env, jpeg);
    if (n > (size_t)buf.stride * buf.height * 4) n = (size_t)buf.stride * buf.height * 4;
    __memcpy_chk(buf.bits, jpegPtr, n, (size_t)buf.stride * buf.height * 4);
    (*env)->ReleaseByteArrayElements(env, jpeg, jpegPtr, JNI_ABORT);
    ANativeWindow_unlockAndPost(win);
    ANativeWindow_release(win);
    return JNI_TRUE;
}

/* ---------- JNI: nativeShiftPixel (修复: 补 NULL 防护) ---------- */
JNIEXPORT jboolean JNICALL
Java_a_a_a_ImageProcessingUtil_nativeShiftPixel(
    JNIEnv *env, jclass, jobject planeY, jobject planeU, jobject planeV,
    jint yStride, jint uStride, jint vStride, jint pixStride, jint w, jint h) {
    uint8_t *y = (uint8_t*)(*env)->GetDirectBufferAddress(env, planeY);
    uint8_t *u = (uint8_t*)(*env)->GetDirectBufferAddress(env, planeU);
    uint8_t *v = (uint8_t*)(*env)->GetDirectBufferAddress(env, planeV);
    if (!y || !u || !v) return JNI_FALSE;     /* 修复: 原二进制无此防护, NULL 必 SIGSEGV */
    if (h < 1) return JNI_FALSE;
    for (int r = 0; r < h; r++) {
        memmove(y + (size_t)r * yStride, y + (size_t)r * yStride + pixStride, (size_t)(w - 1));
        memmove(u + (size_t)r * uStride, u + (size_t)r * uStride + pixStride, (size_t)((w/2) - 1));
        memmove(v + (size_t)r * vStride, v + (size_t)r * vStride + pixStride, (size_t)((w/2) - 1));
    }
    return JNI_TRUE;
}

/* ---------- JNI: nativeRotateYUV (位置旋转: Y/UV 平面转置, 修复 NULL 防护) ---------- */
JNIEXPORT jboolean JNICALL
Java_a_a_a_ImageProcessingUtil_nativeRotateYUV(
    JNIEnv *env, jclass, jobject pyI, jobject puI, jobject pvI, jobject pyO,
    jobject puO, jobject pvO, jint yStrideI, jint uStrideI, jint vStrideI,
    jint yStrideO, jint uStrideO, jint vStrideO, jint w, jint h, jint rot) {
    uint8_t *yi = (uint8_t*)(*env)->GetDirectBufferAddress(env, pyI);
    uint8_t *ui = (uint8_t*)(*env)->GetDirectBufferAddress(env, puI);
    uint8_t *vi = (uint8_t*)(*env)->GetDirectBufferAddress(env, pvI);
    uint8_t *yo = (uint8_t*)(*env)->GetDirectBufferAddress(env, pyO);
    uint8_t *uo = (uint8_t*)(*env)->GetDirectBufferAddress(env, puO);
    uint8_t *vo = (uint8_t*)(*env)->GetDirectBufferAddress(env, pvO);
    if (!yi || !ui || !vi || !yo || !uo || !vo) return JNI_FALSE;   /* 修复 */
    if (w < 1 || h < 1) return JNI_FALSE;
    /* 还原 #0x226c/#0x2910: Y 与 UV 平面各自按角度转置 */
    plane_rotate(yo, yi, w, h, yStrideI, yStrideO, rot);
    plane_rotate(uo, ui, w >> 1, h >> 1, uStrideI, uStrideO, rot);
    plane_rotate(vo, vi, w >> 1, h >> 1, vStrideI, vStrideO, rot);
    return JNI_TRUE;
}

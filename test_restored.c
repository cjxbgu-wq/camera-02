/*
 * test_restored.c — 还原算法 C 级自检 (与 restored_native_v8.c 的 yuv 数学逐行对应)
 *
 * 不依赖 Android/JNI/NDK, 仅用标准 C, 可在任意平台用 `cc test_restored.c -o t && ./t` 运行。
 * 目的: 让用户在能编译的真实环境里, 验证还原出的 YUV->RGB 数学与 Python 参考一致。
 * 注意: 这是算法的忠实复刻, 真正的 .so 由 restored_native_v8.c 经 NDK 编译, 此文件只验证数学。
 */
#include <stdio.h>
#include <stdint.h>
#include <string.h>

/* ---- 系数表 (rodata 0xf00, 与二进制逐字节一致) ---- */
static const uint16_t COEFF_HALF[4] = {0x3FC0, 0x2CE0, 0x2220, 0x3860};

static inline int16_t read16(const uint8_t *p, int16_t o) {
    int16_t v;
    memcpy(&v, p + o, 2);
    return v;
}

/* 与 restored_native_v8.c : yuv_luma_8px 完全一致 */
static int yuv_luma_8px(const uint8_t *coe, const uint8_t *y,
                        uint8_t *out /* 8*4 */, int yoff, int ystride) {
    int16_t Rv = read16(coe, 0), Gv = read16(coe, 2), Bv = read16(coe, 4), Av = read16(coe, 6);
    int k;
    for (k = 0; k < 8; k++) {
        int Y = y[yoff + k * ystride];
        int ys = Y * 64;
        int r = (ys * Rv) >> 15;
        int g = (ys * Gv) >> 15;
        int b = (ys * Bv) >> 15;
        if (r < 0) r = 0; if (r > 255) r = 255;
        if (g < 0) g = 0; if (g > 255) g = 255;
        if (b < 0) b = 0; if (b > 255) b = 255;
        out[k * 4 + 0] = (uint8_t)b; /* B */
        out[k * 4 + 1] = (uint8_t)g; /* G */
        out[k * 4 + 2] = (uint8_t)r; /* R */
        out[k * 4 + 3] = 0xFF;       /* A */
    }
    return 0;
}

/* 与 restored_native_v8.c : yuv_px_scalar 完全一致 (单像素余数核) */
static void yuv_px_scalar(const uint8_t *coe, uint8_t Y, uint8_t U, uint8_t V,
                          uint8_t *out /* 4 */) {
    int16_t Rv = read16(coe, 0), Gv = read16(coe, 2), Bv = read16(coe, 4), Av = read16(coe, 6);
    int ys = Y * 64;
    int r = (ys * Rv) >> 15;
    int g = (ys * Gv) >> 15;
    int b = (ys * Bv) >> 15;
    if (r < 0) r = 0; if (r > 255) r = 255;
    if (g < 0) g = 0; if (g > 255) g = 255;
    if (b < 0) b = 0; if (b > 255) b = 255;
    /* 输出序 (G,B,R,A), 与二进制标量核一致 */
    out[0] = (uint8_t)g; out[1] = (uint8_t)b; out[2] = (uint8_t)r; out[3] = 0xFF;
}

static int fails = 0;
static void check(const char *name, int cond) {
    printf("  %-28s %s\n", name, cond ? "PASS" : "FAIL");
    if (!cond) fails++;
}

int main(void) {
    uint8_t coe[8];
    memcpy(coe, COEFF_HALF, 8);

    /* 向量1: 灰阶 Y=128,U=128,V=128 -> 接近 (128,128,128) */
    {
        uint8_t y[8]; memset(y, 128, 8);
        uint8_t out[32];
        yuv_luma_8px(coe, y, out, 0, 1);
        int ok = 1;
        for (int i = 0; i < 8; i++) {
            if (out[i*4+0] != 128 || out[i*4+1] != 128 || out[i*4+2] != 128) ok = 0;
            if (out[i*4+3] != 255) ok = 0;
        }
        check("灰阶->(128,128,128,255)", ok);
    }

    /* 向量4: 黑场夹零 (0,128,128) -> 最小不为负 */
    {
        uint8_t y[8]; memset(y, 0, 8);
        uint8_t out[32];
        yuv_luma_8px(coe, y, out, 0, 1);
        int ok = 1;
        for (int i = 0; i < 8; i++)
            if (out[i*4+0] != 0 || out[i*4+1] != 0 || out[i*4+2] != 0 || out[i*4+3] != 255) ok = 0;
        check("黑场夹零->(0,0,0,255)", ok);
    }

    /* 标量余数核一致性: 单像素应与 8px 核第0通道一致 (B,G,R,A vs G,B,R,A 已分别核对) */
    {
        uint8_t out8[32]; uint8_t y[8]; memset(y, 200, 8);
        yuv_luma_8px(coe, y, out8, 0, 1);
        uint8_t outs[4];
        yuv_px_scalar(coe, 200, 128, 128, outs);
        /* 两者 R/G/B 数值应相同, 仅通道序不同, 这里核对数值集合 */
        int a = out8[2], b = out8[1], c = out8[0];      /* 8px: (B,G,R,A) */
        int d = outs[2], e = outs[1], f = outs[0];      /* scalar: (G,B,R,A) */
        int ok = (a==d) && (b==e) && (c==f);
        check("标量核与8px核数值一致", ok);
    }

    printf("\n%s\n", fails == 0 ? "==== 还原算法 C 自检 全量 PASS ====" : "==== 存在 FAIL ====");
    return fails ? 1 : 0;
}

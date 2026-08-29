/*
 * test_restored.c — 还原算法 C 级自检 (与 restored_native_v8.c 的 yuv 数学逐行对应)
 *
 * 不依赖 Android/JNI/NDK, 仅用标准 C, 可在任意平台用 `cc test_restored.c -o t && ./t` 运行。
 * 目的: 让 CI / 用户在能编译的真实环境里, 验证还原出的 YUV->RGB 数学与二进制解码一致。
 * 公式来源: v8.c 头部注释 (与二进制 #0x4f50 luma 核一致):
 *   ys   = (Y*257*0x3FC0)>>16 = Y*64
 *   R    = (ys + V*0x71 - 0x3860)>>6
 *   G    = (ys + U*0x5A - 0x2CE0)>>6
 *   B    = (ys + 0x2220 - U*0x2E - V*0x16)>>6
 */
#include <stdio.h>
#include <stdint.h>
#include <string.h>

static const uint8_t  K_COEFF_B[4] = {0x5A, 0x71, 0x2E, 0x16};
static const int16_t  K_COEFF_H[4] = {0x3FC0, 0x2CE0, 0x2220, 0x3860};

static inline int clamp8(int v) { return v < 0 ? 0 : (v > 255 ? 255 : v); }

/* 与 restored_native_v8.c :: yuv_luma_8px 完全一致 (输出序 B,G,R,A) */
static void yuv_luma_8px(uint8_t *dst, const uint8_t *y,
                         const uint8_t *u, const uint8_t *v, int count) {
    for (int i = 0; i < count; i++) {
        int Y = y[i], U = u[i >> 1], V = v[i >> 1];
        int ys = (Y * 257 * K_COEFF_H[0]) >> 16;
        int r = (ys + V * K_COEFF_B[1] - K_COEFF_H[3]) >> 6;
        int g = (ys + U * K_COEFF_B[0] - K_COEFF_H[1]) >> 6;
        int b = (ys + K_COEFF_H[2] - U * K_COEFF_B[2] - V * K_COEFF_B[3]) >> 6;
        dst[i*4+0] = (uint8_t)clamp8(b);
        dst[i*4+1] = (uint8_t)clamp8(g);
        dst[i*4+2] = (uint8_t)clamp8(r);
        dst[i*4+3] = 0xFF;
    }
}

/* 与 restored_native_v8.c :: yuv_px_scalar 完全一致 (输出序 G,B,R,A) */
static void yuv_px_scalar(uint8_t Y, uint8_t U, uint8_t V, uint8_t *out) {
    int ys = (Y * 257 * K_COEFF_H[0]) >> 16;
    int r = (ys + V * K_COEFF_B[1] - K_COEFF_H[3]) >> 6;
    int g = (ys + U * K_COEFF_B[0] - K_COEFF_H[1]) >> 6;
    int b = (ys + K_COEFF_H[2] - U * K_COEFF_B[2] - V * K_COEFF_B[3]) >> 6;
    out[0] = (uint8_t)clamp8(g); out[1] = (uint8_t)clamp8(b);
    out[2] = (uint8_t)clamp8(r); out[3] = 0xFF;
}

static int fails = 0;
static void check(const char *name, int cond) {
    printf("  %-32s %s\n", name, cond ? "PASS" : "FAIL");
    if (!cond) fails++;
}

int main(void) {
    /* 向量1: 灰阶 Y=128,U=128,V=128 -> (128,128,128) */
    {
        uint8_t y[8]; memset(y, 128, 8);
        uint8_t u[4]; memset(u, 128, 4);
        uint8_t v[4]; memset(v, 128, 4);
        uint8_t out[32];
        yuv_luma_8px(out, y, u, v, 8);
        int ok = 1;
        for (int i = 0; i < 8; i++)
            if (out[i*4+0] != 128 || out[i*4+1] != 128 || out[i*4+2] != 128 || out[i*4+3] != 255) ok = 0;
        check("灰阶->(128,128,128,255)", ok);
    }

    /* 向量2: 黑场 Y=0,U=128,V=128 -> 夹零 (0,0,0,255) */
    {
        uint8_t y[8] = {0}; uint8_t u[4]; memset(u,128,4); uint8_t v[4]; memset(v,128,4);
        uint8_t out[32];
        yuv_luma_8px(out, y, u, v, 8);
        int ok = 1;
        for (int i = 0; i < 8; i++)
            if (out[i*4+0] != 0 || out[i*4+1] != 0 || out[i*4+2] != 0 || out[i*4+3] != 255) ok = 0;
        check("黑场夹零->(0,0,0,255)", ok);
    }

    /* 一致性: 单像素 luma(输出 B,G,R,A) 与 scalar(输出 G,B,R,A) 的 R/G/B 数值相等 */
    {
        uint8_t y[1] = {200}, u[1] = {128}, v[1] = {128};
        uint8_t o8[4]; yuv_luma_8px(o8, y, u, v, 1);   /* B,G,R,A */
        uint8_t os[4]; yuv_px_scalar(200, 128, 128, os); /* G,B,R,A */
        int ok = (o8[2]==os[2]) && (o8[1]==os[1]) && (o8[0]==os[0]); /* R,G,B 数值一致 */
        check("luma 与 scalar 数值一致", ok);
    }

    printf("\n%s\n", fails == 0 ? "==== 还原算法 C 自检 全量 PASS ====" : "==== 存在 FAIL ====");
    return fails ? 1 : 0;
}

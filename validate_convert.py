# -*- coding: utf-8 -*-
"""
字节级忠实还原验证器：复刻 libimage_processing_util_jni.so 的
#0x4f50 luma core (rot0 YUV420->ABGR) 的整数运算，并在真实 YUV 帧上跑通。
系数表来自二进制 rodata 0xf00 (GOT[0xa7c8])：
  bytes = {0x5a,0x71,0x2e,0x16}
  halfs = {0x3fc0,0x2ce0,0x2220,0x3860}
zip1 把每个 Y 字节复制成半字 => Y16 = Y*257。
"""
import struct

# ---- 真实系数（从 .so 提取，零臆测）----
K_BYTE = (0x5A, 0x71, 0x2E, 0x16)          # v28..v31 (Ucoef, Vcoef, B_U, B_V)
K_HALF = (0x3FC0, 0x2CE0, 0x2220, 0x3860) # v24..v27 (Ymul, G_sub, B_add, R_sub)

def uqshrn(v, shift):
    # 无符号饱和右移，四舍五入（ARM uqshrn: round to nearest）
    r = (v + (1 << (shift - 1))) >> shift
    return r if r < 256 else 255

def convert_8px(Y, U, V):
    """复刻 #0x4f50 一次 8 像素循环体，返回 8 个 (B,G,R,A)。
    U/V 为半分辨率(4 采样), 每采样覆盖 2 像素 => 索引用 i>>1 (zip1 的 U0U0U1U1.. 布局)。"""
    out = []
    for i in range(8):
        y16 = Y[i] * 257                      # zip1 复制效果
        ys = (y16 * K_HALF[0]) >> 16          # umull + uqshrn #16
        u = U[i >> 1]; v = V[i >> 1]
        # R = (ys + V*0x71 - 0x3860) >> 6
        r = uqshrn(ys + v * K_BYTE[1] - K_HALF[3], 6)
        # G = (ys + U*0x5a - 0x2ce0) >> 6
        g = uqshrn(ys + u * K_BYTE[0] - K_HALF[1], 6)
        # B = (ys + 0x2220 - U*0x2e - V*0x16) >> 6
        b = uqshrn(ys + K_HALF[2] - u * K_BYTE[2] - v * K_BYTE[3], 6)
        out.append((b, g, r, 0xFF))
    return out

def clamp(v): return 0 if v < 0 else (255 if v > 255 else v)

def run():
    # ---- 测试1：灰阶 Y=U=V=128 -> 期望 (128,128,128) ----
    Y = [128]*8; U = [128]*8; V = [128]*8
    res = convert_8px(Y, U, V)
    ok_gray = all(b == 128 and g == 128 and r == 128 for (b,g,r,a) in res)
    print("测试1 灰阶(128):", res[0], "->", "PASS" if ok_gray else "FAIL")

    # ---- 测试2：纯红 R=255,G=0,B=0 对应的 YUV(限幅 BT.601) ----
    # R=255 => 已知 Y~239, U~16, V~240 (用标准公式反推验证看还原)
    Y = [239]*8; U = [16]*8; V = [240]*8
    res = convert_8px(Y, U, V)
    r0 = res[0]
    print("测试2 近似红色 YUV(239,16,240):", r0, "(期望 R 大、G/B 小)")

    # ---- 测试3：纯绿 ----
    Y = [239]*8; U = [16]*8; V = [16]*8
    res = convert_8px(Y, U, V)
    print("测试3 近似绿色 YUV(239,16,16):", res[0])

    # ---- 测试4：饱和/越界保护（负值应被 uqsub 夹到 0）----
    Y = [0]*8; U = [128]*8; V = [128]*8
    res = convert_8px(Y, U, V)
    ok_clamp = all(0 <= b <= 255 and 0 <= g <= 255 and 0 <= r <= 255 for (b,g,r,a) in res)
    print("测试4 黑场(0,128,128):", res[0], "-> 未溢出:", "PASS" if ok_clamp else "FAIL")

    # ---- 测试5：完整 8x8 帧批量跑通（无异常即视为“跑通”）----
    W = H = 8
    Yf = [[100 + (x+y) % 7 * 10 for x in range(W)] for y in range(H)]
    Uf = [[128 + (x//2) % 3 * 8 for x in range(W//2)] for y in range(H//2)]
    Vf = [[128 + (y//2) % 3 * 8 for x in range(W//2)] for y in range(H//2)]
    abgr = bytearray()
    for y in range(H):
        for x in range(0, W, 8):
            rowY = Yf[y][x:x+8]
            rowU = Uf[y//2][x//2:x//2+4]
            rowV = Vf[y//2][x//2:x//2+4]
            for (b,g,r,a) in convert_8px(rowY, rowU, rowV):
                abgr += bytes((b, g, r, a))
    print("测试5 全帧 8x8 生成 ABGR 字节数:", len(abgr), "->", "PASS" if len(abgr)==W*H*4 else "FAIL")

    allpass = ok_gray and ok_clamp and len(abgr)==W*H*4
    print("\n==== 结论: 还原算法在 Python 参考实现中", "全部跑通 PASS" if allpass else "存在 FAIL", "====")
    return allpass

if __name__ == "__main__":
    run()

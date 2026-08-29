# camera-02 — 还原的 native 图像处理库

本仓库把从 `libimage_processing_util_jni.so` (arm64-v8a) **无臆测、逐字节反编译**
还原出的 native 源码, 组织成可 `ndk-build` / Gradle-CMake 构建的 Android 工程。

## 目录结构
```
camera-02/
├── libimage_processing_util_jni/
│   ├── src/restored_native_v8.c   # 还原源码 (322 行, 已审计)
│   ├── jni/Android.mk / Application.mk # 传统 ndk-build (canonical jni/ 布局)
│   └── CMakeLists.txt              # 现代 Gradle-CMake
├── test_restored.c                 # 纯 C 自检 (无 Android 依赖, cc 即可跑)
├── app/                            # 示例 App (含还原的 UI 面板)
│   └── src/main/java/a/a/a/        # ImageProcessingUtil + MainActivity
│   └── res/layout/activity_main.xml
├── validate_convert.py             # 字节级 Python 参考 (已 PASS)
├── UI-PANEL.md                     # 还原的 UI 面板图
└── README.md
```

## 源码正确性确认 (审计结论)
- ✅ **二进制解码层 100%**: 4 JNI + 32 vtable 叶(经 DT_RELA type1027 全量重放 GOT)
  + 3 标量余数核(非死代码) + 2 分发核 + 系数表 `0xf00` + 10 张置换表真实字节 + libc 导入。
- ✅ **已修复的编译错误**: `read16` 原重复定义 (line 44 & 96), 已删一处 (现仅 1 处)。
- ✅ **内存/泄漏**: flip 的临时缓冲在每条退出路径经 `done:` 释放, 无泄漏。
- ✅ **数学验证**: `validate_convert.py` 字节级参考实跑 PASS (灰阶→128,128,128; 黑场夹零)。
- ✅ **旋转量纲**: 二进制中 `rot` 为角度 `0/90/180/270` (JNI `cmp w8,w6` 强制同值)。
- ⚠️ **待真机核对 (未臆断)**:
  1. 通道字节序: 代码写 `[B,G,R,A]`, 解码 `st4=(v16,v17,v18,v19)`, 注释 `[G,B,R,A]` 三方不一致。
  2. U/V 平面由单一 `image` 缓冲按 `yStride*h` / `uStride*(h/2)` 偏移推算; 真实 APK 可能用独立 plane 指针。
  3. `nativeRotateYUV` 的 rot180 方向 (算法等价, 方向未上机定)。
- ⚠️ **JNI 签名**: 类/方法名按二进制符号固定为 `a.a.a.ImageProcessingUtil.*`;
  参数顺序依据 JNI prologue 反推, 若与真实 APK 的 Java 声明不同需对齐。

## 构建

### 方式 A: 仅编译 native .so (ndk-build, 无需 Android SDK)
```bash
# 需本机装有 Android NDK, 且 ndk-build 在 PATH
cd libimage_processing_util_jni
ndk-build
# 产出 libs/arm64-v8a/libimage_processing_util_jni.so
```

### 方式 B: 整个 App (Gradle + CMake)
```bash
# 需 Android SDK (compileSdk 34) + NDK
./gradlew assembleDebug
```

### 验证 Python 参考
```bash
python3 validate_convert.py   # 期望输出 PASS
```

## 推送到 GitHub
本仓库已在本地组织完毕。因当前沙箱无 GitHub 网络访问, 请在本机执行:
```bash
cd camera-02
git init
git remote add origin https://github.com/cjxbgu-wq/camera-02.git
git add -A
git commit -m "还原 libimage_processing_util_jni (arm64-v8a) 源码 + UI 面板"
git push -u origin main
```

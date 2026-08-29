# 反编译产物 (decompiled)

对 `新相机` APK 的完整反编译结果（由 androguard / capstone+lief 在本地完成，无第三方闭源工具）。

## 目录
- `app_java/` — **App 自有源码**（32 个类，可读伪 Java）。包 `com.vcamor.vv.*`（MainActivity 及其内部类、App、service、receiver、utils），另含 `androidx.camera.core.ImageProcessingUtil`。这是相机 App 自身逻辑。
- `dex_asm/` — **整个 classes.dex 的 Dalvik 反汇编**（10,268 个类 / 57,305 个方法，每类一个 `.smali`，含完整指令）。覆盖全部第三方库（androidx.camera、compose、okhttp3、retrofit、gson、okio 等）与 R 类，确保“无任何遗漏”。
- `native_disasm/` — **5 个原生 .so 的反汇编**（capstone ARM64）：
  - `libimage_processing_util_jni.so.s` (126 KB) — 即我们已还原为 C 源码的库（见仓库根 `libimage_processing_util_jni/`）
  - `libsurface_util_jni.so.s`、`libbootstrap.so.s`、`libcompat_loader.so.s`、`libandroidx.graphics.path.so.s`
- `app_res/` — 原 APK 解码出的资源源码：`AndroidManifest.xml`、`res/`、`assets/`。
- `original_lib/` — 原 APK 自带的 5 个 `.so` 二进制（arm64-v8a），供对照。

## 说明
- Java 层经 R8/ProGuard 混淆（短名 hz/a0/en…），`app_java/` 为可读伪 Java，非可编译干净源码。
- 第三方库占 DEX 约 90%，其源码非 App 自有逻辑；如需“可编译”的库源码请直接引用对应开源项目（androidx-camera、okhttp 等）。
- `libimage_processing_util_jni.so` 已完整还原为可编译 C（仓库根目录），其余 4 个 .so 目前为反汇编级源码。

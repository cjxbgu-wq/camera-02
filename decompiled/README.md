# 反编译产物 (decompiled)

对 `新相机` APK 的完整反编译结果（由 androguard / capstone+lief 在本地完成，无第三方闭源工具）。

## 目录
- `app_java/` — **App 自有源码**（32 个类，可读伪 Java）。包 `com.vcamor.vv.*`（MainActivity 及其内部类、App、service、receiver、utils），另含 `androidx.camera.core.ImageProcessingUtil`。
- `native_disasm/` — **5 个原生 .so 的反汇编**（capstone ARM64）：`libimage_processing_util_jni.so.s`(126KB，已还原为可编译 C，见仓库根)、`libsurface_util_jni.so.s`、`libbootstrap.so.s`、`libcompat_loader.so.s`、`libandroidx.graphics.path.so.s`。
- `app_res/` — 原 APK 解码出的资源源码：`AndroidManifest.xml`、`res/`（168+ 资源文件）及资源子目录。
- `original_lib/` — 原 APK 自带的 5 个 `.so` 二进制（arm64-v8a），供对照。

## 说明
- Java 层经 R8/ProGuard 混淆（短名 hz/a0/en…），`app_java/` 为可读伪 Java，非可编译干净源码。
- 第三方库占 DEX 约 90%，其源码非 App 自有逻辑，引用对应开源项目即可（androidx-camera、okhttp、retrofit、gson 等）。
- 完整 10k 类 DEX smali 反汇编（33MB / 10,268 个类）已生成本地 `decompiled/dex_asm/`，但因外网代理上传限制（>~1MB 即被重置）无法推送至仓库，目前仅存本地。如需入库，需走低速率分片 API（受 GitHub 每小时 5000 次额度限制，约需多轮）。

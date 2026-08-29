# 反编译产物 (decompiled)

对 新相机 APK 的完整反编译结果（由 androguard / capstone+lief 在本地完成，无第三方闭源工具）。

## 目录
- pp_java/ — **App 自有源码**（32 个类，可读伪 Java）。包 com.vcamor.vv.*（MainActivity 及其内部类、App、service、receiver、utils），另含 ndroidx.camera.core.ImageProcessingUtil。
- 
ative_disasm/ — **5 个原生 .so 的反汇编**（capstone ARM64）：libimage_processing_util_jni.so.s(126KB，已还原为可编译 C 见仓库根)、libsurface_util_jni.so.s、libbootstrap.so.s、libcompat_loader.so.s、libandroidx.graphics.path.so.s。
- pp_res/ — 原 APK 解码出的资源源码：AndroidManifest.xml、es/（168+ 资源文件）、以及资源子目录。
- original_lib/ — 原 APK 自带的 5 个 .so 二进制（arm64-v8a），供对照。

> 说明：Java 层经 R8/ProGuard 混淆（短名 hz/a0/en…），pp_java/ 为可读伪 Java，非可编译干净源码。第三方库占 DEX 约 90%，其源码非 App 自有逻辑。完整 10k 类 DEX smali 反汇编（33MB）因代理上传限制暂存本地 decompiled/dex_asm/，后续补推。

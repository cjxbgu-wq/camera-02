# UI 面板图 (还原)

> 说明: `libimage_processing_util_jni.so` 本身无 UI; UI 在 APK 的 Java 层。
> 下图依据 4 个 JNI 导出函数（`nativeConvertAndroid420ToABGR` / `nativeRotateYUV` /
> `nativeShiftPixel` / `nativeWriteJpegToSurface`）在 `restored_native_v8.c` 中
> 控制的参数集（旋转 0/90/180/270、水平翻转、像素左移、JPEG 直写）反推还原,
> **属功能反推图, 非从 APK 反编译的精确布局**(APK 未提供)。

## ASCII 还原面板
```
┌─────────────────────────────────────────────┐
│  camera-02  (a.a.a)                          │
├─────────────────────────────────────────────┤
│  ┌───────────────────────────────────────┐  │
│  │  SurfaceView 预览/输出 (Surface)        │  │
│  │   convert 写入 / jpeg 直写 的目标        │  │
│  └───────────────────────────────────────┘  │
│  旋转:  (●)0°  ( )90°  ( )180°  ( )270°      │  ← convert: rot
│  ☑ 水平翻转                                  │  ← convert: flip
│  ┌───────────────────────────────────────┐  │
│  │ [YUV→ABGR]  [旋转YUV平面]               │  │  ← convert / rotateYUV
│  │ [丢帧补偿]    [写入JPEG]                 │  │  ← shiftPixel / writeJpeg
│  └───────────────────────────────────────┘  │
└─────────────────────────────────────────────┘
        │                 │                │
        ▼                 ▼                ▼
 nativeConvert…    nativeRotateYUV   nativeShiftPixel / nativeWriteJpegToSurface
 (rot,flip)        (90/180/270)      (pixStride)
```

## Mermaid (构建/调用关系)
```mermaid
flowchart TB
    subgraph UI["Activity 面板 (activity_main.xml)"]
        SV[SurfaceView 预览]
        RG[RadioGroup 旋转 0/90/180/270]
        CB[CheckBox 水平翻转]
        B1[按钮: YUV→ABGR]
        B2[按钮: 旋转YUV平面]
        B3[按钮: 丢帧补偿]
        B4[按钮: 写入JPEG]
    end
    subgraph JNI["a.a.a.ImageProcessingUtil (native)"]
        N1[nativeConvertAndroid420ToABGR]
        N2[nativeRotateYUV]
        N3[nativeShiftPixel]
        N4[nativeWriteJpegToSurface]
    end
    subgraph SO["libimage_processing_util_jni.so"]
        L1[luma 核 #0x4f50 / 4 分发]
        L2[chroma 核 #0x4238 / 解交错 #0x514c]
        L3[旋转/转置叶 0xa880..0xa8c8]
        L4[jpeg 直写 #0x556c]
    end
    B1 --> N1 --> L1 & L2
    B2 --> N2 --> L3
    B3 --> N3
    B4 --> N4 --> L4
    RG --> N1
    CB --> N1
    SV --> N1
    SV --> N4
```

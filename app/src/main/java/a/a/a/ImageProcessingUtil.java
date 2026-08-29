package a.a.a;

/**
 * JNI 桥接类 — 类名/方法名必须与还原出的符号严格一致:
 *   Java_a_a_a_ImageProcessingUtil_nativeConvertAndroid420ToABGR
 *   Java_a_a_a_ImageProcessingUtil_nativeRotateYUV
 *   Java_a_a_a_ImageProcessingUtil_nativeShiftPixel
 *   Java_a_a_a_ImageProcessingUtil_nativeWriteJpegToSurface
 * 见 libimage_processing_util_jni/src/restored_native_v8.c
 */
public class ImageProcessingUtil {
    static {
        System.loadLibrary("image_processing_util_jni");
    }

    /**
     * YUV420 -> ABGR 写入 Surface(bitmap)。
     * @param bitmap  目标 Surface (ANativeWindow_fromSurface)
     * @param image   源 YUV420 平面 (ByteBuffer, direct)
     * @param p10     原二进制 p10 标志门控 (必须 == 1 才转换)
     * @param rot     旋转角度: 0 / 90 / 180 / 270
     * @param flip    水平镜像
     */
    public static native boolean nativeConvertAndroid420ToABGR(
            Object bitmap, Object image,
            int yStride, int uStride, int vStride, int pixStride,
            int p10, int rot, boolean flip, int w, int h);

    /** Y/U/V 三平面按角度位置旋转 (90/180/270) */
    public static native boolean nativeRotateYUV(
            Object pyI, Object puI, Object pvI,
            Object pyO, Object puO, Object pvO,
            int yStrideI, int uStrideI, int vStrideI,
            int yStrideO, int uStrideO, int vStrideO,
            int w, int h, int rot);

    /** 逐行像素左移 pixStride (丢帧/错位补偿) */
    public static native boolean nativeShiftPixel(
            Object planeY, Object planeU, Object planeV,
            int yStride, int uStride, int vStride, int pixStride, int w, int h);

    /** 将 JPEG 字节直接 memcpy 进 Surface 的 gralloc 缓冲 */
    public static native boolean nativeWriteJpegToSurface(Object surface, byte[] jpeg);
}

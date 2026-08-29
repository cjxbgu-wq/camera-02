// class: Landroidx/camera/core/ImageProcessingUtil;
package androidx.camera.core;
public final class ImageProcessingUtil {
    private static final String TAG = "ImageProcessingUtil";
    private static int sImageCount;

    static ImageProcessingUtil()
    {
        System.loadLibrary("image_processing_util_jni");
        return;
    }

    private ImageProcessingUtil()
    {
        return;
    }

    public static synthetic void ab(androidx.camera.core.ImageProxy p0, androidx.camera.core.ImageProxy p1, androidx.camera.core.ImageProxy p2)
    {
        if ((p0 != null) && (p1 != null)) {
            p1.close();
        }
        return;
    }

    public static synthetic void ac(androidx.camera.core.ImageProxy p0, androidx.camera.core.ImageProxy p1, androidx.camera.core.ImageProxy p2)
    {
        if ((p0 != null) && (p1 != null)) {
            p1.close();
        }
        return;
    }

    public static boolean applyPixelShiftForYUV(androidx.camera.core.ImageProxy p3)
    {
        if (androidx.camera.core.ImageProcessingUtil.isSupportedYUVFormat(p3)) {
            if (androidx.camera.core.ImageProcessingUtil.applyPixelShiftInternal(p3) != androidx.camera.core.ImageProcessingUtil$Result.ERROR_CONVERSION) {
                return 1;
            } else {
                androidx.camera.core.Logger.e("ImageProcessingUtil", "One pixel shift for YUV failure");
                return 0;
            }
        } else {
            androidx.camera.core.Logger.e("ImageProcessingUtil", "Unsupported format for YUV to RGB");
            return 0;
        }
    }

    private static androidx.camera.core.ImageProcessingUtil$Result applyPixelShiftInternal(androidx.camera.core.ImageProxy p13)
    {
        int v8 = p13.getWidth();
        int v9 = p13.getHeight();
        java.nio.ByteBuffer v0_3 = p13.getPlanes()[0].getRowStride();
        java.nio.ByteBuffer v2_2 = p13.getPlanes()[1].getRowStride();
        java.nio.ByteBuffer v4_2 = p13.getPlanes()[2].getRowStride();
        int v6_2 = p13.getPlanes()[0].getPixelStride();
        int v7_2 = p13.getPlanes()[1].getPixelStride();
        if (androidx.camera.core.ImageProcessingUtil.nativeShiftPixel(p13.getPlanes()[0].getBuffer(), v0_3, p13.getPlanes()[1].getBuffer(), v2_2, p13.getPlanes()[2].getBuffer(), v4_2, v6_2, v7_2, v8, v9, v6_2, v7_2, v7_2) == 0) {
            return androidx.camera.core.ImageProcessingUtil$Result.SUCCESS;
        } else {
            return androidx.camera.core.ImageProcessingUtil$Result.ERROR_CONVERSION;
        }
    }

    public static androidx.camera.core.ImageProxy convertJpegBytesToImage(androidx.camera.core.impl.ImageReaderProxy p2, byte[] p3)
    {
        String v0_2;
        if (p2.getImageFormat() != 256) {
            v0_2 = 0;
        } else {
            v0_2 = 1;
        }
        u32.ab(v0_2);
        u32.ag(p3);
        String v0_3 = p2.getSurface();
        u32.ag(v0_3);
        if (androidx.camera.core.ImageProcessingUtil.nativeWriteJpegToSurface(p3, v0_3) == 0) {
            androidx.camera.core.ImageProxy v2_1 = p2.acquireLatestImage();
            if (v2_1 == null) {
                androidx.camera.core.Logger.e("ImageProcessingUtil", "Failed to get acquire JPEG image.");
            }
            return v2_1;
        } else {
            androidx.camera.core.Logger.e("ImageProcessingUtil", "Failed to enqueue JPEG image.");
            return 0;
        }
    }

    public static android.graphics.Bitmap convertYUVToBitmap(androidx.camera.core.ImageProxy p14)
    {
        if (p14.getFormat() != 35) {
            throw new IllegalArgumentException("Input image format must be YUV_420_888");
        } else {
            int v12 = p14.getWidth();
            int v13 = p14.getHeight();
            int v3 = p14.getPlanes()[0].getRowStride();
            int v5 = p14.getPlanes()[1].getRowStride();
            int v7 = p14.getPlanes()[2].getRowStride();
            int v8 = p14.getPlanes()[0].getPixelStride();
            int v9 = p14.getPlanes()[1].getPixelStride();
            android.graphics.Bitmap v10_1 = android.graphics.Bitmap.createBitmap(p14.getWidth(), p14.getHeight(), android.graphics.Bitmap$Config.ARGB_8888);
            if (androidx.camera.core.ImageProcessingUtil.nativeConvertAndroid420ToBitmap(p14.getPlanes()[0].getBuffer(), v3, p14.getPlanes()[1].getBuffer(), v5, p14.getPlanes()[2].getBuffer(), v7, v8, v9, v10_1, v10_1.getRowBytes(), v12, v13) != 0) {
                throw new UnsupportedOperationException("YUV to RGB conversion failed");
            } else {
                return v10_1;
            }
        }
    }

    public static androidx.camera.core.ImageProxy convertYUVToRGB(androidx.camera.core.ImageProxy p5, androidx.camera.core.impl.ImageReaderProxy p6, java.nio.ByteBuffer p7, int p8, boolean p9)
    {
        if (androidx.camera.core.ImageProcessingUtil.isSupportedYUVFormat(p5)) {
            long v3 = System.currentTimeMillis();
            if (androidx.camera.core.ImageProcessingUtil.isSupportedRotationDegrees(p8)) {
                if (androidx.camera.core.ImageProcessingUtil.convertYUVToRGBInternal(p5, p6.getSurface(), p7, p8, p9) != androidx.camera.core.ImageProcessingUtil$Result.ERROR_CONVERSION) {
                    if (android.util.Log.isLoggable("MH", 3)) {
                        androidx.camera.core.Logger.d("ImageProcessingUtil", String.format(java.util.Locale.US, "Image processing performance profiling, duration: [%d], image count: %d", new Object[] {Long.valueOf((System.currentTimeMillis() - v3)), Integer.valueOf(androidx.camera.core.ImageProcessingUtil.sImageCount)})));
                        androidx.camera.core.ImageProcessingUtil.sImageCount = (androidx.camera.core.ImageProcessingUtil.sImageCount + 1);
                    }
                    androidx.camera.core.ImageProxy v6_1 = p6.acquireLatestImage();
                    if (v6_1 != null) {
                        androidx.camera.core.SingleCloseImageProxy v7_9 = new androidx.camera.core.SingleCloseImageProxy(v6_1);
                        v7_9.addOnImageCloseListener(new az0(v6_1, p5));
                        return v7_9;
                    } else {
                        androidx.camera.core.Logger.e("ImageProcessingUtil", "YUV to RGB acquireLatestImage failure");
                        return 0;
                    }
                } else {
                    androidx.camera.core.Logger.e("ImageProcessingUtil", "YUV to RGB conversion failure");
                    return 0;
                }
            } else {
                androidx.camera.core.Logger.e("ImageProcessingUtil", "Unsupported rotation degrees for rotate RGB");
                return 0;
            }
        } else {
            androidx.camera.core.Logger.e("ImageProcessingUtil", "Unsupported format for YUV to RGB");
            return 0;
        }
    }

    private static androidx.camera.core.ImageProcessingUtil$Result convertYUVToRGBInternal(androidx.camera.core.ImageProxy p17, android.view.Surface p18, java.nio.ByteBuffer p19, int p20, boolean p21)
    {
        int v13;
        int v11 = p17.getWidth();
        int v12 = p17.getHeight();
        int v2 = p17.getPlanes()[0].getRowStride();
        int v4 = p17.getPlanes()[1].getRowStride();
        int v6 = p17.getPlanes()[2].getRowStride();
        int v7 = p17.getPlanes()[0].getPixelStride();
        int v8 = p17.getPlanes()[1].getPixelStride();
        if (!p21) {
            v13 = 0;
        } else {
            v13 = v7;
        }
        int v14;
        if (!p21) {
            v14 = 0;
        } else {
            v14 = v8;
        }
        int v15;
        if (!p21) {
            v15 = 0;
        } else {
            v15 = v8;
        }
        if (androidx.camera.core.ImageProcessingUtil.nativeConvertAndroid420ToABGR(p17.getPlanes()[0].getBuffer(), v2, p17.getPlanes()[1].getBuffer(), v4, p17.getPlanes()[2].getBuffer(), v6, v7, v8, p18, p19, v11, v12, v13, v14, v15, p20) == 0) {
            return androidx.camera.core.ImageProcessingUtil$Result.SUCCESS;
        } else {
            return androidx.camera.core.ImageProcessingUtil$Result.ERROR_CONVERSION;
        }
    }

    public static boolean convertYuvToJpegBytesIntoSurface(android.media.Image p1, int p2, int p3, android.view.Surface p4)
    {
        return androidx.camera.core.ImageProcessingUtil.convertYuvToJpegBytesIntoSurface(new androidx.camera.core.AndroidImageProxy(p1), p2, p3, p4);
    }

    public static boolean convertYuvToJpegBytesIntoSurface(androidx.camera.core.ImageProxy p1, int p2, int p3, android.view.Surface p4)
    {
        try {
            return androidx.camera.core.ImageProcessingUtil.writeJpegBytesToSurface(p4, androidx.camera.core.internal.utils.ImageUtil.yuvImageToJpegByteArray(p1, 0, p2, p3));
        } catch (int v1_4) {
            androidx.camera.core.Logger.e("ImageProcessingUtil", "Failed to encode YUV to JPEG", v1_4);
            return 0;
        }
    }

    public static void copyBitmapToByteBuffer(android.graphics.Bitmap p7, java.nio.ByteBuffer p8, int p9)
    {
        androidx.camera.core.ImageProcessingUtil.nativeCopyBetweenByteBufferAndBitmap(p7, p8, p7.getRowBytes(), p9, p7.getWidth(), p7.getHeight(), 0);
        return;
    }

    public static void copyByteBufferToBitmap(android.graphics.Bitmap p7, java.nio.ByteBuffer p8, int p9)
    {
        androidx.camera.core.ImageProcessingUtil.nativeCopyBetweenByteBufferAndBitmap(p7, p8, p9, p7.getRowBytes(), p7.getWidth(), p7.getHeight(), 1);
        return;
    }

    private static boolean isSupportedRotationDegrees(int p1)
    {
        if ((p1 != 0) && ((p1 != 90) && ((p1 != 180) && (p1 != 270)))) {
            return 0;
        } else {
            return 1;
        }
    }

    private static boolean isSupportedYUVFormat(androidx.camera.core.ImageProxy p2)
    {
        if ((p2.getFormat() != 35) || (p2.getPlanes().length != 3)) {
            return 0;
        } else {
            return 1;
        }
    }

    private static native int nativeConvertAndroid420ToABGR(java.nio.ByteBuffer p0, int p1, java.nio.ByteBuffer p2, int p3, java.nio.ByteBuffer p4, int p5, int p6, int p7, android.view.Surface p8, java.nio.ByteBuffer p9, int p10, int p11, int p12, int p13, int p14, int p15);

    private static native int nativeConvertAndroid420ToBitmap(java.nio.ByteBuffer p0, int p1, java.nio.ByteBuffer p2, int p3, java.nio.ByteBuffer p4, int p5, int p6, int p7, android.graphics.Bitmap p8, int p9, int p10, int p11);

    private static native int nativeCopyBetweenByteBufferAndBitmap(android.graphics.Bitmap p0, java.nio.ByteBuffer p1, int p2, int p3, int p4, int p5, boolean p6);

    private static native int nativeRotateYUV(java.nio.ByteBuffer p0, int p1, java.nio.ByteBuffer p2, int p3, java.nio.ByteBuffer p4, int p5, int p6, java.nio.ByteBuffer p7, int p8, int p9, java.nio.ByteBuffer p10, int p11, int p12, java.nio.ByteBuffer p13, int p14, int p15, java.nio.ByteBuffer p16, java.nio.ByteBuffer p17, java.nio.ByteBuffer p18, int p19, int p20, int p21);

    private static native int nativeShiftPixel(java.nio.ByteBuffer p0, int p1, java.nio.ByteBuffer p2, int p3, java.nio.ByteBuffer p4, int p5, int p6, int p7, int p8, int p9, int p10, int p11, int p12);

    private static native int nativeWriteJpegToSurface(byte[] p0, android.view.Surface p1);

    public static androidx.camera.core.ImageProxy rotateYUV(androidx.camera.core.ImageProxy p9, androidx.camera.core.impl.ImageReaderProxy p10, android.media.ImageWriter p11, java.nio.ByteBuffer p12, java.nio.ByteBuffer p13, java.nio.ByteBuffer p14, int p15)
    {
        if (androidx.camera.core.ImageProcessingUtil.isSupportedYUVFormat(p9)) {
            if (androidx.camera.core.ImageProcessingUtil.isSupportedRotationDegrees(p15)) {
                androidx.camera.core.ImageProcessingUtil$Result v3;
                String v9_1;
                androidx.camera.core.ImageProcessingUtil$Result v0_2 = androidx.camera.core.ImageProcessingUtil$Result.ERROR_CONVERSION;
                if (p15 <= 0) {
                    v3 = p9;
                    v9_1 = v0_2;
                } else {
                    v3 = p9;
                    v9_1 = androidx.camera.core.ImageProcessingUtil.rotateYUVInternal(p9, p11, p12, p13, p14, p15);
                }
                if (v9_1 != v0_2) {
                    String v9_2 = p10.acquireLatestImage();
                    if (v9_2 != null) {
                        androidx.camera.core.SingleCloseImageProxy v10_2 = new androidx.camera.core.SingleCloseImageProxy(v9_2);
                        v10_2.addOnImageCloseListener(new bz0(v9_2, v3));
                        return v10_2;
                    } else {
                        androidx.camera.core.Logger.e("ImageProcessingUtil", "YUV rotation acquireLatestImage failure");
                        return 0;
                    }
                } else {
                    androidx.camera.core.Logger.e("ImageProcessingUtil", "rotate YUV failure");
                    return 0;
                }
            } else {
                androidx.camera.core.Logger.e("ImageProcessingUtil", "Unsupported rotation degrees for rotate YUV");
                return 0;
            }
        } else {
            androidx.camera.core.Logger.e("ImageProcessingUtil", "Unsupported format for rotate YUV");
            return 0;
        }
    }

    private static androidx.camera.core.ImageProcessingUtil$Result rotateYUVInternal(androidx.camera.core.ImageProxy p23, android.media.ImageWriter p24, java.nio.ByteBuffer p25, java.nio.ByteBuffer p26, java.nio.ByteBuffer p27, int p28)
    {
        int v20 = p23.getWidth();
        int v21 = p23.getHeight();
        int v2 = p23.getPlanes()[0].getRowStride();
        int v4 = p23.getPlanes()[1].getRowStride();
        int v6 = p23.getPlanes()[2].getRowStride();
        int v7 = p23.getPlanes()[1].getPixelStride();
        androidx.camera.core.ImageProcessingUtil$Result v0_9 = androidx.camera.core.internal.compat.ImageWriterCompat.dequeueInputImage(p24);
        if (v0_9 != null) {
            if (androidx.camera.core.ImageProcessingUtil.nativeRotateYUV(p23.getPlanes()[0].getBuffer(), v2, p23.getPlanes()[1].getBuffer(), v4, p23.getPlanes()[2].getBuffer(), v6, v7, v0_9.getPlanes()[0].getBuffer(), v0_9.getPlanes()[0].getRowStride(), v0_9.getPlanes()[0].getPixelStride(), v0_9.getPlanes()[1].getBuffer(), v0_9.getPlanes()[1].getRowStride(), v0_9.getPlanes()[1].getPixelStride(), v0_9.getPlanes()[2].getBuffer(), v0_9.getPlanes()[2].getRowStride(), v0_9.getPlanes()[2].getPixelStride(), p25, p26, p27, v20, v21, p28) == 0) {
                androidx.camera.core.internal.compat.ImageWriterCompat.queueInputImage(p24, v0_9);
                return androidx.camera.core.ImageProcessingUtil$Result.SUCCESS;
            } else {
                return androidx.camera.core.ImageProcessingUtil$Result.ERROR_CONVERSION;
            }
        } else {
            return androidx.camera.core.ImageProcessingUtil$Result.ERROR_CONVERSION;
        }
    }

    public static boolean writeJpegBytesToSurface(android.view.Surface p0, byte[] p1)
    {
        u32.ag(p1);
        u32.ag(p0);
        if (androidx.camera.core.ImageProcessingUtil.nativeWriteJpegToSurface(p1, p0) == 0) {
            return 1;
        } else {
            androidx.camera.core.Logger.e("ImageProcessingUtil", "Failed to enqueue JPEG image.");
            return 0;
        }
    }
}

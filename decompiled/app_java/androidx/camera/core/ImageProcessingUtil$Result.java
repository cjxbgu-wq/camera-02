// class: Landroidx/camera/core/ImageProcessingUtil$Result;
package androidx.camera.core;
final enum class ImageProcessingUtil$Result extends java.lang.Enum {
    private static final synthetic androidx.camera.core.ImageProcessingUtil$Result[] $VALUES;
    public static final enum androidx.camera.core.ImageProcessingUtil$Result ERROR_CONVERSION;
    public static final enum androidx.camera.core.ImageProcessingUtil$Result SUCCESS;
    public static final enum androidx.camera.core.ImageProcessingUtil$Result UNKNOWN;

    private static synthetic androidx.camera.core.ImageProcessingUtil$Result[] $values()
    {
        return new androidx.camera.core.ImageProcessingUtil$Result[] {androidx.camera.core.ImageProcessingUtil$Result.UNKNOWN, androidx.camera.core.ImageProcessingUtil$Result.SUCCESS, androidx.camera.core.ImageProcessingUtil$Result.ERROR_CONVERSION});
    }

    static ImageProcessingUtil$Result()
    {
        androidx.camera.core.ImageProcessingUtil$Result.UNKNOWN = new androidx.camera.core.ImageProcessingUtil$Result("UNKNOWN", 0);
        androidx.camera.core.ImageProcessingUtil$Result.SUCCESS = new androidx.camera.core.ImageProcessingUtil$Result("SUCCESS", 1);
        androidx.camera.core.ImageProcessingUtil$Result.ERROR_CONVERSION = new androidx.camera.core.ImageProcessingUtil$Result("ERROR_CONVERSION", 2);
        androidx.camera.core.ImageProcessingUtil$Result.$VALUES = androidx.camera.core.ImageProcessingUtil$Result.$values();
        return;
    }

    private ImageProcessingUtil$Result(String p1, int p2)
    {
        super(p1, p2);
        return;
    }

    public static androidx.camera.core.ImageProcessingUtil$Result valueOf(String p1)
    {
        return ((androidx.camera.core.ImageProcessingUtil$Result) Enum.valueOf(androidx.camera.core.ImageProcessingUtil$Result, p1));
    }

    public static androidx.camera.core.ImageProcessingUtil$Result[] values()
    {
        return ((androidx.camera.core.ImageProcessingUtil$Result[]) androidx.camera.core.ImageProcessingUtil$Result.$VALUES.clone());
    }
}

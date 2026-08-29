package a.a.a;

import android.app.Activity;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.*;

import java.nio.ByteBuffer;

public class MainActivity extends Activity {
    private SurfaceView preview;
    private int W = 640, H = 480;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        preview = findViewById(R.id.preview);
        final RadioGroup rot = findViewById(R.id.rotGroup);
        final CheckBox flip = findViewById(R.id.flip);

        // 分配一份 YUV420 平面 (Y:W*H, U/V:(W/2)*(H/2))
        final int ySz = W * H, uvSz = (W / 2) * (H / 2);
        final ByteBuffer yuv = ByteBuffer.allocateDirect(ySz + uvSz * 2);

        findViewById(R.id.btnConvert).setOnClickListener(v -> {
            // 真实场景下 bitmap 应为可绘制的 Surface; 此处演示调用契约
            int r = rotRot(rot);
            // nativeConvertAndroid420ToABGR(bitmap, image, yStride, uStride, vStride, pixStride, p10, rot, flip, w, h)
            Toast.makeText(this, "convert rot=" + r + " flip=" + flip.isChecked(), Toast.LENGTH_SHORT).show();
        });

        findViewById(R.id.btnRotateYUV).setOnClickListener(v -> {
            ByteBuffer yo = ByteBuffer.allocateDirect(ySz);
            ByteBuffer uo = ByteBuffer.allocateDirect(uvSz);
            ByteBuffer vo = ByteBuffer.allocateDirect(uvSz);
            ImageProcessingUtil.nativeRotateYUV(
                    yuv, yuv, yuv, yo, uo, vo,
                    W, W / 2, W / 2, W, W / 2, W / 2, W, H, rotRot(rot));
        });

        findViewById(R.id.btnShift).setOnClickListener(v ->
                ImageProcessingUtil.nativeShiftPixel(yuv, yuv, yuv, W, W / 2, W / 2, 1, W, H));

        findViewById(R.id.btnJpeg).setOnClickListener(v -> {
            byte[] jpeg = new byte[1024];
            Surface surface = preview.getHolder().getSurface();
            ImageProcessingUtil.nativeWriteJpegToSurface(surface, jpeg);
        });
    }

    private int rotRot(RadioGroup g) {
        if (((RadioButton)findViewById(R.id.r90)).isChecked())  return 90;
        if (((RadioButton)findViewById(R.id.r180)).isChecked()) return 180;
        if (((RadioButton)findViewById(R.id.r270)).isChecked()) return 270;
        return 0;
    }
}

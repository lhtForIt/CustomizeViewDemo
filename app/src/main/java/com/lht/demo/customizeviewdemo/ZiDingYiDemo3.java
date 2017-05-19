package com.lht.demo.customizeviewdemo;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by lht on 2017/5/18.
 */

public class ZiDingYiDemo3 extends AppCompatActivity {

    private ImageView iv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zidingyi_activity);

        iv = (ImageView) findViewById(R.id.iv);

        Bitmap bp = Bitmap.createBitmap(500, 800, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bp);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(1);
        final int offsetDy = 50;
        for (int i = 0; i < 5; i++) {
            //横线
//            canvas.drawLine(10, offsetDy * i, 300, offsetDy * i, paint);
            //竖线
            canvas.drawLine(offsetDy * i, 10, offsetDy * i, 300, paint);
        }
        iv.setImageBitmap(bp);


    }
}

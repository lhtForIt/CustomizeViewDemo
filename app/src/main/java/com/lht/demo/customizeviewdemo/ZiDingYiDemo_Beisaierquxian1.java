package com.lht.demo.customizeviewdemo;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by lht on 2017/5/19.
 */

public class ZiDingYiDemo_Beisaierquxian1 extends AppCompatActivity{

    private ImageView iv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zidingyi_activity);

        iv = (ImageView) findViewById(R.id.iv);
        Bitmap bp = Bitmap.createBitmap(600, 800, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bp);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        Path path = new Path();
        path.moveTo(100, 100);
        path.arcTo(new RectF(100, 150, 300, 300), -30, 60, false);
        canvas.drawPath(path, paint);

        iv.setImageBitmap(bp);

    }
}

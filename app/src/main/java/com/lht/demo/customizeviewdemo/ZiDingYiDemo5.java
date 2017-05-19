package com.lht.demo.customizeviewdemo;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by lht on 2017/5/18.
 */

public class ZiDingYiDemo5 extends AppCompatActivity{

    private ImageView iv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zidingyi_activity);

        iv = (ImageView) findViewById(R.id.iv);
        Bitmap bp = Bitmap.createBitmap(500, 800, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bp);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        RectF rect = new RectF(10, 10, 400, 300);
        paint.setColor(Color.GRAY);
        canvas.drawOval(rect, paint);
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);
        canvas.drawArc(rect, -30, -30, false, paint);

        iv.setImageBitmap(bp);


    }
}

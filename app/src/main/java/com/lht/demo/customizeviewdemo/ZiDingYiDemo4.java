package com.lht.demo.customizeviewdemo;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by lht on 2017/5/18.
 */

public class ZiDingYiDemo4 extends AppCompatActivity{

    private ImageView iv;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zidingyi_activity);

        iv = (ImageView) findViewById(R.id.iv);

        Bitmap bp = Bitmap.createBitmap(500, 800, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bp);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        canvas.drawRoundRect(10, 10, 400, 300, 50, 30, paint);

        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRoundRect(new RectF(10, 320, 400, 620), 30, 50, paint);

        iv.setImageBitmap(bp);

    }
}

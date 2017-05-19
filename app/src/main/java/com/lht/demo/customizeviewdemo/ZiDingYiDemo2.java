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

public class ZiDingYiDemo2 extends AppCompatActivity{

    private ImageView iv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zidingyi_activity);

        iv = (ImageView) findViewById(R.id.iv);

        Bitmap bp = Bitmap.createBitmap(500, 800, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bp);
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(4);
        //画一个红色的点
        canvas.drawPoint(120, 20, paint);
        paint.setColor(Color.RED);
        //两个数一组画四个蓝色的点
        float[] point1 = {10, 10, 50, 50, 50, 100, 50, 150};
        canvas.drawPoints(point1, paint);
        paint.setColor(Color.GREEN);
        canvas.drawPoints(point1, 1, 4, paint);

        iv.setImageBitmap(bp);

    }
}

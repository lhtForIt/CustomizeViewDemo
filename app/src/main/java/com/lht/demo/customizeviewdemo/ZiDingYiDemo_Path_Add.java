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

public class ZiDingYiDemo_Path_Add extends AppCompatActivity{


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
        //矩形
        path.addRect(new RectF(10, 10, 300, 100), Path.Direction.CCW);
        //圆角矩形，四个角的弧度都不一样，2个数确定一个弧度
        path.addRoundRect(new RectF(10, 120, 300, 220), new float[]{10, 20, 20, 10, 30, 40, 40, 30}, Path.Direction.CCW);
        //椭圆
        path.addOval(new RectF(10, 240, 300, 340), Path.Direction.CCW);
        //圆
        path.addCircle(60, 390, 50, Path.Direction.CCW);
        //弧线
        path.addArc(new RectF(10, 500, 300, 600), -30, -60);
        canvas.drawPath(path, paint);

        iv.setImageBitmap(bp);

    }
}

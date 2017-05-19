package com.lht.demo.customizeviewdemo;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by lht on 2017/5/19.
 */

public class ZiDingYiDemo_Path extends AppCompatActivity{


    private ImageView iv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zidingyi_activity);


        iv = (ImageView) findViewById(R.id.iv);

        //在1440*2560像素的手机上createBitmap的宽为500是占不满的，要600才能占满
        Bitmap bp = Bitmap.createBitmap(600, 800, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bp);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLUE);
        Path path = new Path();
        path.moveTo(0, 200);
        path.rLineTo(400, 0);
        path.rLineTo(-400, 200);
        path.rLineTo(200, -400);
        path.rLineTo(200, 400);
        path.close();
        canvas.drawPath(path,paint);

        iv.setImageBitmap(bp);



    }
}

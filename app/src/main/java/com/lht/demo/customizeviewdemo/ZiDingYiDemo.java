package com.lht.demo.customizeviewdemo;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by lht on 2017/5/16.
 */

public class ZiDingYiDemo extends AppCompatActivity{


    private ImageView iv;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.zidingyi_activity);

        iv = (ImageView) findViewById(R.id.iv);

        Bitmap bmp = Bitmap.createBitmap(400, 400, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmp);
        //绘制文字
        Paint paint = new Paint();
        //设置抗锯齿
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextAlign(Paint.Align.LEFT);
        int sp = 16;
        paint.setTextSize(sp);
        paint.setTextSkewX(-0.5f);//倾斜左正右负
        paint.setUnderlineText(true);
        paint.setFakeBoldText(true);
        canvas.drawText("兄弟，在你不够强的时候你只能静下来默默努力！", 10, 100, paint);


        //绘制图形
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(20);
        paint.setStrokeJoin(Paint.Join.BEVEL);//此处可以修改枚举值查看效果
        //绘制一个矩形
        canvas.drawRect(new Rect(10, 150, 350, 350), paint);
        iv.setImageBitmap(bmp);

    }
}

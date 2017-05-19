package com.lht.demo.customizeviewdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by lht on 2017/5/17.
 */

public class ZiDingYiDemo1 extends AppCompatActivity{

    private ImageView iv;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.zidingyi_activity);

        iv = (ImageView) findViewById(R.id.iv);

        Bitmap bp = Bitmap.createBitmap(500, 800, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bp);
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        //原大小绘制
        canvas.drawBitmap(bmp, 0, 0, null);
        //对图片进行缩放
        int bmpWidth = bmp.getWidth();
        int bmpHight = bmp.getHeight();
        Rect src = new Rect(0, 0, bmpWidth, bmpHight);
        Rect dst = new Rect(0, bmpHight, bmpWidth * 3, bmpHight * 4);
        canvas.drawBitmap(bmp, src, dst, null);
        iv.setImageBitmap(bp);


    }
}

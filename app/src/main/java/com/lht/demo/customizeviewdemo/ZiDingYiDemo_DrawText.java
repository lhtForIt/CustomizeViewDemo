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

public class ZiDingYiDemo_DrawText extends AppCompatActivity{


    private ImageView iv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zidingyi_activity);

        iv = (ImageView) findViewById(R.id.iv);

        Bitmap bp = Bitmap.createBitmap(600, 800, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bp);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(18);
        String text = "in order to good for android,you should do better than ever";
        canvas.drawText(text, 10, 50, paint);
        canvas.drawText(text, 0, 4, 10, 100, paint);
        canvas.drawText(text.toCharArray(), 5, 10, 10, 150, paint);
        Path path = new Path();
        path.moveTo(10, 200);
        path.quadTo(100, 100, 300, 300);
        canvas.drawTextOnPath(text, path, 15, 15, paint);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path, paint);

        iv.setImageBitmap(bp);


    }
}

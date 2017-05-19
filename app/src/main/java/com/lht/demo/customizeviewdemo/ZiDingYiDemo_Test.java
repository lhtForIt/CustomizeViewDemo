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

import java.util.Random;

/**
 * Created by lht on 2017/5/19.
 */

public class ZiDingYiDemo_Test extends AppCompatActivity{

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
        paint.setColor(Color.BLUE);

        canvas.drawRect(new RectF(30, 30, 330, 180), paint);

        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(100);
        paint.setAntiAlias(true);

        //因为下面的getRandom(10)得到的数大于40，不可能会有值，所以为空，因此画出的图形为空
//        String.valueOf(getRandom(10)) + String.valueOf(getRandom(10)) + String.valueOf(getRandom(10)) + String.valueOf(getRandom(10))
        canvas.drawText(String.valueOf(new Random().nextInt(10))+String.valueOf(new Random().nextInt(10))+String.valueOf(new Random().nextInt(10))+String.valueOf(new Random().nextInt(10)), 50, 140, paint);

        for (int i = 0; i < 100; i++) {
            int x = getRandom(180);
            canvas.drawLine(getRandom(331) - 10, x, getRandom(331), x, paint);
        }

        iv.setImageBitmap(bp);

    }


    private int getRandom(int a) {

        Random r = new Random();

        while (true) {
            int s = r.nextInt(a);
            if (s > 40) {
                return s;
            }
        }

    }
}

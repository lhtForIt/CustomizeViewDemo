package com.lht.demo.customizeviewdemo;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by lht on 2017/5/19.
 */

public class ZiDingYiDemo__Path_Op extends AppCompatActivity{

    private ImageView iv;

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zidingyi_activity);

        iv = (ImageView) findViewById(R.id.iv);

        Bitmap bp = Bitmap.createBitmap(600, 800, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bp);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        Path path = new Path();
        path.addRect(new RectF(10, 10, 110, 110), Path.Direction.CCW);
        Path path1 = new Path();
        path1.addCircle(100, 100, 50, Path.Direction.CCW);
        path.op(path1, Path.Op.DIFFERENCE);
        canvas.drawPath(path, paint);
        paint.setColor(Color.RED);
        canvas.drawPath(path1, paint);

        iv.setImageBitmap(bp);



    }
}

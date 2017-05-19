package com.lht.demo.customizeviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.tv2);
        Animation ani = AnimationUtils.loadAnimation(this, R.anim.donghua);
        //设置一直旋转不停顿
        ani.setInterpolator(new LinearInterpolator());
        textView.startAnimation(ani);

    }

}

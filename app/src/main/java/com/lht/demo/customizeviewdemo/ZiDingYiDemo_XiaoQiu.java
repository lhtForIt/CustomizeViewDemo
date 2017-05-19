package com.lht.demo.customizeviewdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

import View.BallMoveView;

/**
 * Created by lht on 2017/5/19.
 */

public class ZiDingYiDemo_XiaoQiu extends AppCompatActivity{

    private BallMoveView bmv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zidingyidemo_xiaoqiu);

        bmv = (BallMoveView) findViewById(R.id.bv);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                //postInvalidate必须在子线程中调用
                bmv.postInvalidate();
            }
        },200,50);
    }
}

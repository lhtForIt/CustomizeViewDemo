package com.lht.demo.customizeviewdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by lht on 2017/4/19.
 */

public class MyCustomView1 extends View {

    private String mText;
    private int mTextColor;
    private int mTextSize;

    private Paint mPaint;
    private Rect mBounds;


    public MyCustomView1(Context context) {
        this(context, null);
    }

    public MyCustomView1(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }


    public MyCustomView1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.LhtView, defStyleAttr, 0);
        int a = typedArray.getIndexCount();
        for (int i = 0; i < a; i++) {
            int attr = typedArray.getIndex(i);
            switch (attr) {
                case R.styleable.LhtView_mText:
                    mText = typedArray.getString(attr);
                    break;
                case R.styleable.LhtView_mTextColor:
                    mTextColor = typedArray.getColor(attr, Color.BLACK);
                    break;
                case R.styleable.LhtView_mTextSize:
                    mTextSize = typedArray.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
                    break;

            }

        }
        typedArray.recycle();

        mPaint = new Paint();
        mPaint.setTextSize(mTextSize);
        mBounds = new Rect();
        mPaint.getTextBounds(mText, 0, mText.length(), mBounds);

        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                mText = getRandomText();
                postInvalidate();

            }
        });

    }


    private String getRandomText() {

        Random ran = new Random();
        int ranText = 0;
        Set<Integer> set = new HashSet<>();
        while(set.size() < 4) {
            ranText= ran.nextInt(10);
            set.add(ranText);
        }
        StringBuffer sb = new StringBuffer();
        for (Integer i : set) {
            sb.append(i + "");
        }

        return sb.toString();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setColor(Color.BLUE);
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);

        mPaint.setColor(mTextColor);
        Log.d("lht", "=========================getWidth/2:"+getWidth()/2+"\n mBounds.width/2:"+mBounds.width()/2+"\n getHight()/2:"+getHeight()/2+"\n mBounds.hight/2:"+mBounds.height()/2);
        canvas.drawText(mText, getWidth()/2-mBounds.width()/2, getHeight()/2+mBounds.height()/2, mPaint);

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int width = 0;
        int height = 0;
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            mPaint.setTextSize(mTextSize);
            mPaint.getTextBounds(mText, 0, mText.length(), mBounds);
            float textWidth = mBounds.width();
            width = (int) (textWidth + getPaddingLeft() + getPaddingRight());

        }

        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            mPaint.setTextSize(mTextSize);
            mPaint.getTextBounds(mText, 0, mText.length(), mBounds);
            float textHeight = mBounds.height();
            height = (int) (textHeight + getPaddingLeft() + getPaddingRight());

        }



        setMeasuredDimension(width,height);
//        setMeasuredDimension(getMeasureWidth(widthMeasureSpec),getMeasureHight(heightMeasureSpec));
    }


    private int getMeasureWidth(int widthMeasureSpec) {

        int result = 0;
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        if (widthSpecMode == MeasureSpec.EXACTLY) {
            result = widthSpecSize;
        } else {
            result = 200;
            if (widthSpecMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, widthSpecSize);
            }
        }

        return result;

    }


    private int getMeasureHight(int hightMeasureSpec) {

        int result = 0;
        int hightSpecMode = MeasureSpec.getMode(hightMeasureSpec);
        int hightSpecSize = MeasureSpec.getSize(hightMeasureSpec);
        if (hightSpecMode == MeasureSpec.EXACTLY) {
            result = hightSpecSize;
        } else {
            result = 200;
            if (hightSpecMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, hightSpecSize);
            }
        }

        return result;

    }



}

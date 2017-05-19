package com.lht.demo.customizeviewdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lht on 2017/5/3.
 */

public class ViewPagerTest extends AppCompatActivity {

    private ViewPager viewPager;
    private Button bt;
    private RelativeLayout relativeLayout;
    private int[] image = {R.mipmap.buty, R.mipmap.ly, R.mipmap.test, R.mipmap.test1, R.mipmap.lrt, R.mipmap.touxiang, R.mipmap.ty};
    private List<ImageView> list = new ArrayList<>();
    private DisplayMetrics metrics = new DisplayMetrics();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        setContentView(R.layout.viewpager_activity);

        //点类，可在Android坐标系里画点
//        PointF pf = new PointF(12, 50);
//        Log.d("lht", "==================PointF.length(50, 16):"+PointF.length(50, 16));
        //位图类，比较常用的两个Bitmap和BitmapDrawable
        Bitmap bp = Bitmap.createBitmap(400, 400, Bitmap.Config.ARGB_8888);
        Bitmap bp1=BitmapFactory.decodeResource(getResources(), R.mipmap.buty);
        BitmapDrawable bd = new BitmapDrawable(getResources(), bp1);
        Bitmap bp2 = bd.getBitmap();
        bp.copy(Bitmap.Config.ARGB_8888, true);
        //位图内存回收
        if (bp != null || !bp.isRecycled()) {
            bp.recycle();
            System.gc();
            bp = null;
        }

        relativeLayout = (RelativeLayout) findViewById(R.id.rl);
        bt = (Button) findViewById(R.id.bt);
        viewPager = (ViewPager) findViewById(R.id.vp);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(metrics.widthPixels / 20, metrics.widthPixels / 20);
        for (int i = 0; i < image.length; i++) {
            ImageView iv = new ImageView(this);
            iv.setImageResource(image[i]);
            iv.setLayoutParams(new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
            list.add(iv);

            View v = new View(this);
            lp.leftMargin = 10;
            v.setBackgroundResource(R.drawable.selector_point_guide);
            v.setEnabled(false);
            relativeLayout.addView(v, lp);
        }


        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(list.get(position));
            }


            @Override
            public Object instantiateItem(ViewGroup container, int position) {

                container.addView(list.get(position));

                return list.get(position);
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                int i = position % image.length;
//                if () {
//                }

                switch (position) {
                    case 6:
                        bt.setVisibility(View.VISIBLE);
                        break;
                    default:
                        bt.setVisibility(View.GONE);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }
}

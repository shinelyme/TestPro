package com.lsngo.myapplication.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.lsngo.myapplication.ui.adapter.mPagerAdapter;
import com.lsngo.myapplication.R;

/**
 * Created by Administrator on 2017/3/29.
 */

public class GuideActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private int[] pics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_activity);
        viewPager = (ViewPager) findViewById(R.id.guide_activity_vp);
        initData();
        mPagerAdapter mPagerAdapter = new mPagerAdapter(this,pics);
        viewPager.setAdapter(mPagerAdapter);
        viewPager.setOnPageChangeListener(mPagerListener);
    }

    private void initData() {
        pics = new int[]{
                R.drawable.guide32, R.drawable.guide33, R.drawable.guide34
        };
    }

    Handler handler = new Handler();
    private ViewPager.OnPageChangeListener mPagerListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(final int position) {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (position == viewPager.getAdapter().getCount() - 1)
//                        Toast.makeText(GuideActivity.this, "last　image", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(new Intent(GuideActivity.this, MainActivity.class));
                }
            }, 2000);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}

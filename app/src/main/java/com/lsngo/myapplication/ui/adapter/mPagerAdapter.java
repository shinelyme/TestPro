package com.lsngo.myapplication.ui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Administrator on 2017/3/29.
 */

public class mPagerAdapter extends PagerAdapter {
    private Context context;
    private int[] pics;

    public mPagerAdapter(Context context, int[] pics) {
        this.context = context;
        this.pics = pics;
    }

    @Override
    public int getCount() {
        return pics == null ? 0 :pics.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView guide_iv = new ImageView(context);
        guide_iv.setImageResource(pics[position]);
        guide_iv.setScaleType(ImageView.ScaleType.FIT_XY);
        container.addView(guide_iv);
        return guide_iv;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}

package com.lsngo.myapplication.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lsngo.myapplication.R;

/**
 * Created by Administrator on 2017/3/23.
 */

public class NewsFragment extends android.app.Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_news,container,false);
        return rootView;
    }

}

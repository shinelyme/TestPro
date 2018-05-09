package com.lsngo.myapplication.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.lsngo.myapplication.bean.WebBean;
import com.lsngo.myapplication.ui.activity.WebActivity;
import com.lsngo.myapplication.ui.adapter.mRecyclerView;
import com.lsngo.myapplication.R;
import com.socks.library.KLog;

import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.lsngo.myapplication.app.constant.Constants.url;


/**
 * Created by Administrator on 2017/3/23.
 */

public class HomeFragment extends android.app.Fragment {

    private View rootView;
    private RecyclerView home_fragment_rv;
    private List<WebBean> list;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0x001){

                mRecyclerView mRecyclerView = new mRecyclerView(getActivity(),list);
                home_fragment_rv.setAdapter(mRecyclerView);
                mRecyclerView.setOnItemClickListener(mOnItemClick);
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_home,container,false);
        home_fragment_rv = (RecyclerView) rootView.findViewById(R.id.home_fragment_home_rv);
        LinearLayoutManager manager = new LinearLayoutManager(container.getContext(), LinearLayoutManager.VERTICAL, false);
        home_fragment_rv.setLayoutManager(manager);
        downLoadData();
        return rootView;
    }

    private void downLoadData() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        okHttpClient.newCall(request).enqueue(callBack);
    }

    private Callback callBack = new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {

        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            String jsonStr = response.body().string();
            KLog.json("kkk",jsonStr);
            try {
                list = new ArrayList<>();
                JSONObject jsonObject = new JSONObject(jsonStr);
                JSONArray array = jsonObject.getJSONArray("list");
                for (int i = 0; i < array.length(); i++) {
                    WebBean webBean = new WebBean();
                    JSONObject jsonObject1 = array.getJSONObject(i);
                    String title = jsonObject1.getString("title");
                    String pic_url = jsonObject1.getString("pic_url");
                    String web_url = jsonObject1.getString("web_url");

                    webBean.setTitle(title);
                    webBean.setPic_url(pic_url);
                    webBean.setWeb_url(web_url);

                    list.add(webBean);

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Message msg = handler.obtainMessage();
            msg.what = 0x001;
            handler.sendMessage(msg);
        }
    };
    private mRecyclerView.OnItemClickListener mOnItemClick = new mRecyclerView.OnItemClickListener() {
        @Override
        public void onItemClick(View view, int postion) {
//            startActivity(new Intent(getActivity(),WebActivity.class));
            Intent intent = new Intent(getActivity(), WebActivity.class);
            intent.putExtra("web_url",view.getTag(R.id.tag_web_url).toString());
            intent.putExtra("title",view.getTag(R.id.tag_title).toString());
            KLog.d(R.id.tag_web_url);
            startActivity(intent);
        }
    };

}

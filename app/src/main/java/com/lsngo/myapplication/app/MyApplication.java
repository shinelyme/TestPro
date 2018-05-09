package com.lsngo.myapplication.app;

import android.app.Application;
import android.content.Context;

import com.zhouyou.http.EasyHttp;

/**
 * Created by Administrator on 2018/5/6.
 */

public class MyApplication extends Application {
    private static final java.lang.String TAG = "lsngo";
    private static Application app = null;
    private String Url = "http://wthrcdn.etouch.cn";

    @Override
    public void onCreate() {
        super.onCreate();
        initRxHttp();
    }

    private void initRxHttp() {
        EasyHttp.init(this);
        EasyHttp.getInstance()
                .debug(TAG,true)
                .setRetryIncreaseDelay(500)//每次延时叠加500ms
                .setBaseUrl(Url)
                .setCertificates();
    }

    public static Context getAppContext(){
        if (app==null){
            return null;
        }
        return app.getApplicationContext();
    }
}

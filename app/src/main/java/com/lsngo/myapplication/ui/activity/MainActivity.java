package com.lsngo.myapplication.ui.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.lsngo.myapplication.app.constant.Constants;
import com.lsngo.myapplication.ui.fragment.HomeFragment;
import com.lsngo.myapplication.ui.fragment.NewsFragment;
import com.lsngo.myapplication.ui.fragment.ServiceFragment;
import com.lsngo.myapplication.ui.fragment.SettingFragment;
import com.lsngo.myapplication.R;
import com.mob.mobapi.API;
import com.mob.mobapi.APICallback;
import com.mob.mobapi.MobAPI;
import com.mob.mobapi.apis.Weather;
import com.socks.library.KLog;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.ProgressDialogCallBack;
import com.zhouyou.http.exception.ApiException;
import com.zhouyou.http.subsciber.IProgressDialog;
import com.zhouyou.http.utils.HttpLog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import cn.sharesdk.integhelper.Main;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;

public class MainActivity extends AppCompatActivity implements APICallback, View.OnClickListener {
    private RadioGroup radio_group;
    private List<Fragment> fragments;
    private Fragment fragment;
    private Weather api;
    private TextView menu_weather;
    private TextView menu_my;
    private TextView menu_about;
    private SlidingMenu slidingMenu;
    private TextView menu_city;
    private TextView menu_weather_info;
    private TextView menu_temperature;
    private TextView menu_humidity;
    private TextView menu_wind;
    private java.lang.String appSecret = "3ba3a1bf9c300ccb36fa874d8eb622a7";
    private String appKey = "1c6ac480d66c0";
    private String appMessageKey = "1c6ac480d66c0";
    private java.lang.String appMessageSecret = "3ba3a1bf9c300ccb36fa874d8eb622a7";
    private TextView test;
    private SwipeRefreshLayout swipe;
    private String weatherInfo;
    private String temperature;
    private String humidity;
    private String wind;
    private String city;
    private Handler handler1;
    // 短信注册，随机产生头像
    private static final String[] AVATARS = {
            "http://tupian.qqjay.com/u/2011/0729/e755c434c91fed9f6f73152731788cb3.jpg",
            "http://99touxiang.com/public/upload/nvsheng/125/27-011820_433.jpg",
            "http://img1.touxiang.cn/uploads/allimg/111029/2330264224-36.png",
            "http://img1.2345.com/duoteimg/qqTxImg/2012/04/09/13339485237265.jpg",
            "http://diy.qqjay.com/u/files/2012/0523/f466c38e1c6c99ee2d6cd7746207a97a.jpg",
            "http://img1.touxiang.cn/uploads/20121224/24-054837_708.jpg",
            "http://img1.touxiang.cn/uploads/20121212/12-060125_658.jpg",
            "http://img1.touxiang.cn/uploads/20130608/08-054059_703.jpg",
            "http://diy.qqjay.com/u2/2013/0422/fadc08459b1ef5fc1ea6b5b8d22e44b4.jpg",
            "http://img1.2345.com/duoteimg/qqTxImg/2012/04/09/13339510584349.jpg",
            "http://img1.touxiang.cn/uploads/20130515/15-080722_514.jpg",
            "http://diy.qqjay.com/u2/2013/0401/4355c29b30d295b26da6f242a65bcaad.jpg"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new NewsFragment());
        fragments.add(new ServiceFragment());
        fragments.add(new SettingFragment());
        radio_group = (RadioGroup) findViewById(R.id.radio_group);
        radio_group.setOnCheckedChangeListener(onCheckedChangeListener);
        ((RadioButton) radio_group.getChildAt(0)).setChecked(true);
        initSlidingMenu();
        initMobSDK();
        initMessageSDK();
    }

    private void initMessageSDK() {
        SMSSDK.initSDK(MainActivity.this, appMessageKey, appMessageSecret);
    }

    private void initSlidingMenu() {
        slidingMenu = new SlidingMenu(this);
        slidingMenu.setMenu(R.layout.menu);
        initSlidingMenuView();

        menu_weather.setOnClickListener(this);
        menu_my.setOnClickListener(this);
        menu_about.setOnClickListener(this);

        // 宽度
        int screenWidth = getResources().getDisplayMetrics().widthPixels;
        slidingMenu.setBehindWidth(screenWidth * 2 / 3);
        // 位置
        slidingMenu.setMode(SlidingMenu.LEFT);
        // 划出模式
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
        // 附着到Activity上
        slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
    }

    /**
     * 初始化SlidingMenu中的控件
     */
    private void initSlidingMenuView() {
        menu_weather = (TextView) slidingMenu.findViewById(R.id.menu_weather);
        menu_my = (TextView) slidingMenu.findViewById(R.id.menu_my);
        menu_about = (TextView) slidingMenu.findViewById(R.id.menu_about);
        test = (TextView) slidingMenu.findViewById(R.id.testContent);
        swipe = (SwipeRefreshLayout) slidingMenu.findViewById(R.id.swipe);

        menu_city = (TextView) slidingMenu.findViewById(R.id.menu_city);
        menu_weather_info = (TextView) slidingMenu.findViewById(R.id.menu_weather_info);
        menu_temperature = (TextView) slidingMenu.findViewById(R.id.menu_temperature);
        menu_humidity = (TextView) slidingMenu.findViewById(R.id.menu_humidity);
        menu_wind = (TextView) slidingMenu.findViewById(R.id.menu_wind);

        swipe.setOnRefreshListener(mOnSwipeRefresh);
    }

    private void initMobSDK() {
        MobAPI.initSDK(this, appKey);
        api = (Weather) MobAPI.getAPI(Weather.NAME);
    }

    private RadioGroup.OnCheckedChangeListener onCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            View child = group.findViewById(checkedId);
            int index = group.indexOfChild(child);
            fragment = fragments.get(index);
            replaceFragment();
        }
    };

    private void replaceFragment() {
        FragmentManager manager = getFragmentManager();
        manager.beginTransaction()
                .replace(R.id.main_fragment_container, fragment)
                .commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // 天气预报
            case R.id.menu_weather:
//                api.queryByCityName("杭州", this);
                queryWeatherByCityName();
                break;
            // 我的（登录）
            case R.id.menu_my:
                Toast.makeText(this, "我的", Toast.LENGTH_SHORT).show();
                onRegist();
                break;
            // 关于
            case R.id.menu_about:
                Toast.makeText(this, "关于", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
    }

    /**
     * 根据城市名查询天气
     */
    private void queryWeatherByCityName() {
        EasyHttp.post(Constants.WEATHER_URL)
                .params("citykey", "101210111")
                .execute(new ProgressDialogCallBack<String>(mDialog) {
                    @Override
                    public void onSuccess(String s) {
                        HttpLog.d(s);
                        Log.e("数据信息",s);
                    }
                });
    }

    private com.zhouyou.http.subsciber.IProgressDialog mDialog = new IProgressDialog() {
        @Override
        public Dialog getDialog() {
            ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("loading");
            return progressDialog;
        }
    };


    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0x001:
                    if (msg.arg2 == SMSSDK.RESULT_COMPLETE) {
                        if (msg.arg1 == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                            boolean smart = (Boolean) msg.obj;
                            if (smart) {
                                //通过智能验证
                                test.setText("tongguo");
                                Toast.makeText(MainActivity.this, "通过智能验证", Toast.LENGTH_SHORT).show();
                            } else {
                                //依然走短信验证
                                onRegist();
                            }
                        }
                    }
                    break;
                case 0x002:
                    test.setText("0x002");
                    break;
                case 0x003:
                    test.setText("0x003");
                    break;
                case 0x004:
                    test.setText("0x004");
                    break;
                default:
            }
        }
    };

    private void onRegist() {

        // 打开注册界面
        RegisterPage registerPage = new RegisterPage();
        registerPage.setRegisterCallback(new EventHandler() {
            @Override
            // 解析注册结果
            public void afterEvent(int event, int result, Object data) {
                //解析注册结果
                if (result == SMSSDK.RESULT_COMPLETE) {
                    /*HashMap<String, Object> phoneMap = (HashMap<String, Object>) data;
                    String country = (String) phoneMap.get("country");
                    String phone = (String) phoneMap.get("phone");
                    registerUser(country,phone);*/

                    Message msg = Message.obtain();
                    msg.what = 0x001;
                    msg.arg1 = event;
                    msg.arg2 = result;
                    msg.obj = data;
                    handler.sendMessage(msg);
                }
            }

            @Override
            public void onUnregister() {
                super.onUnregister();
                handler.sendEmptyMessage(0x002);
            }

            @Override
            public void onRegister() {
                super.onRegister();
                handler.sendEmptyMessage(0x003);
            }

            @Override
            public void beforeEvent(int i, Object o) {
                super.beforeEvent(i, o);
                handler.sendEmptyMessage(0x004);
            }
        });
        registerPage.show(this);
    }

/*    private void registerUser(String country, String phone) {
        Random random = new Random();
        int id = random.nextInt();
        String uid = String.valueOf(id);
        String nickName = "SmsSdk_User_" + id;
        String avatar = AVATARS[id % 12];
        SMSSDK.submitUserInfo(uid, nickName, avatar, country, phone);
    }*/

    @Override
    public void onSuccess(API api, int i, Map<String, Object> map) {
        switch (i) {
            case Weather.ACTION_QUERY:
                onWeatherDetailsGot(map);
                break;
            default:
        }
    }

    @Override
    public void onError(API api, int i, Throwable throwable) {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
    }

    /* menu_city = (TextView) slidingMenu.findViewById(R.id.menu_city);
     menu_weather_info = (TextView) slidingMenu.findViewById(R.id.menu_weather_info);
     menu_temperature = (TextView) slidingMenu.findViewById(R.id.menu_temperature);
     menu_humidity = (TextView) slidingMenu.findViewById(R.id.menu_humidity);
     menu_wind = (TextView) slidingMenu.findViewById(R.id.menu_wind);*/

    @SuppressWarnings("unchecked")
    private void onWeatherDetailsGot(Map<String, Object> result) {
        ArrayList<HashMap<String, Object>> results = (ArrayList<HashMap<String, Object>>) result.get("result");
        HashMap<String, Object> weather = results.get(0);

        weatherInfo = weather.get("weather").toString();
        city = weather.get("city").toString();
        temperature = weather.get("temperature").toString();
        humidity = weather.get("humidity").toString();
        wind = weather.get("wind").toString();

        menu_city.setText(city);
        menu_weather_info.setText(weatherInfo);
        menu_temperature.setText(temperature);
        menu_humidity.setText(humidity);
        menu_wind.setText(wind);


        Message message = Message.obtain();
        message.what = 0x005;
        if (null != handler1) {
            handler1.sendMessage(message);
            Toast.makeText(this, "更新成功", Toast.LENGTH_SHORT).show();
        }
    }

    private SwipeRefreshLayout.OnRefreshListener mOnSwipeRefresh = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            api.queryByCityName("武汉", MainActivity.this);
            handler1 = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);

                    if (msg.what == 0x005) {
                        swipe.setRefreshing(false);
                    }
                }
            };
        }
    };


}

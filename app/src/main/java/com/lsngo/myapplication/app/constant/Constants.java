package com.lsngo.myapplication.app.constant;

/**
 * Created by Administrator on 2017/3/23.
 */

public class Constants {
    // 首页数据的请求地址
    public static String url = "http://api.fengniao.com/app_ipad/pic_bbs_list_v2.php?appImei=000000000000000&osType=Android&osVersion=4.1.1&fid=16&page=1";

    // 天气的请求地址（使用拼接方式）
//    String weatherUrl = "http://apicloud.mob.com/v1/weather/query?key=1c62e7038ee46&city=杭州&province=浙江";
    public static String WEATHER_URL = "http://wthrcdn.etouch.cn/weather_mini";

    public static final String key = "1c68039e69c0d";

    // 豆瓣接口
    public static String  BASE_URL = "https://api.douban.com/";
    String GET_PLAYING_MOVIE = "v2/movie/in_theaters";
    String GET_COMMING_MOVIE = "v2/movie/coming_soon";

    String UPLOAD = "http://upload.qiniu.com/";
    String DOWNLOAD = "http://ucan.25pp.com/Wandoujia_web_seo_baidu_homepage.apk";
}

package com.zhouyou.http;

/**
 * @author lsbing
 * @version 1.0
 * @created 2018/5/9 17:55
 * @title 类的名称
 * @description 该类主要功能描述
 * @changeRecord：2018/5/9 17:55 modify  by lsbing
 */

public class Http {
    private static volatile Http instance;

    public Http() {
    }

    public static Http getInstance() {
        if (instance == null) {
            synchronized (Http.class) {
                instance = new Http();
            }
        }
        return instance;
    }

    public void sendHttp(){

    }
}

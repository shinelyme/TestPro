package com.lsngo.myapplication.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.lsngo.myapplication.R;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by Administrator on 2017/4/1 0001.
 */

public class WebActivity extends AppCompatActivity {

    private ImageView url_share;
    private String web_url;
    private String title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        WebView webView = (WebView) findViewById(R.id.webView);
        url_share = (ImageView) findViewById(R.id.url_share);
        ShareSDK.initSDK(this);
        url_share.setOnClickListener(shareClick);
        Intent intent = getIntent();
        web_url = intent.getStringExtra("web_url");
        title = intent.getStringExtra("title");
        webView.getSettings().setJavaScriptEnabled(true);

        // 设置适应手机屏幕
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webView.getSettings().setLoadWithOverviewMode(true);

        // 加载需要显示的网页
        webView.loadUrl(web_url);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(web_url);
                return true;
            }
        });
    }

    private View.OnClickListener shareClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            OnekeyShare oks = new OnekeyShare();
            //关闭sso授权
            oks.disableSSOWhenAuthorize();

// 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
            //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
            // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
            oks.setTitle(title);
            // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
            oks.setTitleUrl(web_url);
            // text是分享文本，所有平台都需要这个字段
            oks.setText("来自lsngo的手机分享：网址为www.baidu.com");
            // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
            //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
            // url仅在微信（包括好友和朋友圈）中使用
            oks.setUrl("http://www.sina.com");
            // comment是我对这条分享的评论，仅在人人网和QQ空间使用
            oks.setComment("我是测试评论文本");
            // site是分享此内容的网站名称，仅在QQ空间使用
            oks.setSite(getString(R.string.app_name));
            // siteUrl是分享此内容的网站地址，仅在QQ空间使用
            oks.setSiteUrl("http://www.so.com");

// 启动分享GUI
            oks.show(WebActivity.this);
        }
    };

}

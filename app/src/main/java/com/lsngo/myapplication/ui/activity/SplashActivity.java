package com.lsngo.myapplication.ui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.lsngo.myapplication.R;

/**
 * Created by Administrator on 2017/3/29.
 */

public class SplashActivity extends AppCompatActivity {
    private ImageView splash_iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        splash_iv = (ImageView) findViewById(R.id.splash_iv);
        splash_iv.setScaleType(ImageView.ScaleType.FIT_XY);
        playAnimation();
    }

    private void playAnimation() {
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
        alphaAnimation.setDuration(200);
        animationSet.addAnimation(alphaAnimation);

        ScaleAnimation scaleAnimation = new ScaleAnimation(0, 1, 0, 1,
                Animation.RELATIVE_TO_SELF, 0.2f, Animation.RELATIVE_TO_SELF, 0.8f);
        scaleAnimation.setDuration(200);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setAnimationListener(mAnimationListener);
        splash_iv.startAnimation(animationSet);
    }

    Handler handler = new Handler();
    private Animation.AnimationListener mAnimationListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    playNextActivity();
                }
            }, 200);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    };

    private void playNextActivity() {
        SharedPreferences sp = getSharedPreferences("name", MODE_PRIVATE);
        if (sp.getBoolean("firstStart", true)) {
            SharedPreferences.Editor edit = sp.edit();
            // 将登录标志位设置为FALSE，下次登录不在显示首次登录界面
            edit.putBoolean("firstStart", false);
            edit.commit();
            Intent intent = new Intent();
            intent.setClass(this,GuideActivity.class);
            startActivity(intent);
//            startActivity(new Intent(this, GuideActivity.class));
            finish();
        } else {
            startActivity(new Intent(this, MainActivity.class));
//            Toast.makeText(this, "...", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}

package com.app.uicore.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.widget.ImageView;

import com.app.uicore.R;

public class SplashActivity extends FragmentActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ParallaxContainer container = findViewById(R.id.parallax_container);
        container.setUp(new int[]{
                R.layout.view_intro_1,
                R.layout.view_intro_2,
                R.layout.view_intro_3,
                R.layout.view_intro_4,
                R.layout.view_intro_5,
                R.layout.view_login
        });
        ImageView iv_man = (ImageView) findViewById(R.id.iv_man);
        iv_man.setBackgroundResource(R.drawable.man_run);
        container.setIv_man(iv_man);

    }
}

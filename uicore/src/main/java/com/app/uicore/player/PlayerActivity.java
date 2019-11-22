package com.app.uicore.player;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.app.uicore.R;
import com.app.uicore.player.ui.UIUtils;
import com.app.uicore.player.view.BackgourndAnimationRelativeLayout;
import com.app.uicore.player.view.DiscView;
import com.app.uicore.player.view.MusicListener;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class PlayerActivity extends AppCompatActivity implements MusicListener {

    private List<Integer> mMusicDatas = new ArrayList<>();
    private BackgourndAnimationRelativeLayout backgourndAnimationRelativeLayout;
    DiscView mDisc;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UIUtils.getInstance(this);
        setContentView(R.layout.activity_player);
        backgourndAnimationRelativeLayout = findViewById(R.id.rootLayout);
        mDisc = findViewById(R.id.discview);
        mDisc.setMusicListener(this);
        mMusicDatas.add(R.drawable.ic_music1);
        mMusicDatas.add(R.drawable.ic_music2);
        mMusicDatas.add(R.drawable.ic_music3);
        mMusicDatas.add(R.drawable.ic_music1);
        mMusicDatas.add(R.drawable.ic_music2);
        mMusicDatas.add(R.drawable.ic_music3);
        mMusicDatas.add(R.drawable.ic_music1);
        mMusicDatas.add(R.drawable.ic_music2);
        mMusicDatas.add(R.drawable.ic_music3);
        mMusicDatas.add(R.drawable.ic_music1);
        mMusicDatas.add(R.drawable.ic_music2);
        mMusicDatas.add(R.drawable.ic_music3);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mDisc.setMusicDataList(mMusicDatas);
    }

    @Override
    public void onMusicPicChanged(int resId) {
        Glide.with(this)
                .load(resId)
                .crossFade(500)
                .bitmapTransform(new BlurTransformation(this, 200, 3))
                .into(new SimpleTarget<GlideDrawable>() {
                    @Override
                    public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                        backgourndAnimationRelativeLayout.setForeground(resource);
                    }
                });
    }
}

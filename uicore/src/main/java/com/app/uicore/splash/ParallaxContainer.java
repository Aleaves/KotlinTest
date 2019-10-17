package com.app.uicore.splash;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.app.uicore.R;

import java.util.ArrayList;
import java.util.List;

public class ParallaxContainer extends FrameLayout implements ViewPager.OnPageChangeListener {

    private List<ParallaxFragment> fragments;

    public ParallaxContainer(Context context) {
        super(context);
    }

    public ParallaxContainer(Context context,AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    public void setUp(int... childIds){
        fragments = new ArrayList<>();
        for (int i = 0; i<childIds.length;i++){
            ParallaxFragment f = new ParallaxFragment();
            Bundle args = new Bundle();
            args.putInt("layoutId",childIds[i]);
            f.setArguments(args);
            fragments.add(f);
        }
         ViewPager vp = new ViewPager(getContext());
         vp.setId(R.id.parallax_pager);
         SplashActivity activity = (SplashActivity) getContext();
         ParallaxPagerAdapter adapter = new ParallaxPagerAdapter(activity.getSupportFragmentManager(),fragments);
         vp.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
         vp.setAdapter(adapter);
         addView(vp,0);
    }

}

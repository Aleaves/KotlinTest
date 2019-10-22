package com.app.uicore.splash;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.app.uicore.R;
import com.nineoldandroids.view.ViewHelper;

import java.util.ArrayList;
import java.util.List;

public class ParallaxContainer extends FrameLayout implements ViewPager.OnPageChangeListener {

    private List<ParallaxFragment> fragments;
    private ParallaxPagerAdapter adapter;
    private ImageView iv_man;

    public ParallaxContainer(Context context) {
        super(context);
    }

    public ParallaxContainer(Context context,AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        ParallaxFragment inFragment = null;
        int containerWidth = getWidth();
        ParallaxFragment outFragment = null;

        try {
            outFragment=fragments.get(position - 1);
        } catch (Exception e) {}
        try {
            inFragment = fragments.get(position);
        } catch (Exception e) {}
        if (outFragment != null) {
            List<View> outViews = outFragment.getParallaxViews();
            if (outViews != null) {
                for (View view : outViews) {
                    //获取标签，从标签上获取所有的动画参数
                    ParallaxViewTag tag = (ParallaxViewTag) view.getTag(R.id.parallax_view_tag);
                    if (tag == null) {
                        continue;
                    }

                    ViewHelper.setTranslationX(view, containerWidth - positionOffsetPixels * tag.xIn);
                    ViewHelper.setTranslationY(view, containerWidth - positionOffsetPixels * tag.yIn);
                }
            }
        }
        if(inFragment != null){
            List<View> outViews = inFragment.getParallaxViews();
            if (outViews != null) {
                for (View view : outViews) {
                    ParallaxViewTag tag = (ParallaxViewTag) view.getTag(R.id.parallax_view_tag);
                    if (tag == null) {
                        continue;
                    }
                    //仔细观察退出的fragment中view从原始位置开始向上移动，translationY应为负数
                    ViewHelper.setTranslationY(view, 0 - positionOffsetPixels * tag.yOut);
                    ViewHelper.setTranslationX(view, 0 - positionOffsetPixels * tag.xOut);
                }
            }
        }

    }
    public void setIv_man(ImageView iv_man) {
        this.iv_man = iv_man;
    }


    @Override
    public void onPageSelected(int position) {
        if (position == adapter.getCount() - 1) {
            iv_man.setVisibility(INVISIBLE);
        }else{
            iv_man.setVisibility(VISIBLE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        AnimationDrawable animation = (AnimationDrawable) iv_man.getBackground();
        switch (state) {
            case ViewPager.SCROLL_STATE_DRAGGING:
                animation.start();
                break;

            case ViewPager.SCROLL_STATE_IDLE:
                animation.stop();
                break;

            default:
                break;
        }
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
         adapter = new ParallaxPagerAdapter(activity.getSupportFragmentManager(),fragments);
         vp.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
         vp.setAdapter(adapter);
         addView(vp,0);
         vp.addOnPageChangeListener(this);
    }

}

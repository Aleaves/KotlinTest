package com.app.uicore.player.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.app.uicore.R;
import com.app.uicore.player.ViewPagerAdapter;
import com.app.uicore.player.ui.UIUtils;
import com.app.uicore.player.ui.ViewCalculateUtil;
import com.app.uicore.player.util.BitmapUtil;

import java.util.ArrayList;
import java.util.List;

public class DiscView extends RelativeLayout {


    //    Pager的View
    private List<View> mDiscLayouts = new ArrayList<>();

    private List<Integer> mMusicDatas = new ArrayList<>();

    private List<ObjectAnimator> mDiscAnimators = new ArrayList<>();
    ImageView musicNeedle;
    ImageView musicCircle;
    private ViewPagerAdapter mViewPagerAdapter;
    private ObjectAnimator mNeedleAnimator;
    private ViewPager viewPager;
    private int currentItem = 0;
    private boolean isNeedStartDiscAnim;
    private MusicListener musicListener;


    public DiscView(Context context) {
        super(context);
    }

    public DiscView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DiscView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setMusicListener(MusicListener musicListener){
        this.musicListener = musicListener;
    }

    public void setMusicDataList(List<Integer> musicDataList) {
        if (musicDataList.isEmpty()) return;
        mDiscLayouts.clear();
        mMusicDatas.clear();
        mDiscAnimators.clear();
        mMusicDatas.addAll(musicDataList);

        for (Integer resId:mMusicDatas){
            View centerContainer = LayoutInflater.from(getContext()).inflate(R.layout.layout_disc,viewPager,false);
            ImageView centerImage = (ImageView) centerContainer.findViewById(R.id.music_img);
            Drawable drawable = BitmapUtil.getMusicItemDrawable(getContext(),resId);
            ViewCalculateUtil.setViewLinearLayoutParam(centerImage, 800, 800, ((850 - 800) / 2)+190, 0, 0, 0);
            centerImage.setImageDrawable(drawable);
            mDiscLayouts.add(centerContainer);

            ObjectAnimator rotateAnimator = ObjectAnimator.ofFloat(centerImage,View.ROTATION,0,360);
            rotateAnimator.setRepeatCount(ValueAnimator.INFINITE);
            rotateAnimator.setDuration(20*1000);
            rotateAnimator.setInterpolator(new LinearInterpolator());
            mDiscAnimators.add(rotateAnimator);

        }

        mViewPagerAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        initView();
        initObjectAnimator();
        mViewPagerAdapter = new ViewPagerAdapter(mDiscLayouts);
        viewPager.setAdapter(mViewPagerAdapter);
    }

    private void initView(){
        musicNeedle = findViewById(R.id.musicNeedle);
        viewPager = findViewById(R.id.viewPager);
        musicCircle = findViewById(R.id.musicCircle);
        int musicCircleWidth= UIUtils.getInstance().getWidth(813);
        Bitmap bitmapDisc = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R
                .drawable.ic_disc_blackground), musicCircleWidth, musicCircleWidth, false);
        RoundedBitmapDrawable roundDiscDrawable = RoundedBitmapDrawableFactory.create
                (getResources(), bitmapDisc);
        musicCircle.setImageDrawable(roundDiscDrawable);
        ViewCalculateUtil.setViewLayoutParam(musicCircle, 850, 850, 190, 0, 0, 0);

        Bitmap originBitmap = BitmapFactory.decodeResource(getResources(), R.drawable
                .ic_needle);
        Bitmap bitmap = Bitmap.createScaledBitmap(originBitmap, UIUtils.getInstance().getWidth(276), UIUtils.getInstance().getWidth(276), false);

        ViewCalculateUtil.setViewLayoutParam(musicNeedle, 276, 413, 43, 0, 500, 0);
        musicNeedle.setPivotX(UIUtils.getInstance().getWidth(43));
        musicNeedle.setPivotY(UIUtils.getInstance().getHeight(43));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {
                //currentItem = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                switch (state){
                    case ViewPager.SCROLL_STATE_IDLE:
                        Log.i("=========","0");
                        break;
                    case ViewPager.SCROLL_STATE_SETTLING:
                        Log.i("=========","up");
                        playAnimator();
                        break;
                    case ViewPager.SCROLL_STATE_DRAGGING:
                        Log.i("=========","drag");
                        pauseAnimator();
                        break;
                }
            }
        });

    }

    private void initObjectAnimator(){
        mNeedleAnimator = ObjectAnimator.ofFloat(musicNeedle,View.ROTATION,-30,0);
        mNeedleAnimator.setDuration(500);
        mNeedleAnimator.setInterpolator(new AccelerateInterpolator());
        mNeedleAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.i("=============","指针动画结束");
                int index = viewPager.getCurrentItem();
                playDiscAnimator(index);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    private void playDiscAnimator(int index) {
        if(isNeedStartDiscAnim) {
            ObjectAnimator objectAnimator = mDiscAnimators.get(index);
            if (objectAnimator.isPaused()) {
                objectAnimator.resume();
            } else {
                objectAnimator.start();
            }
            if(currentItem == viewPager.getCurrentItem()){
                mNeedleAnimator.reverse();
            }
        }
        if(currentItem != viewPager.getCurrentItem()){
            currentItem = viewPager.getCurrentItem();
            if(null != musicListener){
                musicListener.onMusicPicChanged( mMusicDatas.get(viewPager.getCurrentItem() ));
            }
        }

    }

    private void playAnimator(){
        isNeedStartDiscAnim = true;
        mNeedleAnimator.start();
    }

    private void pauseAnimator(){
        isNeedStartDiscAnim = false;
        ObjectAnimator objectAnimator = mDiscAnimators.get(viewPager.getCurrentItem());
        objectAnimator.pause();
        mNeedleAnimator.reverse();
    }

}

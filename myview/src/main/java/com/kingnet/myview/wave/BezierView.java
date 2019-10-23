package com.kingnet.myview.wave;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;

public class BezierView extends View {

    private Paint mPaint;
    private Path mBezierPath;

    private int mItemWidth = 300;

    private ValueAnimator mAnimator;
    private int mOffsetX;


    public BezierView(Context context) {
        super(context);
        init();
    }

    public BezierView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BezierView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){

        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(5);

        mBezierPath = new Path();
        mAnimator = ValueAnimator.ofInt(0,mItemWidth);
        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mOffsetX = (int)animation.getAnimatedValue();
                invalidate();
            }
        });
        mAnimator.setInterpolator(new LinearInterpolator());
        mAnimator.setDuration(1000);
        mAnimator.setRepeatCount(-1);
        mAnimator.start();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mBezierPath.reset();
        int halfItem = mItemWidth/2;
        mBezierPath.moveTo(-mItemWidth + mOffsetX,halfItem);
        for(int i = -mItemWidth;i<mItemWidth + getWidth();i+=mItemWidth){
            mBezierPath.rQuadTo(halfItem/2,-100,halfItem,0);
            mBezierPath.rQuadTo(halfItem/2,100,halfItem,0);
        }

        //闭合路径波浪以下区域

        Log.i("=======",getWidth()+"===="+getHeight());
        mBezierPath.lineTo(getWidth(), getHeight());
        mBezierPath.lineTo(0, getHeight());
        mBezierPath.close();

        canvas.drawPath(mBezierPath,mPaint);

    }
}

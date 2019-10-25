package com.kingnet.myview.wave;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
/**
 * 水波纹进度自定义view
 */
public class WaveLoadingView extends View {

    private Path mWavePath1 = new Path();

    private int mItemWidth = 120;

    private int mOffsetX1,mOffsetX2;

    //整个View的宽高
    private float mWidth, mHeight;

    //当前水位高度的纵坐标
    private int mWaterTop;
    //每节波浪上下波动的幅度
    private int mWaveHeight = 100;

    private Paint mIconPaint;


    public WaveLoadingView(Context context) {
        super(context);
    }

    public WaveLoadingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //init();
    }

    public WaveLoadingView(Context context,@Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        mIconPaint = new Paint();
        mIconPaint.setFilterBitmap(true);
        mIconPaint.setAntiAlias(true);
        mIconPaint.setDither(true);

        mWavePath1 = new Path();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.i("=========1",getWidth()+"===="+getHeight());
        Log.i("=========2",mWidth+"==="+mHeight);
        mWavePath1.reset();
        int halfItem = mItemWidth/2;
        mWavePath1.moveTo(0,0);
        mWavePath1.lineTo(-mItemWidth + mOffsetX1,mWaterTop);
        for (int i = -mItemWidth;i<mItemWidth + mWidth;i+=mItemWidth){
            mWavePath1.rQuadTo(halfItem/2,-mWaveHeight,halfItem,0);
            mWavePath1.rQuadTo(halfItem/2,mWaveHeight,halfItem,0);
        }

        mWavePath1.lineTo(mWidth,mHeight);
        mWavePath1.lineTo(0,mHeight);
        mWavePath1.lineTo(-mItemWidth + mOffsetX1, mWaterTop);
        mWavePath1.close();

        //绘制水波纹1
        canvas.drawPath(mWavePath1, mIconPaint);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.i("==========",left+"==="+top+"==="+right+"=="+right);
        mWidth = right - left;
        mHeight = bottom - top;
        mWaterTop = (int)mHeight;
    }
}

package com.app.uicore.gradient;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.app.uicore.R;

public class GradientLayout extends View {

    private Paint mPaint;

    private Shader mShader;

    private Bitmap mBitmap;


    public GradientLayout(Context context) {
        super(context);
        Log.i("========", "1");
        init();
    }

    public GradientLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.i("========", "2");
        init();
    }

    public GradientLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.i("========", "3");
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //线性渲染
        //mShader = new LinearGradient(0,0,500,500,new int[]{Color.RED,Color.BLUE,Color.GREEN},new float[]{0f,0.7f,1},Shader.TileMode.CLAMP);
        //mPaint.setShader(mShader);
        //canvas.drawCircle(250,250,250,mPaint);
        //canvas.drawRect(0,0,500,500,mPaint);
        //环形渲染
//        mShader = new RadialGradient(250,250,250,new int[]{Color.GREEN,Color.YELLOW,Color.RED},null,Shader.TileMode.CLAMP);
//        mPaint.setShader(mShader);
//        canvas.drawCircle(250,250,250,mPaint);
        //扫描渲染
//        mShader = new SweepGradient(250,250,Color.RED,Color.GREEN);
//        mPaint.setShader(mShader);
//        canvas.drawCircle(250,250,250,mPaint);

        //位图渲染
//        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.beauty);
//        mShader = new BitmapShader(mBitmap, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR);
//        mPaint.setShader(mShader);
//        //canvas.drawCircle(250,250,250,mPaint);
//        canvas.drawRect(0, 0, mBitmap.getWidth()*3, mBitmap.getHeight()*3, mPaint);
        

    }
}

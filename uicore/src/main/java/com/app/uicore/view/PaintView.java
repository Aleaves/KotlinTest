package com.app.uicore.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;

public class PaintView extends View {

    private Paint mPaint;
    private Shader mShader;

    private String text = "Android高级开发工程师";

    public PaintView(Context context) {
        super(context);
        init();
    }

    private void init(){

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.RED);
        mPaint.setTextSize(50);
        mPaint.setTypeface(Typeface.MONOSPACE);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawText(text,50,50,mPaint);
//        Rect bounds = new Rect();
//        mPaint.getTextBounds(text,0,text.length(),bounds);
//        Paint.FontMetrics metrics = mPaint.getFontMetrics();

//        mShader = new LinearGradient(0,0,0,0,new int[]{Color.RED,Color.BLUE},null,Shader.TileMode.CLAMP);
//        mPaint.setShader(mShader);
//        canvas.drawCircle(250,250,250,mPaint);

        mShader = new RadialGradient(250,250,250,new int[]{Color.RED,Color.BLUE},null,Shader.TileMode.CLAMP);
        mPaint.setShader(mShader);
        canvas.drawCircle(250,250,250,mPaint);
    }

}

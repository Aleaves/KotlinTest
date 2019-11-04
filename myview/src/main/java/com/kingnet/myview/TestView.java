package com.kingnet.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class TestView extends View {

    public TestView(Context context) {
        super(context);
    }

    public TestView(Context context,@Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TestView(Context context,@Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(10);
        Log.i("==========",getWidth()+"===="+getHeight());
        canvas.drawCircle(getWidth()/2,getHeight()/2,50,paint);
        Path path = new Path();
        //path.moveTo(0,0);
        Log.i("==========",getWidth()+"===="+getHeight());
        path.lineTo(getWidth(),0);
        path.lineTo(getWidth(),getHeight());
        path.lineTo(0,getHeight());
        path.close();

        canvas.drawPath(path,paint);
        //Log.i("========","draw");
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.i("========",left+"=="+top+"=="+right+"=="+bottom);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.i("=========1",(MeasureSpec.getMode(widthMeasureSpec) == MeasureSpec.AT_MOST)+"==="+MeasureSpec.getSize(widthMeasureSpec));
        Log.i("=========2",(MeasureSpec.getMode(heightMeasureSpec) == MeasureSpec.AT_MOST)+"==="+MeasureSpec.getSize(heightMeasureSpec));
        setMeasuredDimension(400,400);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("===========",event.getX()+"===="+event.getY());

        return super.onTouchEvent(event);

    }
}

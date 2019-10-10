package com.app.uicore.bezier;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class BezierView extends View {

    private Paint mPaint;
    private Path mPath;

    public BezierView(Context context) {
        super(context);
        init();

    }

    public BezierView(Context context,AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BezierView(Context context,AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(5);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.RED);
        mPath = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPath.moveTo(100,100);
        mPath.quadTo(150,50,500,500);
        canvas.drawPath(mPath,mPaint);
    }
}

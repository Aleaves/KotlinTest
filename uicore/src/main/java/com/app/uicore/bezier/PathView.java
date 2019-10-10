package com.app.uicore.bezier;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;


public class PathView extends View {

    private Path mPath = new Path();
    private Paint mPaint = new Paint();


    public PathView(Context context) {
        super(context);
        init();
    }

    public PathView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PathView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init(){
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(4);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


//        mPath.moveTo(100,70);
//        mPath.lineTo(140,800);
//        mPath.lineTo(250,600);
//        mPath.close();


        //mPath.addArc(200,200,400,400,-90,270);

        mPath.addRect(500,500,900,900,Path.Direction.CCW);

        mPath.addCircle(700,700,200,Path.Direction.CCW);

        //mPath.addOval(0,0,500,300,Path.Direction.CCW);

        //mPath.arcTo();

        canvas.drawPath(mPath,mPaint);

    }
}

package com.app.uicore.xfermode;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.app.uicore.R;

public class EraserView extends View {

    private Paint mPaint;
    private Bitmap mDstBmp,mSrcBmp,mTxtBmp;
    private Path mPath;


    public EraserView(Context context) {
        super(context);
        init();
    }

    public EraserView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EraserView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(80);

        setLayerType(View.LAYER_TYPE_SOFTWARE,null);

        mTxtBmp = BitmapFactory.decodeResource(getResources(), R.drawable.result);
        mSrcBmp = BitmapFactory.decodeResource(getResources(),R.drawable.eraser);

        mDstBmp = Bitmap.createBitmap(mSrcBmp.getWidth(),mSrcBmp.getHeight(),Bitmap.Config.ARGB_8888);

        mPath = new Path();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(mTxtBmp,0,0,mPaint);

        int layerId = canvas.saveLayer(0,0,getWidth(),getHeight(),mPaint,Canvas.ALL_SAVE_FLAG);

        Canvas dstCanvas = new Canvas(mDstBmp);
        dstCanvas.drawPath(mPath,mPaint);

        canvas.drawBitmap(mDstBmp,0,0,mPaint);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));

        canvas.drawBitmap(mSrcBmp,0,0,mPaint);

        mPaint.setXfermode(null);

        canvas.restoreToCount(layerId);

    }

    private float mEventX,mEventY;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mEventX = event.getX();
                mEventY = event.getY();
                mPath.moveTo(mEventX,mEventY);
                break;
            case MotionEvent.ACTION_MOVE:
                float endX = (event.getX() - mEventX)/2 + mEventX;
                float endY = (event.getY() - mEventY)/2 +mEventY;
                mPath.quadTo(mEventX,mEventY,endX,endY);
                mEventX = event.getX();
                mEventY = event.getY();
                break;
        }
        invalidate();
        return true;
    }
}

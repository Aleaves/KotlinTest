package com.app.uicore.colorfilter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.AttributeSet;
import android.view.View;

import com.app.uicore.R;

public class ColorFilterView extends View {

    private Paint mPaint;
    private Bitmap mBitmap;


    public ColorFilterView(Context context) {
        super(context);
        init();
    }

    public ColorFilterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ColorFilterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init(){
        mPaint = new Paint();
        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.girl);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        LightingColorFilter lighting = new LightingColorFilter(0x00ffff,0x000000);
//        mPaint.setColorFilter(lighting);
//        canvas.drawBitmap(mBitmap,0,0,mPaint);

//        LightingColorFilter lighting = new LightingColorFilter(0xffffff,0x000000);
//        mPaint.setColorFilter(lighting);
//        canvas.drawBitmap(mBitmap,0,0,mPaint);

        PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.DARKEN);
        mPaint.setColorFilter(porterDuffColorFilter);
        canvas.drawBitmap(mBitmap,0,0,mPaint);

    }
}

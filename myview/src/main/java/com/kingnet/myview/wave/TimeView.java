package com.kingnet.myview.wave;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TimeView extends View {

    private int mCircleRadius = 400;

    private int mSecondRadius = 380;
    private int mMinuteRadius = 300;
    private int mHourRadius = 200;

    private int lineWidth = 8;
    private int pointBigWidth = 14;
    private int pointSmallWidth = 8;

    private int textWidth = 50;
    private int textDistance = 35;

    private int diff = 5;

    private Paint mHourPaint;
    private Paint mSecondPaint;
    private Paint mMinutePaint;
    private Paint mPointPaint;
    private Paint mTextPaint;

    private float centerX, centerY;

    private List<Point> points = new ArrayList<>();
    private List<Point> textPoints = new ArrayList<>();


    private int cHour,cMinute,cSecond;

    public TimeView(Context context) {
        super(context);
        init();
    }

    public TimeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TimeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        mPointPaint = new Paint();
        mPointPaint.setAntiAlias(true);
        mPointPaint.setStyle(Paint.Style.FILL);
        mPointPaint.setStrokeCap(Paint.Cap.ROUND);
        mPointPaint.setColor(Color.BLACK);

        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setColor(Color.BLACK);
        mTextPaint.setTextSize(textWidth);
        mTextPaint.setTextAlign(Paint.Align.CENTER);

        mSecondPaint = new Paint();
        mSecondPaint.setAntiAlias(true);
        mSecondPaint.setColor(Color.RED);
        mSecondPaint.setStrokeWidth(lineWidth);
        mSecondPaint.setStrokeCap(Paint.Cap.ROUND);

        mMinutePaint = new Paint();
        mMinutePaint.setAntiAlias(true);
        mMinutePaint.setColor(Color.BLUE);
        mMinutePaint.setStrokeWidth(lineWidth);
        mMinutePaint.setStrokeCap(Paint.Cap.ROUND);

        mHourPaint = new Paint();
        mHourPaint.setAntiAlias(true);
        mHourPaint.setColor(Color.YELLOW);
        mHourPaint.setStrokeWidth(lineWidth);
        mHourPaint.setStrokeCap(Paint.Cap.ROUND);

        initCurrentTime();
    }

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            cSecond ++;
            if(cSecond >= 60){
                cSecond = 0;
                cMinute ++;
            }

            if(cMinute >= 60){
                cMinute = 0;
                cHour++;
            }
            if(cHour >= 12){
                cHour = 0;
            }
            invalidate();
            mHandler.sendEmptyMessageDelayed(1,1000);
        }
    };

    //初始化当前时间
    private void initCurrentTime() {

        Calendar c = Calendar.getInstance();
        cHour = c.get(Calendar.HOUR);
        cMinute = c.get(Calendar.MINUTE);
        cSecond = c.get(Calendar.SECOND);

        mHandler.sendEmptyMessageDelayed(1,1000);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        centerX = (float) getWidth() / 2;
        centerY = (float) getHeight() / 2;

        //drawTimeCircle(canvas);

        //画钟表刻度
        drawPoint(canvas);

        //画数字
        drawText(canvas);

        //画时针
        drawHourPoint(canvas);

        //画分钟
        drawMinutePoint(canvas);

        //画秒钟
        drawSecondPoint(canvas);

    }

    private void drawHourPoint(Canvas canvas) {

        float angle = (float) (Math.PI * 2 * (cHour - 3)*5 / 60) + (float) (Math.PI*2*cMinute/12/60);
        float hX = (float) (centerX + mHourRadius*Math.cos(angle));
        float hY = (float)(centerY + mHourRadius*Math.sin(angle));
        canvas.drawLine(centerX,centerY,hX,hY,mHourPaint);

    }

    private void drawMinutePoint(Canvas canvas) {

        float angle = (float) (Math.PI * 2 * (cMinute -15) / 60) + (float) (Math.PI*2*cSecond/60/60);
        float cX = (float) (centerX + mMinuteRadius*Math.cos(angle));
        float cY = (float)(centerY + mMinuteRadius*Math.sin(angle));

        canvas.drawLine(centerX,centerY,cX,cY,mMinutePaint);

    }


    private void drawSecondPoint(Canvas canvas) {

        float angle = (float) (Math.PI * 2 * (cSecond - 15) / 60);
        float sX = (float) (centerX + mSecondRadius*Math.cos(angle));
        float sY = (float)(centerY + mSecondRadius*Math.sin(angle));

        canvas.drawLine(centerX,centerY,sX,sY,mSecondPaint);

    }

    private void drawText(Canvas canvas) {

        for (int i = 0; i < textPoints.size(); i++) {
            int text = i + 3;
            if (text > 12) {
                text = text - 12;
            }
            //让文字居中
            Paint.FontMetrics fontMetrics = mTextPaint.getFontMetrics();
            float distance = (fontMetrics.bottom - fontMetrics.top) / 2 - fontMetrics.bottom;
            float baseline = textPoints.get(i).y + distance;

            float tX = textPoints.get(i).x;
            float tY = baseline;

            if (textPoints.get(i).x <= (centerX + diff) && textPoints.get(i).x >= (centerX - diff)) {
                //tX = textPoints.get(i).x;
            }else {
                if (textPoints.get(i).x > centerX) {
                    tX = textPoints.get(i).x - textDistance;
                } else if (textPoints.get(i).x < centerX) {
                    tX = textPoints.get(i).x + textDistance;
                }
            }
            if (textPoints.get(i).y <= (centerY + diff) && textPoints.get(i).y >= (centerY - diff)) {
                //tY = baseline;
            }else {
                if (textPoints.get(i).y > centerY) {
                    tY = baseline - textDistance;
                } else if (textPoints.get(i).y < centerY) {
                    tY = baseline + textDistance;
                }
            }
            canvas.drawText(text + "", tX, tY, mTextPaint);
        }

        textPoints.clear();
        points.clear();


    }

    /**
     * 画钟表的时刻
     *
     * @param canvas
     */
    private void drawPoint(Canvas canvas) {
        for (int i = 0; i < 60; i++) {
            float angle = (float) (Math.PI * 2 * i / 60);
            Point point = new Point((int) (centerX + mCircleRadius * Math.cos(angle)), (int) (centerY + mCircleRadius * Math.sin(angle)));
            points.add(point);
        }
        for (int i = 0; i < points.size(); i++) {
            if (i % 5 == 0) {
                textPoints.add(points.get(i));
                mPointPaint.setStrokeWidth(pointBigWidth);
            } else {
                mPointPaint.setStrokeWidth(pointSmallWidth);
            }
            canvas.drawPoint(points.get(i).x, points.get(i).y, mPointPaint);
        }
    }

}

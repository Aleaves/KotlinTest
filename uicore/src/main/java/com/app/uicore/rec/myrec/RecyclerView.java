package com.app.uicore.rec.myrec;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;

import com.app.uicore.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerView extends ViewGroup {

    private Adapter adapter;

    //当前显示的View
    private List<View> viewList;
    //当前滑动的y值
    private int currentY;
    //行数
    private int rowCount;
    //view的第一行  是占内容的几行
    private int firstRow;
    //y偏移量
    private int scrollY;

    //初始化  第一屏最慢
    private boolean needRelayout;
    private int width;

    private int height;
    private int[] heights;//item  高度
    Recycler recycler;
    //最小滑动距离
    private int touchSlop;

    public Adapter getAdapter() {
        return adapter;
    }

    public void setAdapter(Adapter adapter) {
        this.adapter = adapter;
        if(adapter != null){
            recycler = new Recycler(adapter.getViewTypeCount());
            scrollY = 0;
            firstRow = 0;
            needRelayout = true;
            requestLayout();
        }
    }

    public RecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        ViewConfiguration configuration = ViewConfiguration.get(context);
        this.touchSlop = configuration.getScaledTouchSlop();
        this.viewList = new ArrayList<>();
        this.needRelayout = true;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if(needRelayout || changed){
            needRelayout = false;
            viewList.clear();
            removeAllViews();

            if(adapter != null){
                width = r - l;
                height = b - t;
                int left, top = 0, right, bottom;
                for (int i = 0;i<rowCount && top < height;i++){
                    right = width;
                    bottom = top + heights[i];
                    //生成一个View
                    View view= makeAndStep(i, 0, top, width, bottom);
                    viewList.add(view);
                    top = bottom;//循环摆放
                }
            }
        }
    }

    private View makeAndStep(int row,int left,int top, int right,int bottom){
        View view = obtainView(row,right - left,bottom - top);
        view.layout(left,top,right,bottom);
        return view;
    }

    private View obtainView(int row,int width,int height){
        int itemType = adapter.getItemViewType(row);
        View reclyView = recycler.get(itemType);
        View view = null;
        if (reclyView == null) {
            view = adapter.onCreateViewHodler(row, reclyView, this  );
            if (view == null) {
                throw new RuntimeException("onCreateViewHodler  必须填充布局");
            }
        }else {
            view = adapter.onBinderViewHodler(row, reclyView, this);
        }

        view.setTag(R.id.tag_type_view, itemType);
        view.measure(MeasureSpec.makeMeasureSpec(width,MeasureSpec.EXACTLY)
                ,MeasureSpec.makeMeasureSpec(height,MeasureSpec.EXACTLY));
        addView(view,0);
        return view;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        final int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        final int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int h = 0;
        if (adapter != null) {
            this.rowCount = adapter.getCount();
            heights = new int[rowCount];
            for (int i = 0; i < heights.length; i++) {
                heights[i] = adapter.getHeight(i);
            }
        }
        int tempH = sumArray(heights,0,heights.length);
        h = Math.min(heightSize,tempH);
        setMeasuredDimension(widthSize,h);
    }

    private int sumArray(int array[], int firstIndex, int count) {
        int sum = 0;
        count += firstIndex;
        for (int i = firstIndex; i < count; i++) {
            sum += array[i];
        }
        return sum;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercept = false;
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                currentY = (int) ev.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                int y2 = Math.abs(currentY - (int) ev.getRawY());
                if(y2 > touchSlop){
                    intercept = true;
                }
                break;
        }
        return intercept;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_MOVE:
                int y2 = (int) event.getRawY();
                //上滑正   下滑负
                int diffY = currentY - y2;
                scrollBy(0,diffY);
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void scrollBy(int x, int y) {
        super.scrollBy(x, y);
    }

    interface Adapter {
        View onCreateViewHodler(int position, View convertView, ViewGroup parent);

        View onBinderViewHodler(int position, View convertView, ViewGroup parent);

        //Item的类型
        int getItemViewType(int row);

        //Item的类型数量
        int getViewTypeCount();

        int getCount();

        public int getHeight(int index);
    }
}

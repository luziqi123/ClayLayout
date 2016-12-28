package com.clay.layout.layout;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * 这是一个可配置的布局，如同名字一样，他可以通过不同的策略塑造出不同的布局
 * Created by Administrator on 2016/12/6.
 */
public class ClayLayout extends ViewGroup {

    private String TAG = "ClayLayout---";

    private Context mContext;

    private int mWidth , mHeight;

    /**
     * 他是影响你布局样貌的关键所在，提供了对子控件计算的方法
     */
    private IStrategy mStrategy;

    public ClayLayout(Context context) {
        this(context, null);
    }

    public ClayLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ClayLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ClayLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = widthMeasureSpec;
        mHeight = heightMeasureSpec;
        if (mStrategy != null) {
            mStrategy.setSpec(getMeasuredWidth() , getMeasuredHeight());
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            measureChild(childAt, widthMeasureSpec, heightMeasureSpec);
        }

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (mStrategy == null) {
            return;
        }
        int childCount = getChildCount();
        mStrategy.setViewCount(childCount);
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int[] layout = mStrategy.measureLayout(childAt , i);
            if (layout == null || layout.length < 4){
                throw new IllegalStateException("Wrong return value！Strategy.measureLayout(int index) return is a int[4]");
            }
            childAt.layout(
                    layout[IStrategy.LEFT] ,
                    layout[IStrategy.TOP] ,
                    layout[IStrategy.RIGHT] ,
                    layout[IStrategy.BOTTOM]);
        }
    }

    public void setStrategy(IStrategy strategy){
        mStrategy = strategy;
        mStrategy.setSpec(getMeasuredWidth() , getMeasuredHeight());
        mStrategy.setViewCount(getChildCount());
        requestLayout();
    }

}

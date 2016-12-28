package com.clay.layout.layout;

import android.util.Log;
import android.view.View;

/**
 * 线性布局
 * Created by L on 2016/12/7.
 */
public class LinearStrategy extends IStrategy{

    private String TAG = "LinearStrategy";

    /**
     * 横向
     */
    public static final int MODE_HORIZONTAL = 0;

    /**
     * 纵向
     */
    public static final int MODE_VERTICAL = 1;

    /**
     * 当前模式
     * 默认为纵向
     */
    private int mMode = MODE_VERTICAL;

    /**
     * 上一个View占的地方
     */
    private int mLastViewSize = 0;

    /**
     * 上一个View开始的地方
     */
    private int mLastStart = 0;

    /**
     * 上一排中最大的一个View
     */
    private int mMaxSize = 1;

    /**
     * 设置每个控件之间的间距
     */
    private int mPadding = 10;

    /**
     *
     */
    private int[] layout  = new int[4];

    private int[] mWrap = new int[2];

    @Override
    public int[] measureLayout(View view , int index) {
        switch (mMode) {
            case MODE_HORIZONTAL:
                horizontalLayout(view, index);
                break;
            case MODE_VERTICAL:
                verticalLayout(view, index);
                break;
        }
        return layout;
    }

    private void verticalLayout(View view, int index) {
        mMaxSize = view.getMeasuredWidth() > mMaxSize ? view.getMeasuredWidth() : mMaxSize;
        layout[LEFT] = 0;
        layout[TOP] = mLastStart + mLastViewSize + (index == 0 ? 0 : mPadding);
        layout[RIGHT] = view.getMeasuredWidth();
        layout[BOTTOM] = mLastStart + mLastViewSize + view.getMeasuredHeight() + (index == 0 ? 0 : mPadding);
        mLastStart = layout[TOP];
        mLastViewSize = view.getMeasuredHeight();
        Log.i(TAG, "measureLayout: " + layout[TOP]);
    }

    private void horizontalLayout(View view, int index) {
        mMaxSize = view.getMeasuredHeight() > mMaxSize ? view.getMeasuredHeight() : mMaxSize;
        layout[LEFT] = 0;
        layout[TOP] = mLastStart + mLastViewSize + (index == 0 ? 0 : mPadding);
        layout[RIGHT] = view.getMeasuredWidth();
        layout[BOTTOM] = mLastStart + mLastViewSize + view.getMeasuredHeight() + (index == 0 ? 0 : mPadding);
        mLastStart = layout[LEFT];
        mLastViewSize = view.getMeasuredWidth();
    }

    public void setPadding(int padding){
        mPadding = padding;
    }

    public void setMode(int mode){
        mMode = Math.abs(mode) % MODE_VERTICAL;
    }

}

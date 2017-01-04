package com.clay.longface.layout.grid;

import android.view.View;

import com.clay.longface.layout.IStrategy;

/**
 * 网格布局，将子控件从左到右排列
 * 可以设置几行几列
 * Created by Administrator on 2017/1/4.
 */
public class GridStrategy extends IStrategy{

    /**
     * 横向和纵向的间距
     */
    private int mHorSpac  = 0, mVerSpac = 0;

    /**
     * 设置的行列数量
     */
    private int mColumn = 3;

    /**
     * 当前这个View是第几行第几列
     */
    private int mCurrLine = 1;

    /**
     * 最后返回的坐标
     */
    private int[] layout = new int[]{0,0,0,0};

    /**
     * 上一个View的坐标
     */
    private int lastRight = 0;

    /**
     * 一行中的最大值
     */
    private int mMaxHight = 0;
    private int _maxHight = 0;

    public GridStrategy(int norms){
        mColumn = norms;
    }


    @Override
    public int[] measureLayout(View view, int index) {
//        if (view.getMeasuredHeight() > mMaxHight)
//            mMaxHight = view.getMeasuredHeight();
        layout[LEFT] = lastRight + (index % mColumn == 1 ? 0 : mHorSpac);
        layout[RIGHT] = layout[LEFT] + view.getMeasuredWidth();
        layout[TOP] = mMaxHight + (mCurrLine == 1 ? 0 : mVerSpac);
        layout[BOTTOM] = layout[TOP] + view.getMeasuredHeight();
        lastRight = layout[RIGHT];
        if (_maxHight <= layout[BOTTOM]){
            _maxHight = layout[BOTTOM];
        }
        if ((index + 1) % mColumn == 0) {
            mCurrLine++;
            mMaxHight = _maxHight;
            lastRight = 0;
        }
        if (index + 1 == mViewCount){
            mCurrLine = 0;
            mMaxHight = _maxHight = 0;
            lastRight = 0;
        }
        return layout;
    }
}

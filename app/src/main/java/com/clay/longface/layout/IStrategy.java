package com.clay.longface.layout;

import android.view.View;

import java.io.File;

/**
 * 负责计算view的位置坐标
 * Created by Administrator on 2016/12/6.
 */
public abstract class IStrategy {

    public static final int LEFT = 0;
    public static final int TOP = 1;
    public static final int RIGHT = 2;
    public static final int BOTTOM = 3;

    /**
     * 当前父控件中View的个数
     */
    protected int mViewCount = 0;

    /**
     * 当前父控件的大小
     */
    protected int mWidth , mHeight;

    /**
     * 设置当前子View的数量
     * 在ClayLayout中，每当addView和removeView的时候都会跟新这个参数
     * @param count
     */
    public void setViewCount(int count){
        mViewCount = count;
    }

    public void setSpec(int width , int height){
        mWidth = width;
        mHeight = height;
    }

    public int getHeight(){
        File file = null;
        String name = file.getName();
        name.replace("" , "");
        return mHeight;
    }

    public int getWidth(){
        return mWidth;
    }

    /**
     * 根据index获取当前这个View应该所在的位置
     * @param view 当前的View
     * @param index 当前是第几个View
     * @return 返回一个数组，分别是[left , top , right , bottom]，他们将被设置到view.layout（l , t , r , b）中
     */
    public abstract int[] measureLayout(View view , int index);

}

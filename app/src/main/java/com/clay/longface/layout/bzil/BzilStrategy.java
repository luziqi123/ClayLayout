package com.clay.longface.layout.bzil;

import android.view.View;

import com.clay.longface.layout.Dot;
import com.clay.longface.layout.IStrategy;

/**
 * 贝塞尔曲线的布局
 * Created by L on 2016/12/7.
 */
public class BzilStrategy extends IStrategy {

    /**
     * 这个值将返回给父控件使用
     */
    private int[] layout  = new int[4];

    /**
     * 计算实体类
     */
    private Compute mCompute;

    @Override
    public int[] measureLayout(View view, int index) {
        float[] currentDot = getCurrentDot(index);
        layout[TOP] = (int) currentDot[1] - view.getMeasuredHeight() / 2;
        layout[LEFT] = (int) currentDot[0] - view.getMeasuredWidth() / 2;
        layout[RIGHT] = (int) currentDot[0] + view.getMeasuredWidth() / 2;
        layout[BOTTOM] = (int) currentDot[1] + view.getMeasuredHeight() / 2;
        return layout;
    }

    /**
     * 根据当前view的角标获得他对应在贝塞尔曲线上的的X Y值
     * @param index
     * @return
     */
    public float[] getCurrentDot(int index) {
        if (mCompute == null)return new float[]{0,0,0,0};
        return mCompute.comput(index);
    }

    /**
     * 设置点
     * @param dot 设置3个点为二阶贝塞尔 4个点为三阶贝塞尔 多个点目前还不支持……等我学完初中数学就加上
     */
    public void setDot(Dot...dot){
        if (dot == null)return;
        if (dot.length == 3){
            mCompute = new ComputeOf2Bzil(dot[0] , dot[1] , dot[2] , mViewCount);
        }else if (dot.length == 4){
            mCompute = new ComputeOf3Bzil(dot[0] , dot[1] , dot[2] , dot[3] , mViewCount);
        }
    }

}

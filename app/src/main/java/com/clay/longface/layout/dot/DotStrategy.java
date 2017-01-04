package com.clay.longface.layout.dot;

import android.view.View;

import com.clay.longface.layout.Dot;
import com.clay.longface.layout.IStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/1/4.
 */
public class DotStrategy extends IStrategy{

    private List<Dot> mDots = new ArrayList<>();

    private int[] layout = new int[]{0,0,0,0};

    /**
     * 构造函数中需要传入点
     * 这里的这个坐标是相对于父控件的
     * 并且这个点代表子控件的中间部分
     * @param dots
     */
    public DotStrategy(Dot ... dots){
        if (dots == null){
            return;
        }
        mDots = Arrays.asList(dots);
    }

    @Override
    public int[] measureLayout(View view, int index) {
        if (index >= mDots.size()) return layout;
        Dot dot = mDots.get(index);
        if (dot == null) {
            return layout;
        }
        layout[LEFT] = (int) (dot.x - view.getMeasuredWidth() / 2);
        layout[TOP] = (int) (dot.y - view.getMeasuredHeight() / 2);
        layout[RIGHT] = layout[LEFT] + view.getMeasuredWidth();
        layout[BOTTOM] = layout[TOP] + view.getMeasuredHeight();
        return layout;
    }
}

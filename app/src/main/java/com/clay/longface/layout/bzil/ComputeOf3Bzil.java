package com.clay.longface.layout.bzil;

/**
 * Created by Administrator on 2016/12/14.
 */
public class ComputeOf3Bzil implements Compute {

    private Dot mStartDot , mRoadDot1,  mRoadDot2, mEndDot;

    private int mViewCount;

    public ComputeOf3Bzil(Dot startDot , Dot roadDot1 , Dot roadDot2 , Dot endDot , int viewCount){
        this.mStartDot = startDot;
        this.mRoadDot1 = roadDot1;
        this.mRoadDot2 = roadDot2;
        this.mEndDot = endDot;
        this.mViewCount = viewCount;
    }
    
    @Override
    public float[] comput(int index) {
        float f = (float)index / (float)mViewCount;
        float oneMinusT = 1.0f - f;
        float[] point = new float[2];

//        point[0] = oneMinusT * oneMinusT * (mStartDot.x)
//                + 2 * f * oneMinusT * (mRoadDot.x)
//                + f * f * (mEndDot.x);
//
//        point[1] = oneMinusT * oneMinusT * oneMinusT * (mStartDot.y)
//                + 2 * oneMinusT * f * (mRoadDot.y)
//                + f * f * (mEndDot.y);

        return point;
    }
}

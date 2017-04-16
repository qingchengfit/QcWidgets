package cn.qingchengfit.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by fb on 2017/3/20.
 */

public class AutoLineGroup extends ViewGroup {

    private int mScreenWidth;
    private int mHorizontalSpacing;
    private int mVerticalSpacing;
    private int mHeight = 0;

    public AutoLineGroup(Context context) {
        super(context);
    }

    public AutoLineGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AutoLineGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setSpacing(int horizontalSpacing, int verticalSpacing) {
        mHorizontalSpacing = horizontalSpacing;
        mVerticalSpacing = verticalSpacing;
    }

    private void init(){
        getLayoutParams().height = 0;
    }

    public void setmScreenWidth(int mScreenWidth) {
        this.mScreenWidth = mScreenWidth;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(widthSize, heightSize);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int mTotalHeight = 0;
        int mTotalWidth = 0;
        int mTempHeight = 0;
        int childCount = getChildCount();
        int index = 1;
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            int measureHeight = childView.getMeasuredHeight();
            int measuredWidth = childView.getMeasuredWidth();
            mHeight = childView.getMeasuredHeight();
            mTempHeight = (measureHeight > mTempHeight) ? measureHeight : mTempHeight;
            if ((measuredWidth + mTotalWidth + mHorizontalSpacing) > getMeasuredWidth()) {
                mTotalWidth = 0;
                mTotalHeight += (mTempHeight + mVerticalSpacing);
                mTempHeight = 0;
                index++;
            }
            if (mTotalWidth == 0) {
                childView.layout(mTotalWidth, mTotalHeight, measuredWidth + mTotalWidth + mHorizontalSpacing, mTotalHeight + measureHeight);
            }else {
                childView.layout(mTotalWidth + mHorizontalSpacing, mTotalHeight, measuredWidth + mTotalWidth + mHorizontalSpacing, mTotalHeight + measureHeight);
            }
            mTotalWidth += (measuredWidth + mHorizontalSpacing);
        }
        if (childCount > 0) {
            getLayoutParams().height = mHeight * index + mVerticalSpacing * 2;
        }
    }

}

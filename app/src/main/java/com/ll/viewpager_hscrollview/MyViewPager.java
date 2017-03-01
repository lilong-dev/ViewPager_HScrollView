package com.ll.viewpager_hscrollview;

import android.content.Context;
import android.graphics.PointF;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by admin on 2017/3/1.
 */

public class MyViewPager extends ViewPager {
    private int mItemIndex = -1;
    /** 触摸时按下的点 **/
    PointF downP = new PointF();
    /** 触摸时当前的点 **/
    PointF curP = new PointF();
    public MyViewPager(Context context) {
        super(context);
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

   @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        curP.x = ev.getX();
        curP.y = ev.getY();
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            // 记录按下时候的坐标
            downP.x = ev.getX();
            downP.y = ev.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
            mItemIndex = getCurrentItem();
        }
        if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            // 此句代码是为了通知他的父View现在进行的不是本控件的操作，父View可以拦截事件
          if (Math.abs(curP.y - downP.y) > 120) {
                getParent().requestDisallowInterceptTouchEvent(false);
            } else {
                if (mItemIndex == 0) {
                    if (curP.x < downP.x) {//向左滑动
                        getParent().requestDisallowInterceptTouchEvent(true);
                    } else {//向右滑动
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }

                } else {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }

            }
        }
        return super.dispatchTouchEvent(ev);
    }

}

package com.test.androidtest.views.dispatch;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewParent;

/**
 * Created by Administrator on 2017/8/31.
 */

public class TouchTestViewPager extends ViewPager {

    // 滑动距离及坐标
    private float xDistance, yDistance, xLast, yLast;

    public TouchTestViewPager(Context context) {
        super(context);
    }

    public TouchTestViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                xDistance = yDistance = 0f;
                xLast = ev.getX();
                yLast = ev.getY();
                //保证子View能够接收到Action_move事件
                if(null != getParent()){
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                final float curX = ev.getX();
                final float curY = ev.getY();

                xDistance += Math.abs(curX - xLast);
                yDistance += Math.abs(curY - yLast);
                xLast = curX;
                yLast = curY;

                ViewParent parent = getParent();
                if(null != parent){
                    if (xDistance > yDistance) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    } else {
                        Log.e("tag", "TouchTestViewPager requestDisallowInterceptTouchEvent(false)" );
                        parent.requestDisallowInterceptTouchEvent(false);
                    }
                }

                break;

        }
//        Log.e("tag","自身的矩形左边为(0, 0, " + getWidth() + ", " + getHeight() + ")");
//        Log.e("tag","点击坐标为相对自身的(" + ev.getX() + ", " + ev.getY() + ")");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(ev);
    }
}

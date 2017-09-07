package com.test.androidtest.views.dispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * Created by Administrator on 2017/8/31.
 */

public class TestTouchScrollView extends ScrollView {

    // 滑动距离及坐标
    private float xDistance, yDistance, xLast, yLast;

    public TestTouchScrollView(Context context) {
        super(context);
    }

    public TestTouchScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TestTouchScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        switch (ev.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                xDistance = yDistance = 0f;
//                xLast = ev.getX();
//                yLast = ev.getY();
//                break;
//            case MotionEvent.ACTION_MOVE:
//                final float curX = ev.getX();
//                final float curY = ev.getY();
//
//                xDistance += Math.abs(curX - xLast);
//                yDistance += Math.abs(curY - yLast);
//                xLast = curX;
//                yLast = curY;
//
//                if (xDistance > yDistance) {
//                    return false;
//                }
//        }
        boolean result = super.onInterceptTouchEvent(ev);
        Log.e("tag", "TestTouchScrollView onInterceptTouchEvent return " + result +
                "\nev:"
                + TouchEventUtil.getTouchAction(ev.getAction()));
        return result;
    }
}

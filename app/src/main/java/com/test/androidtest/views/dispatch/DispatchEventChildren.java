package com.test.androidtest.views.dispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * Created by Administrator on 2017/8/29.
 */

public class DispatchEventChildren extends RelativeLayout {

    public DispatchEventChildren(Context context) {
        super(context);
    }

    public DispatchEventChildren(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DispatchEventChildren(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("dispatch", "Children | onTouchEvent  <<<start>>>");
        boolean result = super.onTouchEvent(event);

        Log.e("dispatch", "Children | onTouchEvent "+
                TouchEventUtil.getTouchAction(event.getAction()) + "|| return " + result);
        Log.e("dispatch", "Children | onTouchEvent  >>>end<<<");
        return result;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("dispatch", "Children | onInterceptTouchEvent  <<<start>>>");
        boolean result = super.onInterceptTouchEvent(ev);
        Log.e("dispatch", "Children | onInterceptTouchEvent " +
                TouchEventUtil.getTouchAction(ev.getAction()) + "|| return " + result);
        Log.e("dispatch", "Children | onInterceptTouchEvent  >>>end<<<");
        return result;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("dispatch", "Children | dispatchTouchEvent  <<<start>>>");
        boolean result = super.dispatchTouchEvent(ev);
        Log.e("dispatch", "Children | dispatchTouchEvent " +
                TouchEventUtil.getTouchAction(ev.getAction()) + "|| return " + result);
        Log.e("dispatch", "Children | dispatchTouchEvent  >>>end<<<");
        return result;
    }
}

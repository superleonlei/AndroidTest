package com.test.androidtest.views.dispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * Created by Administrator on 2017/8/29.
 */

public class DispatchEventFather extends RelativeLayout {

    public DispatchEventFather(Context context) {
        super(context);
    }

    public DispatchEventFather(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DispatchEventFather(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("dispatch", "Father | onTouchEvent  <<<start>>>");
        boolean result = super.onTouchEvent(event);

        Log.e("dispatch", "Father | onTouchEvent "+
                TouchEventUtil.getTouchAction(event.getAction()) + "|| return " + result);
        Log.e("dispatch", "Father | onTouchEvent  >>>end<<<");
        return result;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("dispatch", "Father | onInterceptTouchEvent  <<<start>>>");
        boolean result = super.onInterceptTouchEvent(ev);
//        boolean result = true;
        Log.e("dispatch", "Father | onInterceptTouchEvent " +
                TouchEventUtil.getTouchAction(ev.getAction()) + "|| return " + result);
        Log.e("dispatch", "Father | onInterceptTouchEvent  >>>end<<<");
        return result;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("dispatch", "Father | dispatchTouchEvent  <<<start>>>");
        boolean result = super.dispatchTouchEvent(ev);
//        boolean result = false;
        Log.e("dispatch", "Father | dispatchTouchEvent " +
                TouchEventUtil.getTouchAction(ev.getAction()) + "|| return " + result);
        Log.e("dispatch", "Father | dispatchTouchEvent  >>>end<<<");
        return result;
    }
}

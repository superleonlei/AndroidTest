package com.test.androidtest.views.dispatch;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2017/8/29.
 */

public class DispatchEventTextView extends android.support.v7.widget.AppCompatTextView {
    public DispatchEventTextView(Context context) {
        super(context);
    }

    public DispatchEventTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DispatchEventTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("dispatch", "TextView | onTouchEvent  <<<start>>>");
        boolean result = super.onTouchEvent(event);

        Log.e("dispatch", "TextView | onTouchEvent "+
                TouchEventUtil.getTouchAction(event.getAction()) + "|| return " + result);
        Log.e("dispatch", "TextView | onTouchEvent  >>>end<<<");
        return result;
    }

    //不会被调用
//    @Override  因为onInterceptTouchEvent是ViewGroup定义的，所以自由其子类才能重写它
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("dispatch", "TextView | dispatchTouchEvent  <<<start>>>");
        boolean result = super.dispatchTouchEvent(ev);
        Log.e("dispatch", "TextView | dispatchTouchEvent " +
                TouchEventUtil.getTouchAction(ev.getAction()) + "|| return " + result);
        Log.e("dispatch", "TextView | dispatchTouchEvent  >>>end<<<");
        return result;
    }

}

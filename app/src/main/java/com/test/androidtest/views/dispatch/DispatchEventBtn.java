package com.test.androidtest.views.dispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2017/8/29.
 */

public class DispatchEventBtn extends android.support.v7.widget.AppCompatButton {
    public DispatchEventBtn(Context context) {
        super(context);
    }

    public DispatchEventBtn(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DispatchEventBtn(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("dispatch", "Button" + getId()+ "| onTouchEvent  <<<start>>>");
        boolean result = super.onTouchEvent(event);

        Log.e("dispatch", "Button" + getId()+ "| onTouchEvent "+
                TouchEventUtil.getTouchAction(event.getAction()) + "|| return " + result);
        Log.e("dispatch", "Button" + getId()+ "| onTouchEvent  >>>end<<<");
        return result;
    }

    //不会被调用
//    @Override  因为onInterceptTouchEvent是ViewGroup定义的，所以自由其子类才能重写它
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("dispatch", "Button" + getId()+ "| dispatchTouchEvent  <<<start>>>");
        boolean result = super.dispatchTouchEvent(ev);
        Log.e("dispatch", "Button" + getId()+ "| dispatchTouchEvent " +
                TouchEventUtil.getTouchAction(ev.getAction()) + "|| return " + result);
        Log.e("dispatch", "Button" + getId()+ "| dispatchTouchEvent  >>>end<<<");
        return result;
    }
}

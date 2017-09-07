package com.test.androidtest.views.dispatch;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;

import com.test.androidtest.R;

/**
 * Created by Administrator on 2017/8/29.
 */

public class DispatchEventTestActivity extends Activity {

    private DispatchEventBtn btn_dispatch1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dispatchevent_test);

        initView();
    }

    private void initView(){
        btn_dispatch1 = (DispatchEventBtn) findViewById(R.id.btn_dispatch1);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("dispatch", "Activity | onTouchEvent  <<<start>>>");
        boolean result = super.onTouchEvent(event);
        Log.e("dispatch", "Activity | onTouchEvent "+
                TouchEventUtil.getTouchAction(event.getAction()) + "|| return " + result);
        Log.e("dispatch", "Activity | onTouchEvent  >>>end<<<");
        return result;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("dispatch", "Activity | dispatchTouchEvent  <<<start>>>");
        boolean result = super.dispatchTouchEvent(ev);
        Log.e("dispatch", "Activity | dispatchTouchEvent "+
                TouchEventUtil.getTouchAction(ev.getAction()) + "|| return " + result);
        Log.e("dispatch", "Activity | dispatchTouchEvent  >>>end<<<");
        return result;
    }
}

package com.test.androidtest.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.test.androidtest.R;

/**
 * Created by Administrator on 2017/8/29.
 */

public class LifeCircleBActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_circle_b);
        log("onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        log("onStart()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        log("onRestart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        log("onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        log("onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        log("onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        log("onDestroy()");
    }

    private void log(String msg){
        Log.e("LifeCircle",  "LifeCircle  B  ==" + msg);
    }
}

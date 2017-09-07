package com.test.androidtest.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.test.androidtest.R;

/**
 * Created by Administrator on 2017/8/29.
 */

public class LifeCircleAActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_circle_a);
        initView();
        log("onCreate()");
    }

    private void initView(){
        Button btn = (Button) findViewById(R.id.btn_2_b);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goCircleBActivity();
            }
        });
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

    private void goCircleBActivity(){
        Intent intent = new Intent(this, LifeCircleBActivity.class);
        startActivity(intent);
    }

    private void log(String msg){
        Log.e("LifeCircle",  "LifeCircle  A  ==" + msg);
    }
}

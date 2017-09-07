package com.test.androidtest;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.test.androidtest.activities.AboutActivitiesListActivity;
import com.test.androidtest.views.AboutViewsListActivity;
import com.test.androidtest.views.aes_rsa.EncryptTestActivity;

public class MainActivity extends ListActivity{

    private String[] items = {"About Activities", "About Views", "加密测试"};

    private Class[] classes = {AboutActivitiesListActivity.class,
            AboutViewsListActivity.class, EncryptTestActivity.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items));
        getListView().setTextFilterEnabled(true);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        startActivity(new Intent(this, classes[position]));
    }

    /**
     * 记录点击返回时间
     **/
    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                showToast("再按一次退出");
                exitTime = System.currentTimeMillis();
            } else {
                this.finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}

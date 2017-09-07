package com.test.androidtest.views;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.test.androidtest.views.dispatch.DispatchEventTestActivity;
import com.test.androidtest.views.dispatch.ScrollViewTouchTestActivity;

/**
 * Created by Administrator on 2017/8/29.
 */

public class AboutViewsListActivity extends ListActivity {

    private String[] items = {"事件分发机制", "ScrollView事件冲突"};

    private Class[] classes = {DispatchEventTestActivity.class, ScrollViewTouchTestActivity.class};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items));
        getListView().setTextFilterEnabled(true);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        startActivity(new Intent(this, classes[position]));
    }
}

package com.test.androidtest.views.aes_rsa;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Administrator on 2017/8/30.
 */

public class EncryptTestActivity extends ListActivity {

    private String[] items = {"AES加密测试", "RSA加密测试"};

    private Class[] classes = {AESTestActivity.class, RSATestActivity.class};

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

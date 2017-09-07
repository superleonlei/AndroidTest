package com.test.androidtest.views.dispatch;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.androidtest.R;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2017/8/31.
 */

public class ScrollViewTouchTestActivity extends Activity {

    @InjectView(R.id.vp_test_touch)
    ViewPager vpTestTouch;

    private ArrayList<TextView> list = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollview_touch_test);
        ButterKnife.inject(this);

        initView();
    }

    private void initView(){
        for(int i = 0; i < 4; ++i){
            TextView textView = new TextView(this);
            textView.setText("TextVew" + (i + 1));
            list.add(textView);
        }

        vpTestTouch.setAdapter(new MyAdapter());
    }

    class MyAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        /**
         * 判断这个View页面是否与函数Object instantiateItem(ViewGroup container, int position)
         * 返回的Object相联系的，
         * @param view
         * @param object
         * @return
         */
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        /**
         * 给ViewPager添加指定位置的View
         * @param container 要添加的View的父View, 此时指的是ViewPager自身
         * @param position  指定的位置
         * @return  返回一个Object作为一个新的页面
         */
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            //获得指定位置的View
            View view = list.get(position);
            //将View添加到ViewPager中
            container.addView(view);

            return view;
        }

        /**
         * 移除指定位置的页面。
         * @param container
         * @param position
         * @param object    Object instantiateItem(ViewGroup container, int position)返回的object
         */
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }
    }
}

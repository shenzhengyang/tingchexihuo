package com.example.zy.happyrun.Cyclists_said.Activity;

import android.app.Activity;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.zy.happyrun.Main_pager.Adapter.MainViewPaperAdapter;
import com.example.zy.happyrun.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zy on 2016/8/9.
 */
public class Cyclists_mainPager extends AppCompatActivity {
    ArrayList<Map<String,Object>> viewlist=new ArrayList<Map<String, Object>>();
    LocalActivityManager activityManager;
    TabLayout tabLayout=null;
    ViewPager viewpager=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cyclists_mainpager);
        activityManager=new LocalActivityManager(this,true);
        activityManager.dispatchCreate(savedInstanceState);
        innit();
        Map<String,Object>map1=new HashMap<String, Object>();
        map1.put("title", "推荐");
        map1.put("view", getView((String) map1.get("title"), new Intent(this, Cyclists_activity_one.class)));
        viewlist.add(map1);
        Map<String,Object>map2=new HashMap<String, Object>();
        map2.put("title", "汽车保养");
        map2.put("view", getView((String) map2.get("title"), new Intent(this, Cyclists_activity_one.class)));
        viewlist.add(map2);
        Map<String,Object>map3=new HashMap<String, Object>();
        map3.put("title", "汽车装备");
        map3.put("view", getView((String) map3.get("title"), new Intent(this, Cyclists_activity_one.class)));
        viewlist.add(map3);
        Map<String,Object>map4=new HashMap<String, Object>();
        map4.put("title", "驾驶技巧");
        map4.put("view", getView((String) map4.get("title"), new Intent(this, Cyclists_activity_one.class)));
        viewlist.add(map4);
        Map<String,Object>map5=new HashMap<String, Object>();
        map5.put("title", "车友故事");
        map5.put("view", getView((String) map5.get("title"), new Intent(this, Cyclists_activity_one.class)));
        viewlist.add(map5);

        MainViewPaperAdapter mainViewPaperAdapter=new MainViewPaperAdapter(viewlist,getSupportFragmentManager());
        tabLayout.setTabsFromPagerAdapter(mainViewPaperAdapter);
        viewpager.setAdapter(mainViewPaperAdapter);
        tabLayout.setupWithViewPager(viewpager);
        viewpager.setOnPageChangeListener(new MyViewPagerPageChangeListener());
    }

    private void innit() {
        tabLayout= (TabLayout) findViewById(R.id.tablayout);
        viewpager= (ViewPager) findViewById(R.id.container);
    }

    private View getView(String id, Intent intent) {
        return activityManager.startActivity(id, intent).getDecorView();
    }

    //调用子Activity发放
    private void loadActivity(int position) {
        Activity activity = activityManager.getActivity((String) viewlist.get(position).get("title"));

    }
    public class MyViewPagerPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            loadActivity(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}

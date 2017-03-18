package com.example.zy.happyrun.Main_pager.Activity;

import android.app.Activity;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.zy.happyrun.Cyclists_ring.Activity.Cyclists_ring_main;
import com.example.zy.happyrun.Cyclists_said.Activity.Cyclists_mainPager;
import com.example.zy.happyrun.Main_pager.Adapter.MainViewPaperAdapter;
import com.example.zy.happyrun.My_Information.Activity.My_InformationActivity;
import com.example.zy.happyrun.R;
import com.example.zy.happyrun.Start.Activity.Main_Start;
import com.example.zy.happyrun.more.Activity.more_main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static android.view.MotionEvent.ACTION_HOVER_ENTER;

/**
 * Created by zy on 2016/7/18.
 */
public class Mainpager_Activity extends AppCompatActivity implements View.OnClickListener{
    ArrayList<Map<String,Object>> viewlist=new ArrayList<Map<String, Object>>();
    LocalActivityManager activityManager;
    TabLayout tabLayout=null;
    ViewPager viewpager=null;
    LinearLayout lin1;
    LinearLayout lin2;
    LinearLayout lin3;
    LinearLayout lin4;
    private TextView lin_Start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpager);
        activityManager=new LocalActivityManager(this,true);
        activityManager.dispatchCreate(savedInstanceState);
        tabLayout= (TabLayout) findViewById(R.id.tablayout);
        viewpager= (ViewPager) findViewById(R.id.container);
        lin1= (LinearLayout) findViewById(R.id.lin1);
        lin2= (LinearLayout) findViewById(R.id.lin2);
        lin3= (LinearLayout) findViewById(R.id.lin3);
        lin4= (LinearLayout) findViewById(R.id.lin4);
        lin_Start= (TextView) findViewById(R.id.lin_start);
        lin1.setOnClickListener(this);
        lin2.setOnClickListener(this);
        lin3.setOnClickListener(this);
        lin4.setOnClickListener(this);
        lin_Start.setOnClickListener(this);
        lin_Start.setOnHoverListener(new View.OnHoverListener() {
            @Override
            public boolean onHover(View view, MotionEvent motionEvent) {
                int event=motionEvent.getAction();
                switch(event){
                    case MotionEvent.ACTION_HOVER_ENTER:{

                        lin_Start.setBackgroundColor(Color.parseColor("#e5f1fb"));
                        break;
                    }
                    case MotionEvent.ACTION_HOVER_EXIT:{
                        lin_Start.setBackgroundColor(Color.parseColor("#9ae569"));
                        break;
                    }
                    case MotionEvent.ACTION_HOVER_MOVE:{
                        break;
                    }
                }
                return true;
            }
        });
        Map<String,Object>map1=new HashMap<String, Object>();
        map1.put("title", "第一个Activity");
        map1.put("view", getView((String) map1.get("title"), new Intent(this, My_InformationActivity.class)));
        viewlist.add(map1);
        Map<String,Object>map2=new HashMap<String, Object>();
        map2.put("title","第二个Activity");
        map2.put("view", getView((String) map2.get("title"), new Intent(this, Cyclists_mainPager.class)));
        viewlist.add(map2);
        Map<String,Object>map3=new HashMap<String, Object>();
        map3.put("title","第三个Activity");
        map3.put("view", getView((String) map3.get("title"), new Intent(this, Main_Start.class)));
        viewlist.add(map3);
        Map<String,Object>map4=new HashMap<String, Object>();
        map4.put("title","第三个Activity");
        map4.put("view", getView((String) map4.get("title"), new Intent(this, Cyclists_ring_main.class)));
        viewlist.add(map4);
        Map<String,Object>map5=new HashMap<String, Object>();
        map5.put("title","第四个Activity");
        map5.put("view", getView((String) map5.get("title"), new Intent(this, more_main.class)));
        viewlist.add(map5);

        MainViewPaperAdapter mainViewPaperAdapter=new MainViewPaperAdapter(viewlist,getSupportFragmentManager());
        tabLayout.setTabsFromPagerAdapter(mainViewPaperAdapter);
        viewpager.setAdapter(mainViewPaperAdapter);
        tabLayout.setupWithViewPager(viewpager);
        viewpager.setOnPageChangeListener(new MyViewPagerPageChangeListener());
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch(id){
            case R.id.lin1:{
                lin1.setBackgroundColor(Color.parseColor("#000000"));
                viewpager.setCurrentItem(0);
                break;
            }
            case R.id.lin2:{
                lin2.setBackgroundColor(Color.parseColor("#000000"));
                viewpager.setCurrentItem(1);
                break;
            }
            case R.id.lin3:{
                lin3.setBackgroundColor(Color.parseColor("#000000"));
                viewpager.setCurrentItem(3);
                break;
            }
            case R.id.lin4:{
                lin4.setBackgroundColor(Color.parseColor("#000000"));
                viewpager.setCurrentItem(4);
                break;
            }
            case R.id.lin_start:{

                viewpager.setCurrentItem(2);
                break;
            }
        }
    }

    public class MyViewPagerPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            loadActivity(position);
            switch (position){
                case 0:{
                    lin1.setBackgroundColor(Color.parseColor("#000000"));
                    break;
                }
                case 1:{
                    lin2.setBackgroundColor(Color.parseColor("#000000"));
                    break;
                }
                case 3:{
                    lin3.setBackgroundColor(Color.parseColor("#000000"));
                    break;
                }
                case 4:{
                    lin3.setBackgroundColor(Color.parseColor("#000000"));
                    break;
                }
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    private View getView(String id, Intent intent) {
        return activityManager.startActivity(id, intent).getDecorView();
    }

    //调用子Activity发放
    private void loadActivity(int position) {
        Activity activity = activityManager.getActivity((String) viewlist.get(position).get("title"));

    }

}

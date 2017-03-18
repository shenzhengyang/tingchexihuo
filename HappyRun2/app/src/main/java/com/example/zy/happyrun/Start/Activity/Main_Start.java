package com.example.zy.happyrun.Start.Activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.zy.happyrun.R;
import com.example.zy.happyrun.Start.UI.DashboardView1;
import com.example.zy.happyrun.Start.UI.DashboardView4;

import java.util.Random;

/**
 * Created by zy on 2017/3/15.
 */

public class Main_Start extends AppCompatActivity implements View.OnClickListener{
    private TextView title;
    private RelativeLayout title_relation;
    private DashboardView1 mDashboardView1;
    private DashboardView1 mDashboardView2;
    private DashboardView4 mDashboardView3;

    private boolean isAnimFinished = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        innit();

    }
    /*
    *初始化控件
     */
    private void innit() {
        title= (TextView) findViewById(R.id.textViewtitle);
        title_relation= (RelativeLayout) findViewById(R.id.mtitle_template);
        mDashboardView1 = (DashboardView1) findViewById(R.id.dashboard_view_1);
        mDashboardView2 = (DashboardView1) findViewById(R.id.dashboard_view_2);
        mDashboardView3 = (DashboardView4) findViewById(R.id.dashboard_view_3);

        title.setText("Start");
        title_relation.setBackgroundColor(Color.parseColor("#151419"));
        mDashboardView1.setOnClickListener(this);
        mDashboardView2.setOnClickListener(this);
        mDashboardView3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        switch(id){
            case R.id.dashboard_view_1 :{
                mDashboardView1.setRealTimeValue(new Random().nextInt(100));
                break;
            }
            case R.id.dashboard_view_2 :{
                mDashboardView2.setRealTimeValue(new Random().nextInt(100));
                break;
            }
            case R.id.dashboard_view_3 :{
                if (isAnimFinished) {
                    ObjectAnimator animator = ObjectAnimator.ofInt(mDashboardView3, "mRealTimeValue",
                            mDashboardView3.getVelocity(), new Random().nextInt(180));
                    animator.setDuration(1500).setInterpolator(new LinearInterpolator());
                    animator.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationStart(Animator animation) {
                            isAnimFinished = false;
                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            isAnimFinished = true;
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {
                            isAnimFinished = true;
                        }
                    });
                    animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {
                            int value = (int) animation.getAnimatedValue();
                            mDashboardView3.setVelocity(value);
                        }
                    });
                    animator.start();
                }
                break;
            }
        }
    }
}

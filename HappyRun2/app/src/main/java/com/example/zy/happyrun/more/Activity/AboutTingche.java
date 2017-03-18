package com.example.zy.happyrun.more.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.zy.happyrun.R;

/**
 * Created by zy on 2017/3/16.
 */

public class AboutTingche extends AppCompatActivity {
    private RelativeLayout title_lin;
    private TextView title;
    private ImageView title_left;
    private ImageView title_right;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guanyutingche);
        innit();
    }

    private void innit() {
        title_lin= (RelativeLayout) findViewById(R.id.mtitle_template);
        title= (TextView) findViewById(R.id.textViewtitle);
        title_left= (ImageView) findViewById(R.id.title_imageLeft);
        title_right= (ImageView) findViewById(R.id.title_imageRight);

        title_lin.setBackgroundColor(Color.parseColor("#191919"));
        title.setText("奖励积分说明");
        title_left.setImageResource(R.mipmap.cha);
        title_right.setImageResource(R.mipmap.gengduo);
    }
}

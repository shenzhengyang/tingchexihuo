package com.example.zy.happyrun.more.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.example.zy.happyrun.R;

/**
 * Created by zy on 2016/8/10.
 */
public class more_main extends AppCompatActivity implements View.OnClickListener{
    private LinearLayout lin_AboutTingChe;
    private LinearLayout lin_shangchuanrizhi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more_main);
        innit();

    }

    private void innit() {

        lin_AboutTingChe= (LinearLayout) findViewById(R.id.AboutTingChe);
        lin_shangchuanrizhi= (LinearLayout) findViewById(R.id.shangchuanrizhi);

        lin_AboutTingChe.setOnClickListener(this);
        lin_shangchuanrizhi.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        switch (id){
            case R.id.AboutTingChe:{

                Intent intent=new Intent(more_main.this,AboutTingche.class);
                startActivity(intent);
                break;
            }
            case R.id.shangchuanrizhi:{
                AlertDialog.Builder builder=new AlertDialog.Builder(more_main.this);
                builder.setTitle("上传本地日志");
                builder.setMessage("当应用出现问题，即可使用此功能上传本地操作日志，方便工程师修复问题，共同建设一个更加稳定的悦跑圈！");
                builder.setPositiveButton("确定",null);
                builder.setNegativeButton("取消",null);
                builder.show();
                break;
            }

        }
    }
}

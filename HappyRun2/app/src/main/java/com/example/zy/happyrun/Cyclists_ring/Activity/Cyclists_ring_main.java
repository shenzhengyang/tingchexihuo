package com.example.zy.happyrun.Cyclists_ring.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.example.zy.happyrun.R;

/**
 * Created by zy on 2016/8/10.
 */
public class Cyclists_ring_main extends AppCompatActivity implements View.OnClickListener{
    private LinearLayout lin1;
    private LinearLayout lin2;
    private LinearLayout lin3;
    private LinearLayout lin4;
    private LinearLayout lin_fenxiang;
    private LinearLayout lin_paihangbang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cyclists_ring);
        innit();
    }

    private void innit() {

        lin1= (LinearLayout) findViewById(R.id.lin1);
        lin2= (LinearLayout) findViewById(R.id.lin2);
        lin3= (LinearLayout) findViewById(R.id.lin3);
        lin4= (LinearLayout) findViewById(R.id.lin4);
        lin_fenxiang= (LinearLayout) findViewById(R.id.fenxiang);
        lin_paihangbang= (LinearLayout) findViewById(R.id.paihangbang);

        lin1.setOnClickListener(this);
        lin2.setOnClickListener(this);
        lin3.setOnClickListener(this);
        lin4.setOnClickListener(this);
        lin_fenxiang.setOnClickListener(this);
        lin_paihangbang.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        switch(id){
            case R.id.lin1:{
                Intent intent=new Intent(Cyclists_ring_main.this,Cyclists_ring_WebViewActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.lin2:{
                Intent intent=new Intent(Cyclists_ring_main.this,Cyclists_ring_WebViewActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.lin3:{
                Intent intent=new Intent(Cyclists_ring_main.this,Cyclists_ring_WebViewActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.lin4:{
                Intent intent=new Intent(Cyclists_ring_main.this,Cyclists_ring_WebViewActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.fenxiang:{

                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_SUBJECT, "分享到朋友圈");
                intent.putExtra(Intent.EXTRA_TEXT, "I have successfully share my message through my app");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(Intent.createChooser(intent, getTitle()));

                break;
            }
            case R.id.paihangbang:{
                Intent intent=new Intent(Cyclists_ring_main.this,Cyclists_ring_paihangbang.class);
                startActivity(intent);
                break;
            }
        }
    }
}

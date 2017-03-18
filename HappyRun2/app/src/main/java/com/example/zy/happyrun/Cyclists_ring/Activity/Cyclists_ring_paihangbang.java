package com.example.zy.happyrun.Cyclists_ring.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.zy.happyrun.Cyclists_ring.Adapter.Cyclists_ring_paihangbang_Adapter;
import com.example.zy.happyrun.Cyclists_ring.Entity.Paihangbang_Entity;
import com.example.zy.happyrun.R;

import java.util.ArrayList;
import java.util.List;

public class Cyclists_ring_paihangbang extends AppCompatActivity implements View.OnClickListener,Toolbar.OnMenuItemClickListener{
    private ImageView title_image;
    private ListView mlistView;
    private int [] icon={R.mipmap.liucunzhen,R.mipmap.liutianhao,R.mipmap.wangyue,R.mipmap.zhoufeng};
    private String []name={"刘存真","刘天浩","王悦","周峰"};
    private String []jifen={"12681","12644","11559","9414"};
    private String []numofzan={"3","0","1","0"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cyclists_ring_paihangbang);
        innit();

    }

    private void innit() {
        //toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(Color.parseColor("#37393e"));
        toolbar.setTitle("排行榜");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.back_64);

        title_image= (ImageView) findViewById(R.id.image_title);
//        int toolbar_height=toolbar.getMeasuredHeight();
//        Log.d("toolbarHeight",String.valueOf(toolbar_height));
//        LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        layoutParams.setMargins(toolbar_height,0,0,0);
//        title_image.setLayoutParams(layoutParams);

        //toolbar注册监听
        toolbar.setOnMenuItemClickListener(this);

        mlistView= (ListView) findViewById(R.id.paihangbangList);
        List<Paihangbang_Entity> paihangbang_entities=new ArrayList<>();
        for(int i=0;i<10;i++){
            Paihangbang_Entity mEntity=new Paihangbang_Entity();
            mEntity.setId(i);
            mEntity.setIcon(icon[i%4]);
            mEntity.setName(name[i%4]);
            mEntity.setJifen(jifen[i%4]);
            mEntity.setNumofzan(numofzan[i%4]);
            mEntity.setZan_icon(R.mipmap.heart_gray);
            paihangbang_entities.add(mEntity);
        }
        Cyclists_ring_paihangbang_Adapter mAdapter=new Cyclists_ring_paihangbang_Adapter(Cyclists_ring_paihangbang.this,paihangbang_entities);
        mlistView.setAdapter(mAdapter);
        setListViewHeightBasedOnChildren(mlistView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {

        int id=item.getItemId();
        switch (id){
            case R.id.action_share:{

                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_SUBJECT, "分享到朋友圈");
                intent.putExtra(Intent.EXTRA_TEXT, "I have successfully share my message through my app");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(Intent.createChooser(intent, getTitle()));
                break;
            }
        }
        return true;
    }
    /**
     * 计算listView高度
     */
    private void setListViewHeightBasedOnChildren(ListView listView) {

        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

}

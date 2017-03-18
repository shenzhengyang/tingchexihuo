package com.example.zy.happyrun.Cyclists_ring.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zy.happyrun.Cyclists_ring.Entity.Paihangbang_Entity;
import com.example.zy.happyrun.R;

import java.util.List;

/**
 * Created by zy on 2017/3/17.
 */

public class Cyclists_ring_paihangbang_Adapter extends BaseAdapter {
    public Context context;
    public LayoutInflater layoutInflater;
    public List<Paihangbang_Entity> paihangbang_entities;

    private TextView id,name,jifen,numofzan;
    private ImageView icon,zan_icon;
    public Cyclists_ring_paihangbang_Adapter(){
        super();
    }
    public Cyclists_ring_paihangbang_Adapter(Context context,List<Paihangbang_Entity> paihangbang_entities){
        this.context=context;
        this.paihangbang_entities=paihangbang_entities;
        layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return paihangbang_entities.size();
    }

    @Override
    public Object getItem(int i) {
        return paihangbang_entities.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Log.d("position",String.valueOf(i));
        view=layoutInflater.inflate(R.layout.cyclists_paihangbang_item,null);
        innitView(view);
        if(i==0){
            jifen.setTextColor(Color.parseColor("#ee7c6d"));
            numofzan.setTextColor(Color.parseColor("#ee7c6d"));
            zan_icon.setImageResource(R.mipmap.heart);
        }
        else if(i==1||i==2){
            numofzan.setTextColor(Color.parseColor("#d6d6d6"));
            jifen.setTextColor(Color.parseColor("#ee7c6d"));
            zan_icon.setImageResource(paihangbang_entities.get(i).getZan_icon());
        }
        else{
            numofzan.setTextColor(Color.parseColor("#d6d6d6"));
            jifen.setTextColor(Color.parseColor("#27aa37"));
            zan_icon.setImageResource(paihangbang_entities.get(i).getZan_icon());
        }
        id.setText(String.valueOf(paihangbang_entities.get(i).getId()));
        icon.setImageResource(paihangbang_entities.get(i).getIcon());
        name.setText(paihangbang_entities.get(i).getName());
        jifen.setText(paihangbang_entities.get(i).getJifen());
        numofzan.setText(paihangbang_entities.get(i).getNumofzan());

        return view;
    }

    private void innitView(View view) {
        id= (TextView) view.findViewById(R.id.id);
        icon= (ImageView) view.findViewById(R.id.icon);
        name= (TextView) view.findViewById(R.id.name);
        jifen= (TextView) view.findViewById(R.id.jifen);
        numofzan= (TextView) view.findViewById(R.id.numofzan);
        zan_icon= (ImageView) view.findViewById(R.id.icon_zan);
    }
}

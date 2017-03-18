package com.example.zy.happyrun.Cyclists_said.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.baidu.mapapi.map.Text;
import com.example.zy.happyrun.Cyclists_said.Activity.Cyclists_activity_one;
import com.example.zy.happyrun.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zy on 2016/8/10.
 */
public class Cyclists_one_adapter extends BaseAdapter {
    public Context context;
    public List<String> mList=new ArrayList<>();
    public LayoutInflater inflater;
    public Cyclists_one_adapter(){
        super();
    }
    public Cyclists_one_adapter(Context context,List<String> mList){
        this.context=context;
        this.mList=mList;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=inflater.inflate(R.layout.cyclists_one_item,null);
        TextView textView= (TextView) convertView.findViewById(R.id.cyclists_one_text);
        textView.setText(mList.get(position));
        return convertView;
    }
}

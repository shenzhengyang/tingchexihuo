package com.example.zy.happyrun.Cyclists_said.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.zy.happyrun.Cyclists_said.Adapter.Cyclists_one_adapter;
import com.example.zy.happyrun.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zy on 2016/8/9.
 */
public class Cyclists_activity_one extends AppCompatActivity {
    TextView texttitle;
    ImageView imagetitle;
    private ListView mListView;
    private Cyclists_one_adapter cyclists_one_adapter;
    private List<String> mlist=new ArrayList<>();
    String[] mString={"广告摊位","车友故事","驾车小技巧","........."};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cyclists_one);
        for(int i=0;i<mString.length;i++){
            mlist.add(mString[i]);
        }
        init();

        //imagetitle.setImageDrawable(getResources().getDrawable(R.mipmap.gengduo));
        mListView.setAdapter(cyclists_one_adapter);
        setListViewHeightBasedOnChildren(mListView);
    }

    private void init() {
        texttitle= (TextView) findViewById(R.id.textViewtitle);
        imagetitle= (ImageView) findViewById(R.id.imageViewtitle);
        mListView= (ListView) findViewById(R.id.cyclists_one_list);
        cyclists_one_adapter=new Cyclists_one_adapter(Cyclists_activity_one.this,mlist);

        //texttitle.setText("车友说");
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

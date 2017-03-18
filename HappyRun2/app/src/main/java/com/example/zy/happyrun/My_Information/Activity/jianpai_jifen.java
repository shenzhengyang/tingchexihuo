package com.example.zy.happyrun.My_Information.Activity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.zy.happyrun.My_Information.Adapter.NumericWheelAdapter;
import com.example.zy.happyrun.My_Information.widget.WheelView;
import com.example.zy.happyrun.R;

import java.util.Calendar;
import java.util.Locale;


public class jianpai_jifen extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout jifen_mingxi;
    private LinearLayout jifen_chaxun;

    private RelativeLayout title;
    private ImageView title_imageRight;
    private TextView title_text;

    private LayoutInflater inflater=null;
    private WheelView year;
    private WheelView month;
    private WheelView day;
    PopupWindow menuWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jianpai_jifen);
        innit();

    }

    private void innit() {
        jifen_chaxun= (LinearLayout) findViewById(R.id.jifen_chaxun);
        jifen_mingxi= (LinearLayout) findViewById(R.id.jifen_mingxi);

        title= (RelativeLayout) findViewById(R.id.mtitle_template);
        title_text= (TextView) findViewById(R.id.textViewtitle);
        title_imageRight= (ImageView) findViewById(R.id.title_imageRight);
        title.setBackgroundColor(Color.parseColor("#f6f6f5"));
        title_text.setTextColor(Color.parseColor("#525252"));
        title_text.setText("减排积分");
        title_imageRight.setImageResource(R.mipmap.gengduo_black);

        inflater= (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
        jifen_chaxun.setOnClickListener(this);
        jifen_mingxi.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        switch(id){
            case R.id.jifen_chaxun:{
                //showDateDialog();
                showPopwindow(getDataPick());
                break;
            }
            case R.id.jifen_mingxi:{
                //showDateDialog();
                showPopwindow(getDataPick());
                break;
            }
        }
    }
    /**
     * 初始化popupWindow
     * @param view
     */
    private void showPopwindow(View view) {
        menuWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        menuWindow.setFocusable(true);
        menuWindow.setBackgroundDrawable(new BitmapDrawable());
        menuWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);
        menuWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                menuWindow=null;
            }
        });
    }
    /**
     * 显示日期
     */
    private void showDateDialog() {
        final AlertDialog dialog = new AlertDialog.Builder(jianpai_jifen.this)
                .create();
        dialog.show();
        Window window = dialog.getWindow();
        // 设置布局
        window.setContentView(R.layout.datepicker_layout);
        // 设置宽高
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        // 设置弹出的动画效果
        window.setWindowAnimations(R.style.AnimBottom);


        Calendar c = Calendar.getInstance();
        int curYear = c.get(Calendar.YEAR);
        int curMonth = c.get(Calendar.MONTH) + 1;//通过Calendar算出的月数要+1
        int curDate = c.get(Calendar.DATE);
        year = (WheelView) window.findViewById(R.id.year);
        initYear();
        month = (WheelView) window.findViewById(R.id.month);
        initMonth();
        day = (WheelView) window.findViewById(R.id.day);
        initDay(curYear,curMonth);


        year.setCurrentItem(curYear - 1950);
        month.setCurrentItem(curMonth - 1);
        day.setCurrentItem(curDate - 1);
        year.setVisibleItems(7);
        month.setVisibleItems(7);
        day.setVisibleItems(7);

        // 设置监听
        Button ok = (Button) window.findViewById(R.id.set);
        Button cancel = (Button) window.findViewById(R.id.cancel);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = String.format(Locale.CHINA,"%4d年%2d月%2d日",year.getCurrentItem()+1950,month.getCurrentItem()+1,day.getCurrentItem()+1);
                Toast.makeText(jianpai_jifen.this, str, Toast.LENGTH_LONG).show();
                dialog.cancel();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        LinearLayout cancelLayout = (LinearLayout) window.findViewById(R.id.view_none);
        cancelLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                dialog.cancel();
                return false;
            }
        });

    }

    /**
     *
     * @return
     */
    private View getDataPick() {
        Calendar c = Calendar.getInstance();
        int curYear = c.get(Calendar.YEAR);
        int curMonth = c.get(Calendar.MONTH) + 1;//通过Calendar算出的月数要+1
        int curDate = c.get(Calendar.DATE);
        final View view = inflater.inflate(R.layout.datepicker_layout, null);

        year = (WheelView) view.findViewById(R.id.year);
        initYear();
        month = (WheelView) view.findViewById(R.id.month);
        initMonth();
        day = (WheelView) view.findViewById(R.id.day);
        initDay(curYear,curMonth);

        year.setCurrentItem(curYear - 1950);
        month.setCurrentItem(curMonth - 1);
        day.setCurrentItem(curDate - 1);
        year.setVisibleItems(7);
        month.setVisibleItems(7);
        day.setVisibleItems(7);

        Button bt = (Button) view.findViewById(R.id.set);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = (year.getCurrentItem()+1950) + "-"+ (month.getCurrentItem()+1)+"-"+(day.getCurrentItem());
                Toast.makeText(jianpai_jifen.this, str, Toast.LENGTH_LONG).show();
                menuWindow.dismiss();
            }
        });
        Button cancel = (Button) view.findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuWindow.dismiss();
            }
        });
        return view;
    }
    /**
     * 初始化年
     */
    private void initYear() {
        NumericWheelAdapter numericWheelAdapter = new NumericWheelAdapter(this,1950, 2050);
        numericWheelAdapter.setLabel(" 年");
        //		numericWheelAdapter.setTextSize(15);  设置字体大小
        year.setViewAdapter(numericWheelAdapter);
        year.setCyclic(true);
    }

    /**
     * 初始化月
     */
    private void initMonth() {
        NumericWheelAdapter numericWheelAdapter = new NumericWheelAdapter(this,1, 12, "%02d");
        numericWheelAdapter.setLabel(" 月");
        //		numericWheelAdapter.setTextSize(15);  设置字体大小
        month.setViewAdapter(numericWheelAdapter);
        month.setCyclic(true);
    }

    /**
     * 初始化天
     */
    private void initDay(int arg1, int arg2) {
        NumericWheelAdapter numericWheelAdapter=new NumericWheelAdapter(this,1, getDay(arg1, arg2), "%02d");
        numericWheelAdapter.setLabel(" 日");
        //		numericWheelAdapter.setTextSize(15);  设置字体大小
        day.setViewAdapter(numericWheelAdapter);
        day.setCyclic(true);
    }
    /**
     *
     * @param year
     * @param month
     * @return
     */
    private int getDay(int year, int month) {
        int day = 30;
        boolean flag = false;
        switch (year % 4) {
            case 0:
                flag = true;
                break;
            default:
                flag = false;
                break;
        }
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                day = 31;
                break;
            case 2:
                day = flag ? 29 : 28;
                break;
            default:
                day = 30;
                break;
        }
        return day;
    }
}

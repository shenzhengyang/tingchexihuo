package com.example.zy.happyrun.My_Information.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.apistore.sdk.ApiCallBack;
import com.baidu.apistore.sdk.ApiStoreSDK;
import com.baidu.apistore.sdk.network.Parameters;
import com.baidu.location.LocationClient;
import com.example.zy.happyrun.BD_location.BD_location_entity;
import com.example.zy.happyrun.BD_location.BD_location_thread;
import com.example.zy.happyrun.My_Application.StatusBars;
import com.example.zy.happyrun.My_Application.Volly_Request;
import com.example.zy.happyrun.My_Application.cn2char;
import com.example.zy.happyrun.My_Information.Entity.tianqi_back_entity;
import com.example.zy.happyrun.My_Information.My_Information_Applycation;
import com.example.zy.happyrun.R;
import com.google.gson.Gson;




/**
 * Created by zy on 2016/7/19.
 */
public class My_InformationActivity extends AppCompatActivity{
    private ImageView tianqi_image;
    private TextView tianqi,didian,shijian,qiwen;
    private tianqi_back_entity  t_b_entity;
    Gson gson=new Gson();
    private BD_location_entity bd_location_entity;
    private Handler handler;
    private Volly_Request volly_request;
    private String tianqi_URL="http://php.weather.sina.com.cn/images/yb3/180_180/";
    private String tianqi_image_URL;
    private LinearLayout my_rank;
    private LinearLayout jianpai_jifen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBars statusBars=new StatusBars(R.color.status_color);
        statusBars.initSystemBar(this);
        setContentView(R.layout.my_information);
        init();
        request_weather();
        handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                switch(msg.what){
                    case 1:{
                        tianqi.setText("天气："+t_b_entity.getRetData().getWeather());
                        didian.setText("地点："+t_b_entity.getRetData().getCity());
                        qiwen.setText("气温："+t_b_entity.getRetData().getL_tmp()+"°C~"+t_b_entity.getRetData().getH_tmp()+"°C");
                        shijian.setText("日期："+t_b_entity.getRetData().getDate());
                        cn2char mcn2char=new cn2char();
                        String tianqi_pinyin=mcn2char.getPinYin(t_b_entity.getRetData().getWeather());
                        Log.d("wrong",tianqi_pinyin);
                        tianqi_image_URL=tianqi_URL+tianqi_pinyin+"_0.png";
                        getImage_code(tianqi_image_URL);
                        break;
                    }
                }
                super.handleMessage(msg);
            }
        };
        tianqi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                request_weather();
            }
        });
        my_rank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(My_InformationActivity.this,My_Rank.class);
                startActivity(intent);
            }
        });
        jianpai_jifen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(My_InformationActivity.this,jianpai_jifen.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {

        super.onResume();
    }
    public void getImage_code(String tianqi_image_URL) {
        volly_request=new Volly_Request(My_InformationActivity.this,tianqi_image_URL);
        volly_request.getImageLoader(tianqi_image);
    }
    private void init() {
        tianqi_image= (ImageView) findViewById(R.id.tianqi_image);
        tianqi= (TextView) findViewById(R.id.tianqi_text);
        didian= (TextView) findViewById(R.id.didian);
        qiwen= (TextView) findViewById(R.id.qiwen);
        shijian= (TextView) findViewById(R.id.shijian);
        my_rank= (LinearLayout) findViewById(R.id.rank);
        jianpai_jifen= (LinearLayout) findViewById(R.id.jianpai_jifen);
    }
    private void request_weather(){
        //bd_location_thread.run();
        Log.d("bd_location_thread",My_Information_Applycation.getBd_location_entity().getCity());
        Log.d("thread","run开始");
        String city=My_Information_Applycation.getBd_location_entity().getCity();
        String subStr=city.substring(0,city.length()-1);
        Log.d("thread",subStr);
        cn2char mcn2char=new cn2char();
        String city_pinyin=mcn2char.getPinYin(subStr);
        Log.d("city_pinyin",city_pinyin);
        Parameters para = new Parameters();
        para.put("citypinyin",city_pinyin);
        ApiStoreSDK.execute("http://apistore.baidu.com/microservice/weather",
                ApiStoreSDK.GET,
                para,
                new ApiCallBack() {
                    @Override
                    public void onSuccess(int status, String responseString) {
                        Log.i("sdkdemo", responseString);
                        t_b_entity=gson.fromJson(responseString, tianqi_back_entity.class);
                        Message message=new Message();
                        message.what=1;
                        handler.handleMessage(message);
                    }

                    @Override
                    public void onComplete() {
                        Log.i("sdkdemo", "onComplete");
                    }

                    @Override
                    public void onError(int status, String responseString, Exception e) {
                        Log.i("sdkdemo", "onError, status: " + status);
                        Log.i("sdkdemo", "errMsg: " + (e == null ? "" : e.getMessage()));
                    }

                });
    }
}

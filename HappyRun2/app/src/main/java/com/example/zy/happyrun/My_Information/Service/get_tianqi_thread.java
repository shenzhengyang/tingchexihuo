package com.example.zy.happyrun.My_Information.Service;

import android.util.Log;
import android.widget.Toast;

import com.example.zy.happyrun.My_Information.Entity.tianqi_back_entity;
import com.example.zy.happyrun.My_Information.Entity.tianqi_entity;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by zy on 2016/7/20.
 */
public class get_tianqi_thread extends Thread {
    private String httpUrl = "http://apis.baidu.com/apistore/weatherservice/cityname";
    private String httpArg = "cityname=%E5%8C%97%E4%BA%AC";
    get_tianqigson_service tq_service;
    private List<tianqi_entity> tq_entity;
    private tianqi_back_entity tq_b_entity;
    Gson gson;
    String jsonResult;
    public get_tianqi_thread(String jsonResult){
        super();
        gson=new Gson();
        this.jsonResult=jsonResult;
        tq_service=new get_tianqigson_service(httpUrl,httpArg);
    }

    @Override
    public void run() {
        jsonResult = tq_service.request(httpUrl, httpArg);
        if(jsonResult!=null){
            Log.d("神",jsonResult);
        }
        else {
            Log.d("神","jsonResult");
        }
        tq_b_entity=gson.fromJson(jsonResult, tianqi_back_entity.class);
        super.run();
    }
}

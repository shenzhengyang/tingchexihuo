package com.example.zy.happyrun.My_Information;

import android.app.Application;

import com.baidu.apistore.sdk.ApiStoreSDK;
import com.baidu.location.BDLocation;
import com.example.zy.happyrun.BD_location.BD_location_entity;
import com.example.zy.happyrun.My_Information.Entity.tianqi_back_entity;

/**
 * Created by zy on 2016/8/8.
 */
public class My_Information_Applycation extends Application {
    private static BD_location_entity bd_location_entity;
    private static tianqi_back_entity tianqi_back_entity;

    public static com.example.zy.happyrun.My_Information.Entity.tianqi_back_entity getTianqi_back_entity() {
        return tianqi_back_entity;
    }

    public static void setTianqi_back_entity(com.example.zy.happyrun.My_Information.Entity.tianqi_back_entity tianqi_back_entity) {
        My_Information_Applycation.tianqi_back_entity = tianqi_back_entity;
    }

    public static BD_location_entity getBd_location_entity() {
        return bd_location_entity;
    }

    public static void setBd_location_entity(BD_location_entity bd_location_entity) {
        My_Information_Applycation.bd_location_entity = bd_location_entity;
    }

    public My_Information_Applycation(){
        super();
    }
    @Override
    public void onCreate() {
        ApiStoreSDK.init(this,"b14c8677c9693816484adc4ffe1be484");
        super.onCreate();

    }

}

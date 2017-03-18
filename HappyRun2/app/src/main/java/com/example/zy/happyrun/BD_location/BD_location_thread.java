package com.example.zy.happyrun.BD_location;

import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;

/**
 * Created by zy on 2016/8/8.
 */
public class BD_location_thread extends Thread {
    public initLocation minitLocation;
    public LocationClient mLocationClient;
    public BDLocationListener myListener;
    public LocationClientOption option;
    public BD_location_thread(LocationClient mLocationClient){
        this.mLocationClient=mLocationClient;
        minitLocation=new initLocation();
    }

    @Override
    public void run() {
        super.run();
        myListener=new MyLocationListener();
        option=minitLocation.init();
        mLocationClient.setLocOption(option);
        mLocationClient.registerLocationListener(myListener);
        mLocationClient.start();
    }
}

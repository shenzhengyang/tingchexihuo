package com.example.zy.happyrun.Login.Service;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zy on 2016/8/17.
 *
 */
public class Login_service {
    public String Encodding="UTF-8";
    public final static String login_in_URL="http://115.29.136.135:8080/HappyRun/Login_servlet";
    public final static String regist_URL="http://115.29.136.135:8080/HappyRun/Regist_servlet";

    public Login_service(){
        super();
    }
    /*
    * 用户登录判断
    * */
    public static String Login_in(String name,String password){
        boolean is_login=false;
        try {
            Map<String, String> params = new HashMap<String, String>();
            params.put("name", name);
            params.put("password", password);
            HttpUtils httpUtils = new HttpUtils();
            String str = HttpUtils.submitPostData(params,login_in_URL);
            System.out.println(str);
            return str;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return "0";
    }
    public static String Regist(String yonghuming,String password,String phone,String image_code){
        boolean is_login=false;
        try {
            Map<String, String> params = new HashMap<String, String>();
            params.put("name", yonghuming);
            params.put("phone", phone);
            params.put("password", password);
            params.put("image_code", image_code);
            HttpUtils httpUtils = new HttpUtils();
            String str = HttpUtils.submitPostData(params,regist_URL);
            System.out.println(str);
            return str;

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return "0";
    }
}

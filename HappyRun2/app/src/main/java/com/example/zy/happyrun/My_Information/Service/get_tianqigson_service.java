package com.example.zy.happyrun.My_Information.Service;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by zy on 2016/7/20.
 */
public class get_tianqigson_service {
//    String httpUrl = "http://apis.baidu.com/apistore/weatherservice/cityname";
//    String httpArg = "cityname=%E5%8C%97%E4%BA%AC";
//    String jsonResult = request(httpUrl, httpArg);
    private String httpUrl;
    private String httpArg;
    /**
     * @param urlAll
     *            :请求接口
     * @param httpArg
     *            :参数
     * @return 返回结果
     */
    public get_tianqigson_service(String httpUrl,String httpArg){
        this.httpUrl=httpUrl;
        this.httpArg=httpArg;
    }
    public static String request(String httpUrl, String httpArg) {
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        httpUrl = httpUrl + "?" + httpArg;

        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            // 填入apikey到HTTP header
            connection.setRequestProperty("apikey",  "b14c8677c9693816484adc4ffe1be484");
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d("shen",result);
        return result;

    }
}

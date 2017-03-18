package com.example.zy.happyrun.My_Information.Entity;

/**
 * Created by zy on 2016/7/20.
 */
public class tianqi_entity {
    private String city;//城市名称
    private String pinyin;//城市拼音
    private String citycode;//城市代码
    private String date;//日期
    private String time;//时间
    private String postCode;//邮政编码
    private String longitude;//经度
    private String latitude;//纬度
    private String altitude;//海拔
    private String weather;//天气
    private String temp;//气温
    private String l_tmp;
    private String h_tmp;
    private String WD;//风向
    private String WS;//风力
    private String sunrise;//日出
    private String sunset;//日落
    public tianqi_entity(){
        super();
    }
    public tianqi_entity(String city, String pinyin, String citycode, String date, String time, String postCode, String longitude, String latitude, String altitude, String weather, String temp, String l_tmp, String h_tmp, String WD, String WS, String sunrise, String sunset) {
        this.city = city;
        this.pinyin = pinyin;
        this.citycode = citycode;
        this.date = date;
        this.time = time;
        this.postCode = postCode;
        this.longitude = longitude;
        this.latitude = latitude;
        this.altitude = altitude;
        this.weather = weather;
        this.temp = temp;
        this.l_tmp = l_tmp;
        this.h_tmp = h_tmp;
        this.WD = WD;
        this.WS = WS;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getL_tmp() {
        return l_tmp;
    }

    public void setL_tmp(String l_tmp) {
        this.l_tmp = l_tmp;
    }

    public String getH_tmp() {
        return h_tmp;
    }

    public void setH_tmp(String h_tmp) {
        this.h_tmp = h_tmp;
    }

    public String getWD() {
        return WD;
    }

    public void setWD(String WD) {
        this.WD = WD;
    }

    public String getWS() {
        return WS;
    }

    public void setWS(String WS) {
        this.WS = WS;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    @Override
    public String toString() {
        return "tianqi_entity{" +
                "city='" + city + '\'' +
                ", pinyin='" + pinyin + '\'' +
                ", citycode='" + citycode + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", postCode='" + postCode + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", altitude='" + altitude + '\'' +
                ", weather='" + weather + '\'' +
                ", temp='" + temp + '\'' +
                ", l_tmp='" + l_tmp + '\'' +
                ", h_tmp='" + h_tmp + '\'' +
                ", WD='" + WD + '\'' +
                ", WS='" + WS + '\'' +
                ", sunrise='" + sunrise + '\'' +
                ", sunset='" + sunset + '\'' +
                '}';
    }
}

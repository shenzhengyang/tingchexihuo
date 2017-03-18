package com.example.zy.happyrun.BD_location;

import com.baidu.location.BDLocationListener;

/**
 * Created by zy on 2016/8/8.
 */
public class BD_location_entity {
    private String time;
    private int LocType;
    private Double latitude;
    private Double lontitude;
    private String Country;
    private String city;
    private String District;
    private String describe;
    public BD_location_entity(){
        super();
    }

    public BD_location_entity(String time, int locType, Double latitude, String describe, String district, String city, String country, Double lontitude) {
        this.time = time;
        LocType = locType;
        this.latitude = latitude;
        this.describe = describe;
        District = district;
        this.city = city;
        Country = country;
        this.lontitude = lontitude;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getLocType() {
        return LocType;
    }

    public void setLocType(int locType) {
        LocType = locType;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLontitude() {
        return lontitude;
    }

    public void setLontitude(Double lontitude) {
        this.lontitude = lontitude;
    }

    @Override
    public String toString() {
        return "BD_location_entity{" +
                "time='" + time + '\'' +
                ", LocType=" + LocType +
                ", latitude='" + latitude + '\'' +
                ", lontitude='" + lontitude + '\'' +
                ", Country='" + Country + '\'' +
                ", city='" + city + '\'' +
                ", District='" + District + '\'' +
                ", describe='" + describe + '\'' +
                '}';
    }
}

package com.example.zy.happyrun.Login.Entity;

import com.example.zy.happyrun.Login.Service.Login_service;

/**
 * Created by zy on 2016/8/21.
 */
public class Login_in_result {
    private String result;
    public Login_in_result(){
        super();
    }
    public Login_in_result(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Login_in_result{" +
                "result='" + result + '\'' +
                '}';
    }
}

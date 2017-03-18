package com.example.zy.happyrun.My_Information.Entity;

import java.util.List;

/**
 * Created by zy on 2016/7/20.
 */
public class tianqi_back_entity {
    private int errNum;
    private String errMsg;
    //private List<tianqi_entity> retData;
    private tianqi_entity retData;
    public tianqi_back_entity(){
        super();
    }

    public tianqi_back_entity(int errNum, String errMsg, tianqi_entity retData) {
        this.errNum = errNum;
        this.errMsg = errMsg;
        this.retData = retData;
    }

    public int getErrNum() {
        return errNum;
    }

    public void setErrNum(int errNum) {
        this.errNum = errNum;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public tianqi_entity getRetData() {
        return retData;
    }

    public void setRetData(tianqi_entity retData) {
        this.retData = retData;
    }

    @Override
    public String toString() {
        return "tianqi_back_entity{" +
                "errNum=" + errNum +
                ", errMsg='" + errMsg + '\'' +
                ", retData=" + retData +
                '}';
    }
}

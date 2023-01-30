package com.ldms.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class DeviceUse {

    private String deviceId;
    private String userId;
    private String useDate;
//    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private String beginTime;
//    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private String endTime;
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUseDate() {
        return useDate;
    }

    public void setUseDate(String useDate) {
        this.useDate = useDate;
    }

//    public Date getBeginTime() {
//        return beginTime;
//    }
//
//    public void setBeginTime(Date beginTime) {
//        this.beginTime = beginTime;
//    }
//
//    public Date getEndTime() {
//        return endTime;
//    }
//
//    public void setEndTime(Date endTime) {
//        this.endTime = endTime;
//    }


    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}

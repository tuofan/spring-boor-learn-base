package com.example.learn.base.dto;

/**
 * Created by tuofan on 2018-7-11.
 */
public class BaseResult {
    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private String errCode;
    private Object data;
}

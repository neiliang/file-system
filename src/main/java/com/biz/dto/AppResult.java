package com.biz.dto;

import java.io.Serializable;

public class AppResult<T> implements Serializable {


    public static AppResult SUCCESS = new AppResult(200, "success");
    public static AppResult FAIL = new AppResult(500, "fail");

    // 响应码
    private int code = 0;
    // 响应信息
    private String msg;
    // 数据
    private T data;

    public AppResult() {
    }

    public AppResult(int code) {
        this.code = code;
    }

    public AppResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public AppResult(int code, T data) {
        this.code = code;
        this.data = data;
    }

    // get && set

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

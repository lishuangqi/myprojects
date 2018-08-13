package com.shuangqi.controller;

/**
 * Created by michael on 2018/8/13.
 */
public class ResultRes {
    private int code;
    private String msg;
    private Object data;
    public ResultRes(int code, String msg, Object data) {
        this.code= code;
        this.msg =msg;
        this.data=data;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

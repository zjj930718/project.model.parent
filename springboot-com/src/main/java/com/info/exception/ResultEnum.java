package com.info.exception;

/**
 * Created by Shuzheng on 2019/9/4.
 */

public enum ResultEnum {

    SUCCESS(200, "成功"),

    FAIL(400, "失败"),

    EXCEPTION(300, "系统异常"),

    UNLOGIN(201, "未登录");


    private Integer code;

    private String msg;


    private ResultEnum(Integer code, String msg) {

        this.code = code;

        this.msg = msg;

    }


    public Integer getCode() {

        return code;

    }


    public void setCode(Integer code) {

        this.code = code;

    }


    public String getMsg() {

        return msg;
    }
}
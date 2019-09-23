package com.info.exception;

import lombok.Data;

/**
 * Created by Shuzheng on 2019/9/4.
 */
@Data
public class BizException extends RuntimeException{

    private Integer code;

    private String msg;


    public BizException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

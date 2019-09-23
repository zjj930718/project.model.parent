package com.info;

import com.info.exception.ResultEnum;
import lombok.Data;

/**
 * Created by Shuzheng on 2019/9/4.
 */
@Data
public class ResponseMsg {

    private Integer code;

    private Object result;

    public ResponseMsg(Object result) {
        this.code = ResultEnum.SUCCESS.getCode();
        this.result = result;
    }

    public ResponseMsg(Integer code, Object result) {
        this.code = code;
        this.result = result;
    }
}

package com.info.exception;

import com.info.ResponseMsg;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Shuzheng on 2019/9/4.
 */

@ControllerAdvice
public class ExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseMsg defaultException(HttpServletRequest request, Exception e){
        e.printStackTrace();
        return new ResponseMsg(ResultEnum.EXCEPTION.getCode(),ResultEnum.EXCEPTION.getMsg());
    }

    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public ResponseMsg bizException(HttpServletRequest request, BizException e) {
        e.printStackTrace();
        Integer code = e.getCode();
        String message = e.getMessage();

        if (e.getCode() == null) {
            code = ResultEnum.EXCEPTION.getCode();
        }

        if (e.getMessage() == null) {
            message = ResultEnum.EXCEPTION.getMsg();
        }

        return new ResponseMsg(code,message);
    }
}

package com.example.sqldemo.util;

import com.example.sqldemo.entity.ExceptionEnum;
import com.example.sqldemo.entity.Result;

/**
 * @author Brandon.
 * @date 2019/4/3.
 * @time 10:16.
 */

public class ResultUtil {
    public static Result success(Object object){
        Result result = new Result();
        result.setStatues(0);
        result.setMsg("success");
        result.setData(object);
        return result;
    }
    public static Result success() {
        return success(null);
    }
    public static Result error(int code,String msg){
        Result result = new Result();
        result.setMsg(msg);
        result.setStatues(code);
        result.setData(null);
        return result;
    }
    public static Result error(ExceptionEnum exceptionEnum){
        Result result = new Result();
        result.setMsg(exceptionEnum.getMsg());
        result.setStatues(exceptionEnum.getCode());
        result.setData(null);
        return result;
    }
}

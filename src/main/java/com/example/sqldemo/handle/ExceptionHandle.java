package com.example.sqldemo.handle;

import com.example.sqldemo.entity.DescribeException;
import com.example.sqldemo.entity.ExceptionEnum;
import com.example.sqldemo.entity.Result;
import com.example.sqldemo.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Brandon.
 * @date 2019/4/3.
 * @time 10:33.
 */

@ControllerAdvice
public class ExceptionHandle {
    private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result exceptionGet(Exception e){
        if(e instanceof DescribeException){
            DescribeException describeException = (DescribeException) e;
            return ResultUtil.error(describeException.getCode(),describeException.getMessage());
        }
        LOGGER.error("【系统异常】{}",e);
        return ResultUtil.error(ExceptionEnum.UNKNOWN_ERROR);
    }
}

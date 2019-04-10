package com.example.sqldemo.entity;

/**
 * @author Brandon.
 * @date 2019/4/3.
 * @time 10:26.
 */

public class DescribeException extends RuntimeException {
    /**
    * 自定义错误代码
    */
    private int code;
    public DescribeException(ExceptionEnum exceptionEnum){
        super(exceptionEnum.getMsg());
        this.code = exceptionEnum.getCode();
    }

    /**
     * 自定义错误信息
     */
    public DescribeException(int code,String msg){
        super(msg);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}

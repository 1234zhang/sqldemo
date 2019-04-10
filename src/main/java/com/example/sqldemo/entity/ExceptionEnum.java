package com.example.sqldemo.entity;

/**
 * @author Brandon.
 * @date 2019/4/3.
 * @time 10:10.
 */

public enum ExceptionEnum {
    /*
    * 用于未知错误，返回-1
    * */
    UNKNOWN_ERROR(-1,"未知错误"),
    /*
    * 如果用户未找到，则返回-101
    * */
    USER_NOT_FIND(-101,"用户未找到"),
    ;

    private int code;
    private String msg;
    ExceptionEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }
}

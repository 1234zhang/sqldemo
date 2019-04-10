package com.example.sqldemo.entity;

/**
 * @author Brandon.
 * @date 2019/4/3.
 * @time 10:00.
 */

public class Result<T> {
    private int statues;
    private String msg;
    private T data;

    public int getStatues() {
        return statues;
    }

    public String getMsg() {
        return msg;
    }

    public T getData(Object object) {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setStatues(int statues) {
        this.statues = statues;
    }

    @Override
    public String toString() {
        return "result{" +
                "status=" + statues +
                ",msg='" + msg + "'" +
                ",data=" + data +
                "}";
    }
}

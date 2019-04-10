package com.example.sqldemo.entity;

import lombok.Data;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brandon.
 * @date 2019/4/3.
 * @time 14:56.
 */

@Data
public class Student {
    public int code;
    public String info;
    public A[] returnData;
    class A{
        public String bj;
        public String csrq;
        public String mz;
        public String nj;
        public String rxrq;
        public String xb;
        public String xh;
        public String xjzt;
        public String xm;
        public String xmEn;
        public int xz;
        public String yxh;
        public String yxm;
        public String yxmen;
        public String zyh;
        public String zym;
        public String zymEn;
    }
    public List<Resource> resources = new ArrayList<>();

    @Override
    public String toString() {
        return code + info;
    }
}
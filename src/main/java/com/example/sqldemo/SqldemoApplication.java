package com.example.sqldemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@MapperScan("com.example.sqldemo.mapper")
public class SqldemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SqldemoApplication.class, args);
    }

}

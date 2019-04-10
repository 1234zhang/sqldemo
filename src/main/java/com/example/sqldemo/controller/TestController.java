package com.example.sqldemo.controller;

import com.example.sqldemo.entity.Resource;
import com.example.sqldemo.entity.ResourceData;
import com.example.sqldemo.entity.Result;
import com.example.sqldemo.handle.ExceptionHandle;
import com.example.sqldemo.service.ChooseService;
import com.example.sqldemo.service.ResourceService;
import com.example.sqldemo.util.ResultUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.List;

/**
 * @author Brandon.
 * @date 2019/4/3.
 * @time 11:03.
 */

@RestController
public class TestController {
    Gson gson = new Gson();
    @Autowired
    ExceptionHandle exceptionHandle;
    @Autowired
    ResourceService resourceService;
    @Autowired
    ChooseService chooseService;
    @RequestMapping("/test")
    public String test(){
        return "hello world";
    }
    @RequestMapping("/abc")
    public Result abc(String name){
        Result result = ResultUtil.success();
        try{
            result = ResultUtil.success("Hello" + name);
        }catch (Exception e){
            result = exceptionHandle.exceptionGet(e);
        }
        return result;
    }
    @RequestMapping("/resource")
    public String resource(String xh){
        ResourceData resourceData = new ResourceData();
        resourceData.data = resourceService.getResource(xh);
        resourceData.outputDataTimeStamp = System.currentTimeMillis();
        resourceData.state = 200;
        resourceData.stuNum = xh;
        return gson.toJson(resourceData);
    }
    @RequestMapping("/selectCourse")
    public String selectCourse(String course,String teacher,String xh){
        return chooseService.choiceResource(course,teacher,xh);
    }
}

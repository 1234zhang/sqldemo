package com.example.sqldemo.service;

import com.example.sqldemo.entity.Resource;
import com.example.sqldemo.mapper.ResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brandon.
 * @date 2019/4/3.
 * @time 22:30.
 */

@Service
public class ResourceService {
    @Autowired
    ResourceMapper resourceMapper;
    public List<Resource>  getResource(String xh){
        List<Resource> resources = resourceMapper.selectResource(xh);
        if(resources.size() == 0){
            throw new IllegalArgumentException("学生不存在");
        }
        for (Resource resource : resources){
            System.out.println(resource.raw_week);
            resource.week = getWeekList(resource.raw_week);
            System.out.println(resource.week.size());
        }
        return resources;
    }
    public List<Integer> getWeekList(String rawWeek){
        String[] result = rawWeek.trim().split(",");
        List<Integer> res = new ArrayList<>();
        for (String a : result){
            char flag = a.charAt(a.length()-2);
            if(flag == '单'){
                String[] week = a.replaceAll("\\D"," ").trim().split(" ");
                for (int i = Integer.parseInt(week[0]); i <= Integer.parseInt(week[week.length - 1]); i++) {
                    if (i % 2 != 0) {
                        res.add(i);
                    }
                }
            }else if(flag == '双'){
                String[] week = a.replaceAll("\\D"," ").trim().split(" ");
                for (int i = Integer.parseInt(week[0]); i <= Integer.parseInt(week[week.length - 1]); i++) {
                    if(i % 2 == 0 ){
                        res.add(i);
                    }
                }
            }else{
                String[] week = a.replaceAll("\\D"," ").trim().split(" ");
                for (int i = Integer.parseInt(week[0]); i <= Integer.parseInt(week[week.length - 1]) ; i++) {
                    res.add(i);

                }
            }

        }
        return res;
    }
}

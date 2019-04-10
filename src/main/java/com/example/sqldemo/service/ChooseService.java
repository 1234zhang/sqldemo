package com.example.sqldemo.service;

import com.example.sqldemo.entity.Resource;
import com.example.sqldemo.mapper.ResourceMapMapper;
import com.example.sqldemo.mapper.ResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Brandon.
 * @date 2019/4/6.
 * @time 14:38.
 */

@Service
public class ChooseService {
    @Autowired
    ResourceMapper resourceMapper;
    @Autowired
    ResourceMapMapper resourceMapMapper;

    @Transactional(noRollbackFor = IllegalArgumentException.class)
    public String choiceResource(String course, String teacher, String xh){
        List<Resource> resources = resourceMapper.selectResource(xh);
        Resource resource = resourceMapper.selectCourse(course,teacher);
        resourceMapMapper.addResourceMap(xh,resource.course_id,resource.teacher);
        if(resource == null){
            throw new IllegalArgumentException("选修课程不存在");
        }
        for (Resource res : resources){
            if(res.lesson.equals(resource.lesson) && res.day.equals(resource.day)){
                throw new IllegalArgumentException("课程时间冲突");
            }
        }
        return "选课成功";
    }
}

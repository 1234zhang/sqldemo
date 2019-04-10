package com.example.sqldemo.mapper;

import com.example.sqldemo.entity.Resource;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Brandon.
 * @date 2019/4/3.
 * @time 15:57.
 */
@Mapper
@Repository
public interface ResourceMapper {
    @Insert("insert into resource(course_id,teacher,course,class_room,raw_week,lesson,type) value (#{courseId},#{teacher},#{course},#{class_room},#{rewWeek},#{lesson},#{type}")
    boolean addResource(Resource resource);
    @Select("select*from resource_map,resource where xh = #{xh} and resource_map.teacher = resource.teacher and resource_map.course_id = resource.course_id;")
    List<Resource> selectResource(String xh);
    @Select("select*from resource where course = #{course} and teacher = #{teacher}")
    Resource selectCourse(String course,String teacher);
}

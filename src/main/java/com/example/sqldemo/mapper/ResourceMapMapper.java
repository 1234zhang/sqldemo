package com.example.sqldemo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

/**
 * @author Brandon.
 * @date 2019/4/3.
 * @time 16:02.
 */

@Mapper
@Repository
public interface ResourceMapMapper {
    @Insert("insert into resource_map(xh,course_id,teacher) value (#{xh},#{courseId},#{teacher})")
    @Options(useGeneratedKeys = true,keyColumn = "id")
    boolean addResourceMap(String xh,String courseId,String teacher);
}

package com.example.sqldemo.mapper;

import com.example.sqldemo.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author Brandon.
 * @date 2019/4/3.
 * @time 15:50.
 */

@Mapper
@Repository
public interface StudentMapper<T> {
    @Insert("insert into student(xh,xm,bj,xym,zym) value(#{xh},#{xm},#{bj},#{xym},#{zy})")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    boolean addStudent(T object);
}

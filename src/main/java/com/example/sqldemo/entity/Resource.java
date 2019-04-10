package com.example.sqldemo.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brandon.
 * @date 2019/4/3.
 * @time 14:55.
 */

@Data
public class Resource implements Cloneable {
    public String day;
    public String class_type;
    public String course_id;
    public String lesson;
    public String course;
    public String teacher;
    public String class_room;
    public String raw_week;
    public String type;
    public List<Integer> week;

    @Override
    public Object clone() throws CloneNotSupportedException {
        Resource resource = null;
        resource = (Resource) super.clone();
        return resource;
    }
}

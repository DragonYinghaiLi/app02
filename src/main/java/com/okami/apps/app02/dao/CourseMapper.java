package com.okami.apps.app02.dao;

import com.okami.apps.app02.bean.Course;

import java.util.List;

public interface CourseMapper {
    List<Course> query(Course course);
    List<Course> selectAll();
    Course selectByPrimaryKey(long id);
    void deleteByPrimaryKey(long id);
    void insert(Course course);
    void update(Course course);
}

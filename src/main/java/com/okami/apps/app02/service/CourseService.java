package com.okami.apps.app02.service;

import com.okami.apps.app02.bean.Course;

import java.util.List;

public interface CourseService {
    List<Course> query(Course course);
    List<Course> findAll();
    Course findById(long id);
    void saveOrUpdate(Course course) throws Exception;
    void deleteById(long id) throws  Exception;
}

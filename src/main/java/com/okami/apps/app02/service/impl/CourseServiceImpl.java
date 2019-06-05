package com.okami.apps.app02.service.impl;

import com.okami.apps.app02.bean.Course;
import com.okami.apps.app02.dao.CourseMapper;
import com.okami.apps.app02.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class CourseServiceImpl implements CourseService {
    @Resource
    private CourseMapper courseMapper;
    @Override
    public List<Course> findAll() {

        return courseMapper.selectAll();
    }
    @Override
    public List<Course> query(Course course){
        return courseMapper.query(course);
    }
    @Override
    public void saveOrUpdate(Course course) throws Exception{
        if(course.getId()==null){
            //初始化属性

            System.out.println("已插入");
            courseMapper.insert(course);
        }else{
            courseMapper.update(course);
            System.out.println("已修改");
        }
    }
    @Override
    public Course findById(long id)
    {
        return courseMapper.selectByPrimaryKey(id);
    }
    @Override
    public void deleteById(long id) throws Exception {
        Course course = courseMapper.selectByPrimaryKey(id);
        if(course == null){
            throw new Exception("要删除的用户不存在");
        } else {
            courseMapper.deleteByPrimaryKey(id);
        }
    }
}

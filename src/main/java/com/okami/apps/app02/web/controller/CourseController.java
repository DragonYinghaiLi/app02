package com.okami.apps.app02.web.controller;

import com.okami.apps.app02.bean.Course;
import com.okami.apps.app02.service.CourseService;
import com.okami.apps.app02.utils.Message;
import com.okami.apps.app02.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @ApiOperation("查询所有")
    @GetMapping("findAll")
    public Message findAll(){
        List<Course> list = courseService.findAll();
        return MessageUtil.success("success",list);
    }

    @ApiOperation("通过id查询")
    @GetMapping("findById")
    public Message findById(@ApiParam(required = true) @RequestParam(value = "id") long id){
        Course course = courseService.findById(id);
        return MessageUtil.success("success",course);
    }




    @ApiOperation("更新用户信息")
    @RequestMapping("saveOrUpdate")
    public String saveOrUpdate(Course course){
        try{
            courseService.saveOrUpdate(course);
            return "更新成功";

        }catch(Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
    @ApiOperation("删除信息")
    @GetMapping("deleteById")
    public String deleteById(@ApiParam(value = "主键",required = true)@RequestParam("id")long id){

        try{
            courseService.deleteById(id);
            return "删除成功";
        }catch(Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }
}

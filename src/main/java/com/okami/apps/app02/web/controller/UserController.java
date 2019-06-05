package com.okami.apps.app02.web.controller;
/***
 *
 */

import com.okami.apps.app02.bean.User;
import com.okami.apps.app02.service.UserService;
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
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("模糊查询")
    @GetMapping("query")
    public Message query(User user){
        List<User> list=userService.query(user);
        return MessageUtil.success("success",list);
    }

    @ApiOperation("查询表数据")
    @GetMapping("findAll")
    public Message findAll(){
        List<User> list=userService.findAll();
        return MessageUtil.success("success",list);
    }

    @ApiOperation("通过id查询")
    @GetMapping("findById")
    public  Message findById(@ApiParam(value = "主键",required =true)@RequestParam(value ="id") long id){
        List<User> list= (List<User>) userService.findById(id);
        return MessageUtil.success("success",list);

    }



    @ApiOperation("更新用户信息")
    @GetMapping("saveOrUpdate")
    public String saveOrUpdate(User user){
        try{
            userService.saveOrUpdate(user);
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
            userService.deleteById(id);
            return "删除成功";
        }catch(Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }
}

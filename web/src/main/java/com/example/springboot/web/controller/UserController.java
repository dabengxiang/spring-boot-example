package com.example.springboot.web.controller;

import com.example.springboot.web.entity.User;
import com.example.springboot.web.exception.MyUserException;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * Date:2018/11/18
 * Author:gyc
 * Desc:
 */
@RequestMapping("/user")
@RestController
@Api(value = "UserController", description = "用户操作api")
public class UserController {

    @PostMapping
    @ApiOperation(value = "创建用户")
    public User create(@Valid @RequestBody User user) {
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());
        user.setId("1");
        return user;
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "根据id来获取简单的信息")
    @JsonView(User.UserSimpleView.class)
    public User getUser(@PathVariable("id") String id){
        User user = new User();
        user.setId("123");
        user.setUsername("张三");
        user.setPassword("123");
        user.setBirthday(new Date());
        return user;

    }


    @GetMapping("/detail/{id}")
    @ApiOperation(value = "根据id来获取详细的信息")
    @JsonView(User.UserDetailView.class)
    public User getDetailUser(@PathVariable("id") String id){
        User user = new User();
        user.setId("123");
        user.setUsername("张三");
        user.setPassword("123");
        user.setBirthday(new Date());
        return user;
    }


    
    @GetMapping("/exception/test")
    @ApiOperation(value = "根据id来获取详细的信息")
    @JsonView(User.UserDetailView.class)
    public void UserTesttException(){
        throw  new MyUserException("测试错误数据");
        
    }



    @PostMapping("/bindingResult")
    @ApiOperation(value = "创建用户")
    public User create(@Valid @RequestBody User user,BindingResult result) {

        if (result.hasErrors()){
            List<ObjectError> errorList = result.getAllErrors();
            for(ObjectError error : errorList){
                System.out.println(error.getDefaultMessage());
            }
        }

//        System.out.println(user.getId());
//        System.out.println(user.getUsername());
//        System.out.println(user.getPassword());
//        System.out.println(user.getBirthday());
        user.setId("1");
        return user;
    }



}

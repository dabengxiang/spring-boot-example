package com.example.springboot.web.controller;

import com.example.springboot.web.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

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
    @ApiOperation(value = "根据id来获取")
    public User getUser(@PathVariable("id") String id){
        User user = new User();
        user.setId("123");
        user.setUsername("张三");
        user.setPassword("123");
        user.setBirthday(new Date());
        return user;

    }

}

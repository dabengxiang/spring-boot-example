package com.example.springboot.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.springboot.web.WebApplicationTests;
import com.example.springboot.web.entity.User;
import javafx.animation.Animation;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;




/**
 * Date:2018/11/18
 * Author:gyc
 * Desc:
 */
@Slf4j
public class UserControllerTest extends WebApplicationTests{

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;


    @Before
    public void setup(){
         mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

    }

    @Test
    public void postUser()  {
        try {

            User user = new User();
            user.setUsername("123");

            String content = JSONObject.toJSONString(user);


            String result = mockMvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON_UTF8).content(content))
                    .andDo(print())
//                    .andExpect(status().isOk())
                    .andReturn().getResponse().getContentAsString();

            log.info(result);


        }catch (Exception e){
            log.error(this.getClass().toString(),e);
        }
    }

    @Test
    public void getUser()  {
        try {
            String result = mockMvc.perform(get("/user/123"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.username").value("张三"))
                    .andReturn().getResponse().getContentAsString();

            log.info(result);


        }catch (Exception e){
            log.error(this.getClass().toString(),e);
        }
    }


}
package com.example.springboot.web.entity;

import com.example.springboot.web.validator.MyConstraint;
import com.fasterxml.jackson.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * Date:2018/11/18
 * Author:gyc
 * Desc:
 */
@Data
public class User {


    public interface UserSimpleView {};
    public interface UserDetailView extends UserSimpleView {};

    @JsonView({UserSimpleView.class})
    private String id;

    @MyConstraint(message = "这是一个测试")
    @ApiModelProperty(value = "用户名")
    @JsonView({UserSimpleView.class})
    private String username;

    @NotBlank(message = "密码不能为空")
    @JsonView({UserDetailView.class})
    private String password;
    

    @Past(message = "生日必须是过去的时间")
    @JsonView({UserSimpleView.class})
    private Date birthday;

    
    @JsonView(UserSimpleView.class)
    @JsonProperty("testcol_1")
    private String testCol1 = "1";

    @JsonView(UserSimpleView.class)
    @JsonIgnore
    private String testCol2 = "2";


    @JsonView(UserSimpleView.class)
    @JsonInclude
    private String testCol3;


}

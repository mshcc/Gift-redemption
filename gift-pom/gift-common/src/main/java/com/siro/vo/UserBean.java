package com.siro.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author mshcc
 */
@Data
@ApiModel(value = "com.siro.vo.UserBean", description = "用户参数(登录/注册)")
public class UserBean implements Serializable {
    @ApiModelProperty(value = "用户名",example = "admin")
    private String username;
    @ApiModelProperty(value = "密码",example = "admin")
    private String password;
    @ApiModelProperty(value = "验证码",example = "abcd")
    private String captcha;
}
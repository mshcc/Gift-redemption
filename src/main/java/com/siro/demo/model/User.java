package com.siro.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 用户
    */
@ApiModel(value="com-siro-demo-model-User")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @ApiModelProperty(value="")
    private Integer id;

    /**
    * 用户名
    */
    @ApiModelProperty(value="用户名")
    private String username;

    /**
    * 密码
    */
    @ApiModelProperty(value="密码")
    private String password;

    /**
    * 盐，用于加密
    */
    @ApiModelProperty(value="盐，用于加密")
    private String salt;

    /**
    * 状态
    */
    @ApiModelProperty(value="状态")
    private Integer status;

    /**
    * 创建日期
    */
    @ApiModelProperty(value="创建日期")
    private Date creationtime;
}
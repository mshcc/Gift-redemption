package com.siro.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
    * 用户--权限中间表
    */
@ApiModel(value="com-siro-demo-model-UserRole")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRole  implements Serializable {
    @ApiModelProperty(value="")
    private Integer id;

    /**
    * 外键，用户id
    */
    @ApiModelProperty(value="外键，用户id")
    private Integer userid;

    /**
    * 外键，权限id
    */
    @ApiModelProperty(value="外键，权限id")
    private Integer roleid;
}
package com.siro.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 权限表
    */
@ApiModel(value="com-siro-demo-model-Role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @ApiModelProperty(value="")
    private Integer id;

    /**
    * 权限名
    */
    @ApiModelProperty(value="权限名")
    private String name;
   
    /**
    * 权限描述
    */
    @ApiModelProperty(value="权限描述")
    private String depict;
}
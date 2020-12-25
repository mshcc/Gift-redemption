package com.siro.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
    * 收件人信息
    */
@ApiModel(value="com-siro-demo-model-Recipient")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipient  implements Serializable {
    @ApiModelProperty(value="")
    private Integer id;

    /**
    * 姓名
    */
    @ApiModelProperty(value="姓名")
    private String name;

    /**
    * 地址
    */
    @ApiModelProperty(value="地址")
    private String address;

    /**
    * 电话
    */
    @ApiModelProperty(value="电话")
    private String phone;
}
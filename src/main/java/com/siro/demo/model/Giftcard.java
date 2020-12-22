package com.siro.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 礼品卡
    */
@ApiModel(value="com-siro-demo-model-Giftcard")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Giftcard {
    @ApiModelProperty(value="")
    private Integer id;

    /**
    * 卡号
    */
    @ApiModelProperty(value="卡号")
    private String cardnumber;

    /**
    * 卡密
    */
    @ApiModelProperty(value="卡密")
    private String cardsecret;

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

    /**
    * 过期日期
    */
    @ApiModelProperty(value="过期日期")
    private Date expiration;
}
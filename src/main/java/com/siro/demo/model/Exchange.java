package com.siro.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 兑换记录
    */
@ApiModel(value="com-siro-demo-model-Exchange")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exchange   implements Serializable {
    @ApiModelProperty(value="")
    private Integer id;

    /**
    * 外键，礼品id
    */
    @ApiModelProperty(value="外键，礼品id")
    private Integer giftid;

    /**
    * 外键，礼品卡id
    */
    @ApiModelProperty(value="外键，礼品卡id")
    private Integer cardid;

    /**
    * 兑换日期
    */
    @ApiModelProperty(value="兑换日期")
    private Date redemption;
}
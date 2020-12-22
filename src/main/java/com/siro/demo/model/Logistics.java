package com.siro.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 物流信息
    */
@ApiModel(value="com-siro-demo-model-Logistics")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Logistics {
    @ApiModelProperty(value="")
    private Integer id;

    /**
    * gift的唯一主键
    */
    @ApiModelProperty(value="gift的唯一主键")
    private Integer gifId;

    /**
    * 外键，礼品信息
    */
    @ApiModelProperty(value="外键，礼品信息")
    private Integer giftid;

    /**
    * 外键，收件人信息
    */
    @ApiModelProperty(value="外键，收件人信息")
    private Integer recipientid;

    /**
    * 物流状态
    */
    @ApiModelProperty(value="物流状态")
    private Integer status;
}
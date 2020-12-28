package com.siro.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
    * 物流信息
    */
@ApiModel(value="com-siro-demo-model-Logistics")
@Data
@AllArgsConstructor
@NoArgsConstructor
// TODO 物流
public class Logistics  implements Serializable {
    @ApiModelProperty(value="")
    private Integer id;

    /**
    * 外键，礼品信息
    */
    @ApiModelProperty(value="gift的唯一主键")
    private Integer gifId;

    /**
     * 外键，收件人信息
     */
    @ApiModelProperty(value="外键，收件人信息")
    private Integer recipientid;

    /**
     * 外键，兑换信息
     */
    @ApiModelProperty(value="外键，兑换信息")
    private Integer exchangeid;

    /**
    * 物流状态
    */
    @ApiModelProperty(value="物流状态")
    private Integer status;
}
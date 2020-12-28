package com.siro.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 礼品表
    */
@ApiModel(value="com-siro-demo-model-Gift")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gift  implements Serializable {
    /**
    * gift的唯一主键
    */
    @ApiModelProperty(value="gift的唯一主键")
    private Integer id;

    /**
    * 礼品名称
    */
    @ApiModelProperty(value="礼品名称")
    private String name;

    /**
    * 礼品描述
    */
    @ApiModelProperty(value="礼品描述")
    private String depict;

    /**
    * 礼品价值
    */
    @ApiModelProperty(value="礼品价值")
    private Long value;

    /**
    * 礼品库存
    */
    @ApiModelProperty(value="礼品库存")
    private Integer stock;

    /**
    * 上架日期
    */
    @ApiModelProperty(value="上架日期")
    private Date creationtime;

    /**
    * 状态
    */
    @ApiModelProperty(value="状态")
    private Integer giftstatus;

    private List<String> pictures;
}
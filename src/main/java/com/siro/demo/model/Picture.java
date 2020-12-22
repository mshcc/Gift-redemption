package com.siro.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 图片地址库
    */
@ApiModel(value="com-siro-demo-model-Picture")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Picture {
    @ApiModelProperty(value="")
    private Integer id;

    /**
    * 图片文件地址
    */
    @ApiModelProperty(value="图片文件地址")
    private String picpath;

    /**
    * 图片作用范围
    */
    @ApiModelProperty(value="图片作用范围")
    private String picrange;

    /**
    * 图片在该作用范围内id
    */
    @ApiModelProperty(value="图片在该作用范围内id")
    private Integer rangeId;
}
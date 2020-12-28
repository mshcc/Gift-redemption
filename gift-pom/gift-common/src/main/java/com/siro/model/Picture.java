package com.siro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
    * 图片地址库
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Picture  implements Serializable {
    private Integer id;

    /**
    * 图片文件地址
    */
    private String picpath;

    /**
    * 图片作用范围
    */
    private String picrange;

    /**
    * 图片在该作用范围内id
    */
    private Integer rangeId;
}
package com.siro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
    * 礼品表
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gift  implements Serializable {
    /**
    * gift的唯一主键
    */
    private Integer id;

    /**
    * 礼品名称
    */
    private String name;

    /**
    * 礼品描述
    */
    private String depict;

    /**
    * 礼品价值
    */
    private Long value;

    /**
    * 礼品库存
    */
    private Integer stock;

    /**
    * 上架日期
    */
    private Date creationtime;

    /**
    * 状态
    */
    private Integer giftstatus;

    private List<String> pictures;
}
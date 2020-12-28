package com.siro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
    * 兑换记录
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exchange   implements Serializable {
    private Integer id;

    /**
    * 外键，礼品id
    */
    private Integer giftid;

    /**
    * 外键，礼品卡id
    */
    private Integer cardid;

    /**
    * 兑换日期
    */
    private Date redemption;
}
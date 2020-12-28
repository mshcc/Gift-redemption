package com.siro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
    * 礼品卡
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Giftcard  implements Serializable {
    private Integer id;

    /**
    * 卡号
    */
    private String cardnumber;

    /**
    * 卡密
    */
    private String cardsecret;

    /**
    * 状态
    */
    private Integer status;

    /**
    * 创建日期
    */
    private Date creationtime;

    /**
    * 过期日期
    */
    private Date expiration;
}
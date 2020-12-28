package com.siro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
    * 物流信息
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
// TODO 物流
public class Logistics  implements Serializable {
    private Integer id;

    /**
    * 外键，礼品信息
    */
    private Integer gifId;

    /**
     * 外键，收件人信息
     */
    private Integer recipientid;

    /**
     * 外键，兑换信息
     */
    private Integer exchangeid;

    /**
    * 物流状态
    */
    private Integer status;
}
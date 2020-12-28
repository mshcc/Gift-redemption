package com.siro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
    * 收件人信息
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipient  implements Serializable {
    private Integer id;

    /**
    * 姓名
    */
    private String name;

    /**
    * 地址
    */
    private String address;

    /**
    * 电话
    */
    private String phone;
}
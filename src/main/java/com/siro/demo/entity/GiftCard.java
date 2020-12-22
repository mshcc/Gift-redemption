package com.siro.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mshcc
 * @date 2020/12/22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GiftCard {
    private Integer id;
    private String key;
    private String password;
    private Integer status;
    private Integer giftId;
}

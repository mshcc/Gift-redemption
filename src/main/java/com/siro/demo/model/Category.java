package com.siro.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mshcc
 * @date 2020/12/23
 * TODO 用于查询图片，存储种类和id
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private String category;
    private Integer id;
}

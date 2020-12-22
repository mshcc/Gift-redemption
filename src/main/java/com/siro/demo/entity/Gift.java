package com.siro.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author mshcc
 * @date 2020/12/22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gift {
    private Integer id;
    private Integer name;
    private Integer description;
    private Integer num;
    private String path;
}

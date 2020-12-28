package com.siro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
    * 权限表
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role  implements Serializable {
    private Integer id;

    /**
    * 权限名
    */
    private String name;

    /**
    * 权限描述
    */
    private String depict;
}
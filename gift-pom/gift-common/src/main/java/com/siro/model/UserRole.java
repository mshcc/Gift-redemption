package com.siro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
    * 用户--权限中间表
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRole  implements Serializable {
    private Integer id;

    /**
    * 外键，用户id
    */
    private Integer userid;

    /**
    * 外键，权限id
    */
    private Integer roleid;
}
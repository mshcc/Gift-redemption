package com.siro.demo.vo;

import lombok.Data;

/**
 * @author mshcc
 * @date 2020/12/24
 */
@Data
public class UpdateUserBean {
    private String username;
    private String password;
    private Integer status;
}

package com.siro.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author mshcc
 * @date 2020/12/24
 */
@Data
@ApiModel(value = "com.siro.vo.UpdateUserBean", description = "更新用户参数")
public class UpdateUserBean implements Serializable {
    @ApiModelProperty(value = "用户名",example = "张三")
    private String username;
    @ApiModelProperty(value = "密码",example = "123456")
    private String password;
    @ApiModelProperty(value = "状态",example = "1")
    private Integer status;
}

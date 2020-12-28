package com.siro.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author mshcc
 * @date 2020/12/25
 */
@Data
@ApiModel(value = "com.siro.vo.RecipientBean", description = "收件人参数")
public class RecipientBean implements Serializable {
    @ApiModelProperty(value = "收件人姓名",example = "张三")
    private String name;
    @ApiModelProperty(value = "收件人地址",example = "黑龙江省五常市")
    private String address;
    @ApiModelProperty(value = "收件人手机号",example = "15788888888")
    private String phone;
}

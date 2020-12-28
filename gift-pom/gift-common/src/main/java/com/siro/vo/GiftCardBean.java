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
@ApiModel(value = "com.siro.vo.GiftCardBean", description = "礼品卡参数")
public class GiftCardBean implements Serializable {
    @ApiModelProperty(value = "卡号",example = "12345678")
    private String cardnumber;
    @ApiModelProperty(value = "卡密",example = "123456")
    private String cardsecret;
}

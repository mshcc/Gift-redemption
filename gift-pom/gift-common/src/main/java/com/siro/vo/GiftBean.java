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
@ApiModel(description = "礼品参数")
public class GiftBean implements Serializable {
    @ApiModelProperty(value = "礼品名称", example = "五常大米")
    private String name;
    @ApiModelProperty(value = "礼品描述", example = "五常大米，黑龙江省哈尔滨市五常市特产，中国国家地理标志产品。五常市是典型农业大县（市）、国家重要的商品粮食基地、全国粮食生产十大先进县之一、也是全国水稻五强县之一。五常水稻种植面积占全省的十分之一，占哈尔滨市的四分之一，被誉为张广才岭下的“水稻王国”。")
    private String depict;
    @ApiModelProperty(value = "礼品价值", example = "998")
    private Long value;
    @ApiModelProperty(value = "礼品数量")
    private Integer stock;
}

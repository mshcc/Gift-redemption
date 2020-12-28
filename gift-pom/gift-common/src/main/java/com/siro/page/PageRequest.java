package com.siro.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 分页请求
 * @author mshcc
 */
@Data
@ApiModel(value = "com.siro.page.PageRequest",description = "分页请求请求参数")
public class PageRequest implements Serializable {
    /**
     * 当前页码
     */
    @ApiModelProperty(required = true,notes = "当前页码",example = "1")
    private int pageNum=1;
    /**
     * 每页数量
     */
    @ApiModelProperty(required = true,notes = "每页数量",example = "10")
    private int pageSize=10;
    /**
     * 查询参数
     */
    @ApiModelProperty(required = true,notes = "查询参数",example = "{ \"name\" : \"张三\" , \"age\" : \"28\"}")
    private Map<String,Object> params = new HashMap<>();

    public Object getParam(String label) {
        return params.get(label);
    }

}

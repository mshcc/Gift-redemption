
package com.siro.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author mshcc
 */
@Data
@ApiModel(value = "com.siro.page.PageResult",description = "分页请求查询结果")
public class PageResult implements Serializable {
    /**
     * 当前页码
     */
    @ApiModelProperty(required = true,notes = "当前页码",example = "1")
    private int pageNum;

    /**
     * 每页数量
     */
    @ApiModelProperty(required = true,notes = "每页数量",example = "10")
    private int pageSize;

    /**
     * 记录总数
     */
    @ApiModelProperty(required = true,notes = "记录总数",example = "20")
    private long totalSize;

    /**
     * 页码总数
     */
    @ApiModelProperty(required = true,notes = "页码总数",example = "2")
    private int totalPages;

    /**
     * 分页数据
     */
    @ApiModelProperty(required = true,notes = "分页数据",example = "\"id\" : \"1\",  \"name\" : \"张三\" , \"age\" : \"28\"}\"")
    private List<?> content;
}


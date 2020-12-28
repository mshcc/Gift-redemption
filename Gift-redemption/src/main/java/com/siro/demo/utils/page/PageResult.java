
package com.siro.demo.utils.page;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author mshcc
 */
@Data
public class PageResult implements Serializable {
    /**
     * 当前页码
     */
    private int pageNum;

    /**
     * 每页数量
     */
    private int pageSize;

    /**
     * 记录总数
     */
    private long totalSize;

    /**
     * 页码总数
     */
    private int totalPages;

    /**
     * 分页数据
     */
    private List<?> content;
}


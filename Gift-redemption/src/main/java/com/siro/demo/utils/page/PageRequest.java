package com.siro.demo.utils.page;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 分页请求
 * @author mshcc
 */
@Data
public class PageRequest implements Serializable {
    /**
     * 当前页码
     */
    private int pageNum=1;
    /**
     * 每页数量
     */
    private int pageSize=10;
    /**
     * 查询参数
     */
    private Map<String,Object> params = new HashMap<>();

    public Object getParam(String label) {
        return params.get(label);
    }

}

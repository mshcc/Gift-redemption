package com.siro.demo.service;

import com.siro.demo.model.Logistics;
import com.siro.demo.utils.page.PageRequest;
import com.siro.demo.utils.page.PageResult;

import java.util.List;

public interface LogisticsService{


    int deleteByPrimaryKey(Integer id);

    int insert(Logistics record);

    int insertSelective(Logistics record);

    Logistics selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Logistics record);

    int updateByPrimaryKey(Logistics record);

    PageResult findPage(PageRequest pageRequest);

    PageResult findPageByNotShipped(PageRequest pageRequest);

    PageResult findPageShipped(PageRequest pageRequest);

    PageResult findPageToBeCollected(PageRequest pageRequest);

    PageResult findPageHasBeenSigned(PageRequest pageRequest);
}

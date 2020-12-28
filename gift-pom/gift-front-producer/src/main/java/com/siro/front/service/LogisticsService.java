package com.siro.front.service;


import com.siro.model.Logistics;
import com.siro.page.PageRequest;
import com.siro.page.PageResult;

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

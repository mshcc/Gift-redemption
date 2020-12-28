package com.siro.producer.service;


import com.siro.model.Gift;
import com.siro.page.PageRequest;
import com.siro.page.PageResult;

public interface GiftService{


    int deleteByPrimaryKey(Integer id);

    int insert(Gift record);

    int insertSelective(Gift record);

    Gift selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Gift record);

    int updateByPrimaryKey(Gift record);

    PageResult findPage(PageRequest pageRequest);

    PageResult findPageByDate(PageRequest pageRequest,Integer date);

    PageResult findPageByRemoved(PageRequest pageRequest);

    PageResult findPageByOutOfStock(PageRequest pageRequest);

    Gift findByName(String name);
}

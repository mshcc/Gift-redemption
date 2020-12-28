package com.siro.demo.service;

import com.siro.demo.model.Gift;
import com.siro.demo.utils.page.PageRequest;
import com.siro.demo.utils.page.PageResult;

import java.util.List;

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

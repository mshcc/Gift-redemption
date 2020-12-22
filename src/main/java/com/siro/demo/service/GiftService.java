package com.siro.demo.service;

import com.siro.demo.model.Gift;
public interface GiftService{


    int deleteByPrimaryKey(Integer id);

    int insert(Gift record);

    int insertSelective(Gift record);

    Gift selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Gift record);

    int updateByPrimaryKey(Gift record);

}

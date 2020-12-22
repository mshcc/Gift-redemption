package com.siro.demo.service;

import com.siro.demo.model.Logistics;
public interface LogisticsService{


    int deleteByPrimaryKey(Integer id);

    int insert(Logistics record);

    int insertSelective(Logistics record);

    Logistics selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Logistics record);

    int updateByPrimaryKey(Logistics record);

}

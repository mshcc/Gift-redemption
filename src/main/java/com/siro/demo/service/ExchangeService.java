package com.siro.demo.service;

import com.siro.demo.model.Exchange;
public interface ExchangeService{


    int deleteByPrimaryKey(Integer id);

    int insert(Exchange record);

    int insertSelective(Exchange record);

    Exchange selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Exchange record);

    int updateByPrimaryKey(Exchange record);

}

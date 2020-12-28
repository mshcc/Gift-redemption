package com.siro.producer.service;


import com.siro.model.Exchange;
import com.siro.page.PageRequest;
import com.siro.page.PageResult;

public interface ExchangeService {


    int deleteByPrimaryKey(Integer id);

    int insert(Exchange record);

    int insertSelective(Exchange record);

    Exchange selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Exchange record);

    int updateByPrimaryKey(Exchange record);

    PageResult findPage(PageRequest pageRequest);

    PageResult findPageByDate(PageRequest pageRequest, Integer date);
}

package com.siro.demo.service;

import com.siro.demo.model.Exchange;
import com.siro.demo.utils.page.PageRequest;
import com.siro.demo.utils.page.PageResult;

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

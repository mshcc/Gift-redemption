package com.siro.demo.service.impl;

import com.siro.demo.utils.page.MybatisPageHelper;
import com.siro.demo.utils.page.PageRequest;
import com.siro.demo.utils.page.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.siro.demo.model.Exchange;
import com.siro.demo.mapper.ExchangeMapper;
import com.siro.demo.service.ExchangeService;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    @Resource
    private ExchangeMapper exchangeMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return exchangeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Exchange record) {
        return exchangeMapper.insert(record);
    }

    @Override
    public int insertSelective(Exchange record) {
        return exchangeMapper.insertSelective(record);
    }

    @Override
    public Exchange selectByPrimaryKey(Integer id) {
        return exchangeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Exchange record) {
        return exchangeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Exchange record) {
        return exchangeMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest, exchangeMapper);
    }

    @Override
    public PageResult findPageByDate(PageRequest pageRequest, Integer date) {
        return MybatisPageHelper.findPage(pageRequest,exchangeMapper,"findPageByDate",date);
    }

}

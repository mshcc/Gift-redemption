package com.siro.demo.service.impl;

import com.siro.demo.utils.page.MybatisPageHelper;
import com.siro.demo.utils.page.PageRequest;
import com.siro.demo.utils.page.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.siro.demo.mapper.LogisticsMapper;
import com.siro.demo.model.Logistics;
import com.siro.demo.service.LogisticsService;

@Service
public class LogisticsServiceImpl implements LogisticsService {

    @Resource
    private LogisticsMapper logisticsMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return logisticsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Logistics record) {
        return logisticsMapper.insert(record);
    }

    @Override
    public int insertSelective(Logistics record) {
        return logisticsMapper.insertSelective(record);
    }

    @Override
    public Logistics selectByPrimaryKey(Integer id) {
        return logisticsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Logistics record) {
        return logisticsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Logistics record) {
        return logisticsMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest, logisticsMapper);
    }

    @Override
    public PageResult findPageByNotShipped(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest, logisticsMapper, "findPageByNotShipped");
    }

    @Override
    public PageResult findPageShipped(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest, logisticsMapper, "findPageShipped");
    }

    @Override
    public PageResult findPageToBeCollected(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest, logisticsMapper, "findPageToBeCollected");
    }

    @Override
    public PageResult findPageHasBeenSigned(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest, logisticsMapper, "findPageHasBeenSigned");
    }

}

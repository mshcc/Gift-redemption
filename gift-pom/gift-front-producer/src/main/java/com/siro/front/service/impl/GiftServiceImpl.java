package com.siro.front.service.impl;


import com.siro.model.Gift;
import com.siro.page.MybatisPageHelper;
import com.siro.page.PageRequest;
import com.siro.page.PageResult;
import com.siro.front.mapper.GiftMapper;
import com.siro.front.service.GiftService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GiftServiceImpl implements GiftService {

    @Resource
    private GiftMapper giftMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return giftMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Gift record) {
        return giftMapper.insert(record);
    }

    @Override
    public int insertSelective(Gift record) {
        return giftMapper.insertSelective(record);
    }

    @Override
    public Gift selectByPrimaryKey(Integer id) {
        return giftMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Gift record) {
        return giftMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Gift record) {
        return giftMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest,giftMapper);
    }

    @Override
    public PageResult findPageByDate(PageRequest pageRequest, Integer date) {
        return MybatisPageHelper.findPage(pageRequest,giftMapper,"findPageByDate",date);
    }

    @Override
    public PageResult findPageByRemoved(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest,giftMapper,"findPageByRemoved");
    }

    @Override
    public PageResult findPageByOutOfStock(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest,giftMapper,"findPageByOutOfStock");
    }

    @Override
    public Gift findByName(String name) {
        return giftMapper.findByName(name);
    }

}

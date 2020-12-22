package com.siro.demo.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.siro.demo.mapper.GiftMapper;
import com.siro.demo.model.Gift;
import com.siro.demo.service.GiftService;
@Service
public class GiftServiceImpl implements GiftService{

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

}

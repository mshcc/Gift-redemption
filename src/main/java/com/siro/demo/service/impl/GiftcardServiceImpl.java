package com.siro.demo.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.siro.demo.model.Giftcard;
import com.siro.demo.mapper.GiftcardMapper;
import com.siro.demo.service.GiftcardService;
@Service
public class GiftcardServiceImpl implements GiftcardService{

    @Resource
    private GiftcardMapper giftcardMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return giftcardMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Giftcard record) {
        return giftcardMapper.insert(record);
    }

    @Override
    public int insertSelective(Giftcard record) {
        return giftcardMapper.insertSelective(record);
    }

    @Override
    public Giftcard selectByPrimaryKey(Integer id) {
        return giftcardMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Giftcard record) {
        return giftcardMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Giftcard record) {
        return giftcardMapper.updateByPrimaryKey(record);
    }

}
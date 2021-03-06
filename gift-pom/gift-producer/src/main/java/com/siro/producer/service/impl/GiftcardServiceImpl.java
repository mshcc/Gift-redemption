package com.siro.producer.service.impl;


import com.siro.model.Giftcard;
import com.siro.page.MybatisPageHelper;
import com.siro.page.PageRequest;
import com.siro.page.PageResult;
import com.siro.producer.mapper.GiftcardMapper;
import com.siro.producer.service.GiftcardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GiftcardServiceImpl implements GiftcardService {

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

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest, giftcardMapper);
    }

    @Override
    public PageResult findPageExpired(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest, giftcardMapper, "findPageExpired");
    }

    @Override
    public PageResult findPageWorks(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest, giftcardMapper, "findPageWorks");
    }

    @Override
    public Giftcard findByName(String name) {
        return giftcardMapper.findByName(name);
    }

    @Override
    public int insertList(List<Giftcard> cards) {
        return giftcardMapper.insertList(cards);
    }

}

package com.siro.demo.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.siro.demo.model.Recipient;
import com.siro.demo.mapper.RecipientMapper;
import com.siro.demo.service.RecipientService;
@Service
public class RecipientServiceImpl implements RecipientService{

    @Resource
    private RecipientMapper recipientMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return recipientMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Recipient record) {
        return recipientMapper.insert(record);
    }

    @Override
    public int insertSelective(Recipient record) {
        return recipientMapper.insertSelective(record);
    }

    @Override
    public Recipient selectByPrimaryKey(Integer id) {
        return recipientMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Recipient record) {
        return recipientMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Recipient record) {
        return recipientMapper.updateByPrimaryKey(record);
    }

}

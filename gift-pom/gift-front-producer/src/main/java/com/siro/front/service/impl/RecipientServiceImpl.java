package com.siro.front.service.impl;


import com.siro.model.Recipient;
import com.siro.page.MybatisPageHelper;
import com.siro.page.PageRequest;
import com.siro.page.PageResult;
import com.siro.front.mapper.RecipientMapper;
import com.siro.front.service.RecipientService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RecipientServiceImpl implements RecipientService {

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

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest, recipientMapper);
    }

    @Override
    public List<Recipient> findListByName(String name) {
        return recipientMapper.findListByName(name);
    }

}

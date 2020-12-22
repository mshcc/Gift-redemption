package com.siro.demo.service;

import com.siro.demo.model.Recipient;
public interface RecipientService{


    int deleteByPrimaryKey(Integer id);

    int insert(Recipient record);

    int insertSelective(Recipient record);

    Recipient selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Recipient record);

    int updateByPrimaryKey(Recipient record);

}

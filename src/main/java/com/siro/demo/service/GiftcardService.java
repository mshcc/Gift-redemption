package com.siro.demo.service;

import com.siro.demo.model.Giftcard;
public interface GiftcardService{


    int deleteByPrimaryKey(Integer id);

    int insert(Giftcard record);

    int insertSelective(Giftcard record);

    Giftcard selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Giftcard record);

    int updateByPrimaryKey(Giftcard record);

}

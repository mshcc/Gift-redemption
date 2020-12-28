package com.siro.front.service;


import com.siro.model.Giftcard;
import com.siro.page.PageRequest;
import com.siro.page.PageResult;

import java.util.List;

public interface GiftcardService {


    int deleteByPrimaryKey(Integer id);

    int insert(Giftcard record);

    int insertSelective(Giftcard record);

    Giftcard selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Giftcard record);

    int updateByPrimaryKey(Giftcard record);

    PageResult findPage(PageRequest pageRequest);

    PageResult findPageExpired(PageRequest pageRequest);

    PageResult findPageWorks(PageRequest pageRequest);

    Giftcard findByName(String name);

    int insertList(List<Giftcard> cards);

}

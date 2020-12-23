package com.siro.demo.service;

import com.siro.demo.model.Giftcard;
import com.siro.demo.utils.page.PageRequest;
import com.siro.demo.utils.page.PageResult;

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


}

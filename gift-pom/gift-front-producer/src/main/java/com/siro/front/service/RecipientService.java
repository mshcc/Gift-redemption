package com.siro.front.service;


import com.siro.model.Recipient;
import com.siro.page.PageRequest;
import com.siro.page.PageResult;

import java.util.List;

public interface RecipientService{


    int deleteByPrimaryKey(Integer id);

    int insert(Recipient record);

    int insertSelective(Recipient record);

    Recipient selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Recipient record);

    int updateByPrimaryKey(Recipient record);

    PageResult findPage(PageRequest pageRequest);

    List<Recipient> findListByName(String name);

}

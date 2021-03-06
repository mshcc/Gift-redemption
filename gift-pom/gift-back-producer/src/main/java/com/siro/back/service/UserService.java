package com.siro.back.service;


import com.siro.model.User;
import com.siro.page.PageRequest;
import com.siro.page.PageResult;

import java.util.Set;

public interface UserService{


    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    PageResult findPage(PageRequest pageRequest);

    PageResult findPageByCreationTime(PageRequest pageRequest);

    User findByName(String name);

    Set<String> findPermissions(String name);
}

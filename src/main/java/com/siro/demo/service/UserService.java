package com.siro.demo.service;

import com.siro.demo.model.User;
import com.siro.demo.utils.page.PageRequest;
import com.siro.demo.utils.page.PageResult;

import java.util.List;
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

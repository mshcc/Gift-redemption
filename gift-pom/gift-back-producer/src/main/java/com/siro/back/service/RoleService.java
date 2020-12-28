package com.siro.back.service;


import com.siro.model.Role;
import com.siro.page.PageRequest;
import com.siro.page.PageResult;

public interface RoleService{


    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    PageResult findPage(PageRequest pageRequest);
}

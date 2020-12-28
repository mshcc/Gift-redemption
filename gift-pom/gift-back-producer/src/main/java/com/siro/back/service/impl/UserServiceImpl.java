package com.siro.back.service.impl;


import com.siro.model.User;
import com.siro.page.MybatisPageHelper;
import com.siro.page.PageRequest;
import com.siro.page.PageResult;
import com.siro.back.mapper.RoleMapper;
import com.siro.back.mapper.UserMapper;
import com.siro.back.mapper.UserRoleMapper;
import com.siro.back.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserRoleMapper userRoleMapper;
    @Resource
    private RoleMapper roleMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest,userMapper);
    }

    @Override
    public PageResult findPageByCreationTime(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest,userMapper,"findPageByCreationTime");
    }

    @Override
    public User findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public Set<String> findPermissions(String name) {
        List<Integer> roles = userRoleMapper.findRolesByUserId(userMapper.findByName(name).getId());
        List<String> strings = roleMapper.selectByIds(roles);
        return new HashSet<>(strings);
    }


}

package com.siro.consumer.service;

import com.siro.consumer.security.RoleMapper;
import com.siro.consumer.security.UserMapper;
import com.siro.consumer.security.UserRoleMapper;
import com.siro.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author mshcc
 * @date 2020/12/28
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
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

package com.siro.demo.service.impl;

import com.siro.demo.mapper.RoleMapper;
import com.siro.demo.mapper.UserRoleMapper;
import com.siro.demo.utils.page.MybatisPageHelper;
import com.siro.demo.utils.page.PageRequest;
import com.siro.demo.utils.page.PageResult;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.siro.demo.model.User;
import com.siro.demo.mapper.UserMapper;
import com.siro.demo.service.UserService;

import java.util.*;

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

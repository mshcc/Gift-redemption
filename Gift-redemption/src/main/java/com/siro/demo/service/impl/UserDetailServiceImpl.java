package com.siro.demo.service.impl;

import com.siro.demo.mapper.UserMapper;
import com.siro.demo.model.User;
import com.siro.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/**
 * @author mshcc
 * @date 2020/12/23
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userMapper.findByName(s);
        if(user==null){
            return null;
        }
        Collection<GrantedAuthority> collection = new ArrayList<>();
        Set<String> permissions = userService.findPermissions(s);
        for (String permission : permissions) {
            collection.add(new SimpleGrantedAuthority(permission));
        }
        UserDetails details = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), collection);
        return details;
    }
}

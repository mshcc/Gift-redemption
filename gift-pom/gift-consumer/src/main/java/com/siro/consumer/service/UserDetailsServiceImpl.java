package com.siro.consumer.service;

import com.siro.consumer.security.GrantedAuthorityImpl;
import com.siro.consumer.security.JwtUserDetails;
import com.siro.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author mshcc
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserLoginService userLoginService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userLoginService.findByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("该用户不存在");
        }
        if (user.getStatus() == 0) {
            throw new BadCredentialsException("用户状态异常，请联系管理员");
        }
        // 此处添加 权限
        Set<String> permissions = userLoginService.findPermissions(username);
        List<GrantedAuthority> list = new ArrayList<>();
        for (String permission : permissions) {
            list.add(new GrantedAuthorityImpl(permission));
        }
        return new JwtUserDetails(user.getUsername(), user.getPassword(), list);
    }
}
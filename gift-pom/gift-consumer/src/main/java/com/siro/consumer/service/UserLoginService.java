package com.siro.consumer.service;


import com.siro.model.User;
import org.springframework.stereotype.Service;

import java.util.Set;


public interface UserLoginService {

    User findByName(String name);

    Set<String> findPermissions(String name);
}

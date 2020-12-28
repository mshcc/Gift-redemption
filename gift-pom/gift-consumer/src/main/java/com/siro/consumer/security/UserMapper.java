package com.siro.consumer.security;


import com.siro.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    User findByName(String name);
}
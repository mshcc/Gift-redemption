package com.siro.consumer.security;

import com.siro.model.UserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRoleMapper {

    List<Integer> findRolesByUserId(Integer id);
}
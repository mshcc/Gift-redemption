package com.siro.consumer.security;

import com.siro.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleMapper {
    List<String> selectByIds(@Param("roleIds") List<Integer> roleIds);
}
package com.siro.demo.dao;

import com.siro.demo.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;

/**
 * @author mshcc
 * @date 2020/12/22
 */
@Mapper
public interface IUserDao {
    @Select("select * from user")
    List<User> findAll();
    @Delete("delete from user where id = #{id}")
    Integer deleteById(Integer id);
    @Select("select * from user where id = #{id} ")
    User findUserById(Integer id);
    @Update("update user set username = #{username} ,password = #{password} ,role_id = #{role} where id = #{id} ")
    Integer updateUser(User user);
    @Insert("insert into user(username, password, role_id) values (#{username} ,#{password} ,#{role} )")
    Integer addUser(User user);
}

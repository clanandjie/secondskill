package com.fanzs.secondskill.dao;

import com.fanzs.secondskill.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by fzs on 2018/3/31.
 */
@Mapper
public interface UserDao {

    @Select("select *  from user where user_id=#{userId}")
    public User getById(@Param("userId") int userId);

    @Insert("insert into user(user_name) values(#{username}) ")
    void insert(User user);
}

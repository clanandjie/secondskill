package com.fanzs.secondskill.dao;


import com.fanzs.secondskill.entity.SecondsKillUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by fzs on 2018/4/7.
 */
@Mapper
public interface SecondsKillUserDao {

    @Select("select * from secondskill_user where #{id} = id")
    public SecondsKillUser getById(@Param("id") long id);

}

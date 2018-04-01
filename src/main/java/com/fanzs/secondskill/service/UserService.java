package com.fanzs.secondskill.service;

import com.fanzs.secondskill.dao.UserDao;
import com.fanzs.secondskill.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by fzs on 2018/3/31.
 */
@Service
public class UserService {
    //配置数据库
    @Autowired
    private UserDao userDao;

    //查询
    public User getById(int id){
        return userDao.getById(id);
    }

    /**
     * 配置事務
     * @return
     */
    @Transactional
    public boolean tx() {
        User u1=new User();
        u1.setUserId(3);
        u1.setUsername("社会");
        userDao.insert(u1);

        User u2=new User();
        u2.setUserId(4);
        u2.setUsername("事物");
        userDao.insert(u2);
        return true;
    }
}

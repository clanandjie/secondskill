package com.fanzs.secondskill.service;

import com.fanzs.secondskill.dao.SecondsKillUserDao;
import com.fanzs.secondskill.entity.SecondsKillUser;
import com.fanzs.secondskill.result.CodeMsg;
import com.fanzs.secondskill.util.MD5Util;
import com.fanzs.secondskill.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.annotation.XmlElementDecl;

@Service
public class SecondsKillUserService {
    @Autowired
    private SecondsKillUserDao secondsKillUserDao;

    public SecondsKillUser getById(long id){
        return secondsKillUserDao.getById(id);
    }

    public CodeMsg login(LoginVo loginVo){
        if(loginVo==null){
            return CodeMsg.MOBILE_EMPTY;
            //throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        String mobile=loginVo.getMobile();
        String formPassword=loginVo.getPassword();

        SecondsKillUser user=getById(Long.parseLong(mobile));
        if(user==null){
            return CodeMsg.MOBILE_NOT_EXIST;
        }
        //
        String dbPass=user.getPassword();
        String saltDB=user.getSalt();
        String calcPass= MD5Util.formToDB(formPassword,saltDB);
        if(!calcPass.equals(dbPass)){
            return CodeMsg.PASSWORD_ERROR;
        }
        return CodeMsg.SUCCESS;
    }
}

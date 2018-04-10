package com.fanzs.secondskill.service;

import com.fanzs.secondskill.dao.SecondsKillUserDao;
import com.fanzs.secondskill.entity.SecondsKillUser;
import com.fanzs.secondskill.exception.GlobalException;
import com.fanzs.secondskill.redis.RedisService;
import com.fanzs.secondskill.redis.SecondsKillUserKey;
import com.fanzs.secondskill.result.CodeMsg;
import com.fanzs.secondskill.util.MD5Util;
import com.fanzs.secondskill.util.UUIDUtil;
import com.fanzs.secondskill.vo.LoginVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Service
public class SecondsKillUserService {

    public static final String COOKIE_NAME_TOKEN="token";

    @Autowired
    private SecondsKillUserDao secondsKillUserDao;

    @Autowired
    private RedisService redisService;

    public SecondsKillUser getById(long id){
        return secondsKillUserDao.getById(id);
    }

    public boolean login(HttpServletResponse response,LoginVo loginVo){
        if(loginVo==null){
            throw  new GlobalException(CodeMsg.MOBILE_EMPTY);
        }
        String mobile=loginVo.getMobile();
        String formPassword=loginVo.getPassword();

        SecondsKillUser user=getById(Long.parseLong(mobile));
        if(user==null){
            throw  new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
        }
        //验证密码，两次MD5加密
        String dbPass=user.getPassword();
        String saltDB=user.getSalt();
        String calcPass= MD5Util.formToDB(formPassword,saltDB);
        if(!calcPass.equals(dbPass)){
            throw  new GlobalException(CodeMsg.PASSWORD_ERROR);
        }
        //
        String token = UUIDUtil.uuid();
        addCookie(response,token,user);
        return true;
    }

    private void addCookie(HttpServletResponse response,String token,SecondsKillUser user){
        redisService.set(SecondsKillUserKey.token,token,user);
        Cookie cookie=new Cookie(COOKIE_NAME_TOKEN,token);
        cookie.setMaxAge(SecondsKillUserKey.token.expireSeconds());
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    /**
     *
     * @param token
     * @return
     */
    public SecondsKillUser getByToken(HttpServletResponse response,String token) {
        if(StringUtils.isEmpty(token)){
            return null;
        }
        SecondsKillUser secondsKillUser=redisService.get(SecondsKillUserKey.token,token,SecondsKillUser.class);
        if(secondsKillUser!=null)
            addCookie(response,token,secondsKillUser);
        return secondsKillUser;
    }
}

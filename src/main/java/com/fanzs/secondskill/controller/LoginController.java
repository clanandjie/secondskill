package com.fanzs.secondskill.controller;

import com.fanzs.secondskill.redis.RedisService;
import com.fanzs.secondskill.result.Result;
import com.fanzs.secondskill.service.UserService;
import com.fanzs.secondskill.vo.LoginVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private RedisService redisService;

    private static Logger log= LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/to_login")
    @ResponseBody
    public String  toLogin(){
        return "login";
    }

    @RequestMapping("/do_login")
    @ResponseBody
    public Result<Boolean> doLogin(LoginVo loginVo){
        log.info(loginVo.toString());
        return Result.success(true);
    }
}

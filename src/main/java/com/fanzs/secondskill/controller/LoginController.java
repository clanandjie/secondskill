package com.fanzs.secondskill.controller;

import com.fanzs.secondskill.redis.RedisService;
import com.fanzs.secondskill.result.CodeMsg;
import com.fanzs.secondskill.result.Result;
import com.fanzs.secondskill.service.SecondsKillUserService;
import com.fanzs.secondskill.util.ValidationUtil;
import com.fanzs.secondskill.vo.LoginVo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private SecondsKillUserService secondskillUserService;

    @Autowired
    private RedisService redisService;

    private static Logger log= LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/to_login")
    public String  toLogin(){
        return "login";
    }

    @RequestMapping("/do_login")
    @ResponseBody
    public Result<Boolean> doLogin(HttpServletResponse response,@Valid LoginVo loginVo){
        log.info(loginVo.toString());
        boolean ret=secondskillUserService.login(response,loginVo);
        return Result.success(true);

    }
}

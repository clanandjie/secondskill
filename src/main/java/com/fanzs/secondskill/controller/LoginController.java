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

import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private SecondsKillUserService userService;

    @Autowired
    private RedisService redisService;

    private static Logger log= LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/to_login")
    public String  toLogin(){
        return "login";
    }

    @RequestMapping("/do_login")
    @ResponseBody
    public Result<Boolean> doLogin(@Valid LoginVo loginVo){
        log.info(loginVo.toString());
//        String passwordInput=loginVo.getPassword();
//        String mobile=loginVo.getMobile();
//
//        if(StringUtils.isEmpty(passwordInput)){
//            return Result.error(CodeMsg.PASSWORD_EMPTY);
//        }
//        if(StringUtils.isEmpty(mobile)){
//            return Result.error(CodeMsg.MOBILE_EMPTY);
//        }
//        if(!ValidationUtil.isMobile(mobile)){
//            return Result.error(CodeMsg.MOBILE_ERROR);
//        }
        CodeMsg codeMsg=userService.login(loginVo);
        if(codeMsg.getCode()==0){
            return Result.success(true);
        }else{
            return Result.error(codeMsg);
        }
    }
}

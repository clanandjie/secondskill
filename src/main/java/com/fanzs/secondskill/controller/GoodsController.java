package com.fanzs.secondskill.controller;

import com.fanzs.secondskill.entity.SecondsKillUser;
import com.fanzs.secondskill.redis.RedisService;
import com.fanzs.secondskill.service.SecondsKillUserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private SecondsKillUserService secondskillUserService;
    @Autowired
    private RedisService redisService;
    private static Logger log = LoggerFactory.getLogger(GoodsController.class);

    @RequestMapping("/to_list")
    public String toLogin(HttpServletResponse response,Model model,
                          @CookieValue(value = SecondsKillUserService.COOKIE_NAME_TOKEN,required = false) String cookieToken,
                          @RequestParam(value=SecondsKillUserService.COOKIE_NAME_TOKEN,required = false)String paramToken) {
        if(StringUtils.isEmpty(cookieToken)&&StringUtils.isEmpty(paramToken)){
            return "login";
        }
        String token=StringUtils.isEmpty(paramToken)?cookieToken:paramToken;
        SecondsKillUser secondsKillUser=secondskillUserService.getByToken(response,token);
        model.addAttribute("user", secondsKillUser);
        return "goods_list";
    }
}

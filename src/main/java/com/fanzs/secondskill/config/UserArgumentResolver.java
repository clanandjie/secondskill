package com.fanzs.secondskill.config;

import com.fanzs.secondskill.entity.SecondsKillUser;
import com.fanzs.secondskill.service.SecondsKillUserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by fzs on 2018/4/9.
 */

@Service
public class UserArgumentResolver implements HandlerMethodArgumentResolver{

    @Autowired
    SecondsKillUserService secondsKillUserService;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        Class<?> clazz=parameter.getParameterType();
        return clazz== SecondsKillUser.class;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);

        String paramToken=request.getParameter(SecondsKillUserService.COOKIE_NAME_TOKEN);
        String cookieToken=getCookieValue(request,SecondsKillUserService.COOKIE_NAME_TOKEN);
        if(StringUtils.isEmpty(cookieToken)&&StringUtils.isAllBlank(paramToken)){
            return null;
        }
        String token=StringUtils.isEmpty(paramToken)?cookieToken:paramToken;
        return secondsKillUserService.getByToken(response,token);
    }

    private String getCookieValue(HttpServletRequest request, String cookieNameToken) {
        for(Cookie cookie:request.getCookies()){
            if(cookie.getName().equals(cookieNameToken))return cookie.getValue();
        }
        return null;
    }


}

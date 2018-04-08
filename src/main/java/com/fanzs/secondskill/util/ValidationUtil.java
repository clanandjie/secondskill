package com.fanzs.secondskill.util;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.groovy.util.StringUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by fzs on 2018/4/7.
 */
public class ValidationUtil {
    private static final Pattern mobile_pattern= Pattern.compile("1\\d{10}");

    public static boolean isMobile(String src){
        if(StringUtils.isEmpty(src)){
            return false;
        }
        Matcher m=mobile_pattern.matcher(src);
        return m.matches();
    }

  /*  public static void main(String[] args) {
        System.out.println(isMobile("18290009676"));
        System.out.println(isMobile("13632188687"));
    }*/
}

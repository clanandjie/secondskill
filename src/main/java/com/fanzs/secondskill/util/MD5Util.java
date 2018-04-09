package com.fanzs.secondskill.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by fzs on 2018/4/7.
 */
public class MD5Util {
    private static final String salt="1a2b3c4d5e6f";

    public static String md5(String src){
        return DigestUtils.md5Hex(src);
    }

    public static String inputToForm(String inputPass){
        String str=""+salt.charAt(0)+salt.charAt(2)+inputPass+salt.charAt(11)+salt.charAt(10);
        return md5(str);
    }

    public static String formToDB(String formPass,String salt){
        String str=""+salt.charAt(0)+salt.charAt(2)+formPass+salt.charAt(11)+salt.charAt(10);
        return md5(str);
    }

    public static String inputToDB(String input,String saltDB){
        String formPass=inputToForm(input);
        String dbPass=formToDB(formPass,saltDB);
        return dbPass;
    }

//    public static void main(String[] args) {
//        System.out.println(inputToDB("951015","1a2b3c4d5e6f"));//274474fef6383c3377c5a7cd94129c88
//    }
}

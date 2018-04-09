package com.fanzs.secondskill.util;

import java.util.UUID;

/**
 * Created by fzs on 2018/4/9.
 */
public class UUIDUtil {
    public static String uuid(){
        return UUID.randomUUID().toString().replace("-","");
    }
}

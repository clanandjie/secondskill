package com.fanzs.secondskill.redis;

/**
 * Created by fzs on 2018/4/9.
 */
public class SecondsKillUserKey extends BaseKeyPrefix{
    private SecondsKillUserKey(int expireSeconds,String prefix){
        super(expireSeconds,prefix);
    }
    public static final int TOKEN_EXPIRE=3600*24*2;

    public static SecondsKillUserKey token=new SecondsKillUserKey(TOKEN_EXPIRE,"token");
}

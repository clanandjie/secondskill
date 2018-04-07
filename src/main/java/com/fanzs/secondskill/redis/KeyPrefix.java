package com.fanzs.secondskill.redis;

/**
 * Created by fzs on 2018/4/7.
 */
public interface KeyPrefix {
    public int expireSeconds();

    public String getPrefix();
}

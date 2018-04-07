package com.fanzs.secondskill.redis;

/**
 * Created by fzs on 2018/4/7.
 */
public abstract class BaseKeyPrefix implements KeyPrefix {
    private int expireSeconds;
    private String prefix;

    public BaseKeyPrefix(int expireSeconds, String prefix) {
        this.expireSeconds = expireSeconds;
        this.prefix = prefix;
    }

    public BaseKeyPrefix(String prefix) {
        this(0,prefix);
    }

    @Override   //默认0永不过期
    public int expireSeconds() {
        return expireSeconds;
    }

    @Override   //
    public String getPrefix() {
        String className=getClass().getSimpleName();
        return className+"-"+prefix;
    }
}

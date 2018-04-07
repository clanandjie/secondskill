package com.fanzs.secondskill.redis;

/**
 * Created by fzs on 2018/4/7.
 */
public class UserKey extends BaseKeyPrefix {
    private UserKey(String prefix) {
        super(prefix);
    }

    public static UserKey getById=new UserKey("id");
    public static UserKey getByName=new UserKey("name");
}

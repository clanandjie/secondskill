package com.fanzs.secondskill.entity;

/**
 * Created by fzs on 2018/3/31.
 */
public class User {
    private String username;
    private int userId;

    public User() {
    }

    public User(int userId, String username) {
        this.username = username;
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

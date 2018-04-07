package com.fanzs.secondskill.vo;

/**
 * Created by fzs on 2018/4/7.
 */
public class LoginVo {
    private String mobile;
    private String password;

    public LoginVo() {
    }

    public String getMobile() {
        return mobile;
    }

    @Override
    public String toString() {
        return "LoginVo{" +
                "mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

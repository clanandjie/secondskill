package com.fanzs.secondskill.result;

/**
 * Created by fzs on 2018/3/31.
 */
public class CodeMsg {
    private int code;
    private String msg;

    public CodeMsg(int code,String msg) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    //通用异常
    public static CodeMsg SUCCESS=new CodeMsg(0,"success");
    public static CodeMsg SERVER_ERROR=new CodeMsg(500100,"服务端异常");
    //登录模块
    //商品模块
    //订单模块
    //秒杀模块
}

package com.fanzs.secondskill.entity;

/**
 * Created by fzs on 2018/4/10.
 */
public class SecondskillOreder {
    private Integer secondskillOrderId;
    private Integer userId;
    private Integer goodsId;
    private Integer OrderId;

    public Integer getOrderId() {
        return OrderId;
    }

    public void setOrderId(Integer orderId) {
        OrderId = orderId;
    }

    public Integer getSecondskillOrderId() {
        return secondskillOrderId;
    }

    public void setSecondskillOrderId(Integer secondskillOrderId) {
        this.secondskillOrderId = secondskillOrderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
}

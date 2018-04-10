package com.fanzs.secondskill.entity;

import java.util.Date;

/**
 * Created by fzs on 2018/4/10.
 */
public class SecondskillGoods {
    private Integer goodsId;
    private Double secondskillPrice;
    private Integer secondskillStockCount;
    private Date startDate;
    private Date endDate;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Double getSecondskillPrice() {
        return secondskillPrice;
    }

    public void setSecondskillPrice(Double secondskillPrice) {
        this.secondskillPrice = secondskillPrice;
    }

    public Integer getSecondskillStockCount() {
        return secondskillStockCount;
    }

    public void setSecondskillStockCount(Integer secondskillStockCount) {
        this.secondskillStockCount = secondskillStockCount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}

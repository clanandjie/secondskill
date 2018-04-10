package com.fanzs.secondskill.vo;

import com.fanzs.secondskill.entity.Goods;

import java.util.Date;

/**
 * Created by fzs on 2018/4/10.
 */
public class GoodsVo extends Goods {
    private Integer secondskillStockCount;
    private Date startDate;
    private Date endDate;
    private Double secondskillPrice;

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

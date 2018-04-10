package com.fanzs.secondskill.entity;

/**
 * Created by fzs on 2018/4/10.
 */
public class Goods {
    private Integer goodsId;
    private String goodsName;
    private String goodsTitle;
    private String goodsType;
    private String goodsImage;
    private String goodsDetail;
    private Double goodsSalesPrice;
    private Double goodsBuyPrice;
    private Double goodsStock;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage;
    }

    public String getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(String goodsDetail) {
        this.goodsDetail = goodsDetail;
    }

    public Double getGoodsSalesPrice() {
        return goodsSalesPrice;
    }

    public void setGoodsSalesPrice(Double goodsSalesPrice) {
        this.goodsSalesPrice = goodsSalesPrice;
    }

    public Double getGoodsBuyPrice() {
        return goodsBuyPrice;
    }

    public void setGoodsBuyPrice(Double goodsBuyPrice) {
        this.goodsBuyPrice = goodsBuyPrice;
    }

    public Double getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(Double goodsStock) {
        this.goodsStock = goodsStock;
    }
}

package com.bysj.qiu.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class ShopCar {
    private int id;
    private String shopcarname;
    private BigDecimal shopcarprices;
    private int shopcarcount;
    private  BigDecimal needmoney;
    private  String shopcarimg;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss" )
    private Date putinshopcartime;
    private String putter;
    private int stockcount;
    private int sellcount;

    public int getStockcount() {
        return stockcount;
    }

    public void setStockcount(int stockcount) {
        this.stockcount = stockcount;
    }

    public int getSellcount() {
        return sellcount;
    }

    public void setSellcount(int sellcount) {
        this.sellcount = sellcount;
    }

    public String getPutter() {
        return putter;
    }

    public void setPutter(String putter) {
        this.putter = putter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShopcarname() {
        return shopcarname;
    }

    public void setShopcarname(String shopcarname) {
        this.shopcarname = shopcarname;
    }

    public BigDecimal getShopcarprices() {
        return shopcarprices;
    }

    public void setShopcarprices(BigDecimal shopcarprices) {
        this.shopcarprices = shopcarprices;
    }

    public int getShopcarcount() {
        return shopcarcount;
    }

    public void setShopcarcount(int shopcarcount) {
        this.shopcarcount = shopcarcount;
    }

    public BigDecimal getNeedmoney() {
        return needmoney;
    }

    public void setNeedmoney(BigDecimal needmoney) {
        this.needmoney = needmoney;
    }

    public String getShopcarimg() {
        return shopcarimg;
    }

    public void setShopcarimg(String shopcarimg) {
        this.shopcarimg = shopcarimg;
    }

    public Date getPutinshopcartime() {
        return putinshopcartime;
    }

    public void setPutinshopcartime(Date putinshopcartime) {
        this.putinshopcartime = putinshopcartime;
    }

    @Override
    public String toString() {
        return "ShopCar{" +
                "id=" + id +
                ", shopcarname='" + shopcarname + '\'' +
                ", shopcarprices=" + shopcarprices +
                ", shopcarcount=" + shopcarcount +
                ", needmoney=" + needmoney +
                ", shopcarimg='" + shopcarimg + '\'' +
                ", putinshopcartime=" + putinshopcartime +
                ", putter='" + putter + '\'' +
                ", stockcount=" + stockcount +
                ", sellcount=" + sellcount +
                '}';
    }
}

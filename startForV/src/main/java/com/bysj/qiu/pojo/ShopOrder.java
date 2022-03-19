package com.bysj.qiu.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class ShopOrder {

    private int id;
    private String buyer;
    private String buyshopitemname;
    private int iscomment;
    private int isdone;
    private BigDecimal consume;
    private String address;
    private String tellphone;
    private String transfername;
    private int buycount;
    private int onecount;
    private String shopimg;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss" )
    private Date buytime;

    public String getTellphone() {
        return tellphone;
    }

    public void setTellphone(String tellphone) {
        this.tellphone = tellphone;
    }

    public String getTransfername() {
        return transfername;
    }

    public void setTransfername(String transfername) {
        this.transfername = transfername;
    }

    public int getIsdone() {
        return isdone;
    }

    public void setIsdone(int isdone) {
        this.isdone = isdone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getBuyshopitemname() {
        return buyshopitemname;
    }

    public void setBuyshopitemname(String buyshopitemname) {
        this.buyshopitemname = buyshopitemname;
    }

    public int getIscomment() {
        return iscomment;
    }

    public void setIscomment(int iscomment) {
        this.iscomment = iscomment;
    }

    public BigDecimal getConsume() {
        return consume;
    }

    public void setConsume(BigDecimal consume) {
        this.consume = consume;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBuycount() {
        return buycount;
    }

    public void setBuycount(int buycount) {
        this.buycount = buycount;
    }

    public int getOnecount() {
        return onecount;
    }

    public void setOnecount(int onecount) {
        this.onecount = onecount;
    }

    public String getShopimg() {
        return shopimg;
    }

    public void setShopimg(String shopimg) {
        this.shopimg = shopimg;
    }

    public Date getBuytime() {
        return buytime;
    }

    public void setBuytime(Date buytime) {
        this.buytime = buytime;
    }

    @Override
    public String toString() {
        return "ShopOrder{" +
                "id=" + id +
                ", buyer='" + buyer + '\'' +
                ", buyshopitemname='" + buyshopitemname + '\'' +
                ", iscomment=" + iscomment +
                ", isdone=" + isdone +
                ", consume=" + consume +
                ", address='" + address + '\'' +
                ", tellphone=" + tellphone +
                ", transfername=" + transfername +
                ", buycount=" + buycount +
                ", onecount=" + onecount +
                ", shopimg='" + shopimg + '\'' +
                ", buytime=" + buytime +
                '}';
    }
}

package com.bysj.qiu.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

//订单评论
public class OrderComment {
    private int id;
    private String shopname;
    private int buycount;
    private BigDecimal consume;
    private String buyer;
    private String buyerheadimg;
    private String shopimg;
    private String commenttext;
    private BigDecimal commentpoint;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss" )
    private Date commenttime;
//    此属性用于评论某人用，用id与sonid之间做左连接
    private List<ReplyComment> replyinfo;


    public List<ReplyComment> getReplyinfo() {
        return replyinfo;
    }

    public void setReplyinfo(List<ReplyComment> replyinfo) {
        this.replyinfo = replyinfo;
    }

    public String getBuyerheadimg() {
        return buyerheadimg;
    }

    public void setBuyerheadimg(String buyerheadimg) {
        this.buyerheadimg = buyerheadimg;
    }

    public String getCommenttext() {
        return commenttext;
    }

    public void setCommenttext(String commenttext) {
        this.commenttext = commenttext;
    }

    public BigDecimal getCommentpoint() {
        return commentpoint;
    }

    public void setCommentpoint(BigDecimal commentpoint) {
        this.commentpoint = commentpoint;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public int getBuycount() {
        return buycount;
    }

    public void setBuycount(int buycount) {
        this.buycount = buycount;
    }

    public BigDecimal getConsume() {
        return consume;
    }

    public void setConsume(BigDecimal consume) {
        this.consume = consume;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getShopimg() {
        return shopimg;
    }

    public void setShopimg(String shopimg) {
        this.shopimg = shopimg;
    }

    public Date getCommenttime() {
        return commenttime;
    }

    public void setCommenttime(Date commenttime) {
        this.commenttime = commenttime;
    }

    @Override
    public String toString() {
        return "OrderComment{" +
                "id=" + id +
                ", shopname='" + shopname + '\'' +
                ", buycount=" + buycount +
                ", consume=" + consume +
                ", buyer='" + buyer + '\'' +
                ", buyerheadimg='" + buyerheadimg + '\'' +
                ", shopimg='" + shopimg + '\'' +
                ", commenttext='" + commenttext + '\'' +
                ", commentpoint=" + commentpoint +
                ", commenttime=" + commenttime +
                ", replyinfo=" + replyinfo +
                '}';
    }
}

package com.bysj.qiu.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class UserBill {

    private int id;
    private String user;
    private BigDecimal flowmoney;
    private String whatdoing;
    private int isbuyoradd;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss" )
    private Date donetime;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getFlowmoney() {
        return flowmoney;
    }

    public void setFlowmoney(BigDecimal flowmoney) {
        this.flowmoney = flowmoney;
    }

    public String getWhatdoing() {
        return whatdoing;
    }

    public void setWhatdoing(String whattdoing) {
        this.whatdoing = whattdoing;
    }

    public int getIsbuyoradd() {
        return isbuyoradd;
    }

    public void setIsbuyoradd(int isbuyoradd) {
        this.isbuyoradd = isbuyoradd;
    }

    public Date getDonetime() {
        return donetime;
    }

    public void setDonetime(Date donetime) {
        this.donetime = donetime;
    }

    @Override
    public String toString() {
        return "UserBill{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", flowmoney=" + flowmoney +
                ", whatdoing='" + whatdoing + '\'' +
                ", isbuyoradd=" + isbuyoradd +
                ", donetime=" + donetime +
                '}';
    }
}

package com.bysj.qiu.pojo;

import java.math.BigDecimal;

public class UserBuyInfo {
    private int id;
    private String user;
    private BigDecimal balance;
    private int buynum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBuyuser() {
        return user;
    }

    public void setBuyuser(String buyuser) {
        this.user = buyuser;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public int getBuynum() {
        return buynum;
    }

    public void setBuynum(int buynum) {
        this.buynum = buynum;
    }

    @Override
    public String toString() {
        return "UserBuyInfo{" +
                "id=" + id +
                ", buyuser='" + user + '\'' +
                ", balance=" + balance +
                ", buynum=" + buynum +
                '}';
    }
}

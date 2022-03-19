package com.bysj.qiu.pojo;

import java.math.BigDecimal;

//用于账户密码管理以及展示信息的pojo
public class Secret {
    private int id;
    private String user;
    private String password;
    private String power;
    private String fatheruser;
    private String headimg;
    private String paypassword;

    public String getPaypassword() {
        return paypassword;
    }

    public void setPaypassword(String paypassword) {
        this.paypassword = paypassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getFatheruser() {
        return fatheruser;
    }

    public void setFatheruser(String fatheruser) {
        this.fatheruser = fatheruser;
    }
    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }

    @Override
    public String toString() {
        return "Secret{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", power='" + power + '\'' +
                ", fatheruser='" + fatheruser + '\'' +
                ", headimg='" + headimg + '\'' +
                ", paypassword='" + paypassword + '\'' +
                '}';
    }
}

package com.bysj.qiu.pojo;

import java.math.BigDecimal;

//果蔬
public class ShopItem {

    private int id;
    private String name;
    private int sellcount;
    private BigDecimal price;
    private int stockcount;
    private BigDecimal evaluatepoint;
    private String simpleintroduction;
    private String forvpicture;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getForvpicture() {
        return forvpicture;
    }

    public void setForvpicture(String forvpicture) {
        this.forvpicture = forvpicture;
    }

    public int getSellcount() {
        return sellcount;
    }

    public void setSellcount(int sellcount) {
        this.sellcount = sellcount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStockcount() {
        return stockcount;
    }

    public void setStockcount(int stockcount) {
        this.stockcount = stockcount;
    }

    public BigDecimal getEvaluatepoint() {
        return evaluatepoint;
    }

    public void setEvaluatepoint(BigDecimal evaluatepoint) {
        this.evaluatepoint = evaluatepoint;
    }

    public String getSimpleintroduction() {
        return simpleintroduction;
    }

    public void setSimpleintroduction(String simpleintroduction) {
        this.simpleintroduction = simpleintroduction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return sellcount;
    }

    public void setCount(int count) {
        this.sellcount = count;
    }

    @Override
    public String toString() {
        return "ShopItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sellcount=" + sellcount +
                ", price=" + price +
                ", stockcount=" + stockcount +
                ", evaluatepoint=" + evaluatepoint +
                ", simpleintroduction='" + simpleintroduction + '\'' +
                ", forvpicture='" + forvpicture + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

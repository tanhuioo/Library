package com.bysj.qiu.pojo;

public class ShopItemType {
    private int id;
    private String shopitemtype;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShopitemtype() {
        return shopitemtype;
    }

    public void setShopitemtype(String shopitemtype) {
        this.shopitemtype = shopitemtype;
    }

    @Override
    public String toString() {
        return "ShopItemType{" +
                "id=" + id +
                ", shopitemtype='" + shopitemtype + '\'' +
                '}';
    }
}

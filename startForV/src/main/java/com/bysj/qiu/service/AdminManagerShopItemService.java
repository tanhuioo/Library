package com.bysj.qiu.service;

import com.bysj.qiu.pojo.ShopItem;
import com.bysj.qiu.pojo.ShopItemType;

import java.math.BigDecimal;
import java.util.List;

public interface AdminManagerShopItemService {

    //查询出所有的商品果蔬列表
    List<ShopItem> selAllShopItem();

    //查询出所有商品的类别作为下拉列表
    List<ShopItemType> selAllShopItemType();

    //查询是否已经有这个商品
    ShopItem selIsHaveShopInfo(String name);

    //修改商品图片
    int upShopItemImg(String forvpicture, String name, BigDecimal price, String simpleintroduction, String type, int stockcount, int id);

    // 增加商品信息
    int addShopItemInfo(String forvpicture, String name, BigDecimal price, String simpleintroduction, String type, int stockcount);

    //删除商品
    int delShopItem(int id);
}

package com.bysj.qiu.service;

import com.bysj.qiu.pojo.ShopItem;
import com.bysj.qiu.pojo.ShopItemType;

import java.util.List;

public interface ShowShopItemService {
    //显示所有的果蔬
    List<ShopItem> selallForV(String type, String name);

    //显示当前这个果蔬的总购买数量或者其他的单条信息
    ShopItem selOneOfForV(String name);

    //查询出所有商品的类别作为下拉列表
    List<ShopItemType> selAllShopItemType();
}

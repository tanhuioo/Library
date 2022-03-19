package com.bysj.qiu.dao;

import com.bysj.qiu.pojo.ShopItem;
import com.bysj.qiu.pojo.ShopItemType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShowShopItemDao {
    //显示所有的果蔬
    List<ShopItem> selallForV(@Param("type") String type, @Param("name") String name);

    //显示当前这个果蔬的总购买数量或者其他的单条信息
    ShopItem selOneOfForV(@Param("name") String name);

    //查询出所有商品的类别作为下拉列表
    List<ShopItemType> selAllShopItemType();
}

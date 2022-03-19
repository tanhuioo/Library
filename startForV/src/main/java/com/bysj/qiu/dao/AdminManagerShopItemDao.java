package com.bysj.qiu.dao;

import com.bysj.qiu.pojo.ShopItem;
import com.bysj.qiu.pojo.ShopItemType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface AdminManagerShopItemDao {
    //查询出所有的商品果蔬列表
    List<ShopItem> selAllShopItem();

    //查询出所有商品的类别作为下拉列表
    List<ShopItemType> selAllShopItemType();

    //查询是否已经有这个商品
    ShopItem selIsHaveShopInfo(@Param("name") String name);

    //修改商品图片
    int upShopItemImg(@Param("forvpicture") String forvpicture, @Param("name") String name, @Param("price") BigDecimal price, @Param("simpleintroduction") String simpleintroduction, @Param("type") String type, @Param("stockcount") int stockcount, @Param("id") int id);

    // 增加商品信息
    int addShopItemInfo(@Param("forvpicture") String forvpicture, @Param("name") String name, @Param("price") BigDecimal price, @Param("simpleintroduction") String simpleintroduction, @Param("type") String type, @Param("stockcount") int stockcount);

    //删除商品
    int delShopItem(@Param("id") int id);
}

package com.bysj.qiu.service;

import com.bysj.qiu.pojo.ShopCar;
import com.bysj.qiu.pojo.ShopItem;
import com.bysj.qiu.pojo.ShopOrder;
import com.bysj.qiu.pojo.UserBill;

import java.math.BigDecimal;
import java.util.List;

public interface DealShopCarService {

    //增加购物信息到购物车列表
    int addToShopCar(String shopcarname, BigDecimal shopcarprices, int shopcarcount, BigDecimal needmoney, String shopcarimg, String putter, int stockcount, int sellcount);

    //查询出所有的购物车列表
    List<ShopCar> selAllShopCar(String putter);

    //批量插入进订单
    int morAddToOrder(List<ShopOrder> list);

    //批量增加账单
    int morAddToBill(List<UserBill> list);

    //批量删除购物车信息
    int delMorShopCar(List<Integer> list);

    //更新余额与总购买次数
    int upBalance(BigDecimal balance, String buyuser, int buynum);

    // 批量更新商品销量与库存
    int upMoreForVCount(List<ShopItem> list);
}

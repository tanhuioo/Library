package com.bysj.qiu.dao;

import com.bysj.qiu.pojo.ShopCar;
import com.bysj.qiu.pojo.ShopItem;
import com.bysj.qiu.pojo.ShopOrder;
import com.bysj.qiu.pojo.UserBill;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface DealShopCarDao {
    //增加购物信息到购物车列表
    int addToShopCar(@Param("shopcarname") String shopcarname, @Param("shopcarprices") BigDecimal shopcarprices, @Param("shopcarcount") int shopcarcount, @Param("needmoney") BigDecimal needmoney, @Param("shopcarimg") String shopcarimg, @Param("putter") String putter, @Param("stockcount") int stockcount, @Param("sellcount") int sellcount);

    //查询出所有的购物车列表
    List<ShopCar> selAllShopCar(@Param("putter") String putter);

    //批量插入进订单
    int morAddToOrder(List<ShopOrder> list);

    //批量增加账单
    int morAddToBill(List<UserBill> list);

    //批量删除购物车信息
    int delMorShopCar(List<Integer> list);

    //更新余额与总购买次数
    int upBalance(@Param("balance") BigDecimal balance, @Param("buyuser") String buyuser, @Param("buynum") int buynum);

    // 批量更新商品销量与库存
    int upMoreForVCount(List<ShopItem> list);
}

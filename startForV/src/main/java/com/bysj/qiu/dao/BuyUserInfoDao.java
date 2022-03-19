package com.bysj.qiu.dao;

import com.bysj.qiu.pojo.ShopOrder;
import com.bysj.qiu.pojo.UserBill;
import com.bysj.qiu.pojo.UserBuyInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface BuyUserInfoDao {
    //获得当前普通用户的购买信息
    UserBuyInfo selThisUserBalance(@Param("buyuser") String buyuser);

    //更新余额与总购买次数
    int upBalance(@Param("balance") String balance, @Param("buyuser") String buyuser, @Param("buynum") int buynum);

    //插入订单信息
    int addOrderInfo(@Param("buyer") String buyer, @Param("buyshopitemname") String buyshopitemname, @Param("address") String address, @Param("tellphone") String tellphone, @Param("transfername") String transfername, @Param("consume") BigDecimal consume, @Param("onecount") int onecount, @Param("shopimg") String shopimg);

    // 水果列表购买次数+1
    int upAllForVCount(@Param("sellcount") int sellcount, @Param("stockcount") int stockcount, @Param("name") String name);

    //显示出榜一的果蔬
    ShopOrder selNumFirstForV(@Param("user") String user);

    // 插入账单信息
    int addBillInfo(@Param("user") String user, @Param("flowmoney") BigDecimal flowmoney, @Param("whatdoing") String whatdoing, @Param("isbuyoradd") int isbuyoradd);

    //显示所有该用户的账单
    List<UserBill> selallbillinfo(@Param("user") String user, @Param("showmore") int showmore);

    //查出有多少条
    Integer selBillAllCount(@Param("user") String user);

    //查询出所有未确认收货的订单
    List<ShopOrder> selNodoneOrder(@Param("buyer") String buyer);

    //查询出所有订单
    List<ShopOrder> selAllOrder(@Param("buyer") String buyer);

    //更新订单状况为已收货
    int upOrderDone(@Param("buyer") String buyer, @Param("id") int id);
}

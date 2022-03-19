package com.bysj.qiu.service;

import com.bysj.qiu.pojo.ShopOrder;
import com.bysj.qiu.pojo.UserBill;
import com.bysj.qiu.pojo.UserBuyInfo;

import java.math.BigDecimal;
import java.util.List;

public interface BuyUserInfoService {

    //获得当前普通用户的购买信息
    UserBuyInfo selThisUserBalance(String buyuser);

    //更新余额
    int upBalance(String balance, String buyuser, int buynum);

    //插入订单信息
    int addOrderInfo(String buyer, String buyshopitemname, String address, String tellphone, String transfername, BigDecimal consume, int onecount, String shopimg);

    // 水果列表购买次数+1
    int upAllForVCount(int sellcount, int stockcount, String name);

    //显示出榜一的果蔬
    ShopOrder selNumFirstForV(String user);

    // 插入账单信息
    int addBillInfo(String user, BigDecimal flowmoney, String whatdoing, int isbuyoradd);

    //显示所有该用户的账单
    List<UserBill> selallbillinfo(String user, int showmore);

    //查出有多少条
    Integer selBillAllCount(String user);

    //查询出所有未确认收货的订单
    List<ShopOrder> selNodoneOrder(String buyer);

    //查询出所有订单
    List<ShopOrder> selAllOrder(String buyer);

    //更新订单状况为已收货
    int upOrderDone(String buyer, int id);
}

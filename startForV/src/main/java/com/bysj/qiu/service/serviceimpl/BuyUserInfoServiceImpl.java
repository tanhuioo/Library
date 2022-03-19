package com.bysj.qiu.service.serviceimpl;

import com.bysj.qiu.dao.BuyUserInfoDao;
import com.bysj.qiu.pojo.ShopOrder;
import com.bysj.qiu.pojo.UserBill;
import com.bysj.qiu.pojo.UserBuyInfo;
import com.bysj.qiu.service.BuyUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BuyUserInfoServiceImpl implements BuyUserInfoService {

    @Autowired
    BuyUserInfoDao buyUserInfoDao;

    @Override
    public UserBuyInfo selThisUserBalance(String buyuser) {
        return buyUserInfoDao.selThisUserBalance(buyuser);
    }

    @Override
    public int upBalance(String balance, String buyuser, int buynum) {
        return buyUserInfoDao.upBalance(balance, buyuser, buynum);
    }

    @Override
    public int addOrderInfo(String buyer, String buyshopitemname, String address, String tellphone, String transfername, BigDecimal consume, int onecount, String shopimg) {
        return buyUserInfoDao.addOrderInfo(buyer, buyshopitemname, address, tellphone, transfername, consume, onecount, shopimg);
    }

    @Override
    public int upAllForVCount(int sellcount, int stockcount, String name) {
        return buyUserInfoDao.upAllForVCount(sellcount, stockcount, name);
    }

    @Override
    public ShopOrder selNumFirstForV(String user) {
        return buyUserInfoDao.selNumFirstForV(user);
    }

    @Override
    public int addBillInfo(String user, BigDecimal flowmoney, String whatdoing, int isbuyoradd) {
        return buyUserInfoDao.addBillInfo(user, flowmoney, whatdoing, isbuyoradd);
    }

    @Override
    public List<UserBill> selallbillinfo(String user, int showmore) {
        return buyUserInfoDao.selallbillinfo(user, showmore);
    }

    @Override
    public Integer selBillAllCount(String user) {
        return buyUserInfoDao.selBillAllCount(user);
    }

    @Override
    public List<ShopOrder> selNodoneOrder(String buyer) {
        return buyUserInfoDao.selNodoneOrder(buyer);
    }

    @Override
    public List<ShopOrder> selAllOrder(String buyer) {
        return buyUserInfoDao.selAllOrder(buyer);
    }

    @Override
    public int upOrderDone(String buyer, int id) {
        return buyUserInfoDao.upOrderDone(buyer, id);
    }
}

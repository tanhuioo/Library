package com.bysj.qiu.service.serviceimpl;

import com.bysj.qiu.dao.DealShopCarDao;
import com.bysj.qiu.pojo.ShopCar;
import com.bysj.qiu.pojo.ShopItem;
import com.bysj.qiu.pojo.ShopOrder;
import com.bysj.qiu.pojo.UserBill;
import com.bysj.qiu.service.DealShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DealShopCarServiceImpl implements DealShopCarService {
    @Autowired
    DealShopCarDao dealShopCarDao;

    @Override
    public int addToShopCar(String shopcarname, BigDecimal shopcarprices, int shopcarcount, BigDecimal needmoney, String shopcarimg, String putter, int stockcount, int sellcount) {
        return dealShopCarDao.addToShopCar(shopcarname, shopcarprices, shopcarcount, needmoney, shopcarimg, putter, stockcount, sellcount);
    }

    @Override
    public List<ShopCar> selAllShopCar(String putter) {
        return dealShopCarDao.selAllShopCar(putter);
    }

    @Override
    public int morAddToOrder(List<ShopOrder> list) {
        return dealShopCarDao.morAddToOrder(list);
    }

    @Override
    public int morAddToBill(List<UserBill> list) {
        return dealShopCarDao.morAddToBill(list);
    }

    @Override
    public int delMorShopCar(List<Integer> list) {
        return dealShopCarDao.delMorShopCar(list);
    }

    @Override
    public int upBalance(BigDecimal balance, String buyuser, int buynum) {
        return dealShopCarDao.upBalance(balance, buyuser, buynum);
    }

    @Override
    public int upMoreForVCount(List<ShopItem> list) {
        return dealShopCarDao.upMoreForVCount(list);
    }
}

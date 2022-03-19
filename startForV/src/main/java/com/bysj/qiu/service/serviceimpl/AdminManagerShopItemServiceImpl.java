package com.bysj.qiu.service.serviceimpl;

import com.bysj.qiu.dao.AdminManagerShopItemDao;
import com.bysj.qiu.pojo.ShopItem;
import com.bysj.qiu.pojo.ShopItemType;
import com.bysj.qiu.service.AdminManagerShopItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AdminManagerShopItemServiceImpl implements AdminManagerShopItemService {
    @Autowired
    AdminManagerShopItemDao adminManagerShopItemDao;

    @Override
    public List<ShopItem> selAllShopItem() {
        return adminManagerShopItemDao.selAllShopItem();
    }

    @Override
    public List<ShopItemType> selAllShopItemType() {
        return adminManagerShopItemDao.selAllShopItemType();
    }

    @Override
    public ShopItem selIsHaveShopInfo(String name) {
        return adminManagerShopItemDao.selIsHaveShopInfo(name);
    }

    @Override
    public int upShopItemImg(String forvpicture, String name, BigDecimal price, String simpleintroduction, String type, int stockcount, int id) {
        return adminManagerShopItemDao.upShopItemImg(forvpicture, name, price, simpleintroduction, type, stockcount, id);
    }

    @Override
    public int addShopItemInfo(String forvpicture, String name, BigDecimal price, String simpleintroduction, String type, int stockcount) {
        System.out.println("诡异的一幕来了" + name);
        return adminManagerShopItemDao.addShopItemInfo(forvpicture, name, price, simpleintroduction, type, stockcount);
    }

    @Override
    public int delShopItem(int id) {
        return adminManagerShopItemDao.delShopItem(id);
    }


}

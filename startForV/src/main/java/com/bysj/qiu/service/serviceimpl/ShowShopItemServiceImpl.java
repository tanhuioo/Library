package com.bysj.qiu.service.serviceimpl;

import com.bysj.qiu.dao.ShowShopItemDao;
import com.bysj.qiu.pojo.ShopItem;
import com.bysj.qiu.pojo.ShopItemType;
import com.bysj.qiu.service.ShowShopItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowShopItemServiceImpl implements ShowShopItemService {
    @Autowired
    ShowShopItemDao showShopItemDao;

    //显示所有的果蔬
    @Override
    public List<ShopItem> selallForV(String type, String name) {
        return showShopItemDao.selallForV(type, name);
    }

    //显示当前这个果蔬的总购买数量或者其他的单条信息
    @Override
    public ShopItem selOneOfForV(String name) {
        return showShopItemDao.selOneOfForV(name);
    }

    @Override
    public List<ShopItemType> selAllShopItemType() {
        return showShopItemDao.selAllShopItemType();
    }
}

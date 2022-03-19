package com.bysj.qiu;

import com.bysj.qiu.dao.*;
import com.bysj.qiu.pojo.ShopItem;
import com.bysj.qiu.pojo.ShopOrder;
import com.bysj.qiu.pojo.Statistics;
import com.bysj.qiu.pojo.UserBuyInfo;
import com.bysj.qiu.service.AdminManagerPowerService;
import com.bysj.qiu.service.GetSecretService;
import com.bysj.qiu.service.ShowShopItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QiuApplicationTests {
    @Autowired
    GetSecretService getSecretService;
    @Autowired
    GetSecretDao getSecretDao;
    @Autowired
    AdminManagerPowerService adminManagerPowerService;
    @Autowired
    AdminManagerPowerDao adminManagerPowerDao;
    @Autowired
    DealChatMessageDao dealChatMessageDao;
    @Autowired
    OtherManagerSelfDao otherManagerSelfDao;
    @Autowired
    ShowShopItemDao showShopItemDao;
    @Autowired
    ShowShopItemService showShopItemService;
    @Autowired
    BuyUserInfoDao buyUserInfoDaol;
    @Autowired
    DealOrderCommentDao dealOrderCommentDao;
    @Autowired
    ShowEachartsDao showEachartsDao;
    @Test
    public void contextLoads() {
        List<Statistics> bigDecimals = showEachartsDao.selFiveMonthConsume();
        System.out.println(bigDecimals);


    }

    @Test
    public  void  four(){


    }

}

package com.bysj.qiu.service.serviceimpl;


import com.bysj.qiu.dao.ShowEachartsDao;
import com.bysj.qiu.pojo.ShopItem;
import com.bysj.qiu.pojo.Statistics;
import com.bysj.qiu.service.ShowEachartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ShowEachartsServiceImpl implements ShowEachartsService {


    @Autowired
    ShowEachartsDao showEachartsDao;

    @Override
    public List<ShopItem> selTesteaCharts() {
        return showEachartsDao.selTopFirstForVCharts();
    }

    @Override
    public BigDecimal selLastMonthConsume() {
        return showEachartsDao.selLastMonthConsume();
    }

    @Override
    public BigDecimal getFiveMonthConsume() {
        return showEachartsDao.getFiveMonthConsume();
    }

    @Override
    public List<Statistics> selFiveMonthConsume() {
        return showEachartsDao.selFiveMonthConsume();
    }


}

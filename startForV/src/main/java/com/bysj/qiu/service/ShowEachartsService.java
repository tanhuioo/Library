package com.bysj.qiu.service;

import com.bysj.qiu.pojo.ShopItem;
import com.bysj.qiu.pojo.Statistics;

import java.math.BigDecimal;
import java.util.List;

public interface ShowEachartsService {
    //显示销量前六的果蔬
    List<ShopItem> selTesteaCharts();

    //上一个月的总消费
    BigDecimal selLastMonthConsume();

    //得到五个月的总消费
    BigDecimal getFiveMonthConsume();

    //得到这五个月分别的消费趋势
    List<Statistics> selFiveMonthConsume();
}

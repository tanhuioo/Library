package com.bysj.qiu.dao;

import com.bysj.qiu.pojo.ShopItem;
import com.bysj.qiu.pojo.Statistics;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;


@Mapper
public interface ShowEachartsDao {
    //显示销量前六的果蔬
    List<ShopItem> selTopFirstForVCharts();

    //上一个月的总消费
    BigDecimal selLastMonthConsume();

    //得到五个月的总消费
    BigDecimal getFiveMonthConsume();

    //得到这五个月分别的消费趋势
    List<Statistics> selFiveMonthConsume();
}

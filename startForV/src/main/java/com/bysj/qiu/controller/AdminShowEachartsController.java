package com.bysj.qiu.controller;

import com.bysj.qiu.pojo.ShopItem;
import com.bysj.qiu.pojo.Statistics;
import com.bysj.qiu.service.ShowEachartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/adminshoweacharts")
public class AdminShowEachartsController {

    @Autowired
    ShowEachartsService showEachartsService;

    //用于统计销售前六的数据
    @ResponseBody
    @RequestMapping("/seltopfirstforfcharts")
    public List<ShopItem> selTopFirstForVCharts() {
        List<ShopItem> clothes = showEachartsService.selTesteaCharts();
        return clothes;
    }

    //得到上一个月的销售总额
    @ResponseBody
    @RequestMapping("/sellastmonthconsume")
    public BigDecimal selLastMonthConsume() {
        return showEachartsService.selLastMonthConsume();
    }

    //得到五个月的销售总额
    @ResponseBody
    @RequestMapping("/getfivemonthallconsume")
    public BigDecimal getFiveMonthConsume() {
        return showEachartsService.getFiveMonthConsume();
    }

    //得到最近五个月的销售数据
    @ResponseBody
    @RequestMapping("/selfivemonthconsume")
    public List<Statistics> fiveMonthConsume() {
        return showEachartsService.selFiveMonthConsume();
    }

}

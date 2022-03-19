package com.bysj.qiu.controller;

import com.bysj.qiu.pojo.ExpressInfo;
import com.bysj.qiu.service.DealExpressInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/otherexpress")
public class OtherExpressController {
    @Autowired
    DealExpressInfoService dealExpressInfoService;

    //查询出所有快递信息
    @RequestMapping("/selallexpressinfo")
    @ResponseBody
    public List<ExpressInfo> selAllExpressInfo(String buyer) {
        List<ExpressInfo> expressInfos = dealExpressInfoService.selExpressInfo(buyer);
        return expressInfos;
    }

    //插入快递信息
    @RequestMapping("/insertexpressinfo")
    @ResponseBody
    public int insertExpressInfo(String transfername, String tellphone, String address, String buyer) {
        return dealExpressInfoService.insertExpressInfo(transfername, tellphone, address, buyer);
    }

    //更新快递信息
    @RequestMapping("/upexpressinfo")
    @ResponseBody
    public int upExpressInfo(String transfername, String tellphone, String address, int id) {
        return dealExpressInfoService.upExpressInfo(transfername, tellphone, address, id);
    }

    //删除快递信息
    @RequestMapping("/delexpressinfo")
    @ResponseBody
    public int delExpressInfo(int id) {
        return dealExpressInfoService.delExpressInfo(id);
    }
}

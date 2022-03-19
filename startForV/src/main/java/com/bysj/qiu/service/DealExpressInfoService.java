package com.bysj.qiu.service;

import com.bysj.qiu.pojo.ExpressInfo;

import java.util.List;

public interface DealExpressInfoService {

    //查询出所有快递信息
    List<ExpressInfo> selExpressInfo(String buyer);

    //增加快递信息
    int insertExpressInfo(String transfername, String tellphone, String address, String buyer);

    //更新快递信息
    int upExpressInfo(String transfername, String tellphone, String address, int id);

    //删除快递信息
    int delExpressInfo(int id);
}

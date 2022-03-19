package com.bysj.qiu.service.serviceimpl;

import com.bysj.qiu.dao.DealExpressInfoDao;
import com.bysj.qiu.pojo.ExpressInfo;
import com.bysj.qiu.service.DealExpressInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealExpressInfoServiceImpl implements DealExpressInfoService {
    @Autowired
    DealExpressInfoDao dealExpressInfoDao;

    @Override
    public List<ExpressInfo> selExpressInfo(String buyer) {
        return dealExpressInfoDao.selExpressInfo(buyer);
    }

    @Override
    public int insertExpressInfo(String transfername, String tellphone, String address, String buyer) {
        return dealExpressInfoDao.insertExpressInfo(transfername, tellphone, address, buyer);
    }

    @Override
    public int upExpressInfo(String transfername, String tellphone, String address, int id) {
        return dealExpressInfoDao.upExpressInfo(transfername, tellphone, address, id);
    }

    @Override
    public int delExpressInfo(int id) {
        return dealExpressInfoDao.delExpressInfo(id);
    }
}

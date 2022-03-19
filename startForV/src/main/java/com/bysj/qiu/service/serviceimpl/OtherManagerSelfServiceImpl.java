package com.bysj.qiu.service.serviceimpl;

import com.bysj.qiu.dao.OtherManagerSelfDao;
import com.bysj.qiu.pojo.Secret;
import com.bysj.qiu.service.OtherManagerSelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OtherManagerSelfServiceImpl implements OtherManagerSelfService {
    @Autowired
    OtherManagerSelfDao otherManagerSelfDao;

    @Override
    public int upOtherHeadImg(String headimg, String user) {
        return otherManagerSelfDao.upOtherHeadImg(headimg, user);
    }

    @Override
    public Secret selOtherHeadImg(String user) {
        return otherManagerSelfDao.selOtherHeadImg(user);
    }

    @Override
    public int addBalance(BigDecimal balance, String user) {
        return otherManagerSelfDao.addBalance(balance, user);
    }
}

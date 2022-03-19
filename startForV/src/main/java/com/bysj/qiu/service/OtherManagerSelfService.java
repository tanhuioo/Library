package com.bysj.qiu.service;

import com.bysj.qiu.pojo.Secret;

import java.math.BigDecimal;

public interface OtherManagerSelfService {
    //更新普通用户的头像
    int upOtherHeadImg(String headimg, String user);

    //查询到普通用户的头像
    Secret selOtherHeadImg(String user);

    //充值
    int addBalance(BigDecimal balance, String user);
}

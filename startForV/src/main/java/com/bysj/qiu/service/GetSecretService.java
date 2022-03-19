package com.bysj.qiu.service;

import com.bysj.qiu.pojo.Secret;

public interface GetSecretService {
    //获得admin的权利
    Secret selAdminPower(String user);

    //    获得普通用户的权利
    Secret selOtherUserPower(String user);

    //    判断用户是否存在
    Secret booleanUserPower(String user, String password);

    //    判断用户是否存在
    Secret booleanAdminPower(String user, String password);

    //    添加用户
    int regist(String user, String password);

    // 注册支付密码
    int uppaypassword(String paypassword, String user);

    //更新用户密码
    int upUserPasswordAndUser(String password, String newuser, String olduser);
}

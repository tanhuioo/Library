package com.bysj.qiu.dao;

import com.bysj.qiu.pojo.Secret;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface GetSecretDao {
    //获得admin的用户名字
    Secret selAdminPower(@Param("user") String user);

    //    获得普通用户的名字
    Secret selOtherUserPower(@Param("user") String user);

    //    判断用户是否存在
    Secret booleanUserPower(@Param("user") String user, @Param("password") String password);

    //    判断用户是否存在
    Secret booleanAdminPower(@Param("user") String user, @Param("password") String password);

    //    添加用户
    int regist(@Param("user") String user, @Param("password") String password);

    // 注册支付密码
    int uppaypassword(@Param("paypassword") String paypassword, @Param("user") String user);

    //更新用户密码
    int upUserPasswordAndUser(@Param("password") String password, @Param("newuser") String newuser, @Param("olduser") String olduser);
}

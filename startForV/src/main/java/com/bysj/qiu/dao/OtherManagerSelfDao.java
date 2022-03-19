package com.bysj.qiu.dao;

import com.bysj.qiu.pojo.Secret;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface OtherManagerSelfDao {
    //更新普通用户的头像
    int upOtherHeadImg(@Param("headimg") String headimg, @Param("user") String user);

    //查询到普通用户的头像
    Secret selOtherHeadImg(@Param("user") String user);

    //充值
    int addBalance(@Param("balance") BigDecimal balance, @Param("user") String user);

}

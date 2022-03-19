package com.bysj.qiu.dao;

import com.bysj.qiu.pojo.ExpressInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DealExpressInfoDao {

    //查询出所有快递信息
    List<ExpressInfo> selExpressInfo(@Param("buyer") String buyer);

    //增加快递信息
    int insertExpressInfo(@Param("transfername") String transfername, @Param("tellphone") String tellphone, @Param("address") String address, @Param("buyer") String buyer);

    //更新快递信息
    int upExpressInfo(@Param("transfername") String transfername, @Param("tellphone") String tellphone, @Param("address") String address, @Param("id") int id);

    //删除快递信息
    int delExpressInfo(@Param("id") int id);
}

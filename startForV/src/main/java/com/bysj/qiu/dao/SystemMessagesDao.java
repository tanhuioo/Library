package com.bysj.qiu.dao;

import com.bysj.qiu.pojo.SystemMessage;
import com.bysj.qiu.pojo.SystemMessageType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SystemMessagesDao {

    //查询出发送类别
    List<SystemMessageType> selSystemMessagesType();

    //发送系统信息
    int sendSystemMessages(@Param("content") String content, @Param("sender") String sender, @Param("type") String type);

    //查询系统全部信息
    List<SystemMessage> selSystemMessages();

    //查询系统部分信息
    List<SystemMessage> selPartSystemMessages();

    //删除系统信息
    int delSystemMessages(@Param("id") int id);

}

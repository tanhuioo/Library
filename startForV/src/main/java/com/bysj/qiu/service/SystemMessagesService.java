package com.bysj.qiu.service;

import com.bysj.qiu.pojo.SystemMessage;
import com.bysj.qiu.pojo.SystemMessageType;

import java.util.List;

public interface SystemMessagesService {
    //查询出发送类别
    List<SystemMessageType> selSystemMessagesType();

    //发送系统信息
    int sendSystemMessages(String content, String sender, String type);

    //查询全部系统信息
    List<SystemMessage> selSystemMessages();

    //查询系统部分信息
    List<SystemMessage> selPartSystemMessages();

    //删除系统信息
    int delSystemMessages(int id);

}

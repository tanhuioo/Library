package com.bysj.qiu.service;

import com.bysj.qiu.pojo.ChatMessage;
import com.bysj.qiu.pojo.Secret;

import java.util.List;

public interface DealChatMessageService {
    // 往数据库里插入发送的信息
    int sendMessage(String sender, String receiver, String topic, String message, String senderheadimg);

    //    展现出未读信息
    List<ChatMessage> showUnReadMsg(String receiver, int isread);

    //     将一条信息的未读状态改为已读状态
    int changeUnreadToRead(int id);

    //获取所有接收来的信息，没有未读已读之分
    List<ChatMessage> showAllMsg(String receiver);

    // 查询出这条消息中发送者的头像
    Secret selSenderHeadimg(String sender);

    //当用户头像更新的时候，聊天信息队列里的头像信息也要更新
    int changeMsgSenderHeadimg(String senderheadimg, String sender);

}

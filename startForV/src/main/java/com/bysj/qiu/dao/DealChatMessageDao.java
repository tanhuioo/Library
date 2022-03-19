package com.bysj.qiu.dao;

import com.bysj.qiu.pojo.ChatMessage;
import com.bysj.qiu.pojo.Secret;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DealChatMessageDao {
    //往数据库里插入发送的信息
    int sendMessage(@Param("sender") String sender, @Param("receiver") String receiver, @Param("topic") String topic, @Param("message") String message, @Param("senderheadimg") String senderheadimg);

    // 展现出未读信息
    List<ChatMessage> showUnReadMsg(@Param("receiver") String receiver, @Param("isread") int isread);

    //将一条信息的未读状态改为已读状态
    int changeUnreadToRead(@Param("id") int id);

    //获取所有接收来的信息，没有未读已读之分
    List<ChatMessage> showAllMsg(@Param("receiver") String receiver);

    // 查询出这条消息中发送者的头像
    Secret selSenderHeadimg(@Param("sender") String sender);

    //当用户头像更新的时候，聊天信息队列里的头像信息也要更新
    int changeMsgSenderHeadimg(@Param("senderheadimg") String senderheadimg, @Param("sender") String sender);
}

package com.bysj.qiu.service.serviceimpl;

import com.bysj.qiu.dao.DealChatMessageDao;
import com.bysj.qiu.pojo.ChatMessage;
import com.bysj.qiu.pojo.Secret;
import com.bysj.qiu.service.DealChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(isolation = Isolation.SERIALIZABLE)
@Service
public class DealChatMessageServiceImpl implements DealChatMessageService {
    @Autowired
    DealChatMessageDao dealChatMessageDao;

    // 往数据库里插入发送的信息
    @Override
    public int sendMessage(String sender, String receiver, String topic, String message, String senderheadimg) {
        return dealChatMessageDao.sendMessage(sender, receiver, topic, message, senderheadimg);
    }

    @Override
    public List<ChatMessage> showUnReadMsg(String receiver, int isread) {
        return dealChatMessageDao.showUnReadMsg(receiver, isread);
    }

    @Override
    public int changeUnreadToRead(int id) {
        return dealChatMessageDao.changeUnreadToRead(id);
    }

    @Override
    public List<ChatMessage> showAllMsg(String receiver) {
        return dealChatMessageDao.showAllMsg(receiver);
    }

    @Override
    public Secret selSenderHeadimg(String sender) {
        return dealChatMessageDao.selSenderHeadimg(sender);
    }

    @Override
    public int changeMsgSenderHeadimg(String senderheadimg, String sender) {
        return dealChatMessageDao.changeMsgSenderHeadimg(senderheadimg, sender);
    }
}

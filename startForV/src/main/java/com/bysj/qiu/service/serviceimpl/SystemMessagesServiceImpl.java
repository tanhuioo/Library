package com.bysj.qiu.service.serviceimpl;

import com.bysj.qiu.dao.SystemMessagesDao;
import com.bysj.qiu.pojo.SystemMessage;
import com.bysj.qiu.pojo.SystemMessageType;
import com.bysj.qiu.service.SystemMessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemMessagesServiceImpl implements SystemMessagesService {

    @Autowired
    SystemMessagesDao systemMessagesDao;

    @Override
    public List<SystemMessageType> selSystemMessagesType() {
        return systemMessagesDao.selSystemMessagesType();
    }

    @Override
    public int sendSystemMessages(String content, String sender, String type) {
        return systemMessagesDao.sendSystemMessages(content, sender, type);
    }

    @Override
    public List<SystemMessage> selSystemMessages() {
        return systemMessagesDao.selSystemMessages();
    }

    @Override
    public List<SystemMessage> selPartSystemMessages() {
        return systemMessagesDao.selPartSystemMessages();
    }

    @Override
    public int delSystemMessages(int id) {
        return systemMessagesDao.delSystemMessages(id);
    }
}

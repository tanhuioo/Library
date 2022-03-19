package com.bysj.qiu.controller;


import com.bysj.qiu.pojo.SystemMessage;
import com.bysj.qiu.pojo.SystemMessageType;
import com.bysj.qiu.service.SystemMessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/adminsystemmanager")
public class AdminSystemManagerController {
    @Autowired
    SystemMessagesService systemMessagesService;

    //加载信息类型
    @RequestMapping("/loadmessagestype")
    @ResponseBody
    public List<SystemMessageType> loadMessagesType() {
        return systemMessagesService.selSystemMessagesType();
    }

    //发送系统信息
    @RequestMapping("/sendmessages")
    @ResponseBody
    public int sendMessages(String content, String sender, String type) {
        return systemMessagesService.sendSystemMessages(content, sender, type);
    }

    //得到数据库里的所有信息
    @RequestMapping("/selmessages")
    @ResponseBody
    public List<SystemMessage> selMessages() {
        return systemMessagesService.selSystemMessages();
    }

    //得到数据库里部分系统信息
    @RequestMapping("/selpartmessages")
    @ResponseBody
    public List<SystemMessage> selpartMessages() {
        return systemMessagesService.selPartSystemMessages();
    }

    //删除信息
    @RequestMapping("/delmessages")
    @ResponseBody
    public int delMessages(int id) {
        return systemMessagesService.delSystemMessages(id);
    }
}

package com.bysj.qiu.controller;

import com.bysj.qiu.pojo.ChatMessage;
import com.bysj.qiu.pojo.Secret;
import com.bysj.qiu.service.AdminManagerPowerService;
import com.bysj.qiu.service.DealChatMessageService;
import com.bysj.qiu.service.GetSecretService;
import com.bysj.qiu.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;
import java.util.UUID;

//这里写admin的代码
@RequestMapping("/admin")
@Controller
public class AdminController {

    @Autowired
    GetSecretService getSecretService;
    @Autowired
    AdminManagerPowerService adminManagerPowerService;
    @Autowired
    DealChatMessageService dealChatMessageService;
    
    

    //    得到admin用户的信息
    @RequestMapping("/seladmininfo")
    @ResponseBody
    public List<Secret> selAdminInfo(String user, String fatheruser) {

        return adminManagerPowerService.selthisAdminInfo();
    }

    //    更新admin信息
    @RequestMapping("/updaadmininfo")
    @ResponseBody
    public int updaAdminInfo(int id, String updauser, String updapassword) {
        return adminManagerPowerService.updathisAdminInfo(id, updapassword, updauser);
    }

    //    判断是否数据库里已经有了除了自己以外的admin用户(更新用)
    @RequestMapping("/booleanupdaadminexist")
    @ResponseBody
    public String booleanexistupdate(String updauser) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Secret secret = getSecretService.selAdminPower(updauser);
        Secret secretother = getSecretService.selOtherUserPower(updauser);
        if ((secret != null && !name.equals(updauser)) || (secretother != null && !name.equals(updauser))) {
            System.out.println(secret);
            return "dead";
        } else {
            System.out.println(secret);
            return "left";
        }
    }

    //    判断是否数据库里已经有了除了自己以外的admin用户(增加用)
    @RequestMapping("/booleaninsertadminexist")
    @ResponseBody
    public String booleaninsertadminexist(String insertuser) {

        Secret secret = getSecretService.selAdminPower(insertuser);
        Secret secretother = getSecretService.selOtherUserPower(insertuser);
        if (secret != null || secretother != null) {
            System.out.println(secret);
            return "dead";
        } else {
            System.out.println(secret);
            return "left";
        }
    }


    //    增加一个admin用户
    @RequestMapping("/insertadmin")
    @ResponseBody
    public int insertadmin(String insertuser, String insertpassword, String insertfatheruser) {
        return adminManagerPowerService.insertAdmin(insertuser, insertpassword, insertfatheruser);
    }

    //查询出普通用户的信息 包括分页
    @RequestMapping("/selotheruser")
    @ResponseBody
    public List<Secret> selOtherUser(int nowpage) {
        List<Secret> secrets = adminManagerPowerService.selOtherUser(nowpage);
        return secrets;
    }

    //动态获取有几页
    @RequestMapping("/selothercount")
    @ResponseBody
    public Integer selOthercount() {
        Integer usercount = adminManagerPowerService.selOthercount();
        int countsize = 10;
        int pagecount = usercount / countsize;
        if (usercount % countsize > 0) {
            pagecount = pagecount + 1;
        }
        System.out.println("总页数" + pagecount);
        return pagecount;
    }

    //删除普通用户
    @RequestMapping("/deletbyidtouser")
    @ResponseBody
    public int deletByidToUser(int id) {
        return adminManagerPowerService.delOtherUser(id);
    }

    //    删除admin用户
    @RequestMapping("/deletByidToAdmin")
    @ResponseBody
    public int deletByidToAdmin(int id, String user) {
        adminManagerPowerService.delAdminUser(id);
        List<Secret> seladminbyfatheruser = adminManagerPowerService.seladminbyfatheruser(user);
        System.out.println("这个list" + seladminbyfatheruser);
        if (seladminbyfatheruser.isEmpty() == false) {
            adminManagerPowerService.upadmintosuperadmin(user);
        }
        return 1;
    }

    //    更新普通用户
    @RequestMapping("/updaotheruserbyid")
    @ResponseBody
    public int updaOtherUserById(int id, String updauser, String updapassword) {
        return adminManagerPowerService.upOtherUser(id, updauser, updapassword);
    }

    //    判断是否已经存在这个普通用户,更新用
    @RequestMapping("/booleanotheruserexit")
    @ResponseBody
    public String booleanotheruserexit(String updauser) {
        Secret secret = getSecretService.selOtherUserPower(updauser);
        Secret secretadmin = getSecretService.selAdminPower(updauser);
        if (secret != null || secretadmin != null) {
            return "exit";
        } else {
            return "noexit";
        }
    }

    //   得到上传来的图片并放入本地文件
    @RequestMapping("/getfileup")
    @ResponseBody
    public String getfileup(MultipartFile file_data) throws IOException {
        System.out.println("getfileup" + file_data);
        String filename = file_data.getOriginalFilename();
        String suffix = filename.substring(filename.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString();
        String newfilename = uuid + suffix;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String nowuser = auth.getName();
        adminManagerPowerService.upadminheadimg(newfilename, nowuser);
        file_data.transferTo(new File(CommonUtil.BASE_PATH + newfilename));
        File file = new File(CommonUtil.BASE_PATH + newfilename);
        System.out.println(file.getPath());
        return "ok";
    }

    //    获得选中的图片并出现在换头像框
    @GetMapping(value = "/getImg", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getImg(HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg/jpg/png/gif/bmp/tiff/svg");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String nowuser = auth.getName();
        Secret seladminheadimg = adminManagerPowerService.seladminheadimg(nowuser);
        String nowheadimg = seladminheadimg.getHeadimg();
        String realheadimgpath;
        if (nowheadimg != null) {
            realheadimgpath = CommonUtil.BASE_PATH + nowheadimg;
        } else {
            realheadimgpath = CommonUtil.BASE_PATH + "/headimg.png";
        }

        System.out.println(realheadimgpath);
        File file = new File(realheadimgpath);
        if (file.exists()) {
            FileInputStream inputStream = new FileInputStream(file);
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes, 0, inputStream.available());
            return bytes;
        } else {
            return null;
        }
    }

    //判断这个admin用户目前是否有头像
    @RequestMapping("booleanhasheadimg")
    @ResponseBody
    public String booleanhasheadimg() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String nowuser = auth.getName();
        Secret seladminheadimg = adminManagerPowerService.seladminheadimg(nowuser);
        String nowheadimg = seladminheadimg.getHeadimg();
        System.out.println("显示出" + seladminheadimg);
        if (nowheadimg != null && nowheadimg != "") {
            return "yes";
        } else {
            return "no";
        }
    }

    //admin界面在菜单栏展现未读信息
    @ResponseBody
    @RequestMapping("/showUnReadmsg")
    public List<ChatMessage> showUnReadmsg(String receiver, int isread) {
        List<ChatMessage> chatMessages = dealChatMessageService.showUnReadMsg(receiver, isread);
        System.out.println("当前用户的未读消息" + chatMessages);
        return chatMessages;
    }

    //    当用户头像改变时更换消息队列头像
    @ResponseBody
    @RequestMapping("/upmsgheadimg")
    public int upmsgheadimg(String sender) {
        Secret secret = dealChatMessageService.selSenderHeadimg(sender);
        String headimg = secret.getHeadimg();
        int i = dealChatMessageService.changeMsgSenderHeadimg(headimg, sender);
        return i;
    }

    //admin界面发送信息
    @ResponseBody
    @RequestMapping("/sendMsg")
    public int sendMsg(String sender, String receiver, String topic, String message) {
        Secret secret = getSecretService.selAdminPower(sender);
        String headimg = secret.getHeadimg();

        int i = dealChatMessageService.sendMessage(sender, receiver, topic, message, headimg);
        return i;
    }

    //    得到发送者的头像
    @GetMapping(value = "/getsendrImg", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getsenderImg(HttpServletResponse response, String nowheadimg) throws IOException {
        response.setContentType("image/jpeg/jpg/png/gif/bmp/tiff/svg");
        String realheadimgpath;
        if (nowheadimg != null || nowheadimg != "") {
            realheadimgpath = CommonUtil.BASE_PATH + nowheadimg;
        } else {
            realheadimgpath = CommonUtil.BASE_PATH + "/headimg.png";
        }
        String imgPath = URLDecoder.decode(realheadimgpath, "utf-8");
        File file = new File(imgPath);
        if (file.exists()) {
            FileInputStream inputStream = new FileInputStream(file);
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes, 0, inputStream.available());
            return bytes;
        } else {
            return null;
        }
    }

    // 点击未读信息后变为已读状态
    @ResponseBody
    @RequestMapping("/changeUnreadToRead")
    public int changeUnreadToRead(int id) {
        int i = dealChatMessageService.changeUnreadToRead(id);
        return i;
    }

    //展现所有信息，不分已读可读
    @ResponseBody
    @RequestMapping("/showAllMsg")
    public List<ChatMessage> showAllMsg(String receiver) {
        List<ChatMessage> chatMessages = dealChatMessageService.showAllMsg(receiver);
        return chatMessages;
    }

    //得到超级管理员权限专用
    @ResponseBody
    @RequestMapping("/getsuperpower")
    public Secret getSuperPower(String user) {
        return getSecretService.selAdminPower(user);
    }

    /////////////////////////////////以下是页面跳转/////////////////////////////////////////////////////
//进入admin页面
    @RequestMapping("/first")
    public String first() {
        return "/adminpage/adminfirst";
    }

    //进入admin首页
    @RequestMapping("/index")
    public String index() {
//adminpage下的adminmanagepower文件
        return "/adminpage/adminindex";
    }

    // 普通用户权限控制页
    @RequestMapping("/managepower")
    public String managePower() {
        //adminpage下的adminmanagepower文件
        return "/adminpage/adminmanagepower";
    }

    //    跳到信息交互的发送页面
    @RequestMapping("/messagesend")
    public String messagesend() {
        //adminpage下的adminmanagepower文件
        return "/adminpage/adminmessagesend";
    }

    //    跳到信息交互的接受页面
    @RequestMapping("/messagereceive")
    public String messagereceive() {
        //adminpage下的adminmanagepower文件
        return "/adminpage/adminmanagereceive";
    }

    //跳到商品条目管理页面
    @RequestMapping("/managershopitem")
    public String managerShopItem() {
        return "/adminpage/adminmanageshopitem";
    }

    //跳到系统管理页面
    @RequestMapping("/managersystem")
    public String managersystem() {
        return "/adminpage/adminmanagesystem";
    }

    //跳到展现所有系统信息列表界面
    @RequestMapping("/showsystemmessages")
    public String showSystemMessages() {
        return "/adminpage/adminshowsystemmessages";
    }
}

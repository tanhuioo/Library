package com.bysj.qiu.controller;


import com.bysj.qiu.pojo.*;
import com.bysj.qiu.service.*;
import com.bysj.qiu.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.List;
import java.util.UUID;

@RequestMapping(value = "/other")
@Controller
public class OtherController {
    @Autowired
    GetSecretService getSecretService;
    @Autowired
    OtherManagerSelfService otherManagerSelfService;
    @Autowired
    ShowShopItemService showShopItemService;
    @Autowired
    BuyUserInfoService buyUserInfoService;
    @Autowired
    SystemMessagesService systemMessagesService;

    //得到数据库里的所有系统信息
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

    //获得当前用户购买信息
    @RequestMapping("/getuserbuyinfo")
    @ResponseBody
    public UserBuyInfo getUserBuyInfo(String buyuser) {
        return buyUserInfoService.selThisUserBalance(buyuser);
    }

    //获得当前用户买过最多的果蔬以及买这个果蔬的次数
    @RequestMapping("/getnumfirstforv")
    @ResponseBody
    public ShopOrder getNumFirstForV(String user) {
        return buyUserInfoService.selNumFirstForV(user);
    }

    //获得所有账单信息(部分的)
    @RequestMapping("/getbillinfo")
    @ResponseBody
    public List<UserBill> getBillInfo(String user, int showmore) {
        return buyUserInfoService.selallbillinfo(user, showmore);
    }

    //获得账单的总条数
    @RequestMapping("/getbillallcount")
    @ResponseBody
    public Integer getBillAllCount(String user) {
        return buyUserInfoService.selBillAllCount(user);
    }

    //获得所有未确认收货的订单
    @RequestMapping("/getnodoneorder")
    @ResponseBody
    public List<ShopOrder> getNoDoneOrder(String buyer) {
        return buyUserInfoService.selNodoneOrder(buyer);
    }

    //获得所有订单
    @RequestMapping("/getallorder")
    @ResponseBody
    public List<ShopOrder> getAllOrder(String buyer) {
        return buyUserInfoService.selAllOrder(buyer);
    }

    //更新订单状况为已收货
    @RequestMapping("/uporderdone")
    @ResponseBody
    public int upOrderDone(String buyer, int id) {
        return buyUserInfoService.upOrderDone(buyer, id);
    }

    //更新余额
    @RequestMapping("/upbalance")
    @ResponseBody
    public int updatebalance(String balacne, String buyuser, int buynum) {
        System.out.println("为什么是string" + balacne);
        return buyUserInfoService.upBalance(balacne, buyuser, buynum);
    }

    //获得当前果蔬的单条信息
    @RequestMapping("/getOneOfForV")
    @ResponseBody
    public ShopItem getOneOfForV(String name) {
        return showShopItemService.selOneOfForV(name);
    }

    // 水果列表购买次数+1
    @RequestMapping("/upforvcount")
    @ResponseBody
    public int upForVCount(int sellcount, int stockcount, String name) {
        return buyUserInfoService.upAllForVCount(sellcount, stockcount, name);
    }

    //购买后，将订单信息存入到数据库中
    @RequestMapping("/addbuyinfo")
    @ResponseBody
    public int addBuyInfo(String buyer, String buyshopitemname, String address, String tellphone, String transfername, BigDecimal consume, int onecount, String shopimg) {
        return buyUserInfoService.addOrderInfo(buyer, buyshopitemname, address, tellphone, transfername, consume, onecount, shopimg);
    }

    //购买后，记录账单
    @RequestMapping("/addbillinfo")
    @ResponseBody
    public int addBillInfo(String user, BigDecimal flowmoney, String whatdoing, int isbuyoradd) {
        return buyUserInfoService.addBillInfo(user, flowmoney, whatdoing, isbuyoradd);
    }

    //判断用户密码合法性（是否密码匹配）
    @RequestMapping("/isrightpassword")
    @ResponseBody
    public String booleanPower(String user, String password) {
        Secret usersecret = getSecretService.booleanUserPower(user, password);
        if (usersecret != null) {
            return "ok";
        } else {
            return "err";
        }
    }

    //更新用户的密码和账户
    @RequestMapping("/changeuserpasswordanduser")
    @ResponseBody
    public int changeUserPasswordAndUser(String password, String newuser, String olduser) {
        return getSecretService.upUserPasswordAndUser(password, newuser, olduser);
    }

    //得到上传来的图片并放入本地文件
    @RequestMapping("/getfileup")
    @ResponseBody
    public String getfileup(MultipartFile file_data) throws IOException {
        String filename = file_data.getOriginalFilename();
        String suffix = filename.substring(filename.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString();
        String newfilename = uuid + suffix;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String nowuser = auth.getName();
        otherManagerSelfService.upOtherHeadImg(newfilename, nowuser);
        file_data.transferTo(new File(CommonUtil.BASE_PATH + newfilename));
        File file = new File(CommonUtil.BASE_PATH + newfilename);
        return "ok";
    }

    //    获得选中的图片并出现在换头像框
    @GetMapping(value = "/getImg", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getImg(HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg/jpg/png/gif/bmp/tiff/svg");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String nowuser = auth.getName();
        Secret selotherheadimg = otherManagerSelfService.selOtherHeadImg(nowuser);
        String nowheadimg = selotherheadimg.getHeadimg();
        String realheadimgpath;
        if (nowheadimg != null) {
            realheadimgpath = CommonUtil.BASE_PATH + nowheadimg;
        } else {
            realheadimgpath = CommonUtil.BASE_PATH + "/headimg.png";
        }
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

    //判断这个普通用户目前是否有头像
    @RequestMapping("booleanhasheadimg")
    @ResponseBody
    public String booleanhasheadimg() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String nowuser = auth.getName();
        Secret selotherheadimg = otherManagerSelfService.selOtherHeadImg(nowuser);
        String nowheadimg = selotherheadimg.getHeadimg();
        if (nowheadimg != null && nowheadimg != "") {
            return "yes";
        } else {
            return "no";
        }
    }

    //注册支付密码
    @RequestMapping("/uppaypassword")
    @ResponseBody
    public int upPayPassword(String paypassword, String user) {
        return getSecretService.uppaypassword(paypassword, user);
    }

    //获取当前支付密码
    @RequestMapping("/selthisuserpassword")
    @ResponseBody
    public Secret selThisUserPassword(String nowuser) {
        return getSecretService.selOtherUserPower(nowuser);
    }

    //充值
    @RequestMapping("/addbalance")
    @ResponseBody
    public int addbalance(BigDecimal oldbalance, String user, BigDecimal addbalance) {
        BigDecimal newbalance = oldbalance.add(addbalance);
        return otherManagerSelfService.addBalance(newbalance, user);
    }

    //将所有果蔬信息放入list，传到前台去循环得到
    @RequestMapping("/showallshopitem")
    @ResponseBody
    public List<ShopItem> showAllShopItem(String type, String name) {
        return showShopItemService.selallForV(type, name);
    }

    //查询出所有商品的类别作为下拉列表
    @RequestMapping("/showallshopitemtype")
    @ResponseBody
    public List<ShopItemType> showAllShopItemType() {
        return showShopItemService.selAllShopItemType();
    }

    //得到果蔬图片
    @GetMapping(value = "/getsendrImg", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getsenderImg(HttpServletResponse response, String nowforvimg) throws IOException {
        response.setContentType("image/jpeg/jpg/png/gif/bmp/tiff/svg");
        String realheadimgpath;
        if (nowforvimg != null) {
            realheadimgpath = "G:/毕业设计/邱/毕业设计果蔬图片库/" + nowforvimg;
        } else {
            realheadimgpath = "G:/毕业设计/邱/毕业设计果蔬图片库/headimg.png";
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


    //得到别人的头像
    @GetMapping(value = "/getotherheadImg", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getOtherHeadImg(HttpServletResponse response, String otherheadimg) throws IOException {
        response.setContentType("image/jpeg/jpg/png/gif/bmp/tiff/svg");
        String realheadimgpath;
        System.out.println(otherheadimg);
        if (otherheadimg != null) {
            realheadimgpath = CommonUtil.BASE_PATH + otherheadimg;
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


    //登录成功后，普通用户来到的页面
    @RequestMapping("/first")
    public String first() {
        return "/otherpage/otherfirst";
    }

    //other首页，也是默认页
    @RequestMapping("/index")
    public String index() {
        return "/otherpage/otherindex";
    }

    //other展现所有果蔬页
    @RequestMapping("/showallitem")
    public String showAllItem() {
        return "/otherpage/othershowallitem";
    }

    //other展现管理自己的界面
    @RequestMapping("/showmanageself")
    public String showSelf() {
        return "/otherpage/othershowmanageself";
    }

    //other展现查看所有订单界面
    @RequestMapping("/showallorderpage")
    public String showAllOrderPage() {
        return "/otherpage/othershowallorder";
    }

    //other编辑地址信息界面
    @RequestMapping("/editaddresspage")
    public String editAddressPage() {
        return "/otherpage/otherseditaddress";
    }

    //other展现购物车界面
    @RequestMapping("/showshopcarpage")
    public String showShopCarPage() {
        return "/otherpage/othershowshopcar";
    }

    //other展现所有系统信息列表界面
    @RequestMapping("/showsystemmessages")
    public String showSystemMessages() {
        return "/otherpage/othershowsystemmessages";
    }


    @RequestMapping("/getname")
    @ResponseBody
    public String wellcome(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        model.addAttribute("role", name);
//        System.out.println(name);
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println("unkunow"+authentication);
//        String s = authentication.getAuthorities().toString();
//        System.out.println(authentication.getAuthorities().toString());
        return name;
    }
}




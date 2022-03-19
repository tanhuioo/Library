package com.bysj.qiu.controller;

import com.bysj.qiu.pojo.ShopCar;
import com.bysj.qiu.pojo.ShopItem;
import com.bysj.qiu.pojo.ShopOrder;
import com.bysj.qiu.pojo.UserBill;
import com.bysj.qiu.service.BuyUserInfoService;
import com.bysj.qiu.service.DealShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/othershopcar")
public class OtherShopCarController {

    @Autowired
    BuyUserInfoService buyUserInfoService;
    @Autowired
    DealShopCarService dealShopCarService;

    @RequestMapping("/addshoptoshopcar")
    @ResponseBody
    public int addShopToShopCar(String shopcarname, BigDecimal shopcarprices, int shopcarcount, BigDecimal needmoney, String shopcarimg, String putter, int stockcount, int sellcount) {

        return dealShopCarService.addToShopCar(shopcarname, shopcarprices, shopcarcount, needmoney, shopcarimg, putter, stockcount, sellcount);
    }

    @RequestMapping("/showallshopcar")
    @ResponseBody
    public List<ShopCar> showallshopcar(String putter) {
        return dealShopCarService.selAllShopCar(putter);
    }

    //总价格小计算,及时出现在按钮旁边
    @RequestMapping("/moneycalclation")
    @ResponseBody
    public BigDecimal moneyCalCulation(@RequestBody(required = false) List<ShopOrder> list) {
        BigDecimal num1 = new BigDecimal(0);
        for (ShopOrder s : list) {
            num1 = num1.add(s.getConsume());
        }
        return num1;
    }

    //批量插入：从购物车到订单
    @RequestMapping("/moraddorder")
    @ResponseBody
    public int morAddOrder(@RequestBody(required = false) List<ShopOrder> list) {
        //(required = false )的作用是，如果用List<>作为参数，则因为是接口的原因，ssm不能自动创建对象，所以需要
        return dealShopCarService.morAddToOrder(list);
    }

    //批量插入：从购物车到账单
    @RequestMapping("/moraddbill")
    @ResponseBody
    public int morAddBill(@RequestBody(required = false) List<UserBill> list) {
        return dealShopCarService.morAddToBill(list);
    }

    //批量删除购物车
    @RequestMapping("/mordelshopcar")
    @ResponseBody
    public int morDelShopCar(@RequestParam(required = false, value = "list[]") List<String> list) {
        List<Integer> intlist = new ArrayList<>();
        for (String item : list) {
            intlist.add(Integer.parseInt(item));
        }
        return dealShopCarService.delMorShopCar(intlist);
    }

    //批量更新商品销售数量与库存
    @RequestMapping("/morupshopitem")
    @ResponseBody
    public int morUpShopItem(@RequestBody(required = false) List<ShopItem> list) {
        System.out.println(list);
        return dealShopCarService.upMoreForVCount(list);
    }

    //更新余额
    @RequestMapping("/upbalance")
    @ResponseBody
    public int updatebalance(BigDecimal balacne, String buyuser, int buynum, BigDecimal allconsume) {
        BigDecimal newbalance = balacne.subtract(allconsume);
        return dealShopCarService.upBalance(newbalance, buyuser, buynum);
    }
}

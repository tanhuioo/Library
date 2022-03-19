package com.bysj.qiu.controller;

import com.bysj.qiu.pojo.OrderComment;
import com.bysj.qiu.pojo.Secret;
import com.bysj.qiu.service.DealOrderCommentService;
import com.bysj.qiu.service.OtherManagerSelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/othercomment")
public class OtherCommentController {
    @Autowired
    DealOrderCommentService dealOrderCommentService;
    @Autowired
    OtherManagerSelfService otherManagerSelfService;

    //增加评论信息
    @ResponseBody
    @RequestMapping("/addcommentinfo")
    public int addCommentInfo(String shopname, int buycount, BigDecimal consume, String buyer, String shopimg, @RequestParam(value = "commenttext", defaultValue = "没有评论") String commenttext, BigDecimal commentpoint) {
        Secret selotherheadimg = otherManagerSelfService.selOtherHeadImg(buyer);
        String buyerheadimg = selotherheadimg.getHeadimg();
        return dealOrderCommentService.addComment(shopname, buycount, consume, buyer, buyerheadimg, shopimg, commenttext, commentpoint);
    }

    //更改订单状况为已经评论
    @ResponseBody
    @RequestMapping("/upcommentstate")
    public int upCommentState(String buyer, int id) {
        return dealOrderCommentService.upOrderComment(buyer, id);
    }

    //得到这个商品的平均评分
    @ResponseBody
    @RequestMapping("/getshopavgpoint")
    public BigDecimal getShopAvgPoint(String shopname) {
        BigDecimal bigDecimal = dealOrderCommentService.selShopPointAvg(shopname);
        BigDecimal avgpoint = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        return avgpoint;
    }

    //更新商品项目的评分平均分
    @ResponseBody
    @RequestMapping("/upshopitemavgpoint")
    public int upShopItemAvgPoint(BigDecimal evaluatepoint, String name) {
        return dealOrderCommentService.upShopItemAvgPoint(evaluatepoint, name);
    }

    //将评论列表展现到商品列表的评论区中
    @ResponseBody
    @RequestMapping("/selcommenttoarea")
    public List<OrderComment> selCommentToArea(String shopname) {
        return dealOrderCommentService.selCommentToCommentArea(shopname);
    }
}

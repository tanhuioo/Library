package com.bysj.qiu.service;

import com.bysj.qiu.pojo.OrderComment;

import java.math.BigDecimal;
import java.util.List;

public interface DealOrderCommentService {
    //增加评论信息
    int addComment(String shopname, int buycount, BigDecimal consume, String buyer, String buyerheadimg, String shopimg, String commenttext, BigDecimal commentpoint);

    //更改订单状况为已经评论
    int upOrderComment(String buyer, int id);

    //查询出此商品的平均评分
    BigDecimal selShopPointAvg(String shopname);

    //更新商品项目的评分平均分
    int upShopItemAvgPoint(BigDecimal evaluatepoint, String name);

    //在商品评论区里显示评论
    List<OrderComment> selCommentToCommentArea(String shopname);
}

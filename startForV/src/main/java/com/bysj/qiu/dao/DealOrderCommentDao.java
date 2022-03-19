package com.bysj.qiu.dao;

import com.bysj.qiu.pojo.OrderComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface DealOrderCommentDao {
    //增加评论信息
    int addComment(@Param("shopname") String shopname, @Param("buycount") int buycount, @Param("consume") BigDecimal consume, @Param("buyer") String buyer, @Param("buyerheadimg") String buyerheadimg, @Param("shopimg") String shopimg, @Param("commenttext") String commenttext, @Param("commentpoint") BigDecimal commentpoint);

    //更改订单状况为已经评论
    int upOrderComment(@Param("buyer") String buyer, @Param("id") int id);

    //查询出此商品的平均评分
    BigDecimal selShopPointAvg(@Param("shopname") String shopname);

    //更新商品项目的评分平均分
    int upShopItemAvgPoint(@Param("evaluatepoint") BigDecimal evaluatepoint, @Param("name") String name);

    //在商品评论区里显示评论
    List<OrderComment> selCommentToCommentArea(@Param("shopname") String shopname);
}

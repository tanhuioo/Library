package com.bysj.qiu.service.serviceimpl;

import com.bysj.qiu.dao.DealOrderCommentDao;
import com.bysj.qiu.pojo.OrderComment;
import com.bysj.qiu.service.DealOrderCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DealOrderCommentServiceImpl implements DealOrderCommentService {

    @Autowired
    DealOrderCommentDao dealOrderCommentDao;

    @Override
    public int addComment(String shopname, int buycount, BigDecimal consume, String buyer, String buyerheadimg, String shopimg, String commenttext, BigDecimal commentpoint) {
        return dealOrderCommentDao.addComment(shopname, buycount, consume, buyer, buyerheadimg, shopimg, commenttext, commentpoint);
    }

    @Override
    public int upOrderComment(String buyer, int id) {
        return dealOrderCommentDao.upOrderComment(buyer, id);
    }

    @Override
    public BigDecimal selShopPointAvg(String shopname) {
        return dealOrderCommentDao.selShopPointAvg(shopname);
    }

    @Override
    public int upShopItemAvgPoint(BigDecimal evaluatepoint, String name) {
        return dealOrderCommentDao.upShopItemAvgPoint(evaluatepoint, name);
    }

    @Override
    public List<OrderComment> selCommentToCommentArea(String shopname) {
        return dealOrderCommentDao.selCommentToCommentArea(shopname);
    }
}

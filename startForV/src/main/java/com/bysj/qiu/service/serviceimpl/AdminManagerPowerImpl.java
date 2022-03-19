package com.bysj.qiu.service.serviceimpl;

import com.bysj.qiu.dao.AdminManagerPowerDao;
import com.bysj.qiu.pojo.Secret;
import com.bysj.qiu.service.AdminManagerPowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(isolation = Isolation.SERIALIZABLE)
@Service
public class AdminManagerPowerImpl implements AdminManagerPowerService {
    @Autowired
    AdminManagerPowerDao adminManagerPowerDao;

    //寻找到所有admin
    @Override
    public List<Secret> selthisAdminInfo() {
        return adminManagerPowerDao.selthisAdminInfo();
    }

    //更新admin信息
    @Override
    public int updathisAdminInfo(int id, String password, String user) {
        return adminManagerPowerDao.updathisAdminInfo(id, password, user);
    }

    //增加admin用户
    @Override
    public int insertAdmin(String user, String password, String fatheruser) {
        return adminManagerPowerDao.insertAdmin(user, password, fatheruser);
    }

    //查询出普通用户加分页
    @Override
    public List<Secret> selOtherUser(int nowpage) {
        int thiscount = 10;
        int first = (nowpage - 1) * thiscount;
        List<Secret> secrets = adminManagerPowerDao.selOtherUser(first, thiscount);
        return secrets;
    }

    //总数
    @Override
    public Integer selOthercount() {
        Integer count = adminManagerPowerDao.selOthercount();
        return count;
    }

    //删除普通用户
    @Override
    public int delOtherUser(int id) {
        int delbyid = adminManagerPowerDao.delOtherUser(id);
        return delbyid;
    }

    @Override
    public int delAdminUser(int id) {
        return adminManagerPowerDao.delAdminUser(id);
    }

    @Override
    public int upOtherUser(int id, String user, String password) {
        int upother = adminManagerPowerDao.upOtherUser(id, user, password);
        return upother;
    }

    //更新admin用户的头像
    @Override
    public int upadminheadimg(String headimg, String user) {
        return adminManagerPowerDao.upadminheadimg(headimg, user);
    }

    //查询出的当前用户的头像
    @Override
    public Secret seladminheadimg(String user) {
        return adminManagerPowerDao.seladminheadimg(user);
    }

    //查询出当前管理员的父用户是谁
    @Override
    public List<Secret> seladminbyfatheruser(String fatheruser) {
        return adminManagerPowerDao.seladminbyfatheruser(fatheruser);
    }

    //把普通用户变为超级用户
    @Override
    public int upadmintosuperadmin(String user) {
        return adminManagerPowerDao.upadmintosuperadmin(user);
    }


}

package com.bysj.qiu.service.serviceimpl;


import com.bysj.qiu.dao.GetSecretDao;
import com.bysj.qiu.pojo.Secret;
import com.bysj.qiu.service.GetSecretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(isolation = Isolation.SERIALIZABLE)
@Service
public class GetSecretServiceImpl implements GetSecretService {

    @Autowired
    GetSecretDao getSecretDao;

    @Override
    public Secret selAdminPower(String user) {
        return getSecretDao.selAdminPower(user);
    }

    @Override
    public Secret selOtherUserPower(String user) {
        return getSecretDao.selOtherUserPower(user);
    }

    @Override
    public Secret booleanUserPower(String user, String password) {
        return getSecretDao.booleanUserPower(user, password);
    }

    @Override
    public Secret booleanAdminPower(String user, String password) {
        return getSecretDao.booleanAdminPower(user, password);
    }

    @Override

    //事务管理，如果遇到异常，则不会保存数据，不然的话如果执行到操作代码，但是遇到错误了还是会保存数据的。
    public int regist(String user, String password) {
        int regist = getSecretDao.regist(user, password);
        return regist;
    }

    @Override
    public int uppaypassword(String paypassword, String user) {
        return getSecretDao.uppaypassword(paypassword, user);
    }

    @Override
    public int upUserPasswordAndUser(String password, String newuser, String olduser) {
        return getSecretDao.upUserPasswordAndUser(password, newuser, olduser);
    }


}

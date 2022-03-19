package com.bysj.qiu.config;

import com.bysj.qiu.dao.GetSecretDao;
import com.bysj.qiu.pojo.Secret;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class ResovleSecurity implements UserDetailsService {

    @Autowired
    GetSecretDao getSecretDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Secret secretadmin = getSecretDao.selAdminPower(s);
        Secret secretother = getSecretDao.selOtherUserPower(s);
        if (secretadmin != null && secretadmin.getPower().equals("ADMIN")) {
//            如果能在admin用户的数据库中找到这个名字，并且这个人的权利时ADMIN。得到权限ROLE_ADMIN
            return new User(secretadmin.getUser(), secretadmin.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"));
        } else if (secretadmin != null && secretadmin.getPower().equals("SUPERADMIN")) {
            return new User(secretadmin.getUser(), secretadmin.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"));
        } else if (secretother != null && secretother.getPower().equals("USER")) {

//            Secret secretuser = getSecretDao.selOtherUserPower(s);
            return new User(secretother.getUser(), secretother.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
        } else {

            return new User("ERROR", "ERROR", AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ERROR"));
        }
    }

}

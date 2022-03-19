package com.bysj.qiu.service;

import com.bysj.qiu.pojo.Secret;

import java.util.List;

public interface AdminManagerPowerService {

    //    查询出admin的信息
    List<Secret> selthisAdminInfo();

    //    更新admin信息
    int updathisAdminInfo(int id, String password, String user);

    //    增加admin用户
    int insertAdmin(String user, String password, String fatheruser);

    //  得到普通 用户的权限，用分页查询
    List<Secret> selOtherUser(int nowpage);

    //   得到所有用户的数量
    Integer selOthercount();

    //    删除普通用户
    int delOtherUser(int id);

    //    删除admin用户
    int delAdminUser(int id);

    //    更新普通用户
    int upOtherUser(int id, String user, String password);

    //    更新admin用户头像
    int upadminheadimg(String headimg, String user);

    //   查询到admin用户的头像
    Secret seladminheadimg(String user);

    //    通过fatheruser来查询这个admin列表中是否有这个用户
    List<Secret> seladminbyfatheruser(String fatheruser);

    //   如果这个admin的父用户不存在，则把这个夫用户的权限转交给超级admin用户
    int upadmintosuperadmin(String user);
}

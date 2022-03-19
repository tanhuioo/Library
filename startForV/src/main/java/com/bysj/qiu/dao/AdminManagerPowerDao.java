package com.bysj.qiu.dao;


import com.bysj.qiu.pojo.Secret;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//这是用于admin页面下用户权限管理的dao
@Mapper
public interface AdminManagerPowerDao {
    //  得到admin的所有信息
    List<Secret> selthisAdminInfo();

    //  更新admin的信息
    int updathisAdminInfo(@Param("id") int id, @Param("password") String password, @Param("user") String user);

    //  增加admin用户
    int insertAdmin(@Param("user") String user, @Param("password") String password, @Param("fatheruser") String fatheruser);

    //  得到普通 用户的权限，用分页查询
    List<Secret> selOtherUser(@Param("first") int first, @Param("thiscount") int thiscount);

    //   得到所有用户的数量
    Integer selOthercount();

    //   删除普通用户
    int delOtherUser(@Param("id") int id);

    //   删除admin用户
    int delAdminUser(@Param("id") int id);

    //   更新普通用户
    int upOtherUser(@Param("id") int id, @Param("user") String user, @Param("password") String password);

    //   更新admin用户的头像
    int upadminheadimg(@Param("headimg") String headimg, @Param("user") String user);

    //   查询到admin用户的头像
    Secret seladminheadimg(@Param("user") String user);

    //    通过fatheruser来查询这个admin列表中是否有这个用户
    List<Secret> seladminbyfatheruser(@Param("fatheruser") String fatheruser);

    //   如果这个admin的父用户不存在，则把这个夫用户的权限转交给超级admin用户
    int upadmintosuperadmin(@Param("user") String user);
}

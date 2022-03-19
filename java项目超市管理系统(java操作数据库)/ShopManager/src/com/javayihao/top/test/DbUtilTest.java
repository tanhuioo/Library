package com.javayihao.top.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.javayihao.top.utils.DbUtil;

/**
 * @date 2019-12-9
 * @Description 测试数据库连接类
 * @author com.javayihao.top
 */
public class DbUtilTest {
	public static void main(String[] args) throws SQLException {
		Connection con = DbUtil.getConnection();
		System.out.println(con);
	}
}

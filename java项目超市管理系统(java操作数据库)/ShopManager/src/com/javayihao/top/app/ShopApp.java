package com.javayihao.top.app;

import com.javayihao.top.service.ShopView;

/**
 * @date 2019-12-9
 * @Description 系统启动类
 * @author com.javayihao.top
 */
public class ShopApp {
	public static void main(String[] args) {
		//创建一个系统主界面对象，调用展示系统的方法
		ShopView sv = new ShopView();
		sv.ShopStart();
	}
}

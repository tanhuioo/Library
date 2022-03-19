package com.javayihao.top.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.javayihao.top.pojo.Good;
import com.javayihao.top.utils.DbUtil;

/**
 * @date 2019-12-9
 * @Description 系统主界面
 * @author com.javayihao.top
 */
public class ShopView {
	//获取键盘输入对象
	Scanner input = new Scanner(System.in);
	/*
	 * 系统运行方法
	 */
	public void ShopStart() {
		System.out.println("=================欢迎使用超市购物管理系统=================");
		//是否继续的标志量，默认是
		String isGo="y";
		do{
			//调用菜单那展示的函数
				showMenu();
				System.out.println("请输入要执行的操作");
				//接受键盘的输入，这里使用String,一次性处理数字和字符输入，不建议使用int类型数字
				String select =input.next();
				//根据输入的选择执行对应的方法
				switch (select) {
				//执行商品入库方法
				case "1":
					insertGood();
					break;
				//执行商品查詢方法
				case "2":
					System.out.println("输入要查询的商品编号");
					int goodId = input.nextInt();
					//调用查询商品的方法，
					Good good = searchGoodById(goodId);
					//存在
					if(good!=null){
						System.out.println("商品编号:"+goodId+" 商品名称:"+good.getName()
						+"  商品价格:"+good.getPrice()+"  商品数量:"+good.getNum());
					}else{
						System.out.println("此商品不存在");
					}
					break;
				//执行商品列表方法
				case "3":
					getGoodList();
					break;
				//执行商品购买方法
				case "4":
					buyGood();
					break;
					//执行商品购买方法
				case "5":
					System.out.println("输入要刪除的商品编号");
					int id = input.nextInt();
					//调用查询商品的方法，
					if(searchGoodById(id)!=null){
						deleteGood(id);
					}else{
						System.out.println("沒有此商品");
					}
					break;
				case "6":
					updateGood();
					break;
				//退出系统
				case "0":
					System.out.println("*************欢迎下次使用 再见!*************");
					//终止程序
					System.exit(0);
				default:
					System.err.println("输入有误 请重新输入!");
					continue;
			}
				System.out.println("输入y继续/否则退出");
				isGo = input.next();
		}while(isGo.equals("y"));
		System.out.println("*************欢迎下次使用 再见!*************");
	}
	/**
	 * 更新商品操作
	 * 1.先查询当前要更新的商品存不存在
	 * 2.如果存在更新即可，不存在提示
	 */
	private void updateGood() {
		System.out.println("输入要修改的商品id");
		int gid = input.nextInt();
		Good good = searchGoodById(gid);
		System.out.println("商品信息如下");
		if(good!=null){
			System.out.println("商品编号:"+gid+" 商品名称:"+good.getName()
			+"  商品价格:"+good.getPrice()+"  商品数量:"+good.getNum());
			System.out.println("修改商品名称");
			String name = input.next();
			System.out.println("修改商品单价");
			float price = input.nextFloat();
			System.out.println("修改商品库存");
			int num = input.nextInt();
			String sql="update t_good set name=?,price=?,num=? where id=? ";
			try {
				//创建一个操作数据库的对象
				Connection con = DbUtil.getConnection();
				//创建执行sql的执行对象PreparedStatement
				PreparedStatement pst = con.prepareStatement(sql);
				//给占位符设置值
				pst.setString(1, name);
				pst.setFloat(2, price);
				pst.setInt(3, num);
				pst.setInt(4, gid);
				//如果是查询的话execute()返回true，如果是更新或插入的话就返回false
				if(!pst.execute()){
					System.out.println("更新成功");
				}
				//关闭连接
				DbUtil.close(con, pst);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("更新异常"+e.getMessage());
			}
		}else{
			System.out.println("此商品不存在");
		}
		
	}
		//用于展示系统界面菜单的方法
		private void  showMenu() {
			System.out.println("1.商品入库");
			System.out.println("2.根据商品编号查询商品");
			System.out.println("3.商品列表");
			System.out.println("4.购买商品");
			System.out.println("5.删除商品");
			System.out.println("6.更新商品");
			System.out.println("0.退出系统");
		}
	/*
	 * 刪除商品
	 * 1.首先得判断该商品存在
	 * 2.根据商品编号id删除
	 */
	private void deleteGood(int id) {
		String sql = "delete from t_good where id=?";
		try {
			//创建一个操作数据库的对象
			Connection con = DbUtil.getConnection();
			//创建执行sql的执行对象PreparedStatement
			PreparedStatement pst = con.prepareStatement(sql);
			//给占位符设置值
			pst.setInt(1, id);
			//如果是查询的话execute()返回true，如果是更新或插入的话就返回false
			if(!pst.execute()){
				System.out.println("刪除成功");
			}
			//关闭连接
			DbUtil.close(con, pst);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("删除异常"+e.getMessage());
		}
	}
	/*
	 * 商品入库
	 * 这里只处理编号不能重复的逻辑，
	 * 关于输入的编号是不是数字这里就不做判断，有兴趣的朋友可以试试
	 */
	private void insertGood(){
		//商品编号
		int id=0;
		System.out.println("输入商品编号");
		while(true){
			 id= input.nextInt();
			//判断当前输入的编号重复没有，重复重新输入
			if(searchGoodById(id)==null){
				break;
			}
			System.err.println("编号重复，请重新输入商品编号");
		}
		System.out.println("输入商品名称");
		String name = input.next();
		System.out.println("输入商品单价");
		float price = input.nextFloat();
		System.out.println("输入商品数量");
		int num = input.nextInt();
		//要执行的sql语句，这里使用占位符防止sql入侵
		String sql = "insert into t_good()values(?,?,?,?)";
		try {
			//创建一个操作数据库的对象
			Connection con = DbUtil.getConnection();
			//创建执行sql的执行对象PreparedStatement
			PreparedStatement pst = con.prepareStatement(sql);
			//给占位符设置值
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setFloat(3, price);
			pst.setInt(4, num);
			//执行sql语句
		    if(!pst.execute()){
		    	System.out.println("入库成功");
		     }
			//关闭连接
			DbUtil.close(con, pst);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("入库异常"+e.getMessage());
		}
	}
	/*商品查询
	 * 返回的是一个商品对象，没有此商品返回null
	 */
	private Good searchGoodById(int id) {
		//执行的sql语句
		String sql="select id,name,price,num from t_good where id=?";
		try {
			//创建一个操作数据库的对象
			Connection con = DbUtil.getConnection();
			//创建执行sql的对象PreparedStatement
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){//有结果，将查到的数据通过构造函数封装成一个商品对象
				Good good = new Good(rs.getInt("id"), rs.getString("name"), 
						rs.getFloat("price"), rs.getInt("num"));
				return good;
			}
			//关闭连接
			DbUtil.close(con, pst);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//商品列表
	private void getGoodList(){
		//执行的sql语句
				String sql="select id,name,price,num from t_good";
				try {
					//创建一个操作数据库的对象
					Connection con = DbUtil.getConnection();
					//创建执行sql的对象PreparedStatement
					PreparedStatement pst = con.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();
					System.out.println("编号\t"+"名称\t"+"单价\t"+"数量\t");
					if(rs.wasNull()){
						System.out.println("没有商品");
					}else{
						while(rs.next()){//有结果，打印
							//通过rs.getxxx("yy")方法参数是数据库列名
							System.out.println(rs.getInt("id")+"\t"+rs.getString("name")+"\t"+
									rs.getFloat("price")+"\t"+rs.getInt("num")+"\t");
						}
					}
					//关闭连接
					DbUtil.close(con, pst);
				} catch (SQLException e) {
					e.printStackTrace();
				}
	}
	//购买商品
	public void buyGood() {
		//用来存储购买商品的集合
		ArrayList<Good> goods = new ArrayList<>();
		//是否继续购买标记
		String flag = "y";
		do{
			System.out.println("输入购买商品的编号");
			int id = input.nextInt();
			Good good = searchGoodById(id);
			if(good!=null){
				System.out.println("输入购买商品的数量");
				int num = input.nextInt();
				if(good.getNum()<num){
					System.out.println("此商品库存"+good.getNum()+"  无法购买;");
					
				}else{
					try{
						String sql="update t_good set num=? where id=?";
						//创建一个操作数据库的对象
						Connection con = DbUtil.getConnection();
						//创建执行sql的对象PreparedStatement
						PreparedStatement pst = con.prepareStatement(sql);
						pst.setInt(1, good.getNum()-num);//更新库存
						pst.setInt(2, id);
						if(pst.executeUpdate()==1){
							//存入购买商品的集合goods
							Good g = new Good(id,good.getName(),good.getPrice(),num);
							if(goods.size()>0){
								for (int i = 0; i < goods.size(); i++) {
									if(goods.get(i).getId()==id){//如果购物车中有该商品 数量加即可
										goods.get(0).setNum(num+goods.get(0).getNum());
									}else{//如果购物车中没有该商品 数量加即可
										goods.add(g);
									}
								}
							}else{//购物车中没有商品，加入到购物车中
								goods.add(g);
							}
							System.out.println("购买成功");
						}else{
							System.out.println("购买失敗");
						}
					}catch(Exception e){
						e.printStackTrace();
						System.out.println("购买异常"+e.getMessage());
					}
				}
				System.out.println("输入y继续购买/输入其他结算");
				flag = input.next();
				if(!flag.equals("y")){
					//结算
					account(goods);
				}
			}else{
				System.out.println("没有此商品");
			}
		}while(flag.equals("y"));
	}
	//结算购物车
	private void account(ArrayList<Good> goods) {
		System.out.println("编号\t"+"名称\t"+"数量\t"+"总价");
		//lambda表达式遍历集合，当然是用for循环也ok
		goods.forEach(in->System.out.println(in.getId()+"\t"+in.getName()+
				"\t"+in.getNum()+"\t"+in.getNum()*in.getPrice()));
		//合计
		float sum=0;
		for (int i = 0; i < goods.size(); i++) {
			//对总价求和
			sum += (goods.get(i).getNum())*(goods.get(i).getPrice());
		}
		System.out.println("总计消费:"+sum+"元");
	}
}

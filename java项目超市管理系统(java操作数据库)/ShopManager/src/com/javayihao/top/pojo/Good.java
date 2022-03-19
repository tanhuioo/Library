package com.javayihao.top.pojo;
/**
 * @date 2019-12-9
 * @Description 商品实体
 * @author com.javayihao.top
 */
public class Good {
	//商品编号
	private int id;
	//商品名称
	private String name;
	//商品价格(价格可能涉及到小数，这里使用float,当然真正大型购物平台不会使用float,有兴趣的朋友可以上网了解)
	private float price;
	//库存
	private int num;
	//空参构造
	public Good() {
		super();
	}
	//打印方法
	@Override
	public String toString() {
		return "Good [id=" + id + ", name=" + name + ", price=" + price + ", num=" + num + "]";
	}
	//有参构造，方便初始化对象
	public Good(int id, String name, float price, int num) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.num = num;
	}
	//set get方法
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}

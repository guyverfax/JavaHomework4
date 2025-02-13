package model;

import java.io.Serializable;

public class Porder implements Serializable {
	private Integer id;
	private String  name;
	private Integer apple;
	private Integer banana;
	private Integer lemon;
	
	
	public Porder() {
		super();
	}

	public Porder(String name, Integer apple, Integer banana, Integer lemon) {
		super();
		this.name = name;
		this.apple = apple;
		this.banana = banana;
		this.lemon = lemon;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getApple() {
		return apple;
	}
	public void setApple(Integer apple) {
		this.apple = apple;
	}
	public Integer getBanana() {
		return banana;
	}
	public void setBanana(Integer banana) {
		this.banana = banana;
	}
	public Integer getLemon() {
		return lemon;
	}
	public void setLemon(Integer lemon) {
		this.lemon = lemon;
	}
	
	public String getShow() {
		int sum=(int)(apple*50+banana*20+lemon*30);
		return String.format("顧客名字:%s\n蘋果數量:%d\n香蕉數量:%d\n檸檬數量:%d\n金額:%d元\n", 
				name, apple, banana, lemon, sum);
	}	
	
	public String getShowDetail(String address,String phone) {
		int sum=(int)(apple*50+banana*20+lemon*30);
		return String.format("=====訂單內容=====\n***客戶資料***\n顧客名字:%s\n地址:%s\n電話:%s\n***購買明細***\n蘋果數量:%d\n香蕉數量:%d\n檸檬數量:%d\n總金額:%d元\n", 
				name, address, phone, apple, banana, lemon, sum);
	}	
}

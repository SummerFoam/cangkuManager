package com.pdsu.bean;

import java.util.Date;

public class InputLog {
	private int id;
	private String productName;
	private int productCount;
	private String shouHuo;
	private String jinHuo;
	private Date date1;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	public String getShouHuo() {
		return shouHuo;
	}
	public void setShouHuo(String shouHuo) {
		this.shouHuo = shouHuo;
	}
	public String getJinHuo() {
		return jinHuo;
	}
	public void setJinHuo(String jinHuo) {
		this.jinHuo = jinHuo;
	}
	public Date getDate1() {
		return date1;
	}
	public void setDate1(Date date1) {
		this.date1 = date1;
	}
	@Override
	public String toString() {
		return "InputLog [id=" + id + ", productName=" + productName + ", productCount=" + productCount + ", shouHuo="
				+ shouHuo + ", jinHuo=" + jinHuo + ", date1=" + date1 + "]";
	}
	

}

package com.pdsu.bean;

import java.util.Date;

public class OutputLog {
	private int id;
	private String productName;
	private int productCount;
	private String chuHuo;
	private String shouHuo;
	private Date date2;
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
	public String getChuHuo() {
		return chuHuo;
	}
	public void setChuHuo(String chuHuo) {
		this.chuHuo = chuHuo;
	}
	public String getShouHuo() {
		return shouHuo;
	}
	public void setShouHuo(String shouHuo) {
		this.shouHuo = shouHuo;
	}
	public Date getDate2() {
		return date2;
	}
	public void setDate2(Date date2) {
		this.date2 = date2;
	}
	@Override
	public String toString() {
		return "OutputLog [id=" + id + ", productName=" + productName
				+ ", productCount=" + productCount + ", chuHuo=" + chuHuo
				+ ", shouHuo=" + shouHuo + ", date2=" + date2 + "]";
	}
	

}

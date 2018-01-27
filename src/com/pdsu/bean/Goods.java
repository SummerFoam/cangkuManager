package com.pdsu.bean;

import java.util.Date;

public class Goods {
	private int goodsId;
	private String ofCategoryName;
	private String goodsName;
	private int goodsCount;
	private float goodsPrice;
	private String inputManager;
	private String receiveManager;
	private Date inputDate;
	private String ofRackId;
	private String ofCangId;
	
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getOfCategoryName() {
		return ofCategoryName;
	}
	public void setOfCategoryName(String ofCategoryName) {
		this.ofCategoryName = ofCategoryName;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getGoodsCount() {
		return goodsCount;
	}
	public void setGoodsCount(int goodsCount) {
		this.goodsCount = goodsCount;
	}
	public float getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(float goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getInputManager() {
		return inputManager;
	}
	public void setInputManager(String inputManager) {
		this.inputManager = inputManager;
	}
	public String getReceiveManager() {
		return receiveManager;
	}
	public void setReceiveManager(String receiveManager) {
		this.receiveManager = receiveManager;
	}
	public Date getInputDate() {
		return inputDate;
	}
	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}
	
	public String getOfRackId() {
		return ofRackId;
	}
	public void setOfRackId(String ofRackId) {
		this.ofRackId = ofRackId;
	}
	public String getOfCangId() {
		return ofCangId;
	}
	public void setOfCangId(String ofCangId) {
		this.ofCangId = ofCangId;
	}
	@Override
	public String toString() {
		return "Product [goodsId=" + goodsId + ", ofCategoryName="
				+ ofCategoryName + ", goodsName=" + goodsName + ", goodsCount="
				+ goodsCount + ", goodsPrice=" + goodsPrice + ", inputManager="
				+ inputManager + ", receiveManager=" + receiveManager
				+ ", inputDate=" + inputDate + ", ofRackId=" + ofRackId
				+ ", ofCangId=" + ofCangId + "]";
	}
	
	

}

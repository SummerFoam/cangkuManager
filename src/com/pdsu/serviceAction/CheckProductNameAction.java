package com.pdsu.serviceAction;

import com.opensymphony.xwork2.ActionSupport;
import com.pdsu.impDao.ProductDaoImpl;
import com.pdsu.interfaceDao.ProductDaoInterface;

//在增加商品中判断商品名是否重复
public class CheckProductNameAction extends ActionSupport{
	private String goodsName;
	private String check;
	 
       

	public String getCheck() {
		return check; 
	}

	public void setCheck(String check) {
		this.check = check;
	}

	public String getGoodsName() {  
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String execute(){
		ProductDaoInterface productDaoInterface=new ProductDaoImpl();
		check=productDaoInterface.checkProductName(goodsName);
		return SUCCESS;
	}
   
}

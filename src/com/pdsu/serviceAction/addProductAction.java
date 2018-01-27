package com.pdsu.serviceAction;

import com.opensymphony.xwork2.ActionSupport;
import com.pdsu.bean.Goods;
import com.pdsu.impDao.ProductDaoImpl;
import com.pdsu.interfaceDao.ProductDaoInterface;
//增加商品
public class addProductAction extends ActionSupport{
	private Goods goods;
	
	
	public Goods getGoods() {
		return goods;
	}


	public void setGoods(Goods goods) {
		this.goods = goods;
	}


	public String execute(){ 
		System.out.println("kkkkkkkkkkkkkk");
		ProductDaoInterface productDaoInterface=new ProductDaoImpl();
		String add=productDaoInterface.addProduct(goods);
		return SUCCESS; 
	}

} 

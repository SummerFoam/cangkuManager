package com.pdsu.serviceAction;

import com.opensymphony.xwork2.ActionSupport;
import com.pdsu.impDao.ProductDaoImpl;
import com.pdsu.interfaceDao.ProductDaoInterface;

//É¾³ýÉÌÆ·
public class DeleteProductAction extends ActionSupport{
	private int goodsId;
	

	public int getGoodsId() {
		return goodsId;
	}


	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}


	public String execute(){
		ProductDaoInterface productDaoInterface=new ProductDaoImpl();
		String delete=productDaoInterface.deleteProduct(goodsId);
		return delete;
	}
	
	
	
}

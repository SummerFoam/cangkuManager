package com.pdsu.serviceAction;

import com.opensymphony.xwork2.ActionSupport;
import com.pdsu.bean.Goods;
import com.pdsu.bean.InputLog;
import com.pdsu.impDao.ProductDaoImpl;
import com.pdsu.interfaceDao.ProductDaoInterface;

//���������¼���Ҹ�������
public class InputLogSaveAction extends ActionSupport{
	private InputLog product;
	
	public InputLog getProduct() {
		return product;
	}

	public void setProduct(InputLog product) {
		this.product = product;
	}

	public String execute(){
		ProductDaoInterface productDaoInterface=new ProductDaoImpl();
		productDaoInterface.inputLogSave(product);
		System.out.println(product);
		return SUCCESS;
	}
	

}
 
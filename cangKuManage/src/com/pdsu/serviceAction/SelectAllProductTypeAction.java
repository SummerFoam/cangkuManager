package com.pdsu.serviceAction;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.pdsu.bean.GoodsCategoryBean;
import com.pdsu.impDao.ProductDaoImpl;
import com.pdsu.interfaceDao.ProductDaoInterface;

//得到商品类别
public class SelectAllProductTypeAction extends ActionSupport{

	private List<GoodsCategoryBean> list;
	
	public List<GoodsCategoryBean> getList() {
		return list;
	}

	public void setList(List<GoodsCategoryBean> list) {
		this.list = list;
	}

	public String execute(){
		ProductDaoInterface productDaoInterface=new ProductDaoImpl();
		list=productDaoInterface.getAllProductType();
		return SUCCESS; 
	}
}

package com.pdsu.serviceAction;

import com.opensymphony.xwork2.ActionSupport;
import com.pdsu.bean.Goods;
import com.pdsu.impDao.ProductDaoImpl;
import com.pdsu.interfaceDao.ProductDaoInterface;

import freemarker.template.utility.Execute;
//保存修改后的信息
public class UpdataSaveProductAction extends ActionSupport{
	private Goods goods;
	
	

	public Goods getGoods() {
		return goods;
	}



	public void setGoods(Goods goods) {
		this.goods = goods;
	}


	public String execute(){
		System.out.println("productDaoInterface");
		ProductDaoInterface productDaoInterface=new ProductDaoImpl();
		productDaoInterface.updataSaveProduct(goods);
		System.out.println(goods.getGoodsPrice()+":");
				return SUCCESS;
	}

}

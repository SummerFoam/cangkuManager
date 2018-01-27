package com.pdsu.serviceAction;

import com.opensymphony.xwork2.ActionSupport;
import com.pdsu.bean.Goods;
import com.pdsu.impDao.ProductDaoImpl;
import com.pdsu.interfaceDao.ProductDaoInterface;

//得到要出货的商品名
public class outputLogAction extends ActionSupport{
	private String goodsName;
	private String goodsId;
	
	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String execute(){
	//	System.out.println();
		ProductDaoInterface productDaoInterface=new ProductDaoImpl();
		Goods goods=productDaoInterface.updataFindProduct(goodsId);
	//	System.out.println(goods);
		goodsName=goods.getGoodsName();
		return SUCCESS;
	}
	
}

package com.pdsu.serviceAction;

import com.opensymphony.xwork2.ActionSupport;
import com.pdsu.bean.Goods;
import com.pdsu.impDao.ProductDaoImpl;
import com.pdsu.interfaceDao.ProductDaoInterface;

//得到进货页面中商品名
public class InputLogAction extends ActionSupport{
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
		ProductDaoInterface productDaoInterface=new ProductDaoImpl();
		Goods goods=productDaoInterface.updataFindProduct(goodsId);
		goodsName=goods.getGoodsName();
		return SUCCESS;
	}
	

}

package com.pdsu.serviceAction;

import com.opensymphony.xwork2.ActionContext;
import com.pdsu.bean.GoodsCategoryBean;
import com.pdsu.impDao.GoodsCategoryDaoImpl;

public class AddGoodsCategoryAction {
	private	GoodsCategoryBean  gcd;
	
	
	public GoodsCategoryBean getGcd() {
		return gcd;
	}



	public void setGcd(GoodsCategoryBean gcd) {
		this.gcd = gcd;
	}


	public String execute() throws Exception {
		//System.out.println("rb-------------"+rb);
		String data;
	    GoodsCategoryDaoImpl  goodsCategory=new GoodsCategoryDaoImpl();
	 
	  boolean i=goodsCategory.addGoodsCategory(gcd);
	System.out.println(gcd.getCategoryName());
			if (i==true) {
				data="success";
			}else {
				ActionContext.getContext().put("addcate", "亲，已存在该类别，请重新添加");
				data="error";
				
			}
		return data;
	}

}

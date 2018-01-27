package com.pdsu.serviceAction;

import com.opensymphony.xwork2.ActionSupport;
import com.pdsu.bean.GoodsCategoryBean;
import com.pdsu.impDao.GoodsCategoryDaoImpl;
import com.pdsu.impDao.RackDaoImpl;

public class updateGoodsCategoryAction extends ActionSupport{
private GoodsCategoryBean gcd;

public GoodsCategoryBean getGcd() {
	return gcd;
}
public void setGcd(GoodsCategoryBean gcd) {
	this.gcd = gcd;
}

public String execute() throws Exception {
	
	System.out.println("======"+gcd.getCategoryId());
		String data = null;
	GoodsCategoryDaoImpl gcb2=new GoodsCategoryDaoImpl();
	boolean i =gcb2.updateGoodsCategory(gcd);
	if (i == true) {
		data = "success";
	} else {
		data = "error";
	}
	return data;
}
}

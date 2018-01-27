package com.pdsu.serviceAction;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pdsu.bean.GoodsCategoryBean;
import com.pdsu.bean.RackBean;
import com.pdsu.impDao.GoodsCategoryDaoImpl;
import com.pdsu.impDao.RackDaoImpl;

public class SelectCategoryNameAction extends ActionSupport{
private  GoodsCategoryBean gcd;


public GoodsCategoryBean getGcd() {
	return gcd;
}


public void setGcd(GoodsCategoryBean gcd) {
	this.gcd = gcd;
}


public String execute() throws Exception {
	// TODO Auto-generated method stub
	
	GoodsCategoryDaoImpl gcp=new GoodsCategoryDaoImpl();
	List<GoodsCategoryBean> list=gcp.select(gcd);
	System.out.println("list.get(0):"+list.get(0).getCategoryName());
		ActionContext ac = ActionContext.getContext();
		Map map = ac.getContextMap();
		Object put = map.put(gcd, list.iterator());
		map.put("RBIDList", list);
		System.out.println(list.get(0));
		 ac.put("Category",list.get(0));	
		 ac.put("CategoryName", list.get(0).getCategoryName());
		SelectRackAction2 action=new SelectRackAction2();

		try {
			action.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SUCCESS;
}
}

package com.pdsu.serviceAction;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pdsu.bean.GoodsCategoryBean;
import com.pdsu.bean.RackBean;
import com.pdsu.impDao.GoodsCategoryDaoImpl;
import com.pdsu.impDao.RackDaoImpl;

public class SelectGoodsCategoryAction extends ActionSupport{
	public String execute() throws Exception {
		
		GoodsCategoryDaoImpl gcd=new GoodsCategoryDaoImpl();
		List<GoodsCategoryBean> list=gcd.SelGoodsCategory();
		//syso
		
		ActionContext ac = ActionContext.getContext();
		Map map = ac.getContextMap();
		map.put("GTList", list);
		
		return SUCCESS;
	}
}

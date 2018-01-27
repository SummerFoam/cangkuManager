package com.pdsu.serviceAction;

import java.util.List;
import java.util.Map;

import org.apache.catalina.core.ApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pdsu.bean.RackBean;
import com.pdsu.impDao.GoodsCategoryDaoImpl;

public class SelectRackAction2 extends ActionSupport{
	public String execute() throws Exception {
	
		GoodsCategoryDaoImpl gcd=new GoodsCategoryDaoImpl();
		List<RackBean> list=gcd.SelRack();
		System.out.println(list.get(0));
		
		ActionContext ac = ActionContext.getContext();
		Map map = ac.getContextMap();
		map.put("RBList", list);
		
		return SUCCESS;
	}
}

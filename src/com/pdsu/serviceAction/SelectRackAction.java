package com.pdsu.serviceAction;

import java.util.List;
import java.util.Map;

import org.apache.catalina.core.ApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pdsu.bean.RackBean;
import com.pdsu.impDao.RackDaoImpl;
import com.pdsu.interfaceDao.RackDao;

public class SelectRackAction   extends ActionSupport {

	@Override
	public String execute() throws Exception {
	   	
		RackDaoImpl rackDaoImpl=new RackDaoImpl();
		
		List<RackBean> list=rackDaoImpl.SelRack();
		
		ActionContext ac = ActionContext.getContext();
		Map map = ac.getContextMap();
		map.put("RBList", list);
	
		return SUCCESS;
	}
	
	
	
	
}

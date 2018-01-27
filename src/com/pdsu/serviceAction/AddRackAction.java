package com.pdsu.serviceAction;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pdsu.bean.CangBean;
import com.pdsu.bean.RackBean;
import com.pdsu.impDao.RackDaoImpl;

public class AddRackAction extends ActionSupport {
	private	RackBean  rb;
	
	public RackBean getRb() {
		return rb;
	}

	public void setRb(RackBean rb) {
		this.rb = rb;
	}


	
	@Override
	public String execute() throws Exception {
		//System.out.println("rb-------------"+rb);
		String data;
		RackDaoImpl rackDaoImpl=new RackDaoImpl();
	
	  boolean i=rackDaoImpl.addRac(rb);
			if (i==true) {
				data="success";
			}else {
				
				ActionContext.getContext().put("addRack", "亲，该货架名已存在，请重新填写");	
				data="error";
				
			}
		return data;
	}

	
}

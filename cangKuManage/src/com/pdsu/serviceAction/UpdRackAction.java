package com.pdsu.serviceAction;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pdsu.bean.RackBean;
import com.pdsu.impDao.RackDaoImpl;

public class UpdRackAction  extends ActionSupport{
	private	RackBean  rb;
	
	
	
	public RackBean getRb() {
		return rb;
	}



	public void setRb(RackBean rb) {
		this.rb = rb;
	}



	@Override
	public String execute() throws Exception {
		
		String data = "error";
		RackDaoImpl rackDaoImpl=new RackDaoImpl();
	//	RackBean rb=new RackBean();
	//	rb.setOfCangId("A03");
	//	rb.setRackId("B07");
		boolean i =rackDaoImpl.updateRac(rb);
		
		if (i == true) {
			data = "success";
		} else {
			data = "error";
		}
		return data;
	}
}

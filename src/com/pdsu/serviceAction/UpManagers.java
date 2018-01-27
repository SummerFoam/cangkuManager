package com.pdsu.serviceAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pdsu.bean.Managers;
import com.pdsu.impDao.ManaFaceimp;
import com.pdsu.interfaceDao.ManaFace;

public class UpManagers extends ActionSupport{
	
	
	
	@Override
	public String execute() throws Exception {

		System.out.println("aaaaaaaaaaaaaaaaaaa");
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=ServletActionContext.getRequest().getSession();
		String id=request.getParameter("id");
		if(id.equals("1")){
//			ActionContext.getContext().put("id","超级管理员不准修改");
			return "error";
		}
//		System.out.println(id);
		// TODO Auto-generated method stub
		ManaFace mafa=new ManaFaceimp();
		Managers mana= mafa.QueryManagersById(id);
		//System.out.println(mana);
		ActionContext.getContext().getSession().put("mana",mana);
	
		return SUCCESS;
	}
}

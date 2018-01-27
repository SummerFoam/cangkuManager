package com.pdsu.serviceAction;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pdsu.bean.Managers;
import com.pdsu.impDao.ManaFaceimp;
import com.pdsu.interfaceDao.ManaFace;

public class SelManagers extends ActionSupport{
	
	
	@Override
	public String execute() throws Exception {
		System.out.println("*****************************");
		HttpSession session =ServletActionContext.getRequest().getSession();
		ManaFace mana=new ManaFaceimp();
		List<Managers> list= mana.SelManagers();
		System.out.println(list);
		if(mana!=null&list.size()>0){
			ActionContext.getContext().getSession().put("list", list);
		}
		
		return SUCCESS;
	}
}

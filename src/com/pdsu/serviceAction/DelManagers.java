package com.pdsu.serviceAction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pdsu.bean.Managers;
import com.pdsu.impDao.ManaFaceimp;
import com.pdsu.interfaceDao.ManaFace;

public class DelManagers extends ActionSupport{
	
	
	@Override
	public String execute() throws Exception {
		
		
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=ServletActionContext.getRequest().getSession();
		
		String id=request.getParameter("id");
		
		if(id.equals("1")){
			//System.out.println("**********************");
			return SUCCESS;
		}
			
		ManaFace mana=new ManaFaceimp();
		boolean boo=mana.delMana(id);
		//…æ≥˝∫Û‘Ÿ≤È—Ø
		List<Managers> list= mana.SelManagers();
		if(list!=null&list.size()>0){
		ActionContext.getContext().getSession().put("list", list);
		}
		return SUCCESS;
	}
}

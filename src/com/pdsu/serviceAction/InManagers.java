package com.pdsu.serviceAction;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pdsu.bean.Managers;
import com.pdsu.impDao.ManaFaceimp;
import com.pdsu.interfaceDao.ManaFace;

public class InManagers extends ActionSupport{
	private Managers m;

	public Managers getM() {
		return m;
	}

	public void setM(Managers m) {
		this.m = m;
	}
	@Override
	public String execute() throws Exception {
		System.out.println(m.getPosition()+"*************");
			
		HttpSession session=ServletActionContext.getRequest().getSession();
		ManaFace mana=new ManaFaceimp();
		boolean boo= mana.InSelManager(m);
	//	System.out.println(boo);
		
		if(boo==true){
			ActionContext.getContext().put("noinput", "已存在相同用户名");
			return ERROR;
		}
		
		//System.out.println(m.getPosition());
		if(m.getPosition().equals("普通管理员")){
			mana.addManagers(m);
			
			//添加后再查询
			List<Managers> list= mana.SelManagers();
			if(list!=null&list.size()>0){
			ActionContext.getContext().getSession().put("list", list);
			}
			return SUCCESS;
		}
		
		return ERROR;
	}
	
}

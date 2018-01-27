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

public class UpInManagers extends ActionSupport{
	
	private Managers m;
	
	public Managers getM() {
		return m;
	}

	public void setM(Managers m) {
		this.m = m;
	}

	@Override
	public String execute() throws Exception {
		HttpSession session=ServletActionContext.getRequest().getSession();
		
		ManaFace mafa=new ManaFaceimp();
		Managers mana= mafa.QueryManagersById(m.getId()+"");
	System.out.println(m.getName()+"VVVVVVVVVVV"+mana.getName());
		//先判断修改的用户名是否为原来用户名
		if(m.getName().equals(mana.getName())){
			System.out.println("是原来用户名》》》》》》》》》》》》》");
		boolean boo= mafa.updateMana(m);
		//修改后再查询
			List<Managers> list= mafa.SelManagers();
			if(list!=null&list.size()>0){
			ActionContext.getContext().getSession().put("list", list);
			}
			return SUCCESS;
		}
		//如果不是原来用户名
		boolean ol=mafa.InSelManager(m);
		if(ol==true){
			ActionContext.getContext().put("both","已有相同用户名");
			return ERROR;
		}else{
			boolean boo= mafa.updateMana(m);
			//修改后再查询
			List<Managers> list= mafa.SelManagers();
			if(list!=null&list.size()>0){
			ActionContext.getContext().getSession().put("list", list);
			}
			return SUCCESS;
		}
		
		
	}
}

package com.pdsu.serviceAction;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pdsu.bean.Managers;
import com.pdsu.impDao.ManaFaceimp;
import com.pdsu.interfaceDao.ManaFace;

public class LoginAction extends ActionSupport{
	private Managers managers;
	private String checkCode;
	
	
	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	public Managers getManagers(){
		return managers;
	}

	public void setManagers(Managers managers) {
		this.managers = managers;
	}

	@Override
	public String execute() throws Exception {
		
		HttpSession session=ServletActionContext.getRequest().getSession();
		
		 String checkCode2 = (String)session.getAttribute("checkCode");  
	       
		    if(!checkCode.equals(checkCode2))  
		    {  
		    	ActionContext.getContext().put("yanzheng", "验证码不正确"); 
		        return "error";
		    }  
		
		ManaFace mana=new ManaFaceimp();
		Managers managers2 = mana.selManLogin(managers);
		System.out.println(managers2);
		if(managers2!=null){
		//	ActionContext.getContext().getSession().put("managers2", managers);
	    //System.out.println(managers2.getName(sys));
			session.setAttribute("user", managers2.getName());
			if(managers2.getPosition().equals("超级管理员"))
			{	
			//System.out.println("*&*&*&*&*&*&*&*&*&*&*&");
				return "success";
				
			}else{
				
			return "main";
			
			}
			
		}
		
		ActionContext.getContext().put("error", "输入有误，请重新登录！");
		
		return ERROR;
	}
}

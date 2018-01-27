package com.pdsu.serviceAction;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.pdsu.bean.InputLog;
import com.pdsu.impDao.ProductDaoImpl;
import com.pdsu.interfaceDao.ProductDaoInterface;

//查询进货记录
public class SelectAllInputLogAction extends ActionSupport{
	private List<InputLog> list;
	
	
	public List<InputLog> getList() {
		return list;
	}


	public void setList(List<InputLog> list) {
		this.list = list;
	}


	public String execute(){
		ProductDaoInterface productDaoInterface=new ProductDaoImpl();
		list=productDaoInterface.getAllInputLog();
		return SUCCESS;
	}

}

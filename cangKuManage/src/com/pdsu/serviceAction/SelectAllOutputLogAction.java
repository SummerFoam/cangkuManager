package com.pdsu.serviceAction;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.pdsu.bean.OutputLog;
import com.pdsu.impDao.ProductDaoImpl;
import com.pdsu.interfaceDao.ProductDaoInterface;
//查询出货记录
public class SelectAllOutputLogAction extends ActionSupport{
	private List<OutputLog> list;

	

	public List<OutputLog> getList() {
		return list;
	}



	public void setList(List<OutputLog> list) {
		this.list = list;
	}



	public String execute(){
		ProductDaoInterface productDaoInterface=new ProductDaoImpl();
		list=productDaoInterface.getAllOutputLog();
	//	System.out.println(list.get(0));
		return SUCCESS;
	}
}

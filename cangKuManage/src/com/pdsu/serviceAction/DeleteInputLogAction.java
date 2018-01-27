package com.pdsu.serviceAction;

import com.opensymphony.xwork2.ActionSupport;
import com.pdsu.impDao.ProductDaoImpl;
import com.pdsu.interfaceDao.ProductDaoInterface;
//É¾³ý½ø»õ¼ÇÂ¼
public class DeleteInputLogAction extends ActionSupport{
    private int id;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String execute(){
		ProductDaoInterface productDaoInterface=new ProductDaoImpl();	
	//	System.out.println("hhhhhhhhhh");
		String delete=productDaoInterface.deleteInputLog(id);
		return delete;
	}
	

}

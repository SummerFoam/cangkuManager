package com.pdsu.serviceAction;
import com.opensymphony.xwork2.ActionSupport;

import com.pdsu.impDao.ProductDaoImpl;
import com.pdsu.interfaceDao.ProductDaoInterface;

//�����ӻ��޸���Ʒ��ͨ�������Ѱ�һ��ܺͲֿ�
public class FindRockByCategoryNameAction extends ActionSupport{

	private String categoryName;
	private String he[]=new String[2];
	

  
	public String[] getHe() {
		return he;
	}

 
	public void setHe(String[] he) {
		this.he = he;
	}
 
 
	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public String execute(){
		ProductDaoInterface productDaoInterface=new ProductDaoImpl();
		he=productDaoInterface.getFindRockByCategoryName(categoryName);
		return SUCCESS;
	}
}

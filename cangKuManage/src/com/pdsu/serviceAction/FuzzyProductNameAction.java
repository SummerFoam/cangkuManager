package com.pdsu.serviceAction;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.pdsu.bean.Goods;
import com.pdsu.impDao.ProductDaoImpl;
import com.pdsu.interfaceDao.ProductDaoInterface;
//通过类别名，和商品名模糊查询商品
public class FuzzyProductNameAction extends ActionSupport{
	int pageSize;
	private int pageIndex;
	int currentPage;
	int pageCount;
	

	private String fuzzyName;
	private List<Goods> list;
	
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public List<Goods> getList() {
		return list;
	}
	public void setList(List<Goods> list) {
		this.list = list;
	}
	public String getFuzzyName() {
		return fuzzyName;
	}
	public void setFuzzyName(String fuzzyName) {
		this.fuzzyName = fuzzyName;
	}
	public String execute(){ 
		
		 String  str =null;
		pageSize=8; 
	//	System.out.println(fuzzyName);
		ProductDaoInterface productDaoInterface=new ProductDaoImpl();
		HttpSession session = ServletActionContext.getRequest().getSession(); 
		if(fuzzyName!=null) {
	   session.setAttribute("fuzzyName",fuzzyName);
	     str =  (String) session.getAttribute("fuzzyName");
	   
		}
		
		else {
			str =  (String) session.getAttribute("fuzzyName");
					}
		
	  // System.out.println("==="+str);
		pageCount=productDaoInterface.getFuzzyProductListPageCount(pageSize,str);
		if(pageIndex<1){
			pageIndex=1;
		}else if(pageIndex>pageCount){
			pageIndex=pageCount;
		}
		
			list=productDaoInterface.getFuzzyProductListByFenPage(pageIndex,pageSize,str);
	//	list=productDaoInterface.getProductByFuzzyName(fuzzyName);
		return SUCCESS; 
	}

}

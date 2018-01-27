package com.pdsu.serviceAction;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.pdsu.bean.Goods;
import com.pdsu.impDao.ProductDaoImpl;
import com.pdsu.interfaceDao.ProductDaoInterface;
//查询所有商品
public class SelectAllProductAction extends ActionSupport{
	int pageSize;
	private int pageIndex;
	int currentPage;
	int pageCount;
	private List<Goods> list;
	 
	
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	 
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public List<Goods> getList() { 
		return list;
	}
	public void setList(List<Goods> list) {
		this.list = list;
	}  
	public String execute(){
		pageSize=8; 
		ProductDaoInterface productDaoInterface=new ProductDaoImpl();
		pageCount=productDaoInterface.getProductListPageCount(pageSize);
		if(pageIndex<1){
			pageIndex=1;
		}else if(pageIndex>pageCount){
			pageIndex=pageCount;
		}
	//	list=productDaoInterface.getAllProduct();
		list=productDaoInterface.getProductListByFenPage(pageIndex,pageSize);
		return SUCCESS;
	}

}

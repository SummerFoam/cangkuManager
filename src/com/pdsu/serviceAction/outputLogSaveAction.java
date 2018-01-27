package com.pdsu.serviceAction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pdsu.bean.InputLog;
import com.pdsu.bean.OutputLog;
import com.pdsu.impDao.ProductDaoImpl;
import com.pdsu.interfaceDao.ProductDaoInterface;

//���������¼���Ҹ�������
public class outputLogSaveAction extends ActionSupport{
     private OutputLog product;
	
	

	public OutputLog getProduct() {
		return product;
	}



	public void setProduct(OutputLog product) {
		this.product = product;
	}



	public String execute(){
		ProductDaoInterface productDaoInterface=new ProductDaoImpl();
	    boolean result = productDaoInterface.outputLogSave(product);
	    
	    System.out.println("result:  "+result);
	    
	    if(!result) {
	    	System.out.println("result:  "+!result);
          ActionContext.getContext().put("chu", "�ף����������");
	    	return "error";
	    }
	    
	//	System.out.println(product);
		return SUCCESS;
	}

}

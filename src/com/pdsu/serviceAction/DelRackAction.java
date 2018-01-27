package com.pdsu.serviceAction;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pdsu.bean.RackBean;
import com.pdsu.impDao.RackDaoImpl;

public class DelRackAction  extends ActionSupport{
	private String deleteRackId;
	private List<RackBean> list;
	public String getDeleteRackId() {
		return deleteRackId;
	}
	public void setDeleteRackId(String deleteRackId) {
		this.deleteRackId = deleteRackId;
	}
	public List<RackBean> getList() {
		return list;
	}
	public void setList(List<RackBean> list) {
		this.list = list;
	}
	
	@Override
	public String execute() throws Exception {
		//System.out.println(deleteRackId);
		String data = "error";
		
		RackDaoImpl rackDaoImpl = new RackDaoImpl();
	
		String ofRackId;
		     ofRackId=(deleteRackId);
		boolean b=	rackDaoImpl.isExistGoods(ofRackId);
		
	//	System.out.println(b);
		if (b==true) {
			ActionContext.getContext().put("rack", "亲，该货架有商品，不能删除!");
			data = "error";
		} else {
			RackBean rb = new RackBean();
			rb.setRackId(deleteRackId);
			boolean i = rackDaoImpl.delReck(rb);
			data = "success";
			
		}
		
		return data;
		
	}
	
}

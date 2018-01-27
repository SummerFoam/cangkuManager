package com.pdsu.serviceAction;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pdsu.bean.CangBean;
import com.pdsu.bean.RackBean;
import com.pdsu.impDao.RackDaoImpl;

public class SelRackIDAction  extends ActionSupport  {

	private	RackBean  rb;
	
	
	public RackBean getRb() {
		return rb;
	}


	public void setRb(RackBean rb) {
		this.rb = rb;
	}


	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
RackDaoImpl rackDaoImpl=new RackDaoImpl();
		System.out.println("////////////////////"+rb.getRackId());

    List<RackBean> list=rackDaoImpl.select(rb);
		
		ActionContext ac = ActionContext.getContext();
		Map map = ac.getContextMap();
		Object put = map.put(rb, list.iterator());
	     ac.put("RackId", rb.getRackId());	
	     
	    //ªÒ»°≤÷ø‚ID
	        List<CangBean> list2=rackDaoImpl.SelCang();
			ActionContext ac2 = ActionContext.getContext();
			Map map2 = ac2.getContextMap();
			map2.put("CBList", list2);
	     
	/*	SelectCangAction action = new SelectCangAction();
		try {
			action.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		return SUCCESS;
	}
}

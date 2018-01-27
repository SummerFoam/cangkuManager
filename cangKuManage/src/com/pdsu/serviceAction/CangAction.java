package com.pdsu.serviceAction;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pdsu.bean.CangBean;
import com.pdsu.bean.Goods;
import com.pdsu.impDao.CangDaoImpl;
import com.sun.net.httpserver.Authenticator.Success;

public class CangAction extends ActionSupport{
	private CangBean cangBean;
	private Goods goods;
	
	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	//从页面获取参数cangId cangAdress
	private String cangId;
	private String cangAdress;
	
	public String getCangAdress() {
		return cangAdress;
	}

	public void setCangAdress(String cangAdress) {
		this.cangAdress = cangAdress;
	}

	public String getCangId() {
		return cangId;
	}

	public void setCangId(String cangId) {
		this.cangId = cangId;
	}

	public CangBean getCangBean() {
		return cangBean;
	}

	public void setCangBean(CangBean cangBean) {
		this.cangBean = cangBean;
	}
	
	/*public static void main(String[] args) {
		CangAction action = new CangAction();
	System.out.println("===="+action.delete());
		
	}*/
	
	public String delete(){
		
		CangDaoImpl cd=new CangDaoImpl();
//	    System.out.println("cangku"+cangId);
		boolean b=cd.isExistGoods(cangId);
		
	//	System.out.println();
		if(b){
		//	System.out.println("cangku"+cangId);
			ActionContext.getContext().put("jing", "亲，该仓库有商品 ，不能删除!");
			return "err";
		}
		
		else{
		//	System.out.println("delete()");
			boolean bd=cd.deleteCang(cangId);
		}
		return "delete";
	}
	
	public String update(){
		//System.out.println("123"+cangId);
		
		if(cangId!=null){
			CangDaoImpl cd=new CangDaoImpl();
			CangBean cb=cd.findById(cangId);
			ActionContext.getContext().put("cangId", cb.getCangId());
			ActionContext.getContext().put("cangAdress", cb.getCangAdress());
			//System.out.println(cb.getCangAdress());

			return SUCCESS;
		}
		if(cangBean!=null){
			CangDaoImpl cd=new CangDaoImpl();
			boolean b=cd.updateCang(cangBean);
			if(b){
				return "update";
			}
		}
		return ERROR;
	}
	public String insertCang(){
		CangDaoImpl cd=new CangDaoImpl();
		boolean bl=cd.isExist(cangBean.getCangId());
		if(!bl){
			int i=cd.InsertCang(cangBean);
			if(i!=-1){
				ActionContext actionContext=ActionContext.getContext();
				Map<String,Object> session = actionContext.getSession();
				session.put("cangId", cangBean.getCangId());
				return "insert";
			}else{
			//	ActionContext.getContext().put("jing2", "亲，仓库名已存在，请重新填写!");
				return ERROR;
			}
		}
		else{
			ActionContext.getContext().put("jing2", "亲，仓库名已存在，请重新填写!");
			return ERROR;
		}
	}
	public String findAll(){
		CangDaoImpl cd=new CangDaoImpl();
		List<CangBean> list=cd.findAll();
		ActionContext.getContext().put("list", list);
		return SUCCESS;
	}
	
}

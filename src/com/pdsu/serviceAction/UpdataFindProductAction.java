package com.pdsu.serviceAction;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.pdsu.bean.Goods;
import com.pdsu.bean.GoodsCategoryBean;
import com.pdsu.impDao.ProductDaoImpl;
import com.pdsu.interfaceDao.ProductDaoInterface;


//修改时回显信息
public class UpdataFindProductAction extends ActionSupport{
	private String goodsId;
	private Goods goods;
	private List<GoodsCategoryBean> list;

	public List<GoodsCategoryBean> getList() {
		return list;
	}
	public void setList(List<GoodsCategoryBean> list) {
		this.list = list;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	} 



	public String execute(){
		ProductDaoInterface productDaoInterface=new ProductDaoImpl();
		goods=productDaoInterface.updataFindProduct(goodsId);
		list=productDaoInterface.getAllProductType();
		
		
		for(int i=0;i<list.size();i++){
			GoodsCategoryBean GoodsCategoryBean=list.get(i);
			if(goods.getOfCategoryName().equals(GoodsCategoryBean.getCategoryName())){
				list.remove(GoodsCategoryBean);			
			}
		}	
		return SUCCESS;
	}

}

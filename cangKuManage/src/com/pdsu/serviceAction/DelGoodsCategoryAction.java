package com.pdsu.serviceAction;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pdsu.bean.GoodsCategoryBean;
import com.pdsu.impDao.GoodsCategoryDaoImpl;

public class DelGoodsCategoryAction extends ActionSupport {
	
	private String deleteCategoryId;
//	private List<GoodsCategoryBean> list;


	@Override
	public String execute() throws Exception {
		System.out.println("====="+deleteCategoryId);
		String data = "error";
		 GoodsCategoryDaoImpl  goodsCategory=new GoodsCategoryDaoImpl();
		boolean b=	goodsCategory.isExistGoods(deleteCategoryId);
		if (b==true) {
			ActionContext.getContext().put("cate", "亲，还存该类别的商品，不能删除");
			data = "error";
		} else {
			GoodsCategoryBean gcb=new GoodsCategoryBean();
			gcb.setCategoryName(deleteCategoryId);
			boolean i = goodsCategory.delGoodsCategory(deleteCategoryId);
			
			/*if (i == true) {
				data = "success";
			} else {
				data = "error";
			}
*/
			data = "success";
			
		}
		
		return data;
		
	}





	public String getDeleteCategoryId() {
		return deleteCategoryId;
	}





	public void setDeleteCategoryId(String deleteCategoryId) {
		this.deleteCategoryId = deleteCategoryId;
	}
	
}

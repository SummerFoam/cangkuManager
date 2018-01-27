package com.pdsu.interfaceDao;

import java.util.List;

import com.pdsu.bean.Goods;

import com.pdsu.bean.GoodsCategoryBean;
import com.pdsu.bean.InputLog;
import com.pdsu.bean.OutputLog;

public interface ProductDaoInterface {
	//public List<Goods> getAllProduct();                    //查看商品
	 
	public String deleteProduct(int goodsId);              //删除商品
	
	public List<GoodsCategoryBean> getAllProductType();                               //1.得到所有商品种类
	public String[] getFindRockByCategoryName(String categoryName);  //增加商品                     //2.通过种类名查出仓库名和货架
	public String addProduct(Goods goods);                                        //3.保存商品
	public String checkProductName(String goodsName);                             //4.防止增加商品时重名
	
	public Goods updataFindProduct(String goodsId);               //修改商品                               //1.先查出要修改商品的信息
	public String updataSaveProduct(Goods goods);                                 //2.保存修改的信息

	public int getProductListPageCount(int pageSize);
	public List<Goods> getProductListByFenPage(int pageIndex, int pageSize);

	
	//public List<Goods> getProductByFuzzyName(String fuzzyName);

	public int getFuzzyProductListPageCount(int pageSize, String fuzzyName);


	public List<Goods> getFuzzyProductListByFenPage(int pageIndex,
			int pageSize, String fuzzyName);

	public String inputLogSave(InputLog product);

	public boolean outputLogSave(OutputLog product);

	public List<InputLog> getAllInputLog();

	public String deleteInputLog(int id);

	public List<OutputLog> getAllOutputLog();

	public String deleteOutputLog(int id);
	
	

}         

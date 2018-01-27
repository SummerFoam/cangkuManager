package com.pdsu.interfaceDao;

import java.sql.SQLException;
import java.util.List;

import com.pdsu.bean.CangBean;
import com.pdsu.bean.GoodsCategoryBean;
import com.pdsu.bean.RackBean;

public interface GoodsCategoryDao {
//添加类别
	public List<RackBean> SelRack() throws Exception;
	public boolean addGoodsCategory(GoodsCategoryBean CategoryName) throws SQLException;
//查询类别
	public List<GoodsCategoryBean> SelGoodsCategory() throws Exception;
	
	public List<GoodsCategoryBean> select(GoodsCategoryBean CategoryName) throws Exception;
	// 删除类别
	public  boolean delGoodsCategory(String categoryId) throws SQLException;
	//判断此货架上是否有商品
//	public boolean checkGood(RackBean rackId) throws SQLException;
	public boolean isExistGoods(String CateGoryName)throws SQLException;
	// 修改货架
	public boolean updateGoodsCategory(GoodsCategoryBean CategoryName) throws SQLException;
}

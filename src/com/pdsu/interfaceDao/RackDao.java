package com.pdsu.interfaceDao;

import java.sql.SQLException;
import java.util.List;

import com.pdsu.bean.CangBean;
import com.pdsu.bean.RackBean;

public interface RackDao {
	// 添加货架
	public List<CangBean> SelCang() throws Exception;
	public boolean addRac(RackBean rackId) throws SQLException;

	// 查询货架
	public List<RackBean> SelRack() throws Exception;
	      
	
	public List<RackBean> select(RackBean rackId) throws Exception;
	// 删除货架
	public  boolean delReck(RackBean rackId) throws SQLException;
	//判断此货架上是否有商品
//	public boolean checkGood(RackBean rackId) throws SQLException;
	public boolean isExistGoods(String ofRackId)throws SQLException;
	// 修改货架
	public boolean updateRac(RackBean rackId) throws SQLException;
	
	

	

	

	
}
	

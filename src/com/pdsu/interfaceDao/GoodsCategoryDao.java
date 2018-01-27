package com.pdsu.interfaceDao;

import java.sql.SQLException;
import java.util.List;

import com.pdsu.bean.CangBean;
import com.pdsu.bean.GoodsCategoryBean;
import com.pdsu.bean.RackBean;

public interface GoodsCategoryDao {
//������
	public List<RackBean> SelRack() throws Exception;
	public boolean addGoodsCategory(GoodsCategoryBean CategoryName) throws SQLException;
//��ѯ���
	public List<GoodsCategoryBean> SelGoodsCategory() throws Exception;
	
	public List<GoodsCategoryBean> select(GoodsCategoryBean CategoryName) throws Exception;
	// ɾ�����
	public  boolean delGoodsCategory(String categoryId) throws SQLException;
	//�жϴ˻������Ƿ�����Ʒ
//	public boolean checkGood(RackBean rackId) throws SQLException;
	public boolean isExistGoods(String CateGoryName)throws SQLException;
	// �޸Ļ���
	public boolean updateGoodsCategory(GoodsCategoryBean CategoryName) throws SQLException;
}

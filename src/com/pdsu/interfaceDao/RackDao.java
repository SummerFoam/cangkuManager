package com.pdsu.interfaceDao;

import java.sql.SQLException;
import java.util.List;

import com.pdsu.bean.CangBean;
import com.pdsu.bean.RackBean;

public interface RackDao {
	// ��ӻ���
	public List<CangBean> SelCang() throws Exception;
	public boolean addRac(RackBean rackId) throws SQLException;

	// ��ѯ����
	public List<RackBean> SelRack() throws Exception;
	      
	
	public List<RackBean> select(RackBean rackId) throws Exception;
	// ɾ������
	public  boolean delReck(RackBean rackId) throws SQLException;
	//�жϴ˻������Ƿ�����Ʒ
//	public boolean checkGood(RackBean rackId) throws SQLException;
	public boolean isExistGoods(String ofRackId)throws SQLException;
	// �޸Ļ���
	public boolean updateRac(RackBean rackId) throws SQLException;
	
	

	

	

	
}
	

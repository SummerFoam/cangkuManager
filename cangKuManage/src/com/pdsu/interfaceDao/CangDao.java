package com.pdsu.interfaceDao;

import java.util.List;

import com.pdsu.bean.CangBean;

public interface CangDao {
	public int InsertCang(CangBean cangBean);
	public boolean isExist(String cangId);
	public boolean isExistGoods(String ofCangId);
	public List<CangBean> findAll();
	public CangBean findById(String cangId);
	public boolean updateCang(CangBean cangBean);
	public boolean deleteCang(String cangId);
}

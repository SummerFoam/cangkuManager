package com.pdsu.interfaceDao;

import java.util.List;

import com.pdsu.bean.Goods;

import com.pdsu.bean.GoodsCategoryBean;
import com.pdsu.bean.InputLog;
import com.pdsu.bean.OutputLog;

public interface ProductDaoInterface {
	//public List<Goods> getAllProduct();                    //�鿴��Ʒ
	 
	public String deleteProduct(int goodsId);              //ɾ����Ʒ
	
	public List<GoodsCategoryBean> getAllProductType();                               //1.�õ�������Ʒ����
	public String[] getFindRockByCategoryName(String categoryName);  //������Ʒ                     //2.ͨ������������ֿ����ͻ���
	public String addProduct(Goods goods);                                        //3.������Ʒ
	public String checkProductName(String goodsName);                             //4.��ֹ������Ʒʱ����
	
	public Goods updataFindProduct(String goodsId);               //�޸���Ʒ                               //1.�Ȳ��Ҫ�޸���Ʒ����Ϣ
	public String updataSaveProduct(Goods goods);                                 //2.�����޸ĵ���Ϣ

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

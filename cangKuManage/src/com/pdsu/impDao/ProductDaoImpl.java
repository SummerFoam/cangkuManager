package com.pdsu.impDao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pdsu.bean.Goods;
import com.pdsu.bean.GoodsCategoryBean;
import com.pdsu.bean.InputLog;
import com.pdsu.bean.OutputLog;
import com.pdsu.bean.RackBean;
import com.pdsu.interfaceDao.ProductDaoInterface;
import com.pdsu.util.MySessionFactory;

public class ProductDaoImpl implements ProductDaoInterface{

	
	
	@Override
	public String deleteProduct(int goodsId) {
		Session session=MySessionFactory.getSessionFactory().openSession();
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("from Goods where goodsId=?");
		query.setInteger(0, goodsId);
	    List<Goods> list= query.list();
	    Goods product=list.get(0);
	    session.delete(product);
		trans.commit();
		session.close();
		return "success";
	}

	@Override
	public List<GoodsCategoryBean> getAllProductType() {
		Session session=MySessionFactory.getSessionFactory().openSession();
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("from GoodsCategoryBean");
		List<GoodsCategoryBean> list=query.list();		
	//	System.out.println("===="+list.size());
		trans.commit();
		session.close();
		return list;
	}

	@Override
	public String[] getFindRockByCategoryName(String categoryName) {
		String he[]=new String[2];
		Session session=MySessionFactory.getSessionFactory().openSession();
		Transaction trans=session.beginTransaction();
		
		Query query=session.createQuery("from GoodsCategoryBean where categoryName=?");
		query.setString(0, categoryName);
		List<GoodsCategoryBean> list=query.list();
		System.out.println(list.size());
		
		
		GoodsCategoryBean GoodsCategoryBean=list.get(0);
		he[0]=GoodsCategoryBean.getOfRackid();
		
		query=session.createQuery("from RackBean where rackId=?");
		query.setString(0, GoodsCategoryBean.getOfRackid());
		List<RackBean> list1=query.list();
		
		
		RackBean rack=list1.get(0);
		
		he[1]=rack.getOfCangId();
		System.out.println(rack.getOfCangId());
		trans.commit();
		session.close();
		return he;
	}
	
public static void main(String[] args) {
	ProductDaoImpl daoImpl = new ProductDaoImpl();
	daoImpl.getFindRockByCategoryName("衣服类");
}
	

	@Override
	public String addProduct(Goods goods) {
		Session session=MySessionFactory.getSessionFactory().openSession();
		Transaction trans=session.beginTransaction();

		session.save(goods);
	//	System.out.println("iiiiiiiiiiii"+i);
		
		trans.commit();
		session.close();
		return "success";
	}
 
	@Override
	public String checkProductName(String goodsName) {
		Session session=MySessionFactory.getSessionFactory().openSession();
		Transaction trans=session.beginTransaction();
		String result;

		Query query=session.createQuery("from Goods where goodsName=?");
		query.setString(0, goodsName);
		List<Goods> list=query.list();
		if(list.size()==0) 
		  {
			result="正确";
		     }else{ 
		    	 result="用户名已有，请重新选择";
		     }
		trans.commit();
		session.close();    
		return result;
	} 

	@Override
	public Goods updataFindProduct(String goodsId) {
		Session session=MySessionFactory.getSessionFactory().openSession();
		Transaction trans=session.beginTransaction();

		Query query=session.createQuery("from Goods where goodsId=?");
		query.setString(0, goodsId);
		List<Goods> list=query.list();
		Goods goods=list.get(0);
		 
		trans.commit();
		session.close();
		return goods;
	}

	@Override
	public String updataSaveProduct(Goods goods) {
		Session session=MySessionFactory.getSessionFactory().openSession();
		Transaction trans=session.beginTransaction();
		
		Goods goods2=new Goods();
		goods2=(Goods) session.get(Goods.class,goods.getGoodsId());
		
		goods2.setOfCategoryName(goods.getOfCategoryName());
		goods2.setGoodsCount(goods.getGoodsCount());
		goods2.setGoodsName(goods.getGoodsName());
		goods2.setGoodsPrice(goods.getGoodsPrice());
		goods2.setInputDate(goods.getInputDate());
		goods2.setInputManager(goods.getInputManager());
		goods2.setReceiveManager(goods.getReceiveManager());
		
		 session.update(goods2);
		
		//Query query=session.createQuery("from Goods where goodsId=?");
		//goods2.setGoodsCount(gonds.s);
		//query.setInteger(0, goods2.getGoodsId());
		//List<Goods> list= query.list();
		
		/*System.out.println("list======: "+list.size());
	    Goods product=list.get(0);
	    session.delete(product);*/
	   // session.save(goods);
	    	
		trans.commit();
		session.close();
		return "success";
		
	}

	@Override
	public int getProductListPageCount(int pageSize) {
		int totalPage=0;
		int productCount=getAllProduct();
		if(productCount%pageSize==0){
			totalPage=productCount/pageSize;
		}else{
			totalPage=productCount/pageSize+1;
		}
		//System.out.println(totalPage);////
		return totalPage;
	}
	
	public int getAllProduct() {
		int rowCount = 0;
		Session session=MySessionFactory.getSessionFactory().openSession();
		Transaction trans=session.beginTransaction();
		rowCount=Integer.parseInt(session.createQuery("select count(*) from Goods").uniqueResult().toString());
		//System.out.println(i);///
		trans.commit();
		session.close();
		return rowCount;  
	} 


	@Override
	public List<Goods> getProductListByFenPage(int pageIndex, int pageSize) {
		//System.out.println(pageIndex);
	//	System.out.println(pageSize);
		Session session=MySessionFactory.getSessionFactory().openSession();
		Transaction trans=session.beginTransaction();
		List<Goods> list=new ArrayList<Goods>();
		Query query=session.createQuery("from Goods");
		
		query.setFirstResult((pageIndex-1)*pageSize).setMaxResults(pageSize);
		
		
		
	    list=query.list();
	    
	    
	  /* for(Goods s:list) {
	 //  System.out.println(s.getGoodsName()+"  "+s.getGoodsPrice());
	   } 		*/
		trans.commit();
		session.close();
		return list;
	}

	 
	
	
	
	
	
	@Override
	public List<Goods> getFuzzyProductListByFenPage(int pageIndex, int pageSize,String fuzzyName) {
	
	//	System.out.println(fuzzyName);
		Session session=MySessionFactory.getSessionFactory().openSession();
		Transaction trans=session.beginTransaction();
		
		Query query=session.createQuery("from Goods where goodsName like:name1 or ofCategoryName like:name2");
		query.setString("name1", "%"+fuzzyName+"%");
		query.setString("name2", "%"+fuzzyName+"%");
		query.setFirstResult((pageIndex-1)*pageSize).setMaxResults(pageSize);
		List<Goods> list=query.list();
		
		System.out.println(list.size());
		trans.commit();
		session.close();
		return list;
		
	}

	
	
	@Override
	public int getFuzzyProductListPageCount(int pageSize,String fuzzyName) {
		int totalPage=0;
		int productCount=getFuzzyProduct(fuzzyName);
		if(productCount%pageSize==0){
			totalPage=productCount/pageSize;
		}else{
			totalPage=productCount/pageSize+1;
		}
		//System.out.println(totalPage);////
		return totalPage;
	}

	private int getFuzzyProduct(String fuzzyName) {
		int rowCount = 0;
		Session session=MySessionFactory.getSessionFactory().openSession();
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("select count(*) from Goods where goodsName like:name1 or ofCategoryName like:name2");
		query.setString("name1", "%"+fuzzyName+"%");
		query.setString("name2", "%"+fuzzyName+"%");
		rowCount=Integer.parseInt(query.uniqueResult().toString());
		//System.out.println(i);///
		trans.commit();
		session.close();
		return rowCount; 
	}

	

/*	private void qq(String name) {
		Session session=MySessionFactory.getSessionFactory().openSession();
		Transaction trans=session.beginTransaction();

		Query query=session.createQuery("from Goods where ofCategoryName=?");
		query.setParameter(0, "衣服类");
		List<Goods> list= query.list();
		System.out.println(list.size());
	 //   Goods product=list.get(0);
	  //  session.delete(product);
	  //  session.save(goods);

		trans.commit();
		session.close();
		
	//	return "success";
		
	}
	
	public static void main(String[] args) {
	ProductDaoImpl daoImpl = new ProductDaoImpl();
	daoImpl.qq("gg");
	
	
      }
*/

	public String inputLogSave(InputLog product) {
		Session session=MySessionFactory.getSessionFactory().openSession();
		Transaction trans=session.beginTransaction();

		Query query=session.createQuery("from Goods where goodsName=?");
		query.setString(0, product.getProductName());
		List<Goods> list= query.list();
	    Goods pp=list.get(0);
	    int count=pp.getGoodsCount()+product.getProductCount();
	    pp.setGoodsCount(count);
	    session.save(pp);
		
		session.save(product);
		trans.commit();
		session.close();
		return "success";
		 
	}

	public boolean outputLogSave(OutputLog product) {
		
		boolean b = true;
		
		Session session=MySessionFactory.getSessionFactory().openSession();
		Transaction trans=session.beginTransaction();

		Query query=session.createQuery("from Goods where goodsName=?");
		query.setString(0, product.getProductName());
		List<Goods> list= query.list();
	    Goods pp=list.get(0);
	    
	    int count=pp.getGoodsCount()-product.getProductCount();
	    System.out.println("count: "+count);
	    if(count<0) {
	    	b=false;
	    	return b;
	    }
	    System.out.println("count: "+count);
	    pp.setGoodsCount(count);
	    session.save(pp);
		session.save(product);
		trans.commit();
		session.close();
		return b;
	}

	@Override
	public  List<InputLog> getAllInputLog() {
		Session session=MySessionFactory.getSessionFactory().openSession();
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("from InputLog");
		List<InputLog> list=query.list();
	
		
		trans.commit();
		session.close();
		return list;
	}

	@Override
	public String deleteInputLog(int id) {
		Session session=MySessionFactory.getSessionFactory().openSession();
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("from InputLog where id=?");
		query.setInteger(0, id);
	    List<InputLog> list= query.list();
	    InputLog inputLog=list.get(0);
	    session.delete(inputLog);
		trans.commit();
		session.close();
		return "success";
	}

	@Override
	public List<OutputLog> getAllOutputLog() {
		Session session=MySessionFactory.getSessionFactory().openSession();
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("from OutputLog");
		List<OutputLog> list=query.list();
	
	//	System.out.println(list.get(0));
		trans.commit();
		session.close();
		return list;
	}

	@Override
	public String deleteOutputLog(int id) {
		Session session=MySessionFactory.getSessionFactory().openSession();
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("from OutputLog where id=?");
		query.setInteger(0, id);
	    List<OutputLog> list= query.list();
	    OutputLog outputLog=list.get(0);
	    session.delete(outputLog);
		trans.commit();
		session.close();
		return "success";
	}
	
}

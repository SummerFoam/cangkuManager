package com.pdsu.impDao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.pdsu.bean.Goods;
import com.pdsu.bean.GoodsCategoryBean;
import com.pdsu.bean.RackBean;
import com.pdsu.interfaceDao.GoodsCategoryDao;
import com.pdsu.util.HibernateUtil;


public class GoodsCategoryDaoImpl implements GoodsCategoryDao{
	//先查看货架编号(cheng）
	public List<RackBean> SelRack() throws Exception {

		String hql = "from RackBean";
		List<RackBean> list = null;
		try {
			Session session = HibernateUtil.openSession();
			Transaction trans = session.beginTransaction();
			Query query = session.createQuery(hql);
			list = query.list();
			trans.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
			
			throw new RuntimeException();
		} 
		return list;
	}
	
	// 添加类别(CHENG）
		@Override
		public boolean addGoodsCategory(GoodsCategoryBean CategoryName) throws SQLException {
		
			Session session = HibernateUtil.openSession();
			boolean result = false;
			Transaction trans = null;
			try {
				trans = session.beginTransaction();
				List<GoodsCategoryBean> list = select(CategoryName);
				if (list.size()==0) {
					session.save(CategoryName);
					trans.commit();
					result=true;
				}else return result;
			} catch (Exception e) {
				if(trans!=null)
			     {
				   trans.rollback();
				 }
			//  throw new RuntimeException(e.getMessage());
			}finally{
				if(session!=null&&session.isOpen())
				    session.close();
			}
			return result;
		}
		// 查询类别（cheng）
		@Override
		
		public List<GoodsCategoryBean> SelGoodsCategory() throws Exception{
			
			String hql = "from GoodsCategoryBean";
			List<GoodsCategoryBean> list = null;
			try {
				Session session = HibernateUtil.openSession();
				Transaction trans = session.beginTransaction();
				Query query = session.createQuery(hql);
				list = query.list();
				
				System.out.println("hhhgetCategoryName"+list.get(0).getCategoryName());
				trans.commit();
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
				throw new RuntimeException();
			} 
			return list;
			
		}
	//  修改信息前根据货架编号看详情(CHENG）
		public List<GoodsCategoryBean> select(GoodsCategoryBean CategoryName) throws Exception {
			Session session = HibernateUtil.openSession();
			Transaction trans = null;
			List<GoodsCategoryBean> list;
			try {
				trans = session.beginTransaction();
				Query query=session.createQuery("from GoodsCategoryBean where categoryId=?");
				query.setString(0, CategoryName.getCategoryId());
			//	System.out.println("getCategoryId:"+CategoryName.getCategoryId());
				list=query.list();
				for (GoodsCategoryBean goodsCategoryBean : list) {
				//	System.out.println(goodsCategoryBean.getCategoryName()+" "+goodsCategoryBean.getOfRackid());
				}
				trans.commit();
			} catch (Exception e) {
				if(trans!=null)
			     {
				   trans.rollback();
				 }
			    throw new RuntimeException(e.getMessage());
			}finally{
				if(session!=null&&session.isOpen())
				    session.close();
			}
			return list;
			
		}
		
		/*public static void main(String[] args) {
			GoodsCategoryDaoImpl categoryDaoImpl = new GoodsCategoryDaoImpl();
			try {
				System.out.println(categoryDaoImpl.delGoodsCategory("C01"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}*/
		
		// 删除类别(CHENGFONG）
		@Override
		public  boolean delGoodsCategory(String categoryId) throws SQLException {
			boolean result;
			Session session = HibernateUtil.openSession();
			Transaction trans=null;
			try {
				trans = session.beginTransaction();
				GoodsCategoryBean	 goodsCategoryBean=(GoodsCategoryBean)session.get(GoodsCategoryBean.class, categoryId);
				session.delete(goodsCategoryBean);
				trans.commit();
				result=true;
			} catch (Exception e) {
				if(trans!=null)
			     {
				   trans.rollback();
				 }
			    throw new RuntimeException(e.getMessage());
			}finally{
				if(session!=null&&session.isOpen())
				    session.close();
			}
			return result;
		}
		//判断此类别上是否有商品（CHENG）
		@Override
		public boolean isExistGoods(String ofCategoryId) {
			// TODO Auto-generated method stub
			boolean result=false;
			Session session=HibernateUtil.openSession();
			Transaction trans=null;
			try{
				trans=session.beginTransaction();
				String hql2="from GoodsCategoryBean where categoryId=?";
				Query query2=session.createQuery(hql2);
				query2.setString(0, ofCategoryId);
				List<GoodsCategoryBean> list2=query2.list();
			if(list2.size()>0) {
			//	System.out.println(list2.size());
				String hql="from Goods where ofCategoryName=?";
				Query query=session.createQuery(hql);
				query.setString(0, list2.get(0).getCategoryName());
				List<Goods> list=query.list();
			//	System.out.println(list.size());
			if(list.size()>0) {
				result=true;
					
				}
				}
				/*for (Goods goods : list) {
					System.out.println("//////////////////");
					result=true;
				}*/
				
				trans.commit();
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				if(session!=null){
					session.close();
				}
			}
			return result;
		}
		
		public static void main(String[] args) {
			GoodsCategoryDaoImpl categoryDaoImpl = new GoodsCategoryDaoImpl();
			System.out.println(categoryDaoImpl.isExistGoods("C02"));
			
		}
		
		// 修改类别（CHENG）
		@Override
		public boolean updateGoodsCategory(GoodsCategoryBean CategoryName) throws SQLException{
			boolean result=false;
			Session session = HibernateUtil.openSession();
			Transaction trans=null;
			try {
				trans = session.beginTransaction();
				//System.out.println();
				session.update(CategoryName);
				trans.commit();
				result=true;
			} catch (Exception e) {
				if(trans!=null)
			     {
				   trans.rollback();
				 }
//			    throw new RuntimeException(e.getMessage());
			}finally{
				if(session!=null&&session.isOpen())
				    session.close();
			}
			return result;

		}

	
}

package com.pdsu.impDao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pdsu.bean.CangBean;
import com.pdsu.bean.Goods;
import com.pdsu.bean.RackBean;
import com.pdsu.interfaceDao.RackDao;
import com.pdsu.util.HibernateUtil;
public class RackDaoImpl  implements RackDao{
	
	//先查看仓库编号(成功）
	@Override
	public List<CangBean> SelCang() throws Exception {

		String hql = "from CangBean";
		List<CangBean> list = null;
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
	// 添加货架(成功）
	@Override
	public boolean  addRac(RackBean rackId) throws SQLException {
	
		Session session = HibernateUtil.openSession();
		boolean result = false;
		Transaction trans = null;
		try {
			trans = session.beginTransaction();
			List<RackBean> list = select(rackId);
			if (list.size()==0) {
				session.save(rackId);
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

	// 查询货架（成功）
	@Override
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
//  修改信息前根据仓库编号看详情(调试中）
	public List<RackBean> select(RackBean rackId) throws SQLException {
		Session session =HibernateUtil.openSession();
		Transaction trans = null;
		List<RackBean> list;
		try {
			trans = session.beginTransaction();
			Query query=session.createQuery("from RackBean where rackId=?");
			query.setString(0, rackId.getRackId());
			list=query.list();
			for (RackBean rackBean : list) {
				System.out.println(rackBean.getRackId()+" "+rackBean.getOfCangId());
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
	// 删除货架(成功）
	@Override
	public boolean delReck(RackBean rackId) throws SQLException {
		boolean result;
		Session session = HibernateUtil.openSession();
		Transaction trans=null;
		try {
			trans = session.beginTransaction();
			session.delete(rackId);
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
	//判断此货架上是否有商品（测试通过）
	@Override
	public boolean isExistGoods(String ofRackId) {
		// TODO Auto-generated method stub
		boolean result=false;
		Session session=HibernateUtil.openSession();
		Transaction trans=null;
		try{
			trans=session.beginTransaction();
			String hql="from Goods where ofRackId=?";
			Query query=session.createQuery(hql);
			query.setString(0, ofRackId);
			List<Goods> list=query.list();
			for (Goods goodsBean : list) {
				//System.out.println("//////////////////");
				result=true;
			}
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

	// 修改货架（测试通过）
	@Override
	public boolean updateRac(RackBean rackId) throws SQLException {
		boolean result=false;
		Session session = HibernateUtil.openSession();
		Transaction trans=null;
		RackBean rackbean = null;
		try {
			trans = session.beginTransaction();
			session.update(rackId);
			trans.commit();
			result=true;
		} catch (Exception e) {
			if(trans!=null)
		     {
			   trans.rollback();
			 }
//		    throw new RuntimeException(e.getMessage());
		}finally{
			if(session!=null&&session.isOpen())
			    session.close();
		}
		return result;

	}

	
	
}

package com.pdsu.impDao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pdsu.bean.CangBean;
import com.pdsu.bean.Goods;
import com.pdsu.interfaceDao.CangDao;
import com.pdsu.util.HibernateUtil;

public class CangDaoImpl implements CangDao{

	@Override
	public int InsertCang(CangBean cangBean) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.openSession();
		Transaction trans=null;
		int i=-1;
		try{
			trans=session.beginTransaction();
			session.save(cangBean);
			trans.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session!=null){
				session.close();
			}
		}
		return 0;
	}

	@Override
	public List<CangBean> findAll() {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.openSession();
		Transaction trans=null;
		try{
			trans=session.beginTransaction();
			String hql="from CangBean";
			Query query=session.createQuery(hql);
			List<CangBean> list=query.list();
			trans.commit();
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session!=null){
				session.close();
			}
		}
		return null;
	}

	@Override
	public boolean isExist(String cangId) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.openSession();
		Transaction trans=null;
		int i=-1;
		try{
			trans=session.beginTransaction();
			String hql="from CangBean where cangId=:c";
			Query query=session.createQuery(hql);
			query.setString("c", cangId);
			List<CangBean> list=query.list();
			for(CangBean cb:list){
				return true;
			}
			trans.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session!=null){
				session.close();
			}
		}
		return false;
	}


	@Override
	public boolean updateCang(CangBean cangBean) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.openSession();
		Transaction trans=null;
		try{
			trans=session.beginTransaction();
			CangBean cb= (CangBean) session.get(CangBean.class, cangBean.getCangId());
			cb.setCangAdress(cangBean.getCangAdress());
			session.update(cb);
			trans.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session!=null){
				session.close();
			}
		}
		return true;
	}
	

	@Override
	public CangBean findById(String cangId) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.openSession();
		Transaction trans=null;
		try{
			trans=session.beginTransaction();
			CangBean cangBean=(CangBean) session.get(CangBean.class, cangId);
			trans.commit();
			return cangBean;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session!=null){
				session.close();
			}
		}
		return null;
	}
	
	@Override
	public boolean deleteCang(String cangId) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.openSession();
		Transaction trans=null;
		try{
			trans=session.beginTransaction();
			CangBean cangBean=(CangBean) session.get(CangBean.class, cangId);
			session.delete(cangBean);
			trans.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session!=null){
				session.close();
			}
		}
		return true;
	}

	public static void main(String[] args) {
		CangDaoImpl cangDaoImpl = new CangDaoImpl();
		System.out.println(cangDaoImpl.isExistGoods("A01"));
	}
	
	
	@Override
	public boolean isExistGoods(String ofCangId) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.openSession();
		Transaction trans=null;
		try{
			trans=session.beginTransaction();
			String hql="from Goods where ofCangId=:gd";
			Query query=session.createQuery(hql);
			query.setString("gd", ofCangId);
			/*String hql="from Goods where ofCangId=?";
			Query query=session.createQuery(hql);
			query.setString(1, ofCangId);*/
			
			List<Goods> list=query.list();
			
		//System.out.println(ofCangId+"===  "+list.size());
			
			
			for(Goods goods:list){
				return true;
			}
			
			trans.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session!=null){
				session.close();
			}
		}
		return false;
	}
	

	
}

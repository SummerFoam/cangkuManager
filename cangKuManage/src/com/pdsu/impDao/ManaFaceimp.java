package com.pdsu.impDao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import com.pdsu.bean.Managers;
import com.pdsu.interfaceDao.ManaFace;
import com.pdsu.util.HibernateUtil;

public class ManaFaceimp implements ManaFace{
	
	//登录界面查询
	public Managers selManLogin(Managers mana) throws SQLException {
	Session session=HibernateUtil.openSession();  
	Transaction trans =null;
	Managers managers=null ;
	
try {
		 trans=session.beginTransaction();
		 Query query=session.createQuery("from Managers where name=? and password=?");
//		 System.out.println(user.getUsername());
		 query.setParameter(0, mana.getName());
		 query.setParameter(1, mana.getPassword());
//		 query.setParameter(2, mana.getPosition());
//		 System.out.println(query);
		 List list=query.list();
		// System.out.println(list);
		 if(list.size()>0){
		 managers = (Managers) list.get(0);
		 }
		 trans.commit();
		/* if(list.size()>0) {
			 return true;
		 }else {
			 return false;
		 }*/
}catch(Exception e) {
	    e.printStackTrace();
	    return managers;
}finally {
	 if(session!=null&&session.isOpen())
		 //session的本质就是jdbc的connection，占用很多系统资源，一定要关闭
	    session.close();
	}
   return managers;


}
	
	//查询全部用户
	public List<Managers> SelManagers() throws Exception {
		Session session=HibernateUtil.openSession();  
		Transaction trans =null;
		List<Managers> list=null;
		try{
			trans=session.beginTransaction();
			Query query=session.createQuery("from Managers");
			list=query.list();
			trans.commit();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			trans.commit();
			return list;
		}finally{
			if(session!=null&&session.isOpen())
				 //session的本质就是jdbc的connection，占用很多系统资源，一定要关闭
			    session.close();
		}
		
	}
	
	//添加新用户查询
	public boolean InSelManager(Managers mana) throws SQLException {
		Session session=HibernateUtil.openSession();  
		Transaction trans =null;
	try {
			 trans=session.beginTransaction();
			 Query query=session.createQuery("from Managers where name=?");
//			 System.out.println(user.getUsername());
			 query.setParameter(0, mana.getName());
//			 System.out.println(query);
			 List list=query.list();
			 System.out.println(list);
			 trans.commit();
			 if(list.size()>0) {
				 return true;
			 }else {
				 return false;
			 }
	}catch(Exception e) {
		    e.printStackTrace();
		    return false;
	}finally {
		 if(session!=null&&session.isOpen())
			 //session的本质就是jdbc的connection，占用很多系统资源，一定要关闭
		    session.close();
		}
	}
	
	//添加新用户
	public String addManagers(Managers mana) throws SQLException {
		String u="success";
//		System.out.println(user);
	   Configuration configure = new Configuration().configure();
	   
	   SessionFactory factory = configure.buildSessionFactory();
	   Session session = factory.openSession();
	   Transaction trans = session.beginTransaction();
	   //添加一个雇员
	   Managers man=new Managers();
	   man.setName(mana.getName());
	   man.setPassword(mana.getPassword());
//	   System.out.println(user1);
	   man.setPosition(mana.getPosition());
	   //save user对象到数据库，对象的持久化。
	   session.save(man);///////////////
	   trans.commit();
	   session.close();
	   return u;
}
	
	//根据id查询修改用户
	public Managers QueryManagersById(String id) throws Exception {
		System.out.println(id);
		
		Session session=HibernateUtil.openSession();  
		Transaction trans =null;
		Managers s=null;
		try{
			
			trans=session.beginTransaction();
			s=(Managers) session.get(Managers.class,Integer.valueOf(id));
			System.out.println(s);
			trans.commit();
			
			return s;
			
		}catch(Exception e){
			e.printStackTrace();
			trans.commit();
			return s;
		}finally{
			if(session!=null&&session.isOpen())
				 //session的本质就是jdbc的connection，占用很多系统资源，一定要关闭
			    session.close();
		}
	}
	
	
	//修改用户信息
	public boolean updateMana(Managers mana) throws SQLException{
		//修改对象1.查询出对象2.setXXX修改属性  
		 Session session=HibernateUtil.getCurrentSession();  
		 Transaction trans =null;
		 Managers man = null;
		 try {
			 trans=session.beginTransaction();
			 man=(Managers)session.get(Managers.class,Integer.valueOf(mana.getId()));
			// System.out.println("************************");
			// System.out.println(man);
			 man.setId(mana.getId());
			 man.setName(mana.getName());
			 man.setPassword(mana.getPassword());
			 man.setPosition(mana.getPosition());
			 session.update(man);
			 trans.commit();
			 return true;
		 }catch(Exception e) {
			 if(trans!=null)
			     {
				   trans.rollback();
				 }
			    throw new RuntimeException(e.getMessage());
		 }finally {
			 if(session!=null&&session.isOpen())
				 //session的本质就是jdbc的connection，占用很多系统资源，一定要关闭
			    session.close();
		 }
		 
	}
	
	//删除用户
	public  boolean delMana(String id) throws SQLException{
		//删除对象，1.查询出一个对象 2.删除
		   Session session=HibernateUtil.openSession();
		   Transaction tr=session.beginTransaction();
		   Managers mana = (Managers) session.load(Managers.class, Integer.valueOf(id));
		   session.delete(mana);
		   tr.commit();
		   session.close();
		   return true;
	}
}

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
	
	//��¼�����ѯ
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
		 //session�ı��ʾ���jdbc��connection��ռ�úܶ�ϵͳ��Դ��һ��Ҫ�ر�
	    session.close();
	}
   return managers;


}
	
	//��ѯȫ���û�
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
				 //session�ı��ʾ���jdbc��connection��ռ�úܶ�ϵͳ��Դ��һ��Ҫ�ر�
			    session.close();
		}
		
	}
	
	//������û���ѯ
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
			 //session�ı��ʾ���jdbc��connection��ռ�úܶ�ϵͳ��Դ��һ��Ҫ�ر�
		    session.close();
		}
	}
	
	//������û�
	public String addManagers(Managers mana) throws SQLException {
		String u="success";
//		System.out.println(user);
	   Configuration configure = new Configuration().configure();
	   
	   SessionFactory factory = configure.buildSessionFactory();
	   Session session = factory.openSession();
	   Transaction trans = session.beginTransaction();
	   //���һ����Ա
	   Managers man=new Managers();
	   man.setName(mana.getName());
	   man.setPassword(mana.getPassword());
//	   System.out.println(user1);
	   man.setPosition(mana.getPosition());
	   //save user�������ݿ⣬����ĳ־û���
	   session.save(man);///////////////
	   trans.commit();
	   session.close();
	   return u;
}
	
	//����id��ѯ�޸��û�
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
				 //session�ı��ʾ���jdbc��connection��ռ�úܶ�ϵͳ��Դ��һ��Ҫ�ر�
			    session.close();
		}
	}
	
	
	//�޸��û���Ϣ
	public boolean updateMana(Managers mana) throws SQLException{
		//�޸Ķ���1.��ѯ������2.setXXX�޸�����  
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
				 //session�ı��ʾ���jdbc��connection��ռ�úܶ�ϵͳ��Դ��һ��Ҫ�ر�
			    session.close();
		 }
		 
	}
	
	//ɾ���û�
	public  boolean delMana(String id) throws SQLException{
		//ɾ������1.��ѯ��һ������ 2.ɾ��
		   Session session=HibernateUtil.openSession();
		   Transaction tr=session.beginTransaction();
		   Managers mana = (Managers) session.load(Managers.class, Integer.valueOf(id));
		   session.delete(mana);
		   tr.commit();
		   session.close();
		   return true;
	}
}

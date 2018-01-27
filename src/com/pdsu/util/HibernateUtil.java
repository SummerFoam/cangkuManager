package com.pdsu.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

final public class HibernateUtil {
    private static SessionFactory sessionfactory=null ;
    
    //ThreadLocal�ֲ߳̾�ģʽ
	private static ThreadLocal<Session> threadLocal = new ThreadLocal<>();
	
	
private HibernateUtil() {
	
}
	static {
		sessionfactory = new Configuration().configure().buildSessionFactory();
			}
	
	//���ȫ�µ�session�������ֶ���
	public static Session openSession() {
		
		return sessionfactory.openSession();
	}

	//����session,��ǰsession �Զ��� 
	//hibernate.cfg.xml��������<property name="hibernate.current_session_context_class">threa
  public static Session getCurrentSession() {
	Session session = threadLocal.get();
	
	if(session==null) {
		session = sessionfactory.openSession();
		//����Ϊ�߳�session
		threadLocal.set(session);
		
	}
		return session ;
	}
}

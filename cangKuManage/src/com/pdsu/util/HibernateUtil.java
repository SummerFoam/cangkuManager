package com.pdsu.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

final public class HibernateUtil {
    private static SessionFactory sessionfactory=null ;
    
    //ThreadLocal线程局部模式
	private static ThreadLocal<Session> threadLocal = new ThreadLocal<>();
	
	
private HibernateUtil() {
	
}
	static {
		sessionfactory = new Configuration().configure().buildSessionFactory();
			}
	
	//获得全新的session，必须手动关
	public static Session openSession() {
		
		return sessionfactory.openSession();
	}

	//返回session,当前session 自动关 
	//hibernate.cfg.xml必须配置<property name="hibernate.current_session_context_class">threa
  public static Session getCurrentSession() {
	Session session = threadLocal.get();
	
	if(session==null) {
		session = sessionfactory.openSession();
		//设置为线程session
		threadLocal.set(session);
		
	}
		return session ;
	}
}

package com.yang.demo.Utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	private static Session session;
	
	static {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		StandardServiceRegistry serviceRegistry = registryBuilder.build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
//	获取sessionFactory
	public static  SessionFactory getSessionFactory(){
		return sessionFactory;
	}
//session 获取
	public static Session getSession(){
		session = sessionFactory.getCurrentSession();
		return session;
	}
	
	public static void Close() {
		
		sessionFactory.close();
		
	}
}

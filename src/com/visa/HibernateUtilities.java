package com.visa;

import org.hibernate.HibernateException;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtilities {
	
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	
	static
	{
		try
		{
			Configuration configuration=new Configuration().configure();
			StandardServiceRegistryBuilder serviceBuilder=new StandardServiceRegistryBuilder();
			serviceBuilder.applySettings(configuration.getProperties());
			serviceRegistry=serviceBuilder.build();
			sessionFactory=configuration.buildSessionFactory(serviceRegistry);
			
		}
		
	catch(HibernateException ex)
		{
		System.out.println(ex.getMessage());
		}
		
	}
  
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
		
	}
}

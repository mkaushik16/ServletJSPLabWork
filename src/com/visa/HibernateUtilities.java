package com.visa;

import org.hibernate.HibernateException;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtilities {
	
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	
	static
	{
		StandardServiceRegistry serviceBuilder=new StandardServiceRegistryBuilder().configure().build();
		try
		{
//			Configuration configuration=new Configuration().configure();
		//StandardServiceRegistry serviceBuilder=new StandardServiceRegistryBuilder().configure().build();
//			serviceBuilder.applySettings(configuration.getProperties());
//			serviceRegistry=serviceBuilder.build();
//			sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		sessionFactory = new MetadataSources( serviceBuilder ).buildMetadata().buildSessionFactory();
			
			
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

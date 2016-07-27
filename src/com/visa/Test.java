package com.visa;

import org.hibernate.Session;


public class Test {
	
	public static void main(String[] args)
	{
		
		System.out.println("Hello");
		Session session=HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();
		User user=new User();
		user.setName("Manish");
		user.setGoal(100);
		session.save(user);
		session.getTransaction().commit();
		session.close();
		HibernateUtilities.getSessionFactory().close();
	}

}

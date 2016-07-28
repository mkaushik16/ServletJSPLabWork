package com.visa;

import java.util.Date;

import org.hibernate.Session;


public class Test {
	
	public static void main(String[] args)
	{
		
		System.out.println("Hello");
		Session session=HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();
		User user=new User();
		user.setName("Tanmay");
		user.getHistory().add(new UserHistory(new Date(),"Name set to Tanmay"));
		user.getProteinData().setGoal(200);
		user.getHistory().add(new UserHistory(new Date(),"Goal set to 200"));
		session.save(user);
		session.getTransaction().commit();
		session.beginTransaction();
		User usr=(User)session.get(User.class,1);
		System.out.println(usr.getName());
		System.out.println(usr.getProteinData().getTotal());
		System.out.println(usr.getProteinData().getGoal());
		for(UserHistory hist:usr.getHistory())
		{
			System.out.println(hist.getEntryTime().toString()+" "+hist.getEntry());
		}
		usr.getProteinData().setTotal(usr.getProteinData().getTotal()+50);
		usr.getHistory().add(new UserHistory(new Date(),"Total 50 proteins added"));
		
		session.getTransaction().commit();
		session.close();
		HibernateUtilities.getSessionFactory().close();
	}

}

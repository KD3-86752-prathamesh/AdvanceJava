package com.cdac.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



// this is the boiler plate code which is used  to create the
// session factory for the current application 
public class HibernateUtils {

	private static SessionFactory sessionFactory ; 
	
	static {
		System.out.println("inside the session factory ");
		sessionFactory = new Configuration() 
					.configure()
					.buildSessionFactory() ; 
	}
	
	public static SessionFactory getSessionFactory( ) {
		return sessionFactory ; 
	}
	
}

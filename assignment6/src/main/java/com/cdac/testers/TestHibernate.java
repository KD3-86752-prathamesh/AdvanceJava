package com.cdac.testers;


import static com.cdac.utils.HibernateUtils.getSessionFactory;

import org.hibernate.SessionFactory;
public class TestHibernate {

	public static void main (String [] args) {
		try (SessionFactory sf = getSessionFactory()) {
			System.out.println("hibernate is up  n running ");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}

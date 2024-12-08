package com.cdac.testers;

import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.TeamsDao;
import com.cdac.dao.TeamsDaoImpl; 
public class TesterUpdateMaxAge {

	public static void main (String [] args) {
		
		try (SessionFactory sf = getSessionFactory() ; Scanner sc= new Scanner (System.in)){
		
			TeamsDao teamDao = new TeamsDaoImpl() ; 
			System.out.println("enter team name and new max age to be updated : -");
			if (teamDao.updateMaxAge(sc.next(), sc.nextInt())) {
				System.out.println("success");
			}
			else {
				System.out.println("failure");
			}
			
		}
		catch (Exception e) {
			e.printStackTrace(); 
		}
		
		
	}
	
}

package com.cdac.testers;

import org.hibernate.SessionFactory;

import com.cdac.dao.TeamsDao;
import com.cdac.dao.TeamsDaoImpl;

import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

public class TesterAgeAvgTeams {

	public static void main(String[] args) {
		
		try (SessionFactory sf = getSessionFactory() ;  Scanner sc = new Scanner(System.in)	 ) {
			TeamsDao teamDao = new TeamsDaoImpl() ; 
			System.out.println("enter the age and the batting avg");
			teamDao.getAgeAvgTeamList(sc.nextInt(), sc.nextDouble()).forEach(System.out::println); ; 
			
		}
		catch (Exception  e ) {
			e.printStackTrace();
		}
		
	}

}

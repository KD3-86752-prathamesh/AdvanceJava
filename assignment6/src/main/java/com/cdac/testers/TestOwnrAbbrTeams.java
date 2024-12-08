package com.cdac.testers;

import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.TeamsDao;
import com.cdac.dao.TeamsDaoImpl;

public class TestOwnrAbbrTeams {

	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory() ;  Scanner sc = new Scanner(System.in)	 ) {
			TeamsDao teamDao = new TeamsDaoImpl() ; 
			System.out.println("enter the age and the batting avg to get the Owner and abbreviation of the teams");
			teamDao.getOwnrAbbrTeamList(sc.nextInt(), sc.nextDouble()).forEach(Teams -> System.out.println(Teams.getOwner() +" " + Teams.getAbbreviation())); ; 
			
		}
		catch (Exception  e ) {
			e.printStackTrace();
		}
	}

}

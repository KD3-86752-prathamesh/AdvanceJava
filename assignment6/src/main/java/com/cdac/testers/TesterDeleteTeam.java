package com.cdac.testers;

import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.TeamsDao;
import com.cdac.dao.TeamsDaoImpl;
public class TesterDeleteTeam {

	public static void main(String[] args) {
		
		try (SessionFactory sf = getSessionFactory() ; Scanner sc = new Scanner(System.in)  ) {
		TeamsDao teamDao = new TeamsDaoImpl() ; 
		System.out.println("enter team id to be deleted ");
		System.out.println(teamDao.deleteTeams(sc.nextLong()));  ; 
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

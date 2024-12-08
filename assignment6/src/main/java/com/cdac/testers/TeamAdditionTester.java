package com.cdac.testers;

import org.hibernate.SessionFactory;

import com.cdac.dao.TeamsDao;
import com.cdac.dao.TeamsDaoImpl;
import com.cdac.entities.Teams;

import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

public class TeamAdditionTester {

	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory();
				Scanner sc=new Scanner(System.in)) {
			//create team dao instance
			TeamsDao teamsDao =new TeamsDaoImpl();
			System.out.println("Enter teams details - String name, "
					+ "String abbrevation, String owner, int maxPlayerAge , "
					+ "int battingAvg, int wicketsTaken \r\n");
			Teams newTeam=new Teams(sc.next(), sc.next(), sc.next(), sc.nextInt(), 
					sc.nextInt() ,sc.nextInt());
			System.out.println(teamsDao.addTeam(newTeam));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

package com.cdac.testers;

import org.hibernate.SessionFactory;

import com.cdac.dao.TeamsDao;
import com.cdac.dao.TeamsDaoImpl;

import static com.cdac.utils.HibernateUtils.getSessionFactory;

public class TesterDisplayAll {

	public static void main(String[] args) {
	
		try (SessionFactory sf = getSessionFactory()) {
			// create teams  dao instance
			TeamsDao teamsDao = new TeamsDaoImpl();
			teamsDao.getAllTeamList().forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

package com.cdac.dao;

import static com.cdac.utils.HibernateUtils.getSessionFactory  ; 
import org.hibernate.*;

import com.cdac.entities.Teams;
import java.io.Serializable;
import java.util.List;

import static com.cdac.utils.HibernateUtils.getSessionFactory;

import javax.transaction.Transaction;

public class TeamsDaoImpl implements TeamsDao {
	String mesg = "user registration failed !!!!!!!!!!!";

	@Override
	public String addTeam(Teams team) {

		// step one) get the session from sssessionFactory ; 
		
		Session session  = getSessionFactory().getCurrentSession(); 
			
		org.hibernate.Transaction tx =  session.beginTransaction();
		
		try {
			Serializable teamId = session.save(team) ; 
			
			tx.commit();
			mesg = "team addition done " ; 
		}catch (RuntimeException e) {
			
			if(tx != null) {
				tx.rollback();
			}
			throw  e ; 
		}
		
			
		return mesg;
	}

	@Override
	public List<Teams> getAllTeamList() {
		
		String jpql = "select T from Teams T" ; 
		List <Teams> teamList ; 
		
		Session session = getSessionFactory().getCurrentSession() ; 
		
		org.hibernate.Transaction tx = session.beginTransaction() ; 
		
		try {
			teamList=  session.createQuery(jpql, Teams.class).getResultList() ; 
			tx.commit(); // connection is closed , flush , l1 cache is distroyed 
		}
		catch (RuntimeException e){
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			throw e ; 
		}
		
		return teamList;
	}

	@Override
	public List<Teams> getAgeAvgTeamList(int age, double avg) {
		String jpql =  "select T from Teams T where T.maxPlayerAge <= :ag and T.battingAvg >= :avg" ; 
		
		List <Teams> teamAgeAvgList ; 
		Session session = getSessionFactory().getCurrentSession() ; 
		
		org.hibernate.Transaction tx = session.beginTransaction() ; 
		
		try {
			teamAgeAvgList = session.createQuery(jpql, Teams.class).setParameter("ag", age).setParameter("avg", avg).getResultList() ; 
			tx.commit();
		}
		catch (RuntimeException e) {
			if (tx != null ) {
				tx.rollback(); 
			}
			throw e ; 
		}
		
		
		
		return teamAgeAvgList;
	}

	@Override
	public List<Teams> getOwnrAbbrTeamList(int age, double avg) {
String jpql =  "select new com.cdac.entities.Teams(abbreviation ,owner)  from Teams T where T.maxPlayerAge <= :ag and T.battingAvg >= :avg" ; 
		
		List <Teams> teamOwnrAbbrList ; 
		Session session = getSessionFactory().getCurrentSession() ; 
		
		org.hibernate.Transaction tx = session.beginTransaction() ; 
		
		try {
			teamOwnrAbbrList = session.createQuery(jpql, Teams.class).setParameter("ag", age).setParameter("avg", avg).getResultList() ; 
			tx.commit();
		}
		catch (RuntimeException e) {
			if (tx != null ) {
				tx.rollback(); 
			}
			throw e ; 
		}
		
		
		
		return teamOwnrAbbrList;
	}

	@Override
	public boolean updateMaxAge(String teamName , int maxAge) {
		boolean success  ; 
		
		Session session = getSessionFactory().getCurrentSession() ; 
		
		org.hibernate.Transaction tx =  session.beginTransaction() ; 
		
		try {
			String jpql = "select T from Teams T where T.name = :name" ; 
			Teams team = session.createQuery(jpql , Teams.class).setParameter("name", teamName).getSingleResult() ; 
			team.setMaxPlayerAge(maxAge); 
			tx.commit();
			success = true ;
		}
		catch (RuntimeException e) {
			if (tx != null ) {
				tx.rollback();  
			}
			throw e ; 
		}
		
		return success ;
	}

	@Override
	public String  deleteTeams(Long teamId) {
	String result ; 
		Teams team ; 
		Session session = getSessionFactory().getCurrentSession() ; 
		org.hibernate.Transaction tx = session.beginTransaction() ; 
		
		try {
			team = session.get(Teams.class, teamId) ; 
			
			if (team!= null) {
				session.delete(team);
				
			}
			tx.commit();  
			result  = "deleted" ;  
			
		}
		catch (RuntimeException e) {
			if (tx!= null ) {
				tx.rollback();  
			}
			throw e  ; 
		}
		return result ;
	}

}

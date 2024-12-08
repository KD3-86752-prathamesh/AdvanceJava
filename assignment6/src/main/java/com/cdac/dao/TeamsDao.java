package com.cdac.dao;

import java.util.List;

import com.cdac.entities.Teams;


public interface TeamsDao {
	
	String addTeam (Teams team)  ; 
	List<Teams>  getAllTeamList() ; 
	List<Teams>  getAgeAvgTeamList( int age , double  avg) ; 
	List<Teams> getOwnrAbbrTeamList (int age , double avg) ; 
	boolean updateMaxAge(String teamName, int maxAge); 

	String deleteTeams(Long teamId); 

	
}

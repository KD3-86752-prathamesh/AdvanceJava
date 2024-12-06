package com.sunbeam.beans;

import java.util.ArrayList;
import java.util.List;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.Candidate;

public class ResultBean {
	
	private int candId ; 
	
	private List<Candidate> candList  ; 
	
	public ResultBean () {
		candList = new  ArrayList<Candidate>()  ; 
	}

	public int getCandId() {
		return candId;
	}

	public void setCandId(int candId) {
		this.candId = candId;
	}

	public List<Candidate> getCandList() {
		return candList;
	}

	public void setCandList(List<Candidate> list) {
		this.candList = list;
	}
	
	public void  getResult() {
		
		try(CandidateDao canDao = new CandidateDaoImpl()) {
			candList = canDao.findAll() ; 
			
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
	
	
	

}

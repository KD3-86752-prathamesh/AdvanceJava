package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

public class VoteBean {

	
	private int candidate ; 
	private int userId ; 
	private boolean success ; 
	
	public VoteBean() {
		this.success  = false ; 
	}
	
	public void doVote() {
		
		try( CandidateDao canDao = new CandidateDaoImpl()) {
			int count = canDao.incrVote(this.candidate)  ; 
			if (count == 1) {
				try(UserDao usrDao = new UserDaoImpl()) { 
					User user =  usrDao.findById(this.userId) ; 
					if (user!= null) {
						user.setStatus(1);
						count = usrDao.update(user) ; 
						if (count == 1) {
							this.success = true ; 
						}
						
					}
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

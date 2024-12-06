package com.sunbeam.beans;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

public class LoginBean {
	
	private String email ; 
	private String password ; 
	private boolean success ; 
	private User user ; 
	
	
	public LoginBean () {
		this.success = false ; 
	}
	
	public void loginUser() {
		
		try(UserDao usrDao = new UserDaoImpl()) {
		 user = usrDao.findByEmail(email) ; 
			
		if (user.getPassword().equals(this.password))  {
			success = true ; 
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	

}

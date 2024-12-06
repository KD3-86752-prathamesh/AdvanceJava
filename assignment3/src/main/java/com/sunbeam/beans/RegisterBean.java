
package com.sunbeam.beans;

import java.sql.Date;

import javax.servlet.ServletException;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

public class RegisterBean {
	
	private String fname ; 
	private String lname ; 
	private String email ; 
	private String password ; 
	private String date; 
	private boolean success ; 
	
	
	public void RegisterBean () {
		this.success = false ; 
	}
	
	public void registerUser() throws ServletException {
		try(UserDao usrDao = new  UserDaoImpl()) {
			Date date1 = Date.valueOf(date) ; 
			User usr = new User(0,fname , lname , email , password ,date1 ,0 ,"voter") ; 
		usrDao.save(usr) ; 
			success = true  ; 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException(e) ; 
		}
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	

}

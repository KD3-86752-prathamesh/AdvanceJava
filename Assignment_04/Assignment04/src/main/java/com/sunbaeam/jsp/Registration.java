package com.sunbaeam.jsp;

import java.sql.Date;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

public class Registration {

	private String fname;
	private String lname;
	private String email;
	private String passwd;
	private String dob;
	int u;
	
	
	public int getU() {
		return u;
	}


	public void setU(int u) {
		this.u = u;
	}

	
	
	
	public Registration() {
	
	}


	public Registration(String fname, String lname, String email, String passwd, String dob) {

		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.passwd = passwd;
		this.dob = dob;
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


	public String getPasswd() {
		return passwd;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}	
	
	public void saveUser() {
		

		Date birth = Date.valueOf(dob);
		
		User user = new User(0, lname, fname, email, passwd, birth, 0, "Voter");
		try(UserDao userDao = new UserDaoImpl()) {
		u = userDao.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

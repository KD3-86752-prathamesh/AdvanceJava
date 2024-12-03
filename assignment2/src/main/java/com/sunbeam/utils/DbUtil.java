/**
 * Course: Advanced Computing (DAC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Nov 5, 2024
 */

package com.sunbeam.utils;
// three things you have  to do , fields , static block and forname("driver" )  , and then create function  which will send the object of the connection 
import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
	// basic  class declare the fields of the class which will comman and will be used  for the conneciotn building 
	public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/kdacdb";
	public static final String DB_USER = "KD3_86752_prathamesh";
	public static final String DB_PASSWD = "manager";
	
	static { // this is static block which will be loaded and executed only one  while class loading 
		// load and register driver 
		try {            // this is the first step in the which we are loading hte our driver that we have added into our project  to the drivermanger so driver manager is been able to build  the connection  
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	 
	// here we have then  made  one funciton which sends the object of the  connection for the  for our connections 
	public static Connection getConnection() throws Exception {
		Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
		return con;
	}
}

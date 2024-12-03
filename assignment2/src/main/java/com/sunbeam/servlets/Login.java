package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.filters.ExpiresFilter.XPrintWriter;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;
@WebServlet("/login")
public class Login  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req , resp) ; 
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req , resp) ; 
	}
	
	protected void processRequest (HttpServletRequest req , HttpServletResponse resp) {
		
		String name = req.getParameter("username") ; 
		String password = req.getParameter("password") ; 
		
		try(UserDao userDao = new  UserDaoImpl()) {
			User dbUser = userDao.findByEmail(name) ; 
			if (dbUser != null && dbUser.getPassword().equals(password)) {
				Cookie c1 = new Cookie ("uname" , dbUser.getFirstName()); 
				c1.setMaxAge(10);
				resp.addCookie(c1);
				Cookie c2 = new Cookie ("role" , dbUser.getRole()) ; 
				if(dbUser.getRole().equals("admin"))  {
					resp.sendRedirect("result");
				}
				else {
					
					resp.sendRedirect("candidatelist");
				}
				
			}
			else {
				resp.setContentType("text/html");
				PrintWriter out = resp.getWriter() ; 
				out.println("<html>");
								out.println("<head>");
								out.println("<title>Login</title>");
								out.println("</head>");
								out.println("<body>");
								out.println("<h2>Login Failed</h2>");
								out.println("<p>Sorry, Invalid email or password.</p>");
								out.println("<p><a href='index.html'>Login Again</a></p>");
								out.println("</body>");
								out.println("</html>");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}

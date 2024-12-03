package com.sunbeam.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;


@WebServlet("/registerCandidate")
public class RegisterCandidateServlet  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest (req , resp) ; 
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest (req , resp) ; 	
	}
	
	protected void processRequest (HttpServletRequest req , HttpServletResponse resp ) throws ServletException , IOException{
		
	String name = req.getParameter("name") ; 
	String party = req.getParameter("party") ; 
	
	
	try (CandidateDao  canDap = new CandidateDaoImpl())   { 
		
		Candidate cand = new Candidate(0 , name , party , 0) ; 
		
		canDap.save(cand) ; 
		resp.sendRedirect("result");
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	
	
}

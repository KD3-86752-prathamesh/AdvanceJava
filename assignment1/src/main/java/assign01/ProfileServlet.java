package assign01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/info")
public class ProfileServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html") ; 
		
		PrintWriter out = resp.getWriter() ; 
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>") ;
		out.println("<body bgcolor='pink'>");
		out.println("<h1 style='text-align: center'>welcome to my profile</h1>") ; 
		out.println("</br>") ; 
		out.println("<h3>Name: Prathamesh </h3>"); 
		out.println("</br>") ; 
		out.println("<h3>LastName: Hendre</h3>");
		out.println("</br>") ; 
		out.println("<h3>Qualification: BE in Computer Engineering</h3>");
		out.println("</br>") ; 
		out.println("<h3>College : Wadia College Of Engineering Pune</h3>");
		out.println("</br>") ; 
		out.println("<h3> Birth Date: 12/08/2002</h3>");
		
		out.println("</body>") ; 
		out.println("</html>") ; 
		
	}
	
}

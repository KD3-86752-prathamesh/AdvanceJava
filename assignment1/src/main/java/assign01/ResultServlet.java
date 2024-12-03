package assign01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/marks")
public class ResultServlet extends HttpServlet {

	ArrayList<Marks> result ; 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html") ; 
		
		PrintWriter out = resp.getWriter() ; 
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>") ;
		out.println("<body bgcolor='pink'>");
		out.println("<table border='1'>"); 
		out.println("<thead>") ;
		
		 out.println("<tr>");
		 out.println("<td>marks <td>") ; 
		 out.println("<td>subject<td>") ; 
		 out.println("</tr>");
		 

		
		out.println("</thead>") ; 
		out.println("<tbody>"); 
		for(Marks m:result) {
			 out.println("<tr>");
			 out.printf("<td>%s<td>\r\n", m.getSubject());
			 out.printf("<td>%.2f<td>\r\n", m.getMarks());
			 out.println("</tr>");
			}
		out.println("</tbody>"); 
		out.println("</table>"); 
		out.println("</body>") ; 
		out.println("</html>") ; 
		
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		result = new ArrayList<>()  ; 
		result.add(new Marks ( 80.0 , "java programming")) ; 
		result.add(new Marks ( 85.0 , "web programming") ) ;
		result.add(new Marks (83.0 , "database technology")) ; 
	}
	
	
	
	
	
}

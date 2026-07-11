

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;




@WebServlet("/firstServlet")
public class FirstServletApp extends HttpServlet {
	
	public FirstServletApp()
	{
		System.out.println("Servlet obj is created internally by container");
	}
  	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name = request.getParameter("uname");
		String ucity = request.getParameter("ucity");
		
		PrintWriter writer = response.getWriter();
		
//		writer.println("Hello " + name);
//		writer.println("I know you're from "+ucity);
		
		writer.println("<html><head><title>Second App</title></head>");
		writer.println("<body bgcolor='cyan'><h1><marquee> Welcome to our dynamic app </marquee></h1>");

		writer.println("<table>");
		writer.println("<tr><th>NAME</th><th>CITY</th></tr>");
		writer.println("<tr><td>" + name + "</td><td>" + ucity + "</td></tr>");

		writer.println("</table></body>");
		writer.println("</html>");
		
		writer.close();
		
		
	}

}

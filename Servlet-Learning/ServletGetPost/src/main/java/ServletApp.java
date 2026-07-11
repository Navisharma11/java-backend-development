

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/ServletApp")
public class ServletApp extends HttpServlet {


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("Control in servlet/controller");
		
          String name = request.getParameter("uname");
          String city = request.getParameter("ucity");
          
          if(name.equals("Rohan") && city.equals("Pune"))
          {
        	  System.out.println("Success! He is the right Rohan Logged in");
          }
          else
          {
        	  System.out.println("Diff Rohan logged in");
          }
	}

	

}

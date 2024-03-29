package Display;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {

@Override
public void doGet(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException {
	// Set the response message's MIME type
    response.setContentType("text/html;charset=UTF-8");

try
{	    
	System.out.println("Login action");

     UserBean user = new UserBean();
     Transaction t = new Transaction();
     user.setUserName(request.getParameter("un"));
     user.setPassword(request.getParameter("pw"));
     user.setAccountType(request.getParameter("at"));

     user = UserDAO.login(user);
     String transactions = t.transaction(user);
     System.out.print("Check account type = "+user.getAccountType());
	  System.out.print("Transactions"+ transactions); 		    
     if (user.isValid())
     {
	        
          HttpSession session = request.getSession(true);	    
          session.setAttribute("currentSessionUser",user); 
          response.sendRedirect("userLogged.jsp"); //logged-in page  
         // getServletContext().getRequestDispatcher("/userLogged.jsp").forward(request, response);  
     }
	        
     else 
          response.sendRedirect("invalidLogin.jsp"); //error page 
} 
		
		
catch (Throwable theException) 	    
{
     System.out.println(theException); 
}
       }
	}

				

package org.OnlineServlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ManServlet
 */
@WebServlet("/ManServlet")
public class ManServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("user");
		String password=request.getParameter("pass");
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		if(username.equals("user") && password.equals("pass"))
		{
			
			RequestDispatcher rd1=request.getRequestDispatcher("man2.jsp");
			
			request.setAttribute("SUCCESS", null);
			
			rd1.forward(request,response);
			
		}
		else
		{
			out.println("<font color=red>INVALID USERNAME OR PASSWORD</font><br>");
			out.println("<a href='manlog.jsp'>TRY AGAIN</a>");
			
		}
		  
	}

}

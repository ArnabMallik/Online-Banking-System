package org.OnlineServlet;

import online.dao.*;
import java.io.*;
import java.sql.SQLException;

import online.dao.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;



/**
 * Servlet implementation class SuccessServlet
 */
@WebServlet("/SuccessServlet")
public class SuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuccessServlet() {
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
		
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		 response.setContentType("text/html");
		  
		  PrintWriter out=response.getWriter();
		  
		  try {
			  CustomerDAO obj=new CustomerDAO();
			  
			  boolean ob=obj.check(username,password);
			  
			  if(ob==true)
			  {
				  
				  HttpSession s=request.getSession(true);
				  s.setAttribute("SEND", username);
				 
				  try {
					  CustomerDAO obj1=new CustomerDAO();
					  
					  String user=obj1.getname(username);
					  s.setAttribute("NAME", user);
					  //Customer c=obj1.ck(username);
					
			  
				  //out.println("<MARQUEE><H2>WELCOME CUSTOMER</H2></MARQUEE>");
				 
				  RequestDispatcher rd=request.getRequestDispatcher("useacc.jsp");
				  request.setAttribute("SUCCESS",user);
				  rd.forward(request,response);
				  
				  }
				  
				  
				  
				  catch(ClassNotFoundException e)
				  {
					  e.printStackTrace();
					  
					 // out.println("<b> Class Loading Error!! "+e.getMessage()+"</b>");
				  }
				  
				  catch(SQLException e)
				  {
					  e.printStackTrace();
					  //out.println("<b> SQL Error!! "+e.getSQLState()+"</b>");
				  }
				  
			  }
			  else
			  {
				  out.println("<font color=red>INVALID USERNAME OR PASSWORD</font><br>");
					out.println("<a href='view.jsp'>TRY AGAIN</a>");
				  
			  }
			  
		  }
			  catch(ClassNotFoundException e)
			  {
				  e.printStackTrace();
				  
				  out.println("<b> Class Loading Error!! "+e.getMessage()+"</b>");
			  }
			  
			  catch(SQLException e)
			  {
				  e.printStackTrace();
				  out.println("<b> SQL Error!! "+e.getSQLState()+"</b>");
			  }
			  
			  out.close();
		  
		
		

	}

}

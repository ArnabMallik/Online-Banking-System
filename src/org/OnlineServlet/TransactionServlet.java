package org.OnlineServlet;

import java.io.*;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import online.dao.CustomerDAO;

/**
 * Servlet implementation class TransactionServlet
 */
@WebServlet("/TransactionServlet")
public class TransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransactionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	response.setContentType("text/html");
	
	String str=request.getParameter("username");
	
	System.out.println(str);
	
	PrintWriter out=response.getWriter();
	
	 try {
		  CustomerDAO obj=new CustomerDAO();
		  
		  boolean b=obj.checkname(str);
		  
		 if(b==true)
		 {
			 
				
				RequestDispatcher rd1=request.getRequestDispatcher("transfermoney.jsp");
				
				request.setAttribute("SUCCESS",str);
				
				rd1.forward(request,response);
				
		 }
		 
		 else 
		 {
			 out.println("<b>INVALID USERNAME</b><br>");
		 out.println("<a href='transfer.jsp'>TRY AGAIN</a>");
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
	

	

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

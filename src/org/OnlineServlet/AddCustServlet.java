package org.OnlineServlet;

import online.dao.*;

import java.io.*;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class AddcustServlet
 */
@WebServlet("/AddCustServlet")
public class AddCustServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCustServlet() {
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
		
		String name=request.getParameter("NAME");
		String DOB=request.getParameter("DOB");
		String email=request.getParameter("EMAIL");
		String acctype=request.getParameter("ACCOUNTTYPE");
		//String accno=request.getParameter("accountno");
		String username=request.getParameter("USERNAME");
		String password=request.getParameter("PASSWORD");
		double balance=Double.parseDouble(request.getParameter("BALANCE"));
		String pan=request.getParameter("PAN_NO");
		
		
		Customer c=new Customer(name,DOB,email,acctype,username,password,balance,pan);
		
		 response.setContentType("text/html");
		  
		  PrintWriter out=response.getWriter();
		  

		  try {
			  CustomerDAO obj=new CustomerDAO();
			  
			  obj.create(c);
			  
			  int accno=obj.getno(username);
			  Account a=new Account(accno,balance);
			  AccountDAO ac=new AccountDAO();
			  ac.create(a);
			  
			  
			  
			  out.println("<br><br><br><center>Database Updated\nCustomer added successfully....</center><br><br>");
			  
			  out.println("<center><a href='man2.jsp'>ADD MORE CUSTOMERS</a></center><br><br>");
			  out.println("<center><a href='firstpage.jsp'>Log out</a></center>");
			  
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

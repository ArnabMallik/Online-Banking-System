package org.OnlineServlet;

import online.dao.*;


import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SentServlet
 */
@WebServlet("/SentServlet")
public class SentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	response.setContentType("text/html");
	
	PrintWriter out=response.getWriter();
	
	HttpSession s=request.getSession(false);
	
	String username=(String)s.getAttribute("SEND");
	
	int source_id=Store.getsource();
	
	int destination_id=Store.getdest();
	
	
	
	double amount=Double.parseDouble(request.getParameter("amount"));
	
	
	 Transaction t_source=new Transaction(Gettime.get_date(),"DEBIT",amount,source_id);
	 
	  Transaction t_destination=new Transaction(Gettime.get_date(),"CREDIT",amount,destination_id);
	
	
	 try {
		 
		 
		 
		// CustomerDAO obj=new CustomerDAO();
		
		 TransactionDAO ob=new TransactionDAO();
		 
		 ob.create(t_source);
		 
		 ob.create(t_destination);
		 
		 AccountDAO ac=new AccountDAO();
		 
		 double temp_source_balance=ac.getinfo(source_id);
		 
		 double final_source_balance=temp_source_balance-amount;
		 
		System.out.println(final_source_balance);
		 
		 double temp_dest_balance=ac.getinfo(destination_id);
		 
		 double final_dest_balance=temp_dest_balance+amount;
		 
		 Account o1=new Account(source_id,final_source_balance);
		 
		 Account o2=new Account(destination_id,final_dest_balance);
		 
		 ac.create(o1);
		 
		 ac.create(o2);
		 
		 
		  
		  out.println("TRANSACTION SUCCESSFULL....");
				
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
	 
	 out.println("<a href='useacc.jsp'><center><h1>Back to main menu</h1></a>");
	  
	  out.close();
	  
	
	}
	
	
	
			
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

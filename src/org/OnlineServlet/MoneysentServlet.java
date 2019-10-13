package org.OnlineServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import online.dao.CustomerDAO;

/**
 * Servlet implementation class MoneysentServlet
 */
@WebServlet("/MoneysentServlet")
public class MoneysentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoneysentServlet() {
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
		
		response.setContentType("text/html");
		
		HttpSession s=request.getSession(false);
		
		String str=(String)s.getAttribute("SEND");
		
		System.out.println(str+"HELLO");
		
		
		int a=Integer.parseInt(request.getParameter("source"));
		
		int c=Integer.parseInt(request.getParameter("destination"));
		
		PrintWriter out=response.getWriter();
		
		 try {
			  CustomerDAO obj=new CustomerDAO();
			  
			  boolean b=obj.checktransfer(str,a,c);
			System.out.println("Hello "+str+a+b+c);
			  
			 if(b==true)
			 {
				//s.invalidate();
				
			    RequestDispatcher rd1=request.getRequestDispatcher("amount.jsp");
					out.println("<a href='useacc.jsp'><h2>Back to prevoius page</h2></a>");
					request.setAttribute("SUCCESS",null);
					
					rd1.forward(request,response);
					
			 }
			 
			 else 
			 {
				 out.println("<b>INVALID ENTRY</b><br>");
			 out.println("<a href='transfermoney.jsp'>TRY AGAIN</a>");
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



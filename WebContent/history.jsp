<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*,online.dao.*,java.sql.*,javax.servlet.http.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br><br><br><center>
<table border="1">
<tr><th><u><b>Transaction ID</b></u></th><th><u><b>Transaction Date</b></u></th><th><u><b>Transaction Type</b></u></th><th><u><b>Amount</b></u></th></tr>
<%!public double balance; %>
<%
 HttpSession s=request.getSession(false);
  
String user=(String)s.getAttribute("SEND");

int id=Integer.parseInt(request.getParameter("id"));

try {
	
	CustomerDAO cd=new CustomerDAO();
	
	boolean rslt=cd.checkid(user,id);
	
	if(rslt==true)
	{
	
	AccountDAO ob=new AccountDAO();
	
	double balance=ob.getinfo(id);
	
	TransactionDAO obj=new TransactionDAO();
	
	Collection<Temp> c=obj.get(id);

	
	if(c!=null)
	{
	
  	for(Temp t:c)
	
  	{
	
%>

<tr><td><%=t.getId()%></td><td><%=t.getDate()%></td><td><%=t.getType()%></td><td><%=t.getAmount()%></td></tr>

<%

  	}
  	
  	%>
  	<h2><b>Current Balance<input type="text" value=<%=balance%>></b></h2>
<%

}
	}
	
	else 
	{

		RequestDispatcher rd1=request.getRequestDispatcher("tryagain.jsp");
		
		request.setAttribute("FAILURE",null);
		
		rd1.forward(request,response);
		
		
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


%>

</table>
<br><br><br>
<a href='useacc.jsp'><center><h1>Back to main menu</h1></a>
<center>
</body>
</html>
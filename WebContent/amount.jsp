<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*,online.dao.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" http-equiv="refresh" content="1">
<title>Insert title here</title>
</head>
<body>
<form action="SentServlet">

<%

int a=Integer.parseInt(request.getParameter("source"));

int c=Integer.parseInt(request.getParameter("destination"));

Store.set(a, c);

 try {
	  CustomerDAO obj=new CustomerDAO();
	  
	
	 double balancesource=obj.getbalance(a);
	
		double balancedestination=obj.getbalance(c)	;
	 


%>

<center><b>CURRENT BALANCE IN SOURCE ACCOUNT<%=balancesource%></b></center><br>
<center><b>CURRENT BALANCE IN DESTINATION ACCOUNT<%=balancedestination%></b></center><br>
<center><b>ENTER AMOUNT<input type="text" name="amount"></b></center><br>
<center><input type="submit" value="TRANSFER"></input></center>
<a href='useacc.jsp'><center><h1>Back to main menu</h1></a>
</form>
</body>
</html>

<% 
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="online.dao.*,java.sql.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center><h2>CREATE ACCOUNT FOR EXISTING CUSTOMER</h2></center>
<br>
<center>
<table border="1">
<tr><th>Name</th><th>DOB</th><th>Email</th><th>Account Type</th><th>Account No.</th><th>Username</th><th>Password</th><th>Balance</th></tr>
<%

try {
	
	CustomerDAO obj=new CustomerDAO();
	
	ArrayList<Customer> al=obj.getall();
	
	if(al!=null) {
		
		
		for(Customer c:al) {
			
			
	%>		
			
			
<tr><td><%=c.getName()%></td><td><%=c.getDOB()%></td><td><%=c.getEmail()%></td><td><%=c.getActype()%></td><td><%=c.getAccno()%></td><td><%=c.getUsername()%></td><td><%=c.getPassword()%></td><td><%=c.getBalance()%></td></tr>		
	
	
	
	<% 
	
		}
	
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
</center>
<br>



<center><form ACTION="ExistCustServlet"method="post">

Username<input type="text" name="USERNAME"><br>
Password<input type="PASSWORD" name="PASSWORD"><br>

<input type="submit" value="Register"/>

<a href='man2.jsp'><center><h1>Back to previous menu</h1></a>

</form>

</center>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="javax.servlet.http.*,online.dao.*,java.util.*,java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
String str=(String)request.getAttribute("SUCCESS");
HttpSession s1=request.getSession(false);
String getuser=(String)s1.getAttribute("NAME");

%>
<center><h2>WELCOME</h2><h3><%=getuser %></h3></center>
<br><br><br>
<center><table border='1'>
<tr><th><u><b>Account Type</b></u></th><th><u><b>Account No</b></u></th><th><u><b>Opening Balance</b></u></th><th><u><b>Current Balance</b></u></th></tr>
 

<%HttpSession s=request.getSession(false);

String Str=(String)s.getAttribute("SEND");

try {
	CustomerDAO cobj=new CustomerDAO();
	Collection<Plain> al=cobj.get(Str);
	 
	if(al!=null)
	{
		for(Plain p:al)
			
		{
			int getaccno=p.getA();
			String getacctype=p.getB();
			double getbal=p.getC();

			AccountDAO ob=new AccountDAO();
			
			double currentbalance=ob.getinfo(getaccno);

%>


<tr><td><%=getacctype%></td><td><%=getaccno %></td><td><%=getbal%></td><td><%=currentbalance%></td></tr>



<% 

		}
}
	
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



%>

</table>
</center>
<br><br><br>
<center> 
 <nav id="nav">
 <ul id="navigation">
 <a href="transaction.jsp"><h2>SEE TRANSACTION HISTORY</h2></a>
 <a href="transfermoney.jsp"><h2>TRANSFER MONEY</h2></a>
  
 <a href="firstpage.jsp"><h2>LOG OUT</h2></a>
 
 </li>
 </ul>
 </nav>

</center>
</form>
</body>
</html>

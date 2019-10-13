<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="online.dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" http-equiv="refresh" content="1">
<title>Insert title here</title>
</head>
<body>

<h1  style="background-color:DeepPink;font-family:verdana;text-align:center;">CREATE ACCOUNT FOR EXISTING CUSTOMER</h1>
<body style="background-color:Aquamarine;">
<center><form ACTION="AddCustServlet"method="post">


<%
HttpSession s=request.getSession(false);
Customer c=(Customer)s.getAttribute("SUCCESS");
String a=c.getName();
a.replace(' ', '1');
%>

Name<input type="text" name="NAME" value=<%=a %>><br>
Date of Birth<input type="text" name="DOB" value=<%=c.getDOB() %>><br>
Email<input type="text" name="EMAIL" value=<%=c.getEmail() %>><br>
Account Type<input type="radio" name="ACCOUNTTYPE" value="Savings" />savings
             <input type="radio" name="ACCOUNTTYPE" value="Recurring" />recurring<br>

Username<input type="text" name="USERNAME" value=<%=c.getUsername() %> ><br>
Password<input type="PASSWORD" name="PASSWORD" value=<%=c.getPassword() %>><br>
Balance<input type="text" name="BALANCE"><br>
Pan No.<input type="text" name="PAN_NO" value=<%=c.getPan() %>><br>


<input type="submit" value="Register"/>
</form>

</center>
<a href="viewcust.jsp"><h1><center>Go back to previous menu</center></h1></a>

</body>
</html>
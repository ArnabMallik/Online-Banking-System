<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
String str=(String)request.getAttribute("SUCCESS");
RequestDispatcher rd1=request.getRequestDispatcher("MoneysentServlet");

request.setAttribute("SUCCESS",str);

rd1.forward(request,response);


%>
<b>YOU ARE BEING REDIRECTED.....</b><br>
<a href="MoneysentServlet">CLICK HERE </a>

</body>
</html>
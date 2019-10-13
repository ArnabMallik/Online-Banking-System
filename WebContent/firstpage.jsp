
<%@page import="java.util.Date "%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="online.dao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><br><br><br><br><br><h1><center><b><U>WELCOME TO ABC BANK</U></b></center></h1>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta http-equiv="refresh" content="1">
<title>welcome page</title>
</head>
<body>
<img src='firstpage.jpg' style='position:fixed;top:0px;left:0px;width:100%;height:100%;z-index:-1;font-style: italic; '>
<br><center><%=Currenttime.gettime() %></center><br>
<br><br><br>
<a href='view.jsp'><center><H1>CUSTOMER LOGIN</H1></center></a>
<a href='manlog.jsp'><center><h1>MANAGER LOGIN</h1></a>
</body>
</html>
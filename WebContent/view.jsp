<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" http-equiv="refresh" content="1">
<title>customer login</title>
</head>
<body>
<img src='view.jpg' style='position:fixed;top:0px;left:0px;width:100%;height:100%;z-index:-1;'>
<center><form action="SuccessServlet" method="post">
<br><br><b><h2>USERNAME</h2></b>&nbsp;<input type="text" name="username"><br><br><br>
<b><h2>PASSWORD</h2></b>&nbsp;<input type="password" name="password"><br><br><br><br>
<input type="submit" value="LOGIN"><br><br>
</form></center>
<a href='firstpage.jsp'><center><H2>GO TO PREVIOUS MENU</H2></center></a>
</body>
</html>
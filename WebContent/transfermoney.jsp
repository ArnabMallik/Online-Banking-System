<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" http-equiv="refresh" content="1">
<title>Insert title here</title>
</head>
<body>
<%
HttpSession s=request.getSession(false);
//System.out.println(getno);
%>
<img src='transaction.jpeg' style='position:fixed;top:0px;left:0px;width:100%;height:100%;z-index:-1;'>
<br><br><br>

<form action="MoneysentServlet" method="post">
<center><b>ENTER SOURCE ACCOUNT ID<input type="text" name="source"></b></center><br>
<center><b>ENTER DESTINATION ACCOUNT ID<input type="text" name="destination"></b></center><br>
<center><b><input type="submit" value="Proceed"></b></center><br>
<center><b><input type="reset" value="Reset"></b></center>

</form>
<a href="useacc.jsp"><h2><center>Back to prevoius page</center></h2></a>

</body>
</html>
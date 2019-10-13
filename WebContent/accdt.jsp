<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" http-equiv="refresh" content="1">
<title>Insert title here</title>
</head>
<body>

<img src='accdt.jpg' style='position:fixed;top:0px;left:0px;width:100%;height:100%;z-index:-1;'>
<h1  style="font-family:verdana;text-align:center;">CREATE ACCOUNT FOR NEW CUSTOMER</h1><br><br>
<body style="background-color:Aquamarine;">
<center><form ACTION="AddCustServlet"method="post">

&nbsp;&nbsp;Name&nbsp;<input type="text" name="NAME"><br><br>
&nbsp;&nbsp;Date of Birth&nbsp;<input type="text" name="DOB"><br><br>
Email&nbsp;&nbsp;<input type="text" name="EMAIL"><br><br>
Account Type&nbsp;<input type="radio" name="ACCOUNTTYPE" value="Savings" />savings
             <input type="radio" name="ACCOUNTTYPE" value="Recurring" />recurring<br><br>

Username&nbsp;<input type="text" name="USERNAME"><br><br>
Password&nbsp;<input type="PASSWORD" name="PASSWORD"><br><br>
Balance&nbsp;<input type="text" name="BALANCE"><br><br>
Pan No.&nbsp;<input type="text" name="PAN_NO"><br><br>
<input type="submit" value="Register"/><br>
</form>

</center>
<a href="man2.jsp"><h1><center>Go back to previous menu</center></h1></a>
</body>
</html>
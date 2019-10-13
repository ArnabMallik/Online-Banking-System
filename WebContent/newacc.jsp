<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" http-equiv="refresh" content="1">
<title>Insert title here</title>
</head>
<body>
<form action="AddcustServlet" method="post">
Name<input type="text" name="name"><br>
D.O.B<input type="text" name="dob"><br>
Sex<input type="radio" name="sex">Male
   <input type="radio" name="sex">Female<br>
Nationality<input type="text" name="nationality"><br>  
Address<input type="text" name="address"><br>
City<input type="text" name="city"><br>
State<input type="text" name="state"><br>
PinCode<input type="text" name="pincode"><br>
Contact<input type="text" name="contact"><br>
Email<input type="text" name="email"><br>
Profession<input type="text" name="profession"><br>
Monthly Income<input type="text" name="income"><br>
Account type<input type="text" name="accounttype"><br>
Username<input type="text" name="username"><br>
Password<input type="text" name="password"><br>
Balance<input type="text" name="balance"><br>

<input type="submit" value="Add customer"> <input type="reset" value="reset">


</form>

</body>
</html>
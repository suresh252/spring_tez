<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register tez</title>
<style>  
body {
    background-color: linen;
}
h2{  
color:white;background-color:red; padding:5px;}  
p{  
color:blue;  
}  
</style>  
</head>
<body>
	${sms}
	<h2>Register User</h2>
	<form action="testioc" method="post">
	
	Name:<input type="text" name="empname"><br>
	Company:<input type="text" name="company"><br>
	Email:<input type="text" name="email"><br>
	Password:<input type="password" name="password"><br>
	<input type="submit" value="Register"><br>
	<a href="login.jsp">Login</a><br>
	<a href="getEmployees">View Employees</a>
	</form>
</body>
</html>
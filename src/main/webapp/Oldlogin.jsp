<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login tez</title>
</head>
<body>
${sms}
	<h2>Login User</h2>
	<form action="loginemp" method="post">
	Email:<input type="text" name="email"><br>
	Password:<input type="password" name="password"><br>	
	<input type="submit" value="login"><br>
	<a href="home.jsp">Register</a>
	</form>
</body>
</html>
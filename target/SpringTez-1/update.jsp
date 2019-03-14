<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>update page</title>
</head>
<body>
<form action="update" method="post">

<core:forEach var="employee" items="${empList}">
Name:<input type="text" name="empname" value="${employee.empname}"/><br>
company:<input type="text" name="company" value="${employee.company}"/><br>
email:<input type="text" name="email" readonly="readonly" value="${employee.email}"/><br>
password:<input type="text" name="password" value="${employee.password}"/><br>

<input type="submit" value="Upadte">
</core:forEach>
</form>


</body>
</html>
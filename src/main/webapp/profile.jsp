<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<script type="text/javascript">
function deleteUser(email) {
	alert("delete triggered for : " + email);
	document.forms[0].action="${pageContext.request.contextPath}/deleteUser?email="+email;
	document.forms[0].method="post";
	document.forms[0].submit();
}

function editEmp(email) {
	alert("edit triggered for : " + email);
	document.forms[0].action="${pageContext.request.contextPath}/editEmployee?email="+email;
	document.forms[0].method="post";
	document.forms[0].submit();
}

</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<h3>Profile Page</h3>
	<form action="getemployees" method="post">
		<table border="3">
			<tr style="color: blue">
				<th>empName</th>
				<th>company</th>
				<th>email</th>
				<th>password</th>
			</tr>
			<core:forEach var="employee" items="${empList}">
				<tr>
					<td><core:out value="${employee.empname}" /></td>
					<td><core:out value="${employee.company}" /></td>
					<td><core:out value="${employee.email}" /></td>
					<td><core:out value="${employee.password}" /></td>
					
					<td><input type="button" value="Edit" onclick="editEmp('${employee.email}')" /></td>
					<td><input type="button" value="Delete" onclick="deleteUser('${employee.email}')" /></td>
				</tr>
			</core:forEach>

		</table>

		<input type="submit" value="deleteAll">
	</form>
<a href="<core:url value="j_spring_security_logout" />" > Logout</a></br></br>
</body>
</html>
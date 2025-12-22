<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">

		<tr>
			<td>Employee</td>
			<td>Income</td>
			<td>Company</td>
			<td>Gender</td>
		</tr>

		<c:forEach var="e" items="${list}">
			<tr>
				<td>${e.e_name}</td>
				<td>${e.e_income}</td>
				<td>${e.e_company}</td>
				<td>${e.e_gender}</td>
			</tr>
		</c:forEach>

	</table>
	<br/>
	
	<a href="register">Add Another Employee</a>

</body>
</html>
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
	<table border="2">
		<tr>
			<td>Id</td>
			<td>Project Name</td>
			<td>Description</td>
		</tr>

		<c:forEach var="p" items="${list }">
			<tr>
				<td>${p.id }</td>
				<td>${p.p_name }</td>
				<td>${p.p_desc }</td>
			</tr>
		</c:forEach>
	</table>
	<a href="register">Add Project</a>
</body>
</html>
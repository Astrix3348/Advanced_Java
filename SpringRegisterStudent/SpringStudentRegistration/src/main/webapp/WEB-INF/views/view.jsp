<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>All Students</h1>
	<hr />
	<c:forEach var="s" items="${students }">
		<h2>${ s.s_id}</h2>
		<h2>${ s.s_name}</h2>
		<h2>${ s.s_email}</h2>
		<h2>${ s.s_course}</h2>
		<hr />
	</c:forEach>


</body>
</html>
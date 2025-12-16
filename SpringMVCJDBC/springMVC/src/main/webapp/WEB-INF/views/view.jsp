<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>Registered Students</h2>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Course</th>
    </tr>

    <c:forEach var="s" items="${students}">
        <tr>
            <td>${s.s_id}</td>
            <td>${s.s_name}</td>
            <td>${s.s_email}</td>
            <td>${s.s_course}</td>
        </tr>
    </c:forEach>
</table>

<br>
<a href="register">Add New Student</a>

</body>
</html>
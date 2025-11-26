
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.util.ArrayList"%>
<%@ page import="cdac.Student1"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	ArrayList<Student1> al = (ArrayList<Student1>) request.getAttribute("theObject");

	for (Student1 ss : al) {
	%>
	<h2>
		Welcome
		<%=ss.getName()%></h2>
	<h2>
		Your Prn is
		<%=ss.getPrn()%></h2>
	<h2>
		Your email is
		<%=ss.getEmail()%></h2>
	<hr>
	<hr>

	<%
	}
	%>
</body>
</html>
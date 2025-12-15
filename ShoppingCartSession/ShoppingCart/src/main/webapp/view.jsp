<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	String name = (String) session.getAttribute("cName");
	String item = (String) session.getAttribute("cItem");
	int price = (int) session.getAttribute("cPrice");
	%>
	
	<h2>Your Cart has</h2>
	<h3>Your name: <%= name %></h3>
	<h3>Your item name: <%= item %></h3>
	<h3>item price: <%= price %></h3>


</body>
</html>
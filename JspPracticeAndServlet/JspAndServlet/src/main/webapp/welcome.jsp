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
    String user = (String)request.getAttribute("sName"); 
    int roll = (Integer)request.getAttribute("sPrn");
    String email = (String)request.getAttribute("sEmail");
%>
<h1>Welcome to the Student Registration Page.</h1>
<h2>Welcome <%= user %></h2>
<h3>Your PRN is <%= roll %></h3>
<h3>And Your Email is <%= email %></h3>
</body>
</html>
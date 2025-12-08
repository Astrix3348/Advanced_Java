<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="cdac.Employee" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <% ArrayList<Employee> al = (ArrayList<Employee>)request.getAttribute("allEmployees");
       for(Employee e : al){
    %>
    <h2>Id: <%= e.getId() %></h2>
    <h2>Name: <%= e.getName() %></h2>
    <h2>Salary: <%= e.getSal() %></h2>
   <%
       }
   %>
    
</body>
</html>
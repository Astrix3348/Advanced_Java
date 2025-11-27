<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="cdac.Book" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
    ArrayList<Book> al =  (ArrayList<Book>)request.getAttribute("allbooks");
    for(Book b : al){    
%>
<h2>Title of the book is: <%= b.getTitle() %></h2>
<h3>Author is: <%= b.getAuthor() %></h3>
<h3>Genre is: <%= b.getGenre() %></h3>
<h3>Year published is: <%= b.getYear() %></h3>
<hr></hr>
<% } %>

</body>
</html>
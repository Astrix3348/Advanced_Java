<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="cdac.Book"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Books</title>

<style>
body {
	font-family: Arial, sans-serif;
	display: flex;
	flex-direction: column;
	align-items: center;
	margin-top: 40px;
}

table {
	width: 70%;
	border-collapse: collapse;
	text-align: center;
	box-shadow: 0px 0px 8px rgba(0, 0, 0, 0.2);
}

th {
	background-color: #e0e0e0;
	padding: 12px;
}

td {
	padding: 10px;
	border-top: 1px solid #ccc;
}

button {
	margin-top: 20px;
	padding: 8px 14px;
	cursor: pointer;
}

a {
	text-decoration: none;
	color: black;
}
</style>
</head>

<body>


	<table>
		<tr>
			<th>Title</th>
			<th>Author</th>
			<th>Genre</th>
			<th>Year Published</th>
			<th>Actions</th>
		</tr>

		<%
		ArrayList<Book> al = (ArrayList<Book>) request.getAttribute("allbooks");
		for (Book b : al) {
		%>
		<tr>
			<td><%=b.getTitle()%></td>
			<td><%=b.getAuthor()%></td>
			<td><%=b.getGenre()%></td>
			<td><%=b.getYear()%></td>
			<td>
				<form method="post" action="deleteBook">
					<input type="hidden" name="del" value="<%=b.getTitle()%>">
					<button type="submit">Delete</button>
				</form>
				
				<button><a href="update.html">update</a></button>
			</td>
		</tr>
		<%
		}
		%>
	</table>

	<button>
		<a href="addBook.html">Home Page</a>
	</button>

	
	

</body>
</html>

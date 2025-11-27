# 📚 Book Library Management System
### (Insert & View Books — Servlet + JSP + JDBC)

A beginner-friendly Java web application to manage book records using **Servlets**, **JSP**, and **JDBC**, supporting:
- ➕ *Insert New Book*
- 📖 *View All Books*

---

## ✨ Features
- Insert and store books into MySQL database
- View all stored books in tabular format
- MVC architecture (Servlets + JSP)
- JDBC connectivity with MySQL

---

## 🧠 Application Flow
- addBook.html
↓ (POST)
- AddBookServlet
↓ Insert into DB
- success.jsp
↓ (View All Books button / link)
- ViewBooksServlet
↓ Fetch from DB
- viewBooks.jsp (Display in table)

---

## 🗂 Project Structure
src/
├── AddBookServlet.java
├── ViewBooksServlet.java
webapp/
├── addBook.html
├── success.jsp
└── viewBooks.jsp

---

## 🗃 Database Schema

```sql
CREATE TABLE books (
   id INT AUTO_INCREMENT PRIMARY KEY,
   title VARCHAR(150),
   author VARCHAR(100),
   genre VARCHAR(50),
   year_published INT
);

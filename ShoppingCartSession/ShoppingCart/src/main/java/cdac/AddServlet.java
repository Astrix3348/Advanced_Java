package cdac;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AddServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String my_item = request.getParameter("my_item");
		int my_price = Integer.parseInt(request.getParameter("my_price"));
		HttpSession session = request.getSession(false);
		
		String c_name = (String)session.getAttribute("username");
		
		
		
		
		JDBCConnection jb = new JDBCConnection();
		ShoppingCart sc = new ShoppingCart(c_name, my_item, my_price);

		
		session.setAttribute("cName", c_name);
		session.setAttribute("cItem", my_item);
		session.setAttribute("cPrice", my_price);

		boolean stat = false;
		try {
			stat = jb.addItems(sc);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (stat == true) {
			response.sendRedirect("success.jsp");
		} else {
			PrintWriter out = response.getWriter();
			out.print("Adding was not successful");
		}
	}
}

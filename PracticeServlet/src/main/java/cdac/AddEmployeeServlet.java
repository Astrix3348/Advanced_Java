package cdac;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddEmployeeServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int e_id = Integer.parseInt(request.getParameter("id"));
		String e_name = request.getParameter("e_name");
		int e_sal = Integer.parseInt(request.getParameter("salary"));
		
		Employee e = new Employee(e_id, e_name, e_sal);
		
		PracJdbc pd = new PracJdbc();
		
		PrintWriter out = response.getWriter();
		
		boolean status = false;
		
		try {
			status = pd.employees(e);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(status) {
			response.sendRedirect("success.jsp");
		}
		else {
			out.print("<h1>Error<h1>");
		}
	}
}

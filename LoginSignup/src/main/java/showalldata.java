import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class showalldata
 */
@WebServlet("/showalldata")
public class showalldata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showalldata() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int x=1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagement","root","root");
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery("select * from people");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					+ "<title>showdata</title>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+"<table border='3%' width='90%'>\r\n"
					+                      "<tr>"
					+ "               <th>S.NO </th>\r\t\n"
					
				    + "               <th>Name</th>\r\t\t\n"
					
					+ "                 <th>Contact</th>\r\t\t\n"
					
					+ "                <th> email</th>\r\t\t\n"
			
					+ "               <th>Address</th>\r\t\t\n"
					
					+ "                 <th>Gender</th>\r\t\t\n"
					
					+ "                  <th>hobbies</th></tr>\r\t\t\n");
					
			while(rs.next())
			{
				out.println("<tr><td>"+x+"</td>");
				out.println("<td>"+rs.getString(1)+"</td>");
				out.println("<td>"+rs.getInt(2)+"</td>");
				out.println("<td>"+rs.getString(3)+"</td>");
				out.println("<td>"+rs.getString(4)+"</td>");
				out.println("<td>"+rs.getString(5)+"</td>");
				out.println("<td>"+rs.getString(6)+"</td>");
				out.println("<td><a href='Update?id="+rs.getInt(2)+"'>Update</a>");
				out.println("<td><a href='deletedata?id="+rs.getInt(2)+"'>Delete</a>");
				out.println("</tr>");
				x++;
			}
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
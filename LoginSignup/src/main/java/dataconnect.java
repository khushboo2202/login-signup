

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class dataconnect
 */
@WebServlet("/dataconnect")
public class dataconnect extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public dataconnect() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		  
				try {
					Class.forName("com.mysql.jdbc.Driver");
				     Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagement","root","root");
				String query = "insert into people values(?,?,?,?,?,?)";
		
		String name = request.getParameter("name");
		String contact = request.getParameter("contact");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String gender = request.getParameter("Gender");
		String hobby[] = request.getParameterValues("hobbies");
		
		String hobbies="";
		for(int i=0;i<hobby.length;i++)
		{
		   hobbies = hobbies+","+hobby[i];
		}
		
		 hobbies=hobbies.replaceFirst("hobby[0]", " ");
		
		PreparedStatement pst = conn.prepareStatement(query);
		pst.setString(1, name);
		pst.setString(2,contact);
		pst.setString(3, email);
		pst.setString(4, address);
		pst.setString(5, gender);
		
		//for(String hobbies:hobby)
		//{
		pst.setString(6, hobbies);
		//}
		
		System.out.println(pst);
		pst.execute();
		conn.close();

	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
				response.getWriter().append("<h1>Data inserted Successfully!!</h1> "
						+ "<br> <a href='login.html'>Go to login page</a>");
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
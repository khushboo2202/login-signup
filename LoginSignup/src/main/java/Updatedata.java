import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class Updatedata
 */
@WebServlet("/Updatedata")
public class Updatedata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updatedata() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String gender = request.getParameter("Gender");
		String hobby[] = request.getParameterValues("hobbies");
		String contact=request.getParameter("contact");
		int contact1 = Integer.parseInt(contact);
		
		String hobbies="";
		for(int i=0;i<hobby.length;i++){
			hobbies = hobby[i]+" ,"+hobbies;
		}
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagement","root","root");
			String query = "Update people set name=?,email=?,address=?,gender=?,hobbies=? where contact=?";
			PreparedStatement pst = conn.prepareStatement(query);
			
			pst.setString(1, name);
			pst.setString(2, email);
			pst.setString(3, address);
			pst.setString(4, gender);
			pst.setString(5, hobbies);
		    pst.setInt(6, contact1);
			
			System.out.println(pst);
			pst.execute();
			conn.close();
			System.out.println("data Updated successfully");
			
			PrintWriter out= response.getWriter();
			out.println("<h1>Data Updated Successfully");
			out.println("<h1><a href='showalldata'>Show Updated Data</a></h1>");
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

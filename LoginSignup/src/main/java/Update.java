import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String ID=request.getParameter("id");
		//int id = Integer.parseInt(ID);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagement","root","root");
			//Statement stm = conn.createStatement();
			
			String query = "select * from people where contact=?" ;
			
			PreparedStatement pst = conn.prepareStatement(query);
			
			pst.setString(1,ID);
			System.out.println(pst);
			ResultSet rs = pst.executeQuery();
			
			rs.next();
			
			String name =rs.getString("name");
			String email =rs.getString("email");
			String address = rs.getString("address");
			String gender =rs.getString("gender");
			String hobbies =rs.getString("hobbies");
			String contact = rs.getString("contact");
			
			PrintWriter out = response.getWriter();
			out.println("<h1>Update record for - "+ID+"</h1>");
			out.println("<form action ='Updatedata' method='get'>"
					+                           "\r\n"
					+ "                      <table>\r\n"
					+ "                              <tr>\r\n"
					+ "                                   <td>Name : </td>\r\n"
					+ "                                   <td><input type ='text' name ='name' value="+name+"></td>\r\n"
					+ "                              </tr>     \r\n"
					+ "                               \r\n"      
					+ "                               <tr>\r\n"
					+ "                                   <td>Email :</td>\r\n"
					+ "                                   <td><input type ='email' name='email' value="+email+"></td>\r\n"
					+ "                              </tr>     \r\n"
					+ "                              \r\n"
					+ "                               <tr>\r\n"
					+ "                                   <td>Address :</td>\r\n"
					+ "                                   <td><input type ='text' name='address' value="+address+"></td>\r\n"
					+ "                              </tr>\r\n"
					+ "                             \r\n"
					+ "                              <tr>\r\n"
					+ "                                     <th><label>Gender :</label></th>\r\n"
					+ "                                     <th>\r\n");			
					                                        if(gender.equals("Male"))
					                                        {
					                           out.println("<input type ='radio' name ='Gender' id='Male' value="+gender+" checked><label>Male</label>\r\n");
					                                        }
					                                        else
					                                        {
					                                        	out.println("<input type ='radio' name ='Gender' id='Male' value="+gender+"><label>Male</label>\r\n");             	
					                                        }
					                                        if(gender.equals("Female"))
					                                        {
					                           out.println("<input type ='radio' name ='Gender' id='Female' value="+gender+" checked><label>Female</label>\r\n");
					                                        }
					                                        else
					                                        {
					                           out.println("<input type ='radio' name ='Gender' id='Female' value="+gender+"><label>Female</label>\r\n");
										                    }
					                                        if(gender.equals("Other"))
					                                        {
					                           out.println("<input type ='radio' name ='Gender' id='Other' value="+gender+" checked><label>Other</label>  \r\n");
					                                        }
					                                        else
					                                        {
					                           out.println("<input type ='radio' name ='Gender' id='Other' value="+gender+" ><label>Other</label>  \r\n");            	
					                                        }
					                           out.println("</th>\r\n"
					+ "                              </tr>\r\n"
					+ "                              \r\n"
					+ "                              <tr>\r\n"
					+ "                                     <td><label>Hobbies </label></td>\r\n"
					+ "                                     <td>\r\n");
					                           
					                                    if(hobbies.contains("cricket"))
					                                    {
					                           out.println("<input type ='checkbox' name ='hobbies' id='cricket' value='cricket' checked><label>Cricket</label>\r\n");
					                                    }
					                                    else
					                                    {
					                           out.println("<input type ='checkbox' name ='hobbies' id='cricket' value='cricket'><label>Cricket</label>\r\n");
					                                    }
					                                    
					                                    if(hobbies.contains("football"))
					                                    {
					                           out.println("<input type ='checkbox' name ='hobbies' id='football' value='football' checked><label>Football</label>\r\n");
					                                    }
					                                    else
					                                    {
					                           out.println("<input type ='checkbox' name ='hobbies' id='football' value='football'><label>Football</label>\r\n");								                                  	
					                                    }
					                                    
					                                    if(hobbies.contains("swimming"))
					                                    {
					                           out.println("<input type ='checkbox' name ='hobbies' id='swimming' value='swimming' checked><label>Swimming</label>\r\n");
					                                    }
					                                    else
					                                    {
					                           out.println("<input type ='checkbox' name ='hobbies' id='swimming' value='swimming'><label>Swimming</label>\r\n");
									                    }
					                           out.println("</td></tr>\r\n<tr>\r\n"
				    + "                                   <td>Contact : </td>\r\n"
					+ "                                   <td><input type ='number' name ='contact' value="+contact+" readonly></td>\r\n"
					+ "                              </tr>     \r\n"
					+ "                               \r\n"                          		   
					+ "                                   \r\n"
					+ "                              \r\n"
					+ "                              \r\n"
					+ "                                  \r\n"
					+ "                                  <tr>\r\n"
					+ "					                    <th><input type='Submit' value='Update' id='btn'></th>\r\n"
					+ "				                 </tr>\r\n"
					+ "				                \r\n"
					
					+ "                       </table>\r\n"
					+ "                 </form>");
			

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

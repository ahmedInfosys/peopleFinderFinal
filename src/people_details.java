// Import required java libraries
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;



import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

// Extend HttpServlet class

  
@WebServlet("/People_details")
public class people_details extends HttpServlet {
	  
	 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			// int customer_id  = Integer.parseInt(request.getParameter("customer_id"));
			 String url = "jdbc:oracle:thin:testuser/password@localhost"; 
		      //properties for creating connection to Oracle database
		      Properties props = new Properties();
		      
		      props.setProperty("user", "testdb");
		      props.setProperty("password", "password");
		    
		      //creating connection to Oracle database using JDBC
		      Connection conn;
			
			  PreparedStatement preStatement;
			  String  people_details = "";
			  String sql_command = "select  firstname, lastname, streetaddress, city, state, zipcode,position,name, emailaddress "
			  		+ "from customers,cities,states,companies where customers.city_id = cities.ID "
			  		+ "and customers.STATE_ID = states.id and customers.COMPANY_ID = companies.id "
			  		+ "and personid = " + request.getParameter("customer_ID");
			  System.out.println(sql_command);
			  try{
					conn = DriverManager.getConnection(url,props);
					preStatement = conn.prepareStatement(sql_command);
					ResultSet result = preStatement.executeQuery();
				
				    while(result.next()){
				    	people_details += "<p><b> Name:  </b>"+ result.getString("firstname") + "  " + result.getString("lastname")+ "</p>" ;
				    	people_details += "<p><b> Address: </b>"   + result.getString("streetaddress") + "</p>";
				    	people_details += "<p> " + result.getString("city") +", " + result.getString("state") + "   " + result.getInt( "zipcode") + "</p>";
				    	people_details += "<p><b> Email Address: </b>"   + result.getString("emailaddress") + "</p>";
				    	people_details += "<p><b> Position: </b>"   + result.getString("position") + "</p>";
				    	people_details += "<p><b> Company: </b>"   + result.getString("name") + "</p>";
				    	
				    }
				    
				    conn.close();
			  	}catch (SQLException e) {
						// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  request.setAttribute("people_details",people_details);
			  getServletContext().getRequestDispatcher("/People_details.jsp").forward(request, response);
		  }

		   public void destroy() 
		   { 
		     // do nothing. 
		   } 
}
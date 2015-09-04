// Import required java libraries
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;



import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.City;
import model.Company;
import model.Customer;
import model.State;

// Extend HttpServlet class

  
@WebServlet("/People_details")
public class people_details extends HttpServlet {
	  
	 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 List <Customer> customers = new ArrayList<Customer>();
		 List <City> cities = new ArrayList<City>();
		 List <State> states = new ArrayList<State>();
		 List<Company> companies = new ArrayList<Company>();
		 
		 String people_details = "";
		 
		 long id = Long.parseLong(request.getParameter("customer_ID"));
		 
		 customers = People_Finder_DB.select_single_customer(id);
		 cities = People_Finder_DB.select_single_city(id);
		 states = People_Finder_DB.select_single_state(id);
		 companies = People_Finder_DB.select_single_company(id);
		 
		 
		
			people_details += "<p><b> Name:  </b>"+ customers.get(0).getFirstname() + "  " +customers.get(0).getLastname()+ "</p>" ;
	    	people_details += "<p><b> Address: </b>"   + customers.get(0).getStreetaddress() + "</p>";
	    	people_details += "<p> " + cities.get(0).getCity() +", " + states.get(0).getState()+ "   " + customers.get(0).getZipcode() + "</p>";
	    	people_details += "<p><b> Email Address: </b>"   + customers.get(0).getEmailaddress() + "</p>";
	    	people_details += "<p><b> Position: </b>"   + customers.get(0).getPosition() + "</p>";
	    	people_details += "<p><b> Company: </b>"   + companies.get(0).getName()  + "</p>";

		
				    	
			  request.setAttribute("people_details",people_details);
			  getServletContext().getRequestDispatcher("/People_details.jsp").forward(request, response);
		  }

		   public void destroy() 
		   { 
		     // do nothing. 
		   } 
}
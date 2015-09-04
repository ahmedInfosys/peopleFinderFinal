import java.io.IOException;

import java.util.ArrayList;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;

/**
 * Servlet implementation class Store_Assignment
 */
@WebServlet("/search")
public class find_people extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public find_people() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Customer> customers = new ArrayList<Customer>();
		customers = People_Finder_DB.search_people(request.getParameter("name"));
		
		String search_table = "";
		
		search_table += "<div class=\"container\"> <table class=\"table table-striped table-bordered\">";
		search_table +=  "<h3>"  + "Search results:" + "</h3>";
		search_table += "<thread>";
		search_table += "<tr>"; 
		search_table += "<th > First Name</th>";  
		search_table += "<th > Last Name</th>"; 
		search_table += "</tr>";
		search_table += "</thread>";
		search_table +=  "<tbody>" ;

		for(Customer customer:customers){
	
			search_table +=  "<tr>";
			search_table +=  "<td> <a href=\"People_details?customer_ID="+ customer.getPersonid() +" \"> "+ customer.getFirstname() + " </a></td>";
			search_table +=  "<td >" + customer.getLastname() + "</td>" ;
			search_table +=  "</tr>";
			  
		}
			
		
		request.setAttribute("people",search_table);

		getServletContext().getRequestDispatcher("/Search_people.jsp").forward(request, response);
	

	  } 
	  
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

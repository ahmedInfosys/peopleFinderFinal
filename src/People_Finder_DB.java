
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.City;
import model.Company;
import model.Customer;
import model.DBUtil;
import model.State;

public class People_Finder_DB {
	public static List<Customer> search_people(String search){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "select  c"
				+ " from Customer c, Company cm, City ci, State s where c.cityId = ci.id "
				+ " and c.stateId = s.id and c.companyId =  cm.id and c.lastname like :search";
		TypedQuery <Customer> List_of_table = em.createQuery(qString, Customer.class);
		List_of_table.setParameter("search", "%" + search + "%");
		List<Customer> list_of_customers;
		try{
			list_of_customers = List_of_table.getResultList();
			if(list_of_customers == null || list_of_customers.isEmpty()){
				list_of_customers = null;
			}
		}finally{
			em.close();
		}
		return list_of_customers;
	}
	
	public static List<Customer> select_single_customer(long id){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "select c"
				+ " from Customer c, Company cm, City ci, State s where c.cityId = ci.id "
				+ " and c.stateId = s.id and c.companyId =  cm.id and c.personid = :id";
		TypedQuery <Customer> List_of_table = em.createQuery(qString, Customer.class);
		List_of_table.setParameter("id", id);
		List<Customer> list_of_customers;
		try{
			list_of_customers = List_of_table.getResultList();
			if(list_of_customers == null || list_of_customers.isEmpty()){
				list_of_customers = null;
			}
		}finally{
			em.close();
		}
		return list_of_customers;
	}
	
	
	public static List<City> select_single_city(long id){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "select ci "
				+ " from Customer c, Company cm, City ci, State s where c.cityId = ci.id "
				+ " and c.stateId = s.id and c.companyId =  cm.id and c.personid = :id";
		TypedQuery <City> List_of_table = em.createQuery(qString, City.class);
		List_of_table.setParameter("id", id);
		List<City> list_of_cities;
		try{
			list_of_cities = List_of_table.getResultList();
			if(list_of_cities == null || list_of_cities.isEmpty()){
				list_of_cities = null;
			}
		}finally{
			em.close();
		}
	
		return list_of_cities;
	}
	
	
	public static List<State> select_single_state(long id){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "select s  "
				+ " from Customer c, Company cm, City ci, State s where c.cityId = ci.id "
				+ " and c.stateId = s.id and c.companyId =  cm.id and c.personid = :id";
		TypedQuery <State> List_of_table = em.createQuery(qString, State.class);
		
		List_of_table.setParameter("id", id);
		List<State> list_of_states;
		try{
			list_of_states = List_of_table.getResultList();
			if(list_of_states == null || list_of_states.isEmpty()){
				list_of_states = null;
			}
		}finally{
			em.close();
		}
		return list_of_states;
	}
	
	
	
	public static List<Company> select_single_company(long id){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "select cm "
				+ " from Customer c, Company cm, City ci, State s where c.cityId = ci.id "
				+ " and c.stateId = s.id and c.companyId =  cm.id and c.personid = :id";
		TypedQuery <Company> List_of_table = em.createQuery(qString, Company.class);
		List_of_table.setParameter("id", id);
		List<Company> list_of_companies;
		try{
			list_of_companies = List_of_table.getResultList();
			if(list_of_companies == null || list_of_companies.isEmpty()){
				list_of_companies = null;
			}
		}finally{
			em.close();
		}
		return list_of_companies;
	}
	
	
}

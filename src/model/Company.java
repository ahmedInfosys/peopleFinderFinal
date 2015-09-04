package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the COMPANIES database table.
 * 
 */
@Entity
@Table(name="COMPANIES",schema="TESTDB")
@NamedQuery(name="Company.findAll", query="SELECT cm FROM Company cm")
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "COMPANIES_SEQ", catalog = "",schema="TESTDB",allocationSize = 1,initialValue = 1)
	@GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="COMPANIES_SEQ")
	private long id;

	private String name;

	public Company() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
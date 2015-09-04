package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CITIES database table.
 * 
 */
@Entity
@Table(name="CITIES",schema="TESTDB")
@NamedQuery(name="City.findAll", query="SELECT ci FROM City ci")
public class City implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "CITIES_SEQ", catalog = "",schema="TESTDB",allocationSize = 1,initialValue = 1)
	@GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="CITIES_SEQ")

	private long id;

	private String city;

	public City() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
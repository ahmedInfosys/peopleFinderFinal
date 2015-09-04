package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the STATES database table.
 * 
 */
@Entity
@Table(name="STATES",schema="TESTDB")
@NamedQuery(name="State.findAll", query="SELECT s FROM State s")
public class State implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "STATES_SEQ", catalog = "",schema="TESTDB",allocationSize = 1,initialValue = 1)
	@GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="STATES_SEQ")
	private long id;

	@Column(name="\"STATE\"")
	private String state;

	public State() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
package model;

import java.io.Serializable;




import javax.persistence.Column;
import javax.persistence.Entity;


import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table
@NamedQueries( {
    @NamedQuery( name = "Machine.populateMachine", query = "SELECT u FROM Machine u" )
}

)
public class Machine extends BaseEntity implements Serializable {

	 @Column
	private String machine;

	public String getMachine() {
		return machine;
	}

	public void setMachine(String machine) {
		this.machine = machine;
	}

	
	
	
}

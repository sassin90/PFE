package dao;

import javax.ejb.Stateless;


import model.Machine;

@Stateless( name = "MachineDAO" )
public class MachineDAO extends GenericDAO<Machine> {

	public MachineDAO() {
		super(Machine.class);
		// TODO Auto-generated constructor stub
	}

	

	
}

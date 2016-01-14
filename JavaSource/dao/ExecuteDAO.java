package dao;

import java.util.HashMap;
import java.util.Map;

import model.Execute;


import javax.ejb.Stateless;

@Stateless( name = "ExecuteDAO" )
public class ExecuteDAO extends GenericDAO<Execute> {

    public ExecuteDAO() {
        super( Execute.class );
    }
    
   
    
    public Execute findTime()//modifier
    {
    	Map < String, Object> parameters = new HashMap<String, Object>();
    	
    	//parameters.put("machine",machine);
    	//parameters.put("piece",piece);
    	
		return super.findOneResult("ExecuteFindTime", parameters);
    }

}

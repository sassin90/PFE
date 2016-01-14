/*package bean;

import java.io.Serializable;  
import java.util.HashMap;  
import java.util.List;
import java.util.Map;  
  




import javax.faces.application.FacesMessage;  
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;  

import model.Machine;

 
@SuppressWarnings("serial")
@ViewScoped
@ManagedBean( name = "ExecuteBean" )
public class ExecuteBean implements Serializable {  
  
    private String machine;  
  
    private String piece;  
    
    private int nombre;
      
    public int getNombre() {
		return nombre;
	}



	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	private Map<String,String> machines = new HashMap<String, String>();  
  
    private Map<String,Map<String,String>> pieces = new HashMap<String, Map<String,String>>();  
      
    private Map<String,String> suburbs = new HashMap<String, String>();  
  
    public ExecuteBean() {  
        machines.put("MachineA", "Machine A");  
        machines.put("MachineB", "Machine B");  
        machines.put("MachineC", "Machine C");  
          
        Map<String,String> pMachineA = new HashMap<String, String>();  
       pMachineA.put("PieceA", "Piece A");  
        pMachineA.put("PieceB", "Piece B");  
        pMachineA.put("PieceC", "Piece C");  
          
        Map<String,String> pMachineB = new HashMap<String, String>();  
        pMachineB.put("PieceA", "Piece A");  
        pMachineB.put("PieceD", "Piece D");  
        pMachineB.put("PieceE", "Piece E");  
          
        Map<String,String> pMachineC = new HashMap<String, String>();  
        pMachineC.put("PieceB", "Piece B");  
        pMachineC.put("PieceD", "Piece D");  
        pMachineC.put("PieceE", "Piece E");  
          
       pieces.put("Machine A",  pMachineA);  
        pieces.put("Machine B",  pMachineB);  
        pieces.put("Machine C",  pMachineC);  
    }  
      
    
      
    public String getMachine() {
		return machine;
	}



	public void setMachine(String machine) {
		this.machine = machine;
	}



	public String getPiece() {
		return piece;
	}



	public void setPiece(String piece) {
		this.piece = piece;
	}



	public Map<String, String> getMachines() {
		return machines;
	}



	public void setMachines(Map<String, String> machines) {
		this.machines = machines;
	}



	public Map<String, Map<String, String>> getPieces() {
		return pieces;
	}



	public void setPieces(Map<String, Map<String, String>> pieces) {
		this.pieces = pieces;
	}



	public Map<String, String> getSuburbs() {  
        return suburbs;  
    }  
  
    public void setSuburbs(Map<String, String> suburbs) {  
        this.suburbs = suburbs;  
    }  
      
    public void handleCityChange() {  
        if(machine !=null && !machine.equals(""))  
            suburbs = pieces.get(machine);  
        else  
            suburbs = new HashMap<String, String>();  
    }  
  
    public void displayLocation() {  
        FacesMessage msg = new FacesMessage("Selected", "Machine:" + machine + ", Piece: " + piece);  
  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
    
   
}*/

package bean;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

import dao.ExecuteDAO;
import dao.MachineDAO;
import dao.PieceDAO;
import model.Execute;
import model.Machine;
import model.Piece;
import model.UserAdmin;


@SessionScoped
@ManagedBean( name = "executeBean" )
public class ExecuteBean implements Serializable {

    private static final long  serialVersionUID = 1L;
  
	
	private List<Machine> machine2;
	public static final String INJECTION_NAME   = "#{executeBean}";
	
	private List<Execute> exe;
	
private String machine;
private String piece;
	//private List<Piece> piece;

    public String getMachine() {
	return machine;
}



public void setMachine(String machine) {
	this.machine = machine;
}



public void setPiece(String piece) {
	this.piece = piece;
}



	@EJB( name = "ExecuteDAO" )
    private ExecuteDAO            exeDAO;
    @EJB( name = "MachineDAO" )
    private MachineDAO            machineDAO;
    





  
    private Execute newExecute = new Execute();
 

	public Execute getNewExecute() {
		return newExecute;
	}
	
	

	public void setNewExecute(Execute newExecute) {
		this.newExecute = newExecute;
	}

    
	
	
	  
	    @PostConstruct  
	    public void init() {  
	        
	    }  
	    
	    
		public Execute  findTimeExecute () {  //modifier
	        Execute exe = exeDAO.findTime();
	         
	        return exe; 
	    }
		
		 public void calcul( AjaxBehaviorEvent event ) {
			 
			 Execute exe = findTimeExecute ();//modifier
		    	
		       
		        if ( exe != null ) {System.out.println(exe.getTemps());
		        System.out.println("maxhine: "+machine);
		        System.out.println("piece:" + piece);
		        }
		        
		        else System.out.println("resultat n'est pas trouvee");
		        
		 }
    
    @SuppressWarnings("unchecked")
	public List<Machine> complete2 () {  
        machine2 = machineDAO.findWithNamedQuery("Machine.populateMachine");
         
        return machine2;  
    }  
  
    
    

		public List<Machine> getMachine2() {
			return machine2;
		}

		public void setMachine2(List<Machine> machine2) {
			this.machine2 = machine2;
		}

		public List<Execute> getExe() {
			return exe;
		}



		public void setExe(List<Execute> exe) {
			this.exe = exe;
		}





}
package bean;

import java.io.Serializable;  
import java.util.HashMap;  
import java.util.Map;  
  




import javax.faces.application.FacesMessage;  
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;  

 
@SuppressWarnings("serial")
@ViewScoped
@ManagedBean( name = "PPRBean" )
public class PPRBean implements Serializable {  

	  
	    private String machine;  
	  
	    private String moule;  
	    
	    private int heure;
	
	    private Map<String,String> cities = new HashMap<String, String>(); 

		private Map<String,Map<String,String>> suburbsData = new HashMap<String, Map<String,String>>();  
	      
	    private Map<String,String> suburbs = new HashMap<String, String>();  
	    
	    private int piece_h[][]={{66, 86,75,73,138},{78,60,147,75,144},{54,59,60,50},{53},{70,60,72,75,100},
	    						  {120,80,136,76,92},{59,54,59,59}, {62,63,63,69,70,72},{59}};
	    
	    private String piece[][]={{"J56","J51","J14","J06","J67"},{"J10","J16","J61","J9","J19"},{"J01","J04","J05","X01"},
	    		{"X02"},{"J07","X04","J03","J15","X05"},{"J2","J12","J53","J63","J13"},{"J59","J60","J65","J66"}, {"J52","J58","J57","J62","J64","J54"},{"X03"}};
	  
	    public PPRBean() {  
	    	cities.put("ENGEL 1000","0");  
	        cities.put("KM 800","1");  
	        cities.put("ENGEL 2000","2"); 
	        cities.put("SAND 1500","3");
	        cities.put("KM 1000","4");
	        cities.put("ENGEL 700","5");
	        cities.put("KM 2000","6");
	        cities.put("KM 1300","7");
	        cities.put("ENGEL 1500","8");
	          
	        Map<String,String> suburbs2000ENGEL = new HashMap<String, String>();  
	        suburbs2000ENGEL.put("J01","0");  
	        suburbs2000ENGEL.put( "J04","1");  
	        suburbs2000ENGEL.put( "J05","2"); 
	        suburbs2000ENGEL.put( "X01","3");
	          
	        Map<String,String> suburbs800KM = new HashMap<String, String>();  
	        suburbs800KM.put( "J10","0");  
	        suburbs800KM.put( "J16","1");  
	        suburbs800KM.put( "J61","2");  
	        suburbs800KM.put( "J9","3"); 
	        suburbs800KM.put( "J19","4");
	        //suburbs800KM.put( "X05","5");
	        
	        Map<String,String> suburbs1000ENGEL = new HashMap<String, String>();  
	       // suburbs1000ENGEL.put( "J15","0");  
	       // suburbs1000ENGEL.put( "J64","1");  
	        suburbs1000ENGEL.put("J56","0");
	        suburbs1000ENGEL.put("J51","1");
	        suburbs1000ENGEL.put( "J14","2"); 
	        suburbs1000ENGEL.put( "J06","3"); 
	        suburbs1000ENGEL.put( "J67","4"); 
	        
	        Map<String,String> suburbs1500SAND = new HashMap<String, String>();  
	       // suburbs1500SAND.put( "J52","0");  
	        suburbs1500SAND.put( "X02","0");  
	        //suburbs1500SAND.put("J54","3");
	       // suburbs1500SAND.put("J56","4");
	       // suburbs1500SAND.put("J03","5");
	        
	        Map<String,String> suburbs1000KM = new HashMap<String, String>();  
	        suburbs1000KM.put( "J07","0");  
	       // suburbs1000KM.put( "J54","1");  
	        suburbs1000KM.put("X04","1");
	        suburbs1000KM.put("J03","2");
	        suburbs1000KM.put("J15","3");
	        suburbs1000KM.put("X05","4");
	        //suburbs1000KM.put("J63","4");
	       
	        Map<String,String> suburbs700ENGEL = new HashMap<String, String>();  
	        suburbs700ENGEL.put( "J02","0");  
	        suburbs700ENGEL.put( "J12","1");  
	        suburbs700ENGEL.put("J53","2");
	        suburbs700ENGEL.put("J63","3");
	        suburbs700ENGEL.put("J13","4");
	        
	        Map<String,String> suburbs2000KM = new HashMap<String, String>();  
	       // suburbs2000KM.put( "J57","0");  
	        suburbs2000KM.put( "J59","0");  
	       // suburbs2000KM.put("J58","2");
	        suburbs2000KM.put("J60","1");
	        suburbs2000KM.put("J65","2");
	        suburbs2000KM.put("J66","3");
	        
	        Map<String,String> suburbs1300KM = new HashMap<String, String>();  
	        suburbs1300KM.put( "J52","0");  
	        suburbs1300KM.put( "J58","2"); 
	        suburbs1300KM.put("J57","3");
	        suburbs1300KM.put("J62","4");
	        suburbs1300KM.put("J64","5");
	        suburbs1300KM.put("J54","6");
	        
	        Map<String,String> suburbs1500ENGEL = new HashMap<String, String>();  
	       // suburbs1500ENGEL.put( "J03","0");  
	        suburbs1500ENGEL.put( "X03","0");  
	        //suburbs1500ENGEL.put("J65","3");
	        //suburbs1500ENGEL.put("J66","4");
	        
	     
	          
	        suburbsData.put("0", suburbs1000ENGEL);  
	        suburbsData.put("1", suburbs800KM);  
	        suburbsData.put("2", suburbs2000ENGEL); 
	        suburbsData.put("3", suburbs1500SAND);
	        suburbsData.put("4", suburbs1000KM);
	        suburbsData.put("5", suburbs700ENGEL);
	        suburbsData.put("6", suburbs2000KM);
	        suburbsData.put("7", suburbs1300KM);
	        suburbsData.put("8", suburbs1500ENGEL);
	    }  
	      
	    public String getMachine() {  
	        return machine;  
	    }  
	  
	    public void setMachine(String machine) {  
	        this.machine=machine;  
	    }  
	  
	    public String getMoule() {  
	        return moule;  
	    }  
	  
	    public void setMoule(String moule) {  
	        this.moule=moule;  
	    }  
	  
	    public Map<String, String> getCities() {  
	        return cities;  
	    }  
	  
	    public void setCities(Map<String, String> cities) {  
	        this.cities = cities;  
	    }  
	      
	    public Map<String, Map<String, String>> getSuburbsData() {  
	        return suburbsData;  
	    }  
	  
	    public void setSuburbsData(Map<String, Map<String, String>> suburbsData) {  
	        this.suburbsData = suburbsData;  
	    }  
	      
	    public Map<String, String> getSuburbs() {  
	        return suburbs;  
	    }  
	  
	    public void setSuburbs(Map<String, String> suburbs) {  
	        this.suburbs = suburbs;  
	    }  
	      
	    public void handleCityChange() {  
	        if(machine !=null && !machine.equals(""))  
	            suburbs = suburbsData.get(machine);  
	        else  
	            suburbs = new HashMap<String, String>();  
	    }  
	    String aa="";
	    int i = 0, j = 0;
	    public void displayLocation() { 
	    	
	    	if(!moule.equals("") && !machine.equals("")){
	    		i = Integer.parseInt(moule);
	    	    j =  Integer.parseInt(machine);
	    	    
	  
	    		 System.out.println("Piece  : " + piece[j][i]);
	    		  System.out.println("Piece/Heure est : " + piece_h[j][i] * heure);
	    	  //  System.out.println("La valeur du tableau à l'indice ["+j+"]["+i+"] est : ");
	    	
	    	FacesMessage msg = new FacesMessage("Selected", "Machine:" + machine + ", Moule: " + moule);
	        FacesContext.getCurrentInstance().addMessage(null, msg);  
	    	}
	    }

		public int[][] getPiece_h() {
			return piece_h;
		}

		public void setPiece_h(int piece_h[][]) {
			this.piece_h = piece_h;
		}

		public String[][] getPiece() {
			return piece;
		}

		public void setPiece(String piece[][]) {
			this.piece = piece;
		}  
		
		 public int getHeure() {
				return heure;
			}

			public void setHeure(int heure) {
				this.heure = heure;
			}
	} 
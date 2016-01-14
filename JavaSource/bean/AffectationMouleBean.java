package bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



@RequestScoped
@ManagedBean( name = "affectation" )
public class AffectationMouleBean {
	
	private String ref[] = new String[6];
	
	private String des[] = new String[6];
	
	private String moule="";
    
	private String machine="";
    
	private int cycle;
    
    private String superviseur;
    
    private String num;
    
    private Date today = new Date();
    
    private SimpleDateFormat formater = null;
    
    private Date date=today;
    
	public void Affectation() throws IOException{
		
		try {
			
			ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();  
   	    	
			String newFileName = servletContext.getRealPath("") + File.separator + "Planification" + File.separator + "template"+ File.separator+"Affectation Moule Machine.xlsx";

   	    	FileInputStream file = new FileInputStream(new File(newFileName));
		     
		   // FileInputStream file = new FileInputStream(new File("C:/Users/Yassin/Desktop/Affectation Moule Machine.xlsx"));
		      
		    XSSFWorkbook workbook = new XSSFWorkbook(file);
		 
		    XSSFSheet sheet = workbook.getSheet("affectation moule machine");
		     
		    Iterator<Row> rowIterator = sheet.iterator();
		    
		     formater = new SimpleDateFormat(" dd-MM-yyyy");
		    
		    while(rowIterator.hasNext()) {
		        Row row = rowIterator.next();
		         
		        Iterator<Cell> cellIterator = row.cellIterator();
		        while(cellIterator.hasNext()) {
		             
		            Cell cell = cellIterator.next();
		            
		            int i=0,j=0;
		            
		            switch(cell.getCellType()) {
		                
		                case Cell.CELL_TYPE_NUMERIC:
		                	
		                	if(cell.getCellStyle().getFillForegroundColor()==0){
		                		
		                		   moule="";
		        		           
		        		           machine="";
		        		           
		        		           cycle = (int) cell.getNumericCellValue();
		        		           
		        		       	i= cell.getRowIndex();
                        		j= cell.getColumnIndex();
                        		
                        			 row = sheet.getRow(i-(i-1));
			        	           
                        			 cell = row.getCell(j);
                        		
                        		 machine = cell.getStringCellValue();
                        			
                        			
                        		 row = sheet.getRow(i);
			        	           
                    			 cell = row.getCell(j-(j-2));
                    			 
                    			 moule = cell.getStringCellValue();
		                	}
		                    
		                    break;
		               // case Cell.CELL_TYPE_STRING:
		                   // System.out.print("str");
		                	//System.out.println(cell.getCellStyle().getFillForegroundColor());
		                 //   break;
		            }
		        }
		        
		        iniRef();
		        
		        getEquip();
		        
		      getCodeArticle(moule);
   	    		
		        paceBoard(moule,machine);
		        
		        //System.out.println(formater.format(date));
		       
		    }
		    file.close();
		    
		     
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();}

		/* try
	        {
	            FileInputStream file = new FileInputStream(new File("C:/Users/Yassin/Desktop/test.xlsx"));
	 
	            //Create Workbook instance holding reference to .xlsx file
	            XSSFWorkbook workbook = new XSSFWorkbook(file);
	         XSSFSheet sheet = workbook.getSheetAt(0);
	         
	         for(int i=0 ; i<4;i++){
	         
	        	 Row row = sheet.getRow(i);
  	           
    			Cell cell = row.getCell(0);
    			 
    			System.out.println(
						workbook.getSheetAt(0).getRow(i).getCell(0)
							.getCellStyle().getFillForegroundColor());
    			//System.out.println( cell.getNumericCellValue());
	         
	         }
	         }
	            //Get first/desired sheet from the workbook
	           // HSSFSheet sheet = workbook.getSheet("affectation moule machine");
	 
	        /*   int i=0,j=0;
	            Iterator<Row> rowIterator = sheet.iterator();
	            while (rowIterator.hasNext())
	            {
	                Row row = rowIterator.next();
	                String moule="";
                    String machine="";
	                //For each row, iterate through all the columns
	                Iterator<Cell> cellIterator = row.cellIterator();
	                 
	                while (cellIterator.hasNext())
	                {
	                    Cell cell = cellIterator.next();
	                    
	                    switch (cell.getCellType())
	                    {
	                        case Cell.CELL_TYPE_NUMERIC:
	                        	
	                        	if(cell.getNumericCellValue()==1)	{ 
	                        		
	                        		 moule="";
	        	                     machine="";
	                        		
	                        		i= cell.getRowIndex();
	                        		j= cell.getColumnIndex();
	                        		
	                        			 row = sheet.getRow(i-(i-1));
				        	           
	                        			 cell = row.getCell(j);
	                        		
	                        		//	 machine=cell.getStringCellValue();
	                        			
	                        			
	                        		 row = sheet.getRow(i);
				        	           
                        			 cell = row.getCell(j-(j-1));
                        			 
                        			// moule= cell.getStringCellValue();
                        		
                        				System.out.println(
                        						workbook.getSheetAt(0).getRow(j).getCell(i)
                        							.getCellStyle().getFillForegroundColor());
                        			 
                        			// System.out.println(cell.getNumericCellValue());
		  	                      
	                     
	                            break;
	               
	                }
	                    }
	                    
	                }
	                System.out.println("");
	              //  iniRef();
   	    		// getCodeArticle(moule);
   	    	//	paceBoard(moule,machine);
	              //  System.out.print(machine);
         			// System.out.print(moule);
	           }
	            file.close();
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }*/
	    }
	
	public void getEquip(){
		
		switch(num){
		
		case "A":
			
			superviseur = "Hassan";
		//	num = "A";
			break;
			
		case "B":
			
			superviseur = "Mohamed";
		//	num = "B";
			break;
			
		case "C":
			
			superviseur = "Jallal";
			//num = "C";
			break;
			
			default: 
				
				//System.out.println("erreur :"+num);
				//superviseur = "Hassan";
			//	num = "A";
				
				
			
		}
		 
	}
	public void getCodeArticle(String moule){
		
		
		 switch(moule) {
	
	
		case "J56":
			
			ref[0]= "00152697-01-RCAR";
			des[0]= "Collection Tablette Latérale D et G";
			
			break;
		
		case "J51":
			
			ref[0]="00152690-01-RCAR";
			des[0]="Collection PBAR";
			
			break;
			
		case "J14":
			
			ref[0]="00115581-02-RCAR";
			des[0]="Façade couvercle coiffe J92";
			
			ref[1]="00115583-02-RCAR";
			des[1]="Doublure couvercle coiffe J92";
			
			break;

		case "J06":
			
			ref[0]="00115615-02-RCAR";
			des[0]="Doublure portillon huche";
			
			ref[1]="00115614-02-RCAR";
			des[1]="Façade portillon huche";
			
			break;

		case "J67":
			
			ref[0]="00116436-02-RCAR";
			des[0]="Façade VP AR G";
			
			ref[1]="00117321-02-RCAR";
			des[1]="Façade VP AR D";
			
			break;

		case "J2":
			
			ref[0]="00128256-02-RCAR";
			des[0]="FCC Ecomode";
			
			break;
			
		case "J12":
			
			ref[0]= "00115647-01-RCAR";
			des[0]= "Façade rangement passager";
			
			break;
			
		case "J53":
			
			ref[0]= "00117258-02-RCAR";
			des[0]= "Façade VP PLC";
			
			break;
			
		case "J63":
			
			ref[0]= "00116418-02-RTRO";
			des[0]= "Accoudoir E1 LVE G";
			
			ref[1]= "00117312-02-RTRO";
			des[1]= "Accoudoir E1 LVE D";
			
			break;

		case "J13":
			
			ref[0]="00115642-01-RTRO";
			des[0]="Habillage lat cond D";
			
			ref[1]="00115644-01-RTRO";
			des[1]="Habillage lat pass D";
			
			ref[2]="00115645-01-RTRO";
			des[2]="Habillage lat cond G";
			
			break;

		case "J59":
			
			ref[0]="00116411-02-RCAR";
			des[0]="Porteur AV G E 1";
			
			ref[1]="00128391-02-RCAR";
			des[1]="Porteur AV G E 0";
			
			ref[2]="00116416-03-RCAR";
			des[2]="Façade VP AV G";

			break;
			
		case "J60":
			
			ref[0]="00117305-02-RCAR";
			des[0]="Porteur AV D E 1";
			
			ref[1]="00128392-03-RCAR";
			des[1]="Porteur AV D E 0";
			
			ref[2]="00117310-03-RCAR";
			des[2]="Façade VP AV D";

			break;

		case "J65":
			
			ref[0]="00128424-02-RCAR";
			des[0]="Porteur AR G E1";
			
			ref[1]="00116432-02-RCAR";
			des[1]="Porteur AR G E0";
			
			break;

		case "J66":
			
			ref[0]="00128425-02-RCAR";
			des[0]="Porteur AR D E1";
			
			ref[1]="00117317-02-RCAR";
			des[1]="Porteur AR D E0";
			
			break;

		case "J03":
			
			ref[0]="00115670-02-0000";
			des[0]="Conduit de desembuage";
			
			break;
			
		case "J15":
			
			ref[0]="00115556-02-RCAR";
			des[0]="Bac rangement sup FK67";
			
			ref[1]="00115558-02-RCAR";
			des[1]="Dessous de coife FK 67";
			
			break;
			

		case "J07":
			
			ref[0]="00115622-02-RCAR";
			des[0]="Cuve rangement inf";
			
			break;
			
		case "X05":
			
			ref[0]="00171660-02-0000";
			des[0]="Conduit de répartition X52";
			
			break;
			
		case "X04":
			
			ref[0]="00171679-02-T122";
			des[0]="Doublure Portillon Gris Lune X52";
			
			ref[1]="00171670-01-T122";
			des[1]="Facade Portillon Gris Lune X52";
			
			ref[2]="00171679-02-RCAR";
			des[2]="Doublure Portillon Carbon Foncé X52";
			
			ref[3]="00171670-01-RCAR";
			des[3]="Facade Portillon Carbon Foncé X52";
			
			ref[4]="00171679-02-S950";
			des[4]="Doublure Portillon Beige Alphaga X52";
			
			ref[5]="00171670-01-S950";
			des[5]="Facade Portillon Beige Alphaga X52";
			
			break;

		case "J01":
			
			ref[0]="00115549-02-RCAR";
			des[0]="Corp de planche  J92/X67";
			
			break;
			
		case "J05":
			
			ref[0]="00115554-02-RCAR";
			des[0]="Coiffe FK67";
			
			break;
			
		case "J04":
			
			ref[0]="00115553-02-RCAR";
			des[0]="Coiffe J92";
			
			break;
			
		case "X01":

			ref[0]="00171658-02-T122";
			des[0]="CDP Gris Lune  X52";
			
			ref[1]="00171658-02-RCAR";
			des[1]="CDP Carbon Foncé   X52";
			
			ref[2]="00171658-02-S950";
			des[2]="CDP Beige Alphaga   X52";
			
			break;

		case "X02":
			
			ref[0]="00171657-02-RCAR";
			des[0]="Coiffe X52";
			
			break;
			
		case "X03":
			
			ref[0]="00171659-02-0000";
			des[0]="Conduit de structure X52";
			
			break;
			
		case "J52":
			
			ref[0]="00128398-02-S864";
			des[0]="Tablette pavillon AV";
			
			break;
			
		case "J58":
			
			ref[0]="00117248-02-RCAR";
			des[0]="Passage de Roue Droite";
			
			break;
			
		case "J57":
			
			ref[0]="00117249-03-RCAR";
			des[0]="Passage de Roue Gauche";
			
			break;
			
		case "J62":
			
			ref[0]="00116417-02-RTRO";
			des[0]="Accoudoire LVM G";
			
			ref[1]="00117311-02-RTRO";
			des[1]="Accoudoire LVM D";
			
			break;

		case "J64":
			
			ref[0]="00116419-02-RTRO";
			des[0]="Accoudoire E2 G";
			
			ref[1]="00117314-02-RTRO";
			des[1]="Accoudoire E2 D";
			
			break;

		case "J54":
			
			ref[0]="00117255-03-RCAR";
			des[0]="Garniture PLC";
			
			break;
			
		case "J9":
			
			ref[0]="00115654-02-RCAR";
			des[0]="1/2 Coquille Sup";
			
			ref[1]="00115653-01-RCAR";
			des[1]="1/2 Coquille Inf";
			
			break;

		case "J10":
			
			ref[0]="00115665-02-RCAR";
			des[0]="Console LV";
			
			break;
			
		case "J16":
			
			ref[0]="00115748-02-0000";
			des[0]="Renfort inferieur passager ";
			
			break;
			
		case "J19":
			
			ref[0]="00127662-01-0000";
			des[0]="Renfort Genou 1 conducteur ";
			
			ref[1]="00127663-01-0000";
			des[1]="Renfort genou 3 et 4 passager ";
			
			ref[2]="00127664-01-0000";
			des[2]="Renfort genou (coquille)";
			
			break;


		case "J61":
			
			ref[0]="00116424-02-0000";
			des[0]="Padding AV G";
			
			ref[1]="00117316-02-0000";
			des[1]="Padding AV D";
			
			break;

	 default:
		 
		 ref[0]="erreur";
			
       	
		 

		}	


	}
	
	
	public  void paceBoard(String piece,String machine) {
		
			try {
				
				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();  
	   	    	
				String newFileName = servletContext.getRealPath("") + File.separator + "Planification" + File.separator + "template"+ File.separator+"Paceboard.xlsx";

	   	    	FileInputStream file = new FileInputStream(new File(newFileName));
				
		  	//	FileInputStream file = new FileInputStream(new File("C:/Users/Yassin/Desktop/Paceboard.xlsx"));

		        XSSFWorkbook wb = new XSSFWorkbook(file);
		      
		      XSSFSheet sheet = wb.getSheetAt(0);
		    
		if(!ref[0].equals("erreur")){
		     
			Cell cell = sheet.getRow(7).getCell(4);
   			cell.setCellValue(piece);
   			
   			cell = sheet.getRow(3).getCell(27);
   			cell.setCellValue(machine);
   			
   			cell = sheet.getRow(3).getCell(11);
   			cell.setCellValue(superviseur);
   			
   			cell = sheet.getRow(3).getCell(22);
   			cell.setCellValue(num);
   			
   			cell = sheet.getRow(3).getCell(25);
   			cell.setCellValue(formater.format(date));
   			
   			cell = sheet.getRow(7).getCell(19);
   			cell.setCellValue(cycle);
	
   			cell = sheet.getRow(7).getCell(2);
   			cell.setCellValue(ref[0]);
   			
   			cell = sheet.getRow(11).getCell(2);
   			cell.setCellValue(ref[1]);
   			
   			cell = sheet.getRow(15).getCell(2);
   			cell.setCellValue(ref[2]);
   			
   			cell = sheet.getRow(19).getCell(2);
   			cell.setCellValue(ref[3]);
   			
   			cell = sheet.getRow(21).getCell(2);
   			cell.setCellValue(ref[4]);
   			
   			cell = sheet.getRow(22).getCell(2);
   			cell.setCellValue(ref[5]);
   			
   			cell = sheet.getRow(7).getCell(6);
   			cell.setCellValue(des[0]);
   			
   			cell = sheet.getRow(11).getCell(6);
   			cell.setCellValue(des[1]);
   			
   			cell = sheet.getRow(15).getCell(6);
   			cell.setCellValue(des[2]);
   			
   			cell = sheet.getRow(19).getCell(6);
   			cell.setCellValue(des[3]);
   			
   			cell = sheet.getRow(21).getCell(6);
   			cell.setCellValue(des[4]);
   			
   			cell = sheet.getRow(22).getCell(6);
   			cell.setCellValue(des[5]);
   			
   			 servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();  
   	    	
			 newFileName = servletContext.getRealPath("") + File.separator + "Planification"+ File.separator+"Pace board"+ File.separator;

   	    	//FileInputStream file = new FileInputStream(new File(newFileName));
		  
		    		 FileOutputStream outFile =new FileOutputStream(new File(newFileName+piece+".xlsx"));
		           
		    		 wb.write(outFile);
		    		 outFile.close();
		    		 
		}

		    } catch (FileNotFoundException e) {
		        e.printStackTrace();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		  
	}	
	
	public void consult(){
		
		
	    try {
	    	
	    	ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
	    	String newFileName = servletContext.getRealPath("") + File.separator + "Planification" + File.separator + "template"+ File.separator +"Affectation Moule Machine.xlsx";
	    	
	    	String[] command = {"cmd", "/c", newFileName};
			Runtime.getRuntime().exec(command);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	  public void iniRef(){
			for(int i=0;i<6;i++){
				ref[i]="";
				des[i]="";
			}
		}
	    	 	
	public String[] getRef() {
		return ref;
	}

	public void setRef(String[] ref) {
		this.ref = ref;
	}

	public String[] getDes() {
		return des;
	}

	public void setDes(String[] des) {
		this.des = des;
	}

	public String getMoule() {
		return moule;
	}

	public void setMoule(String moule) {
		this.moule = moule;
	}

	public String getMachine() {
		return machine;
	}

	public void setMachine(String machine) {
		this.machine = machine;
	}

	public int getCycle() {
		return cycle;
	}

	public void setCycle(int cycle) {
		this.cycle = cycle;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getSuperviseur() {
		return superviseur;
	}

	public void setSuperviseur(String superviseur) {
		this.superviseur = superviseur;
	}

	public Date getToday() {
		return today;
	}

	public void setToday(Date today) {
		this.today = today;
	}

	public SimpleDateFormat getFormater() {
		return formater;
	}

	public void setFormater(SimpleDateFormat formater) {
		this.formater = formater;
	}
	
	 public Date getDate() {  
	        return date;  
	    }  
	  
	    public void setDate(Date date) {  
	        this.date = date;  
	    }  
}

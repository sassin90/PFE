package bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


@RequestScoped
@ManagedBean( name = "planification" )
public class PlanificationBean {
	
	private int table[] = new int[67];
	
	private String tableP[] = new String[67];
	
	private String tableM[] = new String[67];
	
	private String machine[] = new String[9];
	
	private Date today = new Date();
	
	private Date date1 = today;  
    
    private Date date2 = today;  
      
    private Date date3 = today; 
	
	
	
	 public int[] getTable() {
		return table;
	}
	public void setTable(int[] table) {
		this.table = table;
	}
	
	private int a=0;
	
	
	
	public  void tablePlanning() {
		
		tableauPlanification(10,getDate1());

			
			try {
		  		
		  		FileInputStream file = new FileInputStream(new File("C:/Users/Yassin/Desktop/Tableau Planification.xlsx"));

		        XSSFWorkbook wb = new XSSFWorkbook(file);
		         
		        XSSFSheet sheet = wb.getSheet("test");
		        
		        writePlannig(file ,sheet,3);  
		        
		        tableauPlanification(13,getDate2());
		        
		        writePlannig(file ,sheet,6); 
		        
		        tableauPlanification(16,getDate3());
		        
		        writePlannig(file ,sheet,9);
		  
		            FileOutputStream outFile =new FileOutputStream(new File("C:/Users/Yassin/Desktop/koko.xlsx"));
		           
		            wb.write(outFile);
		            outFile.close();

		    } catch (FileNotFoundException e) {
		        e.printStackTrace();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		  
				
	    	
	  	}

						  public String L3PSTime(Date dd) throws IOException{
							  
							  FileInputStream file = new FileInputStream(new File("C:/Users/Yassin/Desktop/L3PS détail 012014.xlsx")); 
					      		
				        	    XSSFWorkbook workbook = new XSSFWorkbook(file);
				        	    
				        	   Sheet sheet = workbook.getSheetAt(0);
						        
						        DateFormat formater = new SimpleDateFormat("EEEE",Locale.FRANCE);
						        
						        formater = new SimpleDateFormat("yyyy-MM-dd");
					          
						    	for (int k = 0; k < sheet.getLastRowNum()+1; k++){
						    		
						    		Row row = sheet.getRow(k);
						           
						    		Cell cell = row.getCell(5);
						    		
						    		cell.setCellType(Cell.CELL_TYPE_NUMERIC);
						    	
						    		if(formater.format(cell.getDateCellValue()).equals(formater.format(dd)) ){
						    			
						    			 cell = row.getCell(3);
						    			
						    			//String CellValue = cell.getStringCellValue();
						    			 if(table[a]==0){
						    				 formater = new SimpleDateFormat("hh");
						    				 cell = row.getCell(6);
						    				 //System.out.println("table["+a+"]"+formater.format(cell.getDateCellValue()));
						    				 return formater.format(cell.getDateCellValue()).toString();
						    			 }
						    			 else{
						    				 switch(cell.getStringCellValue()) {
						    			 
					        	            
					        	            case "681000643R":
					        	            	table[12]--;table[13]--;table[21]--;table[22]--;table[23]--;table[34]--;table[42]--;
					        	            	table[44]--;table[61]--;table[62]--;table[63]--;table[64]--;
					        	              break;
					        	              
					        	            case "681003901R":
					        	            	table[21]--;table[22]--;table[23]--;table[34]--;table[35]--;table[36]--;table[37]--;
					        	            	table[42]--;table[43]--;table[61]--;table[62]--;table[63]--;table[64]--;
					        	            	
					        	              break;
					        	              
					        	            case "681004426R":
					        	            	table[21]--;table[22]--;table[23]--;table[34]--;table[37]--;table[42]--;table[44]--;table[61]--;
					        	            	table[62]--;table[63]--;table[64]--;
						        	              break;
						        	              
					        	            case "681005017R":
					        	            	table[10]--;table[11]--;table[12]--;table[13]--;table[21]--;table[22]--;table[23]--;table[34]--;
					        	            	table[42]--;table[44]--;table[61]--;table[62]--;table[63]--;table[64]--;
					        	            	break;
						        	              
					        	            case "681006313R":
					        	            	table[12]--;table[13]--;table[17]--;table[21]--;table[22]--;table[23]--;table[34]--;table[35]--;table[36]--;
					        	            	table[42]--;table[43]--;table[61]--;table[62]--;table[63]--;table[64]--;
					        	            	
						        	              break;
						        	              
					        	            case "681007344R":
					        	            	table[17]--;table[21]--;table[22]--;table[23]--;table[34]--;table[35]--;table[36]--;table[37]--;
					        	            	table[42]--;table[43]--;table[61]--;table[62]--;table[63]--;table[64]--;
					        	            	
						        	              break;
						        	              
					        	            case "681007582R":
					        	            	table[12]--;table[13]--;table[21]--;table[22]--;table[23]--;table[34]--;table[35]--;table[36]--;
					        	            	table[42]--;table[43]--;table[61]--;table[62]--;table[63]--;table[64]--;
					        	            	
						        	              break;
						        	              
					        	            case "681002974R":
					        	            	table[10]--;table[11]--;table[12]--;table[13]--;table[17]--;table[21]--;
					        	            	table[22]--;table[23]--;table[34]--;table[42]--;table[44]--;
					        	            	table[61]--;table[62]--;table[63]--;table[64]--;
					        	            		break;
					        	            		
					        	            case "681001430R":
					        	            	table[12]--;table[13]--;table[17]--;table[21]--;table[22]--;table[23]--;table[34]--;
					        	            	table[42]--;table[44]--;table[61]--;table[62]--;table[63]--;table[64]--;
					        	            
					        	            		break;
					        	            		
					        	            case "681004861R":
					        	            	table[17]--;table[21]--;table[22]--;table[23]--;table[34]--;table[37]--;table[42]--;table[44]--;
					        	            	table[61]--;table[62]--;table[63]--;table[64]--;
					        	            	
					        	            		break;
						        	              
					        	            default:
					        	             
					        	          } 
						    				 
						    				 
						    		}
						    		}
						    		}
						    	
						    	//PNO D
						    	

						    	
						    	 sheet = workbook.getSheetAt(1);
							        
							    formater = new SimpleDateFormat("EEEE",Locale.FRANCE);
							        
							        formater = new SimpleDateFormat("yyyy-MM-dd");
						          
							    	for (int k = 0; k < sheet.getLastRowNum()+1; k++){
							    		
							    		Row row = sheet.getRow(k);
							           
							    		Cell cell = row.getCell(5);
							    		
							    		cell.setCellType(Cell.CELL_TYPE_NUMERIC);
							    	
							    		//System.out.println(cell.getDateCellValue());
							    		//String koko=formater.format(cell.getDateCellValue());
							    
							    		if(formater.format(cell.getDateCellValue()).equals(formater.format(dd))) {
							    			
							    			 cell = row.getCell(3);
							    			
							    			 if(table[a]==0){
							    				
							    				 formater = new SimpleDateFormat("hh");
							    				 cell = row.getCell(6);
							    			
							    				 return formater.format(cell.getDateCellValue()).toString();
							    			 }
							    			 else{
							    				 switch(cell.getStringCellValue()) {
							    			 
						        	            
							    				 case "809003785R":
					    	        	            	table[28]--;table[29]--;table[66]--;
					    	        	            	
					    	        	              break;
					    	        	              
					    	        	            case "809004905R":
					    	        	            	table[27]--;table[29]--;table[54]--;table[66]--;
					    	        	            	
					    	        	              break;
					    	        	              
					    	        	            case "809007372R":
					    	        	            	table[27]--;table[20]--;table[29]--;table[66]--;
					    	        	            
					    		        	              break;
					    		        	              
					    	        	            case "809008988R":
					    	        	            	table[27]--;table[29]--;table[56]--;table[66]--;
					    	        	            
					    	        	            	break;
					    		        	              
					    	        	            case "829A05113R":
					    	        	            	table[15]--;table[32]--;table[54]--;
					    	        	            	
					    		        	              break;
					    		        	              
					    	        	            case "829A09392R":
					    	        	            	table[15]--; table[20]--; table[32]--;  	        	            	
					    		        	           
					    	        	            	break;
					    		        	              
					    	        	            case "829A09948R":
					    	        	            	table[15]--;table[33]--;
					    	        	            	
					    	        	            	break;
					    		        	              
					    	        	            case "829A16244R":
					    	        	            	table[18]--;table[57]--;
					    	        	            	
					    	        	            		break;
					    	        	            		
					    	        	            case "829A16774R":
					    	        	            	table[57]--;
					    	        	            	
					    	        	            		break;
							        	              
						        	            default:
						        	             
						        	          } 
							    		}
							    		}
							    		}
							    	
							    	//PNO G
							    	
								     sheet = workbook.getSheetAt(2);
									        
									     formater = new SimpleDateFormat("EEEE",Locale.FRANCE);
									        
									        formater = new SimpleDateFormat("yyyy-MM-dd");
								          
									    	for (int k = 0; k < sheet.getLastRowNum()+1; k++){
									    		
									    		Row row = sheet.getRow(k);
									           
									    		Cell cell = row.getCell(5);
									    		
									    		cell.setCellType(Cell.CELL_TYPE_NUMERIC);
									    	
									    
									    		if(formater.format(cell.getDateCellValue()).equals(formater.format(dd))) {
									    			
									    			 cell = row.getCell(3);
									    			
									    			//String CellValue = cell.getStringCellValue();
									    			 if(table[a]==0){
									    				 formater = new SimpleDateFormat("hh");
									    				 cell = row.getCell(6);
									    				
									    				 return formater.format(cell.getDateCellValue()).toString();
									    			 }
									    			 else{
									    				 switch(cell.getStringCellValue()) {
									    			 
								        	            
									    				   case "809010644R":
					 	   	    	        	            	table[24]--;table[26]--;table[53]--;table[65]--;
					 	   	    	        	            	
					 	   	    	        	              break;
					 	   	    	        	              
					 	   	    	        	            case "809011026R":
					 	   	    	        	            	table[24]--;table[26]--;table[55]--;table[65]--;
					 	   	    	        	            	
					 	   	    	        	              break;
					 	   	    	        	              
					 	   	    	        	         case "809013872R":
					 	   	    	        	        	 	table[19]--;table[24]--;table[26]--;table[65]--;
					 	   	    	        	            	
					 	   	    	        	              break;
					 	   	    	        	              
					 	   	    	        	            case "809015521R":
					 	   	    	        	            	table[25]--;table[26]--;table[65]--;
					 	   	    	        	            
					 	   	    		        	              break;
					 	   	    		        	              
					 	   	    	        	            case "809017849R":
					 	   	    	        	            	table[24]--;table[26]--;table[55]--;table[65]--;
					 	   	    	        	            
					 	   	    	        	            	break;
					 	   	    		        	              
					 	   	    	        	            case "829A10959R":
					 	   	    	        	            	table[57]--;table[18]--;
					 	   	    	        	            	
					 	   	    		        	              break;
					 	   	    		        	              
					 	   	    	        	            case "829A13474R":
					 	   	    	        	            	table[14]--;table[30]--;table[53]--;
					 	   	    	        	            	
					 	   	    		        	              break;
					 	   	    		        	              
					 	   	    	        	            case "829A13934R":
					 	   	    	        	            	table[57]--;
					 	   	    	        	            	
					 	   	    	        	            		break;
					 	   	    	        	            		
					 	   	    	        	            case "829A15254R":
					 	   	    	        	            	table[14]--;table[31]--;
					 	   	    	        	            	
					 	   	    	        	            		break;
					 	   	    	        	            		
					 	   	    	        	         case "829A17388R":
					 	   	    	        	        	 table[57]--;
					 	   	    	        	            	
					 	    	        	            		break;
					 	    	        	            		
					 	   	    	        	      case "829A19085R":
					 	   	    	        	    	  table[14]--;table[19]--;table[30]--;
					 	    	        	            	
					 	    	        	            		break;
									        	              
								        	            default:
								        	             
								        	          } 
									    			 }
									    		}
									    	}
											 return "table["+a+"]14".toString();
						    	
								    		
						        }
						  
						  
						  
						  public void iniTable(){
								for(int i=0;i<67;i++){
									table[i]=-1;
								}
							}
					
						  
						 /* public void getProjet(){
							  
							  String PLS[]={"J56","J51","J2","J52","J58","J57","J9","J10"};
							  
							  for(int i=0;i<;i++){
								  
							  }
						  }*/
						  
						  public void getInfo(String ma,String p_h){
							  
					    	   	
		    		    		switch(ma) {
		    	        	         
		    	        	            case "ENGL 1000":
		    	        	            
		    	        	    			machine[0] = p_h +" h";
		    	        	            	
		    	        	            	
		    	        	              break;
		    	        	              
		    	        	            case "ENGL 1500":
		    	        	            	
		    	        	            	machine[1] = p_h +" h";
		        	        	            	
		        	        	            	
		        	        	              break;
		        	        	              
											case "ENGL 700":
																    	        	            	
												machine[2] = p_h +" h";
																        	        	            	
																        	        	            	
											break;
																        	        	              
											 case "KM 2000":
																 	
												 machine[3] = p_h +" h";
																     	
										 break;
																       
											 case "KM 1000":
																 	
												 machine[4] = p_h +" h";  	
																     	
											 break;
																       
											 case "ENGL 2000":
																 	
												 machine[5] = p_h +" h";
																     	
																     	
											break;
																       
										 case "SAND 1500":
																 	
											 machine[6] = p_h +" h";
																     	
																     	
									 break;
																       
										 case "KM 1300":
																 	
											 machine[7] = p_h +" h";
																     	
																     	
									 break;
									 
										 case "KM 800":
											 	
											 machine[8] = p_h +" h";
																		     	
																		     	
											 break;
		    	        	          
										 default:
											 
											 
		    		    		}
							  
						  }
						  
					
							
							public void tableauPlanification(int col,Date dd){
						     	
						      	try {
						       
						      		FileInputStream file = new FileInputStream(new File("C:/Users/Yassin/Desktop/test4.xls")); 
						      		
						        	    HSSFWorkbook workbook = new HSSFWorkbook(file);
						        	
						        	    Sheet sheet = workbook.getSheet("etat du stock");
						        	    
						        	    iniTable();
						        	    		
						        	    		for (int j = 14; j < 73; j++){
						        	    			
						        	    			int i=0;
						        	    		
						        	    		Row row = sheet.getRow(j);
						        	           
						        	    		Cell cell = row.getCell(col);
						        	    		
						        	    		if(cell.getNumericCellValue()<0){
						 	        	           
							        	    		 cell = row.getCell(8);
							        	    		 
							        	    		 cell.setCellType(Cell.CELL_TYPE_NUMERIC);
							        	    		 
							        	    		    String p_h="";
							        	    		   
							        	    		    String machine="";
							        	    		 
							        	    		 table[j-6] = (int) cell.getNumericCellValue();
							        	    		 
							        	    		 cell = row.getCell(7);
							        	    		 
							        	    		 while(cell.getStringCellValue().equals("")){
							        	    			
							        	    			 j--;
							        	    			 i++;
							        	    			 
							        	    			 row = sheet.getRow(j);
							        	    			 cell = row.getCell(7);
							        	    			 
							        	    		 }
							        	    		 
							        	    		 tableP[j-6] = cell.getStringCellValue();
							        	    		p_h +=tableP[j-6]+" ";
							        	    		
							        	    		 cell = row.getCell(0);
							        	    		 while(cell.getStringCellValue().equals("")){
								        	    			
							        	    			 j--;
							        	    			 i++;
							        	    			 
							        	    			 row = sheet.getRow(j);
							        	    			 cell = row.getCell(0);
							        	    			 
							        	    		 }
							        	    		
							        	    		 tableM[j-6]=cell.getStringCellValue();
							        	    		 machine=tableM[j-6];
							        	    		
							        	    		 j=j+i;
							        	    		 
							        	    		 a=j-6;
							        	    		
							        	    		p_h+=L3PSTime(dd);
							        	    		
							        	    		getInfo(machine,p_h);
							        	    		
							        	    		//int pos = Integer.parseInt(L3PSTime(dd));
							        	    		
							        	    		
							        	    		 }
						        	    	
						        	    		}
						        	    		//tablePlanning();
						        	    
						        	} catch (FileNotFoundException e) {
						        	    e.printStackTrace();
						        	} catch (IOException e) {
						        	    e.printStackTrace();
						        	}
								
							 }
							
							public void writePlannig(FileInputStream file , Sheet sheet,int col) throws IOException{
							
								Cell cell;
					    	   
		    		    	
        	            	cell = sheet.getRow(4).getCell(col);
        	    			cell.setCellValue(machine[0]);
        	            
        	            	
        	            	cell = sheet.getRow(5).getCell(col);
        	    			cell.setCellValue(machine[1]);
	        	           
												    	        	            	
							cell = sheet.getRow(6).getCell(col);
							cell.setCellValue(machine[2]);
						
												 	
							cell = sheet.getRow(7).getCell(col);
							cell.setCellValue(machine[3]);
					
												 	
							cell = sheet.getRow(8).getCell(col);
							cell.setCellValue(machine[4]);
							
												 	
							cell = sheet.getRow(9).getCell(col);
							cell.setCellValue(machine[5]);
						
												 	
						cell = sheet.getRow(10).getCell(col);
						cell.setCellValue(machine[6]);
					
												 	
						cell = sheet.getRow(11).getCell(col);
						cell.setCellValue(machine[7]);
				
							 	
					    cell = sheet.getRow(12).getCell(col);
						cell.setCellValue(machine[8]);
	
						file.close();
							}
							
						/*	public int getHeurePos(int heure){
								
								int pos=-1;
								
								if(heure>22 && heure<=6) pos =0;
								else if((heure>6 && heure<=2)) pos=1;
								else 
							}*/
							
							public int getDatePos(Date dd){
								
								SimpleDateFormat formater = new SimpleDateFormat("EEEE",Locale.FRANCE);
								
								int posDate;
							
								 switch(formater.format(dd)) {
        	         
								 case "Vendredi":
        	            	
									 posDate= 3;
									
									 break;
        	              
								 case "Samedi":
									 
									 posDate= 6;
			        	            	
									 break;
									 
								 case "Dimanche":
									 
									 posDate= 9;
			        	            	
									 break;
									 
								 case "Lundi":
									 
									 posDate= 12;
			        	            	
									 break;
									 
								 case "Mardi":
									 
									 posDate= 15;
			        	            	
									 break;
									 
								 case "Mercredi":
									 
									 posDate= 18;
			        	            	
									 break;
									 
								 case "Jeudi":
									 
									 posDate= 21;
			        	            	
									 break;

						default:
							
							posDate= -1;
								 }
								return posDate;
								
							}
							
							
							
						public int getA() {
							return a;
						}
						public void setA(int a) {
							this.a = a;
						}
						public String[] getTableP() {
							return tableP;
						}
						public void setTableP(String tableP[]) {
							this.tableP = tableP;
						}
						public String[] getTableM() {
							return tableM;
						}
						public void setTableM(String tableM[]) {
							this.tableM = tableM;
						}
						public String[] getMachine() {
							return machine;
						}
						public void setMachine(String machine[]) {
							this.machine = machine;
						}
					
						public Date getDate1() {
							return date1;
						}
						public void setDate1(Date date1) {
							this.date1 = date1;
						}
						public Date getDate2() {
							return date2;
						}
						public void setDate2(Date date2) {
							this.date2 = date2;
						}
						public Date getDate3() {
							return date3;
						}
						public void setDate3(Date date3) {
							this.date3 = date3;
						}
}

package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.primefaces.model.UploadedFile;



@RequestScoped
@ManagedBean( name = "L3psBean" )
public class walo  {
	
	private SimpleDateFormat formater = null;
	
	private Date today = new Date();
	
	private Date date1 = today;  
    
    private Date date2 = today;  
      
    private Date date3 = today; 
    
    private Date date = today;
    
    private String dd;
   
    private String dd1;
    
    private String dd2;
    
    private int debut1 = 1;
    
    private int fin1 = debut1+360;
    
    private int debut2 = 1;
    
    private int fin2 = debut2+360;
    
    private int debut3 = 1;
 
    private int fin3 = debut3+360;
    
    private int debut4 = 1;
    
    private int fin4 = debut4+600;
    
    private int debut5 = 1;
    
    private int fin5 = debut5+600;
    
    private int debut6 = 1;
 
    private int fin6 = debut6+600;
    
    private int debut7 = 1;
    
    private int fin7 = debut7+600;
    
    private int debut8 = 1;
    
    private int fin8 = debut8+600;
    
    private int debut9 = 1;
    
    private int fin9 = debut9+600; 
    
    private int table[] = new int[100];
	
	private int tableQAD[] = new int[100];
	
	private UploadedFile fileL3ps;
	 
	private UploadedFile fileExtraction;
	
	private UploadedFile fileQAD;
	 
	private String[] file = new String[3];
   
	public int getDebut7() {
		return debut7;
	}

	public void setDebut7(int debut7) {
		this.debut7 = debut7;
	}

	public int getFin7() {
		return fin7;
	}

	public void setFin7(int fin7) {
		this.fin7 = fin7;
	}

	public int getDebut8() {
		return debut8;
	}

	public void setDebut8(int debut8) {
		this.debut8 = debut8;
	}

	public int getFin8() {
		return fin8;
	}

	public void setFin8(int fin8) {
		this.fin8 = fin8;
	}

	public int getDebut9() {
		return debut9;
	}

	public void setDebut9(int debut9) {
		this.debut9 = debut9;
	}

	public int getFin9() {
		return fin9;
	}

	public void setFin9(int fin9) {
		this.fin9 = fin9;
	}

	public int getDebut4() {
		return debut4;
	}

	public void setDebut4(int debut4) {
		this.debut4 = debut4;
	}

	public int getFin4() {
		return fin4;
	}

	public void setFin4(int fin4) {
		this.fin4 = fin4;
	}

	public int getDebut5() {
		return debut5;
	}

	public void setDebut5(int debut5) {
		this.debut5 = debut5;
	}

	public int getFin5() {
		return fin5;
	}

	public void setFin5(int fin5) {
		this.fin5 = fin5;
	}

	public int getDebut6() {
		return debut6;
	}

	public void setDebut6(int debut6) {
		this.debut6 = debut6;
	}

	public int getFin6() {
		return fin6;
	}

	public void setFin6(int fin6) {
		this.fin6 = fin6;
	}
	
	public walo(){
		
		setFormater(new SimpleDateFormat("EEEE, d MMM yyyy",Locale.FRANCE));
      
        dd=formater.format(getDate1());
        getDate2().setTime(getDate1().getTime() + 1 * 24 * 60 * 60 * 1000);
        dd1=formater.format(getDate2());
        getDate3().setTime(getDate2().getTime() + 1 * 24 * 60 * 60 * 1000);
        dd2=formater.format(getDate3());
       
        Calendar cal = Calendar.getInstance(); 
        
    	cal.add(Calendar.DAY_OF_MONTH, 0); 
		 date1 = cal.getTime();
		 
		  cal = Calendar.getInstance(); 

		cal.add(Calendar.DAY_OF_MONTH, 1); 
		 date2 = cal.getTime();
		 
		  cal = Calendar.getInstance(); 

			cal.add(Calendar.DAY_OF_MONTH, 2); 
			date3 = cal.getTime();
	}

	 public int[] extractQAD(){//17
		 
	      	try {
       	     
	      		upload();
		      	
	      		String aa = file[2];
	        	   //FileInputStream file = new FileInputStream(new File("C:/Users/Yassin/Desktop/QAD.xls")); 
	      		FileInputStream file = new FileInputStream(new File(aa)); 
	      		
	        	    HSSFWorkbook workbook = new HSSFWorkbook(file);
	        	 
	        	    //Sheet sheet = workbook.getSheetAt(2);
	        	    Sheet sheet = workbook.getSheetAt(0);
	     	
		 for (int j = 0; j < sheet.getLastRowNum()+1; j++){
 			
	    		
	    		Row row = sheet.getRow(j);
	           
	    		Cell cell = row.getCell(0);

	    	String CellValue = cell.getStringCellValue();
     	  
	 		
	 		switch(CellValue) {
	 	         
	 	            case "00115625-02-RCAR":
	 	            	
	 	            //cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	 	            cell = row.getCell(11);
	 	            tableQAD [0] += (int) cell.getNumericCellValue();
	 	            	
	 	            	
	 	              break;
	 	              
	 	            case "00117138-02-RCAR":
					    	
					    	//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
					    	cell = row.getCell(11);
				     tableQAD [1] += (int) cell.getNumericCellValue();
				
				     	
				     		break;
	 	              
	 	            		case "00117137-02-RCAR":
			    	    	
	 			    	    	cell = row.getCell(11);
	 			    	    	tableQAD [2] += (int) cell.getNumericCellValue();
	 		    	    	
	 			            				break;
	 			            				
	 	            		case "00117140-02-RCAR":
									
									//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
									cell = row.getCell(11);
									tableQAD [3] += (int) cell.getNumericCellValue();
							
						 	
						 		break;
	 			            				
	 	            		case "00117139-02-RCAR":
						    		
						    		cell = row.getCell(11);
						    		tableQAD [4] += (int) cell.getNumericCellValue();
					 	    	
					         	
					         		break;
	 	                  		
		        	         case "00128260-03-RCAR":
		        	        	 
		        	        	//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
		        	        	cell = row.getCell(11);
		        	            tableQAD [5] += (int) cell.getNumericCellValue();
		        	        
		        	            	
	 	            		break;
	 	            		
		        	case "00129905-02-RCAR":
		        		
		        	//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
		        	cell = row.getCell(11);
	          tableQAD [6] += (int) cell.getNumericCellValue();
	 	    
	          	
	          		break;
	          		
		        	case "00130772-03-RCAR":
						
						//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
						cell = row.getCell(11);
				     tableQAD [7] += (int) cell.getNumericCellValue();
					
					
						break;
			        	              
		        case "00152697-01-RCAR":
		        	
		        	//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
		        	cell = row.getCell(11);
	         tableQAD [8] += (int) cell.getNumericCellValue();
	 	    	
	         	
	         		break;
	         		
							
					case "00152690-01-RCAR":
						
							//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
							cell = row.getCell(11);
					     tableQAD [9] += (int) cell.getNumericCellValue();
						
						
							break;
							
							
							case "00115581-02-RCAR":
								
								//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
								cell = row.getCell(11);
						          tableQAD [10] += (int) cell.getNumericCellValue();
								
						
							break;
	 
						case "00115583-02-RCAR":
							
							//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
							cell = row.getCell(11);
					        tableQAD [11] += (int) cell.getNumericCellValue();
							
					
									break;
					
						case "00115615-02-RCAR":
						
						//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
						cell = row.getCell(11);
				        tableQAD [12] += (int) cell.getNumericCellValue();
						
				
					break;
					
						case "00115614-02-RCAR":
							
							//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
							cell = row.getCell(11);
					        tableQAD [13] += (int) cell.getNumericCellValue();
							
					
						break;
						
						case "00116436-02-RCAR":
							
							//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
							cell = row.getCell(11);
					        tableQAD [14] += (int) cell.getNumericCellValue();
							
					
						break;
						
						case "00117321-02-RCAR":
							
							//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
							cell = row.getCell(11);
					        tableQAD [15] += (int) cell.getNumericCellValue();
							
					
						break;
		        	 
						case "00201498-01-RCAR":
	        	        	 
		        	        	cell = row.getCell(11);
		        	            tableQAD [16] += (int) cell.getNumericCellValue();
		        	        	 
		        	            	
		        	              break;
		        	              
		        	            case "00201496-01-RCAR":
		        	            	
		        	            cell = row.getCell(11);
		        	            tableQAD [16] += (int) cell.getNumericCellValue();
		        	            	
		        	            
			        	              break;
			        	              
		        	            case "00201499-01-RCAR":
		        	            	
		        	            cell = row.getCell(11);
		        	            tableQAD [16] += (int) cell.getNumericCellValue();
		        	            
		        	            
		        	            	break;
			        	              
		        	            case "00201500-01-RCAR":
		        	            	
		        	            cell = row.getCell(11);
		        	            tableQAD [16] += (int) cell.getNumericCellValue();
		        	            	
		        	            	
			        	              break;
			        	              
		        	            case "00201497-01-RCAR":
		        	            	
		        	            cell = row.getCell(11);
		        	            tableQAD [16] += (int) cell.getNumericCellValue();
		        	            	
		        	            	
			        	              break;
			        	              
		        	            case "00201501-01-RCAR":
		        	            	
		        	            cell = row.getCell(11);
		        	            tableQAD [16] += (int) cell.getNumericCellValue();
		        	            	
		        	            	
		        	            		break;
		        	            		
		        	            case "00201495-01-RCAR":
		        	            	
		        	            cell = row.getCell(11);
		        	            tableQAD [16] += (int) cell.getNumericCellValue();
		        	            	
		        	            	
		        	            		break;
		        	            		
		        	            case "00128256-02-RCAR":
		        	            	
		        	            	cell = row.getCell(11);
	 	        	            tableQAD [16] += (int) cell.getNumericCellValue();
	 	        	            
	 	        	            break;
			
						case "00115647-01-RCAR":
						
						//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
						cell = row.getCell(11);
				        tableQAD [17] += (int) cell.getNumericCellValue();
						
				
					break;
					
						case "00117258-02-RCAR":
						
						//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
						cell = row.getCell(11);
				        tableQAD [18] += (int) cell.getNumericCellValue();
						
				
					break;
					
						case "00116418-02-RTRO":
							
							//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
							cell = row.getCell(11);
					        tableQAD [19] += (int) cell.getNumericCellValue();
							
					
						break;
						
							case "00117312-02-RTRO":
							
							//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
							cell = row.getCell(11);
					         tableQAD [20] += (int) cell.getNumericCellValue();
							
					
						break;
				
					case "00115642-01-RTRO":
						
						//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
						cell = row.getCell(11);
				        tableQAD [21] += (int) cell.getNumericCellValue();
						
				
					break;
					
						case "00115644-01-RTRO":
						
						//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
						cell = row.getCell(11);
				        tableQAD [22] += (int) cell.getNumericCellValue();
						
				
					break;
					

						case "00115645-01-RTRO":
						
						//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
						cell = row.getCell(11);
				        tableQAD [23] += (int) cell.getNumericCellValue();
						
				
					break;
					
						case "00116411-02-RCAR":
							
							//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
							cell = row.getCell(11);
					        tableQAD [24] += (int) cell.getNumericCellValue();
							
					
						break;
						
						case "00128391-02-RCAR":
							
							//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
							cell = row.getCell(11);
					        tableQAD [25] += (int) cell.getNumericCellValue();
							
					
						break;
						
						case "00116416-03-RCAR":
							
							//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
							cell = row.getCell(11);
					        tableQAD [26] += (int) cell.getNumericCellValue();
							
					
						break;
						
						case "00117305-02-RCAR":
							
							//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
							cell = row.getCell(11);
					       tableQAD [27] += (int) cell.getNumericCellValue();
							
					
						break;
						
						case "00128392-03-RCAR":
							
							//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
							cell = row.getCell(11);
					        tableQAD [28] += (int) cell.getNumericCellValue();
							
					
						break;
							
							case "00117310-03-RCAR":
							
							//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
							cell = row.getCell(11);
					         tableQAD [29] += (int) cell.getNumericCellValue();
							
					
						break;	
						
							case "00128424-02-RCAR":
								
								//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
								cell = row.getCell(11);
						        tableQAD [30] += (int) cell.getNumericCellValue();
								
						
							break;
							
								case "00116432-02-RCAR":
								
								//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
								cell = row.getCell(11);
						         tableQAD [31] += (int) cell.getNumericCellValue();
								
						
							break;
							
								case "00128425-02-RCAR":
									
									//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
									cell = row.getCell(11);
							        tableQAD [32] += (int) cell.getNumericCellValue();
									
							
								break;
								
								case "00117317-02-RCAR":
									
									//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
									cell = row.getCell(11);
							      tableQAD [33] += (int) cell.getNumericCellValue();
									
							
								break;
								
								case "00115670-02-0000":
									
									//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
									cell = row.getCell(11);
							           tableQAD [34] += (int) cell.getNumericCellValue();
									
							
								break;
								
								case "00115556-02-RCAR":
									
									//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
									cell = row.getCell(11);
							        tableQAD [35] += (int) cell.getNumericCellValue();
									
							
								break;
								
								case "00115558-02-RCAR":
									
									//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
									cell = row.getCell(11);
							        tableQAD [36] += (int) cell.getNumericCellValue();
									
							
								break;
								
								case "00115622-02-RCAR":
									
									//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
									cell = row.getCell(11);
							       tableQAD [37] += (int) cell.getNumericCellValue();
									
							
								break;
								
									case "00171660-02-0000":
									
									//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
									cell = row.getCell(11);
							        tableQAD [38] += (int) cell.getNumericCellValue();
									
							
								break;
								
									case "00171670-01-T122":
										
										//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
										cell = row.getCell(11);
								         tableQAD [39] += (int) cell.getNumericCellValue();
										
								
									break;
									
									case "00171670-01-RCAR":
										
										//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
										cell = row.getCell(11);
								        tableQAD [40] += (int) cell.getNumericCellValue();
										
								
									break;
									
										case "00171670-01-S950":
										
										//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
										cell = row.getCell(11);
								        tableQAD [41] += (int) cell.getNumericCellValue();
										
								
									break;
									
										case "00115549-02-RCAR":
											
											//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
											cell = row.getCell(11);
									        tableQAD [42] += (int) cell.getNumericCellValue();
											
									
										break;
										
										case "00115554-02-RCAR":
											
											//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
											cell = row.getCell(11);
									        tableQAD [43] += (int) cell.getNumericCellValue();
											
									
										break;
										
										case "00115553-02-RCAR":
											
											//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
											cell = row.getCell(11);
									        tableQAD [44] += (int) cell.getNumericCellValue();
											
									
										break;
										
										case "00171658-02-T122":
											
											//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
											cell = row.getCell(11);
									        tableQAD [45] += (int) cell.getNumericCellValue();
											
									
										break;
										
										case "00171658-02-RCAR":
											
											//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
											cell = row.getCell(11);
									        tableQAD [46] += (int) cell.getNumericCellValue();
											
									
										break;
										
										case "00171658-02-S950":
											
											//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
											cell = row.getCell(11);
									        tableQAD [47] += (int) cell.getNumericCellValue();
											
									
										break;
										
										case "00171657-02-RCAR":
											
											//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
											cell = row.getCell(11);
									       tableQAD [48] += (int) cell.getNumericCellValue();
											
									
										break;
										
										case "00171659-02-0000":
											
											//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
											cell = row.getCell(11);
									        tableQAD [49] += (int) cell.getNumericCellValue();
											
									
										break;
										
										case "00128398-02-S864":
		    	        	            	
				    	        	            cell = row.getCell(11);
				    	        	            tableQAD [50] += (int) cell.getNumericCellValue();
				    	        	          
				    	        	            break;
										
										case "00117248-02-RCAR":
											 
												cell = row.getCell(11);
											   tableQAD [51] += (int) cell.getNumericCellValue();
												
													break;
													
											case "00117249-03-RCAR":
											 
												cell = row.getCell(11);
											   tableQAD [52] += (int) cell.getNumericCellValue();
												
												
													break;
				    	        	            
										case "00116417-02-RTRO":
											
											//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
											cell = row.getCell(11);
									        tableQAD[53] += (int) cell.getNumericCellValue();
											
									
										break;
										
										case "00117311-02-RTRO":
											
											//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
											cell = row.getCell(11);
									       tableQAD [54] += (int) cell.getNumericCellValue();
											
									
										break;
										
										case "00116419-02-RTRO":
											
											//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
											cell = row.getCell(11);
									       tableQAD [55] += (int) cell.getNumericCellValue();
											
									
										break;
										
										case "00117314-02-RTRO":
											
											//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
											cell = row.getCell(11);
									        tableQAD [56] += (int) cell.getNumericCellValue();
											
									
										break;
										
										case "00117255-03-RCAR":
											
											//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
											cell = row.getCell(11);
											tableQAD [57] += (int) cell.getNumericCellValue();
											
									
										break;
										
										case "00115654-02-RCAR":
				    	        	    	  
				    	        	    	//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
				    	        	    	cell = row.getCell(11);
			 	        	            tableQAD [58] += (int) cell.getNumericCellValue();
				    	        	    
				        	            	
				        	            		break;
				        	            		
				    	        	  case "00115653-01-RCAR":
				    	        		  
				    	        		//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
				    	        		cell = row.getCell(11);
				        	            tableQAD [59] += (int) cell.getNumericCellValue();
			    	        	    
				        	            	
				        	            		break;
				        	            		
				    	        	  		case "00115665-02-RCAR":
				    						
				    	        	  			cell = row.getCell(11);
				    				            tableQAD [60] += (int) cell.getNumericCellValue();
				    						
				    				
				    					break;
										
										case "00115748-02-0000":
											
											//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
											cell = row.getCell(11);
									         tableQAD [61] += (int) cell.getNumericCellValue();
											
									
										break;
										
										case "00127662-01-0000":
											
											//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
											cell = row.getCell(11);
									        tableQAD [62] += (int) cell.getNumericCellValue();
											
									
										break;
										
										case "00127663-01-0000":
											
											//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
											cell = row.getCell(11);
									        tableQAD [63] += (int) cell.getNumericCellValue();
											
									
										break;
										
										case "00127664-01-0000":
											
											//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
											cell = row.getCell(11);
									        tableQAD [64] += (int) cell.getNumericCellValue();
											
									
										break;
										
										case "00116424-02-0000":
											
											//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
											cell = row.getCell(11);
									        tableQAD [65] += (int) cell.getNumericCellValue();
											
									
										break;
										
										case "00117316-02-0000":
											
											//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
											cell = row.getCell(11);
									        tableQAD [66] += (int) cell.getNumericCellValue();
											
									
										break;
										case "00171679-02-T122":
											
											//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
											cell = row.getCell(11);
									        tableQAD [67] += (int) cell.getNumericCellValue();
											
									
										break;
									
                                        case "00171679-02-RCAR":
											
											//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
											cell = row.getCell(11);
									        tableQAD [68] += (int) cell.getNumericCellValue();
											
									
										break;
                                        case "00171679-02-S950":
											
											//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
											cell = row.getCell(11);
									        tableQAD [69] += (int) cell.getNumericCellValue();
											
									
										break;
										default:
	 	        	             
	 	        	          }
		 }
	      	}
	      	 catch (FileNotFoundException e) {
	        	    e.printStackTrace();
	        	} catch (IOException e) {
	        	    e.printStackTrace();
	        	}
			return tableQAD;
	 					}
	
	/* public int[] extractQAD(){
	     	
	      	try {
	        	     
	        	   //FileInputStream file = new FileInputStream(new File("C:/Users/Yassin/Desktop/QAD.xls")); 
	      		FileInputStream file = new FileInputStream(new File("C:/Users/Yassin/Desktop/test/planification 11032014.xls")); 
	      		
	        	    HSSFWorkbook workbook = new HSSFWorkbook(file);
	        	 
	        	    //Sheet sheet = workbook.getSheetAt(2);
	        	    Sheet sheet = workbook.getSheet("etat du stock");
	        	    		
	        	    		for (int j = 6; j < 73; j++){
	        	    		
	        	    		Row row = sheet.getRow(j);
	        	           
	        	    		Cell cell = row.getCell(8);
	        	    	
	        	            tableQAD[j-6]= (int) cell.getNumericCellValue();
	        	    		
	        	    		}
	        	             
	        	          // file.close();
	        	 
	            		
	        	} catch (FileNotFoundException e) {
	        	    e.printStackTrace();
	        	} catch (IOException e) {
	        	    e.printStackTrace();
	        	}
			return tableQAD;
		 }*/
	 
	 public String[] upload() throws UnsupportedEncodingException {  
	      
		 if(fileL3ps != null) {  
	        
			 byte[] aa = fileL3ps.getFileName().getBytes();
			 file[0] = new String(aa, "UTF-8");
	           //file[0] = fileL3ps.getFileName();
	       }  
	       
	       if(fileExtraction != null) {  
		          
	    	   byte[] bb = fileExtraction.getFileName().getBytes();
				 file[1] = new String(bb, "UTF-8");
	           //file[1] = fileExtraction.getFileName();
	       }
	       
	       if(fileQAD != null) {  
		          
	    	   byte[] bb = fileQAD.getFileName().getBytes();
				 file[2] = new String(bb, "UTF-8");
	           //file[1] = fileExtraction.getFileName();
	       }
	       
		return file; 
	   }
	
	 public int[] readL3ps(int min,int max){
     	
	      	try {
	        	     
	      		upload();
	      	
	      		String aa = file[0];
	      		
	        	   FileInputStream file = new FileInputStream(new File(aa));
	        	   
	        	  // FileInputStream file = new FileInputStream(new File("C:/Users/Yassin/Desktop/test/L3PS détail 012014_3.xlsx")); 
	      		
	        	    XSSFWorkbook workbook = new XSSFWorkbook(file);
	        	 
	        	    Sheet sheet = workbook.getSheetAt(0);
	        	    
	        	    if(max >= sheet.getLastRowNum()+1) max = sheet.getLastRowNum()+1; 
	        	    		
	        	    		for (int j = min-1; j < max; j++){
	        	    		
	        	    		Row row = sheet.getRow(j);
	        	           
	        	    		Cell cell = row.getCell(3);
	          
	        	            cell.setCellType(Cell.CELL_TYPE_STRING);
	        	            
	        	            String CellValue = cell.getStringCellValue();
	        	            
	        	            switch(CellValue) {
	        	            
	        	            case "681000643R":
	        	            	table[12]++;table[13]++;table[21]++;table[22]++;table[23]++;table[34]++;table[42]++;
	        	            	table[44]++;table[61]++;table[62]++;table[63]++;table[64]++;
	        	              break;
	        	              
	        	            case "681003901R":
	        	            	table[21]++;table[22]++;table[23]++;table[34]++;table[35]++;table[36]++;table[37]++;
	        	            	table[42]++;table[43]++;table[61]++;table[62]++;table[63]++;table[64]++;
	        	            	
	        	              break;
	        	              
	        	            case "681004426R":
	        	            	table[21]++;table[22]++;table[23]++;table[34]++;table[37]++;table[42]++;table[44]++;table[61]++;
	        	            	table[62]++;table[63]++;table[64]++;
		        	              break;
		        	              
	        	            case "681005017R":
	        	            	table[10]++;table[11]++;table[12]++;table[13]++;table[21]++;table[22]++;table[23]++;table[34]++;
	        	            	table[42]++;table[44]++;table[61]++;table[62]++;table[63]++;table[64]++;
	        	            	break;
		        	              
	        	            case "681006313R":
	        	            	table[12]++;table[13]++;table[17]++;table[21]++;table[22]++;table[23]++;table[34]++;table[35]++;table[36]++;
	        	            	table[42]++;table[43]++;table[61]++;table[62]++;table[63]++;table[64]++;
	        	            	
		        	              break;
		        	              
	        	            case "681007344R":
	        	            	table[17]++;table[21]++;table[22]++;table[23]++;table[34]++;table[35]++;table[36]++;table[37]++;
	        	            	table[42]++;table[43]++;table[61]++;table[62]++;table[63]++;table[64]++;
	        	            	
		        	              break;
		        	              
	        	            case "681007582R":
	        	            	table[12]++;table[13]++;table[21]++;table[22]++;table[23]++;table[34]++;table[35]++;table[36]++;
	        	            	table[42]++;table[43]++;table[61]++;table[62]++;table[63]++;table[64]++;
	        	            	
		        	              break;
		        	              
	        	            case "681002974R":
	        	            	table[10]++;table[11]++;table[12]++;table[13]++;table[17]++;table[21]++;
	        	            	table[22]++;table[23]++;table[34]++;table[42]++;table[44]++;
	        	            	table[61]++;table[62]++;table[63]++;table[64]++;
	        	            		break;
	        	            		
	        	            case "681001430R":
	        	            	table[12]++;table[13]++;table[17]++;table[21]++;table[22]++;table[23]++;table[34]++;
	        	            	table[42]++;table[44]++;table[61]++;table[62]++;table[63]++;table[64]++;
	        	            
	        	            		break;
	        	            		
	        	            case "681004861R":
	        	            	table[17]++;table[21]++;table[22]++;table[23]++;table[34]++;table[37]++;table[42]++;table[44]++;
	        	            	table[61]++;table[62]++;table[63]++;table[64]++;
	        	            	
	        	            		break;
		        	              
	        	            default:
	        	             
	        	          } 
	        	            
	   	    	        	    		}
	            		
	        	} catch (FileNotFoundException e) {
	        	    e.printStackTrace();
	        	} catch (IOException e) {
	        	    e.printStackTrace();
	        	}
			return table;
		 }
//PNO D
	 
	 public int[] readL3ps_PNO_D(int min,int max){
	     	
	      	try {
	        	     
	      		upload();
		      	
	      		String aa = file[0];
	      		
	        	   FileInputStream file = new FileInputStream(new File(aa));
	        	     
	      		//FileInputStream file = new FileInputStream(new File("C:/Users/Yassin/Desktop/test/L3PS détail 012014_3.xlsx")); 
	      		
	        	    XSSFWorkbook workbook = new XSSFWorkbook(file);
	        	 
	        	    		// PNO D
	        	    		
	        	    		 XSSFSheet sheet = workbook.getSheetAt(1);
	    	        	    
	    	        	    if(max >= sheet.getLastRowNum()+1) max = sheet.getLastRowNum()+1; 
	    	        	    		
	    	        	    		for (int j = min-1; j < max; j++){
	    	        	    		
	    	        	    		Row row = sheet.getRow(j);
	    	        	           
	    	        	    		Cell cell = row.getCell(3);
	    
	    	          
	    	        	            cell.setCellType(Cell.CELL_TYPE_STRING);
	    	        	            
	    	        	            String CellValue = cell.getStringCellValue();
	    	        	            
	    	        	            switch(CellValue) {
	    	        	            
	    	        	            case "809003785R":
	    	        	            	table[28]++;table[29]++;table[66]++;
	    	        	            	
	    	        	              break;
	    	        	              
	    	        	            case "809004905R":
	    	        	            	table[27]++;table[29]++;table[54]++;table[66]++;
	    	        	            	
	    	        	              break;
	    	        	              
	    	        	            case "809007372R":
	    	        	            	table[27]++;table[20]++;table[29]++;table[66]++;
	    	        	            
	    		        	              break;
	    		        	              
	    	        	            case "809008988R":
	    	        	            	table[27]++;table[29]++;table[56]++;table[66]++;
	    	        	            
	    	        	            	break;
	    		        	              
	    	        	            case "829A05113R":
	    	        	            	table[15]++;table[32]++;table[54]++;
	    	        	            	
	    		        	              break;
	    		        	              
	    	        	            case "829A09392R":
	    	        	            	table[15]++; table[20]++; table[32]++;  	        	            	
	    		        	           
	    	        	            	break;
	    		        	              
	    	        	            case "829A09948R":
	    	        	            	table[15]++;table[33]++;
	    	        	            	
	    	        	            	break;
	    		        	              
	    	        	            case "829A16244R":
	    	        	            	table[18]++;table[57]++;
	    	        	            	
	    	        	            		break;
	    	        	            		
	    	        	            case "829A16774R":
	    	        	            	table[57]++;
	    	        	            	
	    	        	            		break;
	    		        	              
	    	        	            default:
	    	        	             
	    	        	          } 
	    	        	  }
	    	        	    		
	   	        	    		 
	            		
	        	} catch (FileNotFoundException e) {
	        	    e.printStackTrace();
	        	} catch (IOException e) {
	        	    e.printStackTrace();
	        	}
			return table;
		 }
	
	 //PNO G
	 
	 public int[] readL3ps_PNO_G(int min,int max){
	     	
	      	try {
	        	     
	      		upload();
		      	
	      		String aa = file[0];
	      		
	        	   FileInputStream file = new FileInputStream(new File(aa));
	        	     
	      		//FileInputStream file = new FileInputStream(new File("C:/Users/Yassin/Desktop/test/L3PS détail 012014_3.xlsx")); 
	      		//FileInputStream file = new FileInputStream(new File(handleFileUpload));  
	      		
	        	    XSSFWorkbook workbook = new XSSFWorkbook(file);
	        	 
	        	    	
	    	        	    		// PNO G
	    	        	    		  XSSFSheet sheet = workbook.getSheetAt(2);
	 	   	    	        	    
	 	   	    	        	    if(max >= sheet.getLastRowNum()+1) max = sheet.getLastRowNum()+1; 
	 	   	    	        	    		
	 	   	    	        	    		for (int j = min-1; j < max; j++){
	 	   	    	        	    		
	 	   	    	        	    		Row row = sheet.getRow(j);
	 	   	    	        	           
	 	   	    	        	    		Cell cell = row.getCell(3);
	 	   	    	        
	 	   	    	          
	 	   	    	        	            cell.setCellType(Cell.CELL_TYPE_STRING);
	 	   	    	        	            
	 	   	    	        	            String CellValue = cell.getStringCellValue();
	 	   	    	        	            
	 	   	    	        	            switch(CellValue) {
	 	   	    	        	       
	 	   	    	        	            case "809010644R":
	 	   	    	        	            	table[24]++;table[26]++;table[53]++;table[65]++;
	 	   	    	        	            	
	 	   	    	        	              break;
	 	   	    	        	              
	 	   	    	        	            case "809011026R":
	 	   	    	        	            	table[24]++;table[26]++;table[55]++;table[65]++;
	 	   	    	        	            	
	 	   	    	        	              break;
	 	   	    	        	              
	 	   	    	        	         case "809013872R":
	 	   	    	        	        	 	table[19]++;table[24]++;table[26]++;table[65]++;
	 	   	    	        	            	
	 	   	    	        	              break;
	 	   	    	        	              
	 	   	    	        	            case "809015521R":
	 	   	    	        	            	table[25]++;table[26]++;table[65]++;
	 	   	    	        	            
	 	   	    		        	              break;
	 	   	    		        	              
	 	   	    	        	            case "809017849R":
	 	   	    	        	            	table[24]++;table[26]++;table[55]++;table[65]++;
	 	   	    	        	            
	 	   	    	        	            	break;
	 	   	    		        	              
	 	   	    	        	            case "829A10959R":
	 	   	    	        	            	table[57]++;table[18]++;
	 	   	    	        	            	
	 	   	    		        	              break;
	 	   	    		        	              
	 	   	    	        	            case "829A13474R":
	 	   	    	        	            	table[14]++;table[30]++;table[53]++;
	 	   	    	        	            	
	 	   	    		        	              break;
	 	   	    		        	              
	 	   	    	        	            case "829A13934R":
	 	   	    	        	            	table[57]++;
	 	   	    	        	            	
	 	   	    	        	            		break;
	 	   	    	        	            		
	 	   	    	        	            case "829A15254R":
	 	   	    	        	            	table[14]++;table[31]++;
	 	   	    	        	            	
	 	   	    	        	            		break;
	 	   	    	        	            		
	 	   	    	        	         case "829A17388R":
	 	   	    	        	        	 table[57]++;
	 	   	    	        	            	
	 	    	        	            		break;
	 	    	        	            		
	 	   	    	        	      case "829A19085R":
	 	   	    	        	    	  table[14]++;table[19]++;table[30]++;
	 	    	        	            	
	 	    	        	            		break;
	 	   	    		        	              
	 	   	    	        	            default:
	 	   	    	        	             
	 	   	    	        	          } 
	 	   	    	        	    		}	
	   	        	    		 
	            		
	        	} catch (FileNotFoundException e) {
	        	    e.printStackTrace();
	        	} catch (IOException e) {
	        	    e.printStackTrace();
	        	}
			return table;
		 }
	
		
		public int[] readPLS(Date dd){
			
			if(getDatePLS()==-1) return null;
			
			else if(getQtyPLS()==-1) return null;
			
			else if(getRefPLS()==-1) return null;
			
			else {
				
				try {
	        	  
	    	      	
		      		String aa = file[1];
		      		
		        	   FileInputStream file = new FileInputStream(new File(aa));
	        	     
					//FileInputStream file = new FileInputStream(new File("C:/Users/Yassin/Desktop/test/Extract 1103.xlsx")); 
					//FileInputStream file = new FileInputStream(new File(handleFileUpload));  
	      		
	        	    XSSFWorkbook workbook = new XSSFWorkbook(file);
	        	
									int col = getSheet(workbook);
					
		    	        	    		  XSSFSheet sheet = workbook.getSheetAt(col);
	        	 
		    	        	    		  int date = getDatePLS();
		    	      	    			int qty = getQtyPLS();
		    	      	    			int ref = getRefPLS();
		    	      	  
		    	      	    			upload();
	 	   	    	        	
	 	   	    	        	    		
	 	   	    	        	    		for (int i = 1; i < sheet.getLastRowNum(); i++){
	 	   	    	        	    			
	 	   	    	        	    		Row row = sheet.getRow(i);
		 	   	    	        	           
	 	   	    	        	    		Cell cell = row.getCell(date);
	 	   	   	        
	 	   	   	        	    		if(cell.getDateCellValue().equals(dd)){
	 	   	   	        	    			
	 	   	   	        	    			cell = row.getCell(ref);
	 	   	   	        	    		
	 	   	    	        	            String CellValue = cell.getStringCellValue();
	 	   	    	        	            
	 	   	    	        	            switch(CellValue) {
	 	   	    	        	            
	 	   	    	        	            case "00115625-02-RCAR":
 	   	    	        	            	
	 	   	    	        	            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	 	   	    	        	            cell = row.getCell(qty);
	 	   	    	        	            table [0] = (int) cell.getNumericCellValue();
	 	   	    	        	            	
	 	   	    	        	            	
	 	   	    	        	              break;
	 	   	    	        	              
	 	   	    	        	        case "00117138-02-RCAR":
	 		 	   	    	 	   	    	
	 		 	   	    	 	   	    	cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	 		 	   	    	 	   	    	cell = row.getCell(qty);
	 		 	   	        	            table [1] += (int) cell.getNumericCellValue();
	 		 	   	    	 
	 		 	   	    		            	
	 		 	   	    		            		break;
	 	   	    	        	              
	 	   	    		            		
	 	   	    	 	   	    	    case "00117137-02-RCAR":
	 	   	    	 	   	    	    	
	 	   	    	 	   	    	    cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	 	   	    	 	   	    	    	cell = row.getCell(qty);
	 	   	    	        	            table [2] += (int) cell.getNumericCellValue();
	 	   	    	   	        	    	
	 	   	    	        	            	
	 	   	    	        	            		break;
	 	   	    	        	        
	 	   	    	 	   		case "00117140-02-RCAR":
		 	   	    	 	   		
	 	   	    	 	   			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	 	   	    	 	   			cell = row.getCell(qty);
	 	   	    	 	   			table [3] += (int) cell.getNumericCellValue();
	 	   	    	   	    	
	 	   	    	            	
	 	   	    	            		break;	
	 	   	    	 	   
	 	   	    	 	   	    	    case "00117139-02-RCAR":
   	    	 	   	    		
   	    	 	   	    		cell.setCellType(Cell.CELL_TYPE_NUMERIC);
   	    	 	   	    		cell = row.getCell(qty);
   	            	            table [4] += (int) cell.getNumericCellValue();
   	    		        	    	
   	    	    	            	
   	    	    	            		break;
	 	   	    		            		
	 	   	    	 	   
	 	   	    	        	       
	 	   	    	        	           
	 	   	    	        	        case "00128260-03-RCAR":
	 	   	    	        	        	 
	 	   	    	        	        	cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	 	   	    	        	        	cell = row.getCell(qty);
	 	   	    	        	            table [5] += (int) cell.getNumericCellValue();
	 	   	    	        	        
	 	   	    	        	            	
	 	    	        	            		break;
	 	   	    	        	           
	 	   	    	        	    case "00129905-02-RCAR":
		 	   	    	        		
	 		 	   	    	        	cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	 		 	   	    	        	cell = row.getCell(qty);
	 		    	        	            table [6] += (int) cell.getNumericCellValue();
	 		   	    	        	    
	 		    	        	            	
	 		    	        	            		break;
	 		    	        	
	 	   	    	        	    case "00130772-03-RCAR":
	 	   		 	 		
	 	   		 	 			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	 	   		 	 			cell = row.getCell(qty);
	 	   	    	            table [7] += (int) cell.getNumericCellValue();
	 	   			    	
	 	   		        	
	 	   		        		break;
	 		 	   	    		        	              
	 		 	   	    	        case "00152697-01-RCAR":
	 		 	   	    	        	
	 		 	   	    	        	cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	 		 	   	    	        	cell = row.getCell(qty);
	 	    	        	            table [8] += (int) cell.getNumericCellValue();
	 			    	        	    	
	 			        	            	
	 			        	            		break;
	 			        	            		
			 		 	   	    	   case "00152690-01-RCAR":
				 	   	    	 	  		
				 	   		 	  			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
				 	   		 	  			cell = row.getCell(qty);
				 	   	    	            table [9] += (int) cell.getNumericCellValue();
				 	   			    	
				 	   		         	
				 	   		         		break;
	 	   	    	        	              
	 	   	    	        	         case "00201498-01-RCAR":
	 	   	    	        	        	 
	 	   	    	        	        	cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	 	   	    	        	        	cell = row.getCell(qty);
	 	   	    	        	            table [16] += (int) cell.getNumericCellValue();
	 	   	    	        	        	 
	 	   	    	        	            	
	 	   	    	        	              break;
	 	   	    	        	              
	 	   	    	        	            case "00201496-01-RCAR":
	 	   	    	        	            	
	 	   	    	        	            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	 	   	    	        	            cell = row.getCell(qty);
	 	   	    	        	            table [16] += (int) cell.getNumericCellValue();
	 	   	    	        	            	
	 	   	    	        	            
	 	   	    		        	              break;
	 	   	    		        	              
	 	   	    	        	            case "00201499-01-RCAR":
	 	   	    	        	            	
	 	   	    	        	            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	 	   	    	        	            cell = row.getCell(qty);
	 	   	    	        	            table [16] += (int) cell.getNumericCellValue();
	 	   	    	        	            
	 	   	    	        	            
	 	   	    	        	            	break;
	 	   	    		        	              
	 	   	    	        	            case "00201500-01-RCAR":
	 	   	    	        	            	
	 	   	    	        	            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	 	   	    	        	            cell = row.getCell(qty);
	 	   	    	        	            table [16] += (int) cell.getNumericCellValue();
	 	   	    	        	            	
	 	   	    	        	            	
	 	   	    		        	              break;
	 	   	    		        	              
	 	   	    	        	            case "00201497-01-RCAR":
	 	   	    	        	            	
	 	   	    	        	            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	 	   	    	        	            cell = row.getCell(qty);
	 	   	    	        	            table [16] += (int) cell.getNumericCellValue();
	 	   	    	        	            	
	 	   	    	        	            	
	 	   	    		        	              break;
	 	   	    		        	              
	 	   	    	        	            case "00201501-01-RCAR":
	 	   	    	        	            	
	 	   	    	        	            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	 	   	    	        	            cell = row.getCell(qty);
	 	   	    	        	            table [16] += (int) cell.getNumericCellValue();
	 	   	    	        	            	
	 	   	    	        	            	
	 	   	    	        	            		break;
	 	   	    	        	            		
	 	   	    	        	            case "00201495-01-RCAR":
	 	   	    	        	            	
	 	   	    	        	            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	 	   	    	        	            cell = row.getCell(qty);
	 	   	    	        	            table [16] += (int) cell.getNumericCellValue();
	 	   	    	        	            	
	 	   	    	        	            	
	 	   	    	        	            		break;
	 	   	    	        	            		
	 	   	    	        	        
	 	    	        	            		
	 	   	    	        	         case "00128398-02-S864":
	   	    	        	            	
	 	   	    	        	            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	 	   	    	        	            cell = row.getCell(qty);
	 	   	    	        	            table [50] += (int) cell.getNumericCellValue();
	 	   	    	        	            
	 	   	    	        	            	
	 	   	    	        	              break;
	 	   	    	        	              
	 	   	    	        	     case "00117248-02-RCAR":
	 	   	    	  	 		   
	 	   	    	  	 		   cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	 	   	    	  	 		  	cell = row.getCell(qty);
	 	   	    	    	            table [51] += (int) cell.getNumericCellValue();
	 	   	    	  	  	    	
	 	   	    	  	           	
	 	   	    	  	           		break;
	 	   	    	  	           		
	 	   	    	  	 	   case "00117249-03-RCAR":
	 	   	    	  	 		   
	 	   	    	  	 		   cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	 	   	    	  	 		  	cell = row.getCell(qty);
	 	   	    	    	            table [52] += (int) cell.getNumericCellValue();
	 	   	    	  	 	    	
	 	   	    	  	          	
	 	   	    	  	          		break;
	 	   	    	  	          		
	 	   	    	  	          		
	 	    	        	            		
	 	   	    	        	      case "00115654-02-RCAR":
	 	   	    	        	    	  
	 	   	    	        	    	cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	 	   	    	        	    	cell = row.getCell(qty);
 	   	    	        	            table [58] += (int) cell.getNumericCellValue();
	 	   	    	        	    
	 	    	        	            	
	 	    	        	            		break;
	 	    	        	            		
	 	   	    	        	  case "00115653-01-RCAR":
	 	   	    	        		  
	 	   	    	        		cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	 	   	    	        		cell = row.getCell(qty);
	   	    	        	            table [59] += (int) cell.getNumericCellValue();
		   	    	        	    
		    	        	            	
		    	        	            		break;
		    	       
	        		
	 	   	    	        	  case "00115665-02-RCAR":
	 	 				
	 	   	    	        		  cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	 	   	    	        		  cell = row.getCell(qty);
	 	   	    	        		  table [60] += (int) cell.getNumericCellValue();
	 	 				
	        	
	 	   	    	        		  break;
	 	   	    	       
	 	   	    	        	  default:
	 	   	    	        	            }      
	 	   	    	        	          } 
	 	   	    	        	    		}	
	   	        	    		 
	            		
	        	} catch (FileNotFoundException e) {
	        	    e.printStackTrace();
	        	} catch (IOException e) {
	        	    e.printStackTrace();
	        	}
			return table;
		 }
	}

	 
			public  void pieceConsomme() {
				
	
	      	try {
	      		
	      		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();  
	   	    	String newFileName = servletContext.getRealPath("") + File.separator + "Planification" + File.separator + "template"+ File.separator+"planification.xlsx";

	   	    	FileInputStream file = new FileInputStream(new File(newFileName));
	      		
	      		//FileInputStream file = new FileInputStream(new File("C:/Users/Yassin/Desktop/planification.xlsx"));

		           XSSFWorkbook wb = new XSSFWorkbook(file);
		            XSSFSheet sheet = wb.getSheet("etat du stock");
		           
		            Cell cell,cell1,cell2 = null;
		   
		            formater = new SimpleDateFormat("'Etat du stock de ' dd/MM/yyyy 'à' hh:mm",Locale.FRANCE);
		            
		            cell = sheet.getRow(0).getCell(2);
        			
		            cell.setCellValue(formater.format(getDate1()));
		          
		            extractQAD();
		            
		            writeEStock(sheet,tableQAD,8);
		          
		          /*  for(int i=6;i<73;i++){
            			
            			cell = sheet.getRow(i).getCell(8);
            			cell.setCellValue(tableQAD[i-6]);
            			
               
            }*/
		           // setFormater(new SimpleDateFormat("EEEE, d MMM yyyy"));
		           
		           readL3ps(getDebut1(),getFin1());
		            readL3ps_PNO_D(getDebut4(),getFin4());
		            readL3ps_PNO_G(getDebut7(),getFin7());
		         
		           
		            
		            setFormater(new SimpleDateFormat("EEEE, d MMM yyyy",Locale.FRANCE));
		            
		            cell = sheet.getRow(4).getCell(9);
        			cell.setCellValue(formater.format(getDate1()));
        			
        			readPLS(getDate1());
        			
        			writeEStock(sheet,table,9);
        		
		          
		           for(int i=6;i<sheet.getLastRowNum();i++){
	            		
           			cell = sheet.getRow(i).getCell(10);
	            		 cell1 = sheet.getRow(i).getCell(9);
	            		cell2 = sheet.getRow(i).getCell(8);
	 		            cell.setCellValue(cell2.getNumericCellValue() - cell1.getNumericCellValue());
           }
		       	
		           
		            	//2
		            	iniTable();
		            	readL3ps(getDebut2(),getFin2());
		            	 readL3ps_PNO_D(getDebut5(),getFin5());
		            	 readL3ps_PNO_G(getDebut8(),getFin8());
		            	  
		            	  cell = sheet.getRow(4).getCell(12);
	            			
		            	  cell.setCellValue(formater.format(getDate2()));
		             readPLS(getDate2());
		             writeEStock(sheet,table,12);
				            for(int i=6;i<sheet.getLastRowNum();i++){
				         
				            //	cell = sheet.getRow(i).getCell(12);
		            			//cell.setCellValue(table[i-6]);
		            			
		            			cell = sheet.getRow(i).getCell(13);
			            		 cell1 = sheet.getRow(i).getCell(12);
			            		cell2 = sheet.getRow(i).getCell(10);
			 		            cell.setCellValue(cell2.getNumericCellValue() - cell1.getNumericCellValue());
							      
				            }
				            
				        
				            
				           //3
				            iniTable();
				            	 readL3ps(getDebut3(),getFin3());
				            	 readL3ps_PNO_D(getDebut6(),getFin6());
				            	  readL3ps_PNO_G(getDebut9(),getFin9());
				            	 
				            	  
				            	  
				            	  cell = sheet.getRow(4).getCell(15);
			            			
				            	  cell.setCellValue(formater.format(getDate3()));
						            
				            	 readPLS(getDate3());
				            	 writeEStock(sheet,table,15);
						            for(int i=6;i<sheet.getLastRowNum();i++){
								          
						            	//cell = sheet.getRow(i).getCell(15);
				            		//	cell.setCellValue(table[i-6]);
				            			
				            			cell = sheet.getRow(i).getCell(16);
					            		 cell1 = sheet.getRow(i).getCell(15);
					            		cell2 = sheet.getRow(i).getCell(13);
					 		            cell.setCellValue(cell2.getNumericCellValue() - cell1.getNumericCellValue());
						            }
						       
		           file.close();
		           formater = new SimpleDateFormat("dd-MM-yyyy");
		          // ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();  
		   	     newFileName = servletContext.getRealPath("") + File.separator + "Planification" + File.separator + "Etat du stock"+ File.separator;

		            FileOutputStream outFile =new FileOutputStream(new File(newFileName+formater.format(getDate1())+".xlsx"));
		            wb.write(outFile);
		            outFile.close();
		           
		            String[] command = {"cmd", "/c", newFileName+formater.format(getDate1())+".xlsx"};
		    	    Runtime.getRuntime().exec(command);

	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }   
					
	        	}
			
			public  void pieceConsommeplus() {
				
				
		      	try {
		      		
		      		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();  
		   	    	String newFileName = servletContext.getRealPath("") + File.separator + "Planification" + File.separator + "template"+ File.separator+"planification.xlsx";

		   	    	FileInputStream file = new FileInputStream(new File(newFileName));
		      		

			           XSSFWorkbook wb = new XSSFWorkbook(file);
			            XSSFSheet sheet = wb.getSheet("etat du stock");
			           
			            Cell cell,cell1,cell2 = null;
			   
			            formater = new SimpleDateFormat("'Etat du stock de ' dd/MM/yyyy 'à' hh:mm",Locale.FRANCE);
			            
			            cell = sheet.getRow(0).getCell(2);
	        			
			            cell.setCellValue(formater.format(getDate1()));
			          
			            extractQAD();
			            
			            writeEStock(sheet,tableQAD,8);
			          
			           
			           readL3ps(getDebut1(),getDebut1()+360);
			            readL3ps_PNO_D(getDebut4(),getDebut4()+600);
			            readL3ps_PNO_G(getDebut7(),getDebut7()+600);
			         
			           
			            
			            setFormater(new SimpleDateFormat("EEEE, d MMM yyyy",Locale.FRANCE));
			            
			            cell = sheet.getRow(4).getCell(9);
	        			cell.setCellValue(formater.format(getDate1()));
	        			
	        			readPLS(getDate1());
	        			
	        			writeEStock(sheet,table,9);
	        		
			          
			           for(int i=6;i<sheet.getLastRowNum();i++){
		            		
	           			cell = sheet.getRow(i).getCell(10);
		            		 cell1 = sheet.getRow(i).getCell(9);
		            		cell2 = sheet.getRow(i).getCell(8);
		 		            cell.setCellValue(cell2.getNumericCellValue() - cell1.getNumericCellValue());
	           }
			       	
			          
			            	//2
			            	iniTable();
			            	
			            	
				          
			            	readL3ps(getDebut1()+361,getDebut1()+721);
			            	 readL3ps_PNO_D(getDebut4()+601,getDebut4()+1201);
			            	 readL3ps_PNO_G(getDebut7()+601,getDebut7()+1201);
			            	  
			            	  cell = sheet.getRow(4).getCell(12);
		            			
			            	  cell.setCellValue(formater.format(getDate2()));
			             readPLS(getDate2());
			             writeEStock(sheet,table,12);
					            for(int i=6;i<sheet.getLastRowNum();i++){
					         
					            //	cell = sheet.getRow(i).getCell(12);
			            			//cell.setCellValue(table[i-6]);
			            			
			            			cell = sheet.getRow(i).getCell(13);
				            		 cell1 = sheet.getRow(i).getCell(12);
				            		cell2 = sheet.getRow(i).getCell(10);
				 		            cell.setCellValue(cell2.getNumericCellValue() - cell1.getNumericCellValue());
								      
					            }
					       
					            
					           //3
					            iniTable();
					            	 readL3ps(getDebut1()+722,getDebut1()+1804);
					            	 readL3ps_PNO_D(getDebut4()+1202,getDebut4()+1802);
					            	  readL3ps_PNO_G(getDebut7()+1202,getDebut7()+1802);
					            	 
					            	  
					            	  
					            	  cell = sheet.getRow(4).getCell(15);
				            			
					            	  cell.setCellValue(formater.format(getDate3()));
							            
					            	 readPLS(getDate3());
					            	 writeEStock(sheet,table,15);
							            for(int i=6;i<sheet.getLastRowNum();i++){
									          
							            	//cell = sheet.getRow(i).getCell(15);
					            		//	cell.setCellValue(table[i-6]);
					            			
					            			cell = sheet.getRow(i).getCell(16);
						            		 cell1 = sheet.getRow(i).getCell(15);
						            		cell2 = sheet.getRow(i).getCell(13);
						 		            cell.setCellValue(cell2.getNumericCellValue() - cell1.getNumericCellValue());
							            }
							           

			           file.close();

			           formater = new SimpleDateFormat("dd-MM-yyyy");
				        newFileName = servletContext.getRealPath("") + File.separator + "Planification" + File.separator + "Etat du stock"+ File.separator;

				            FileOutputStream outFile =new FileOutputStream(new File(newFileName+formater.format(getDate1())+".xlsx"));
				            wb.write(outFile);
				            outFile.close();
				           
				            String[] command = {"cmd", "/c", newFileName+formater.format(getDate1())+".xlsx"};
				    	    Runtime.getRuntime().exec(command);

		        } catch (FileNotFoundException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }   
						
		        	}
				
			
			 public int getQtyPLS(){
			     	
			      	try {
			        	     
			      		upload();
				      	
			      		String aa = file[1];
			      		
			        	   FileInputStream file = new FileInputStream(new File(aa));
			      		
			      		//FileInputStream file = new FileInputStream(new File("C:/Users/Yassin/Desktop/test/Extract 1103.xlsx")); 
			      		
			        	    XSSFWorkbook workbook = new XSSFWorkbook(file);
			        	    int col = getSheet(workbook);
				        	
				    	        	    		  XSSFSheet sheet = workbook.getSheetAt(col);
			        	    	
			    	        	    		//  XSSFSheet sheet = workbook.getSheetAt(2);
			    	        	    		  
			    	        	    		  Row row = sheet.getRow(0);
			 	   	    	        	 	
			 	   	    	        	    		for (int j = 0; j < row.getLastCellNum()-1; j++){
			 	   	    	        	           
			 	   	    	        	    		Cell cell = row.getCell(j);
			 	   	    	        	       
			 	   	    	        	          if(cell.getStringCellValue().equals("qty")) return j;
			 	   	    	        	    
			 	   	    	        	    		}	
			   	        	    		 
			            		
			        	} catch (FileNotFoundException e) {
			        	    e.printStackTrace();
			        	} catch (IOException e) {
			        	    e.printStackTrace();
			        	}
					return -1;
				 }
			
			 public int getRefPLS(){
			     	
			      	try {
			        	     
			      		upload();
				      	
			      		String aa = file[1];
			      		
			        	   FileInputStream file = new FileInputStream(new File(aa));
			      		
			      	//	FileInputStream file = new FileInputStream(new File("C:/Users/Yassin/Desktop/test/Extract 1103.xlsx")); 
			      		
			        	    XSSFWorkbook workbook = new XSSFWorkbook(file);
			        	    int col = getSheet(workbook);
				        	  
				    	        	    		  XSSFSheet sheet = workbook.getSheetAt(col);
			        	    	
			    	        	    		 // XSSFSheet sheet = workbook.getSheetAt(2);
			    	        	    		  
			    	        	    		  Row row = sheet.getRow(0);
			 	   	    	        	 	
			 	   	    	        	    		for (int j = 0; j < row.getLastCellNum()-1; j++){
			 	   	    	        	           
			 	   	    	        	    		Cell cell = row.getCell(j);
			 	   	    	        
			 	   	    	        	       
			 	   	    	        	          if(cell.getStringCellValue().equals("refgpao")) return j;
			 	   	    	        	    
			 	   	    	        	    		}	
			   	        	    		 
			            		
			        	} catch (FileNotFoundException e) {
			        	    e.printStackTrace();
			        	} catch (IOException e) {
			        	    e.printStackTrace();
			        	}
					return -1;
				 }
			 
			 public int getSheet(XSSFWorkbook workbook){
	        	    for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
	        			String arr[] = workbook.getSheetName(i).split(" ", 2);
	        	    	if(arr[0].equals("Extract"))
	        	    	return i;
	        	            
	                }
	        		return -1;
	        	}
			 
			 public int getDatePLS(){
			     	
			      	try {
			        	     
			      		upload();
				      	
			      		String aa = file[1];
			      		
			        	   FileInputStream file = new FileInputStream(new File(aa));
			      		
			      		//FileInputStream file = new FileInputStream(new File("C:/Users/Yassin/Desktop/test/Extract 1103.xlsx")); 
			      		
			        	    XSSFWorkbook workbook = new XSSFWorkbook(file);
			        	 
			        	   int col = getSheet(workbook);
			        	  
			    	        	    		  XSSFSheet sheet = workbook.getSheetAt(col);
			    	        	    		  
			    	        	    		  Row row = sheet.getRow(0);
			 	   	    	        	 	
			 	   	    	        	    		for (int j = 0; j < row.getLastCellNum()-1; j++){
			 	   	    	        	           
			 	   	    	        	    		Cell cell = row.getCell(j);
			 	   	    	        
			 	   	    	        	       
			 	   	    	        	          if(cell.getStringCellValue().equals("dateliv")) return j;
			 	   	    	        	    
			 	   	    	        	    		}	
			   	        	    		 
			            		
			        	} catch (FileNotFoundException e) {
			        	    e.printStackTrace();
			        	} catch (IOException e) {
			        	    e.printStackTrace();
			        	}
					return -1;
				 }
			 
			 public void writeEStock(Sheet sheet,int tb[],int col){
				
				 
				 for (int j = 6; j < sheet.getLastRowNum(); j++){
			 		
			    		Row row = sheet.getRow(j);
			           
			    		Cell cell = row.getCell(2);

			    	String CellValue = cell.getStringCellValue();
		     	  
			 		
			 		switch(CellValue) {
			 	         
			 	            case "00115625-02-RCAR":
			 	            	
			 	            	cell = sheet.getRow(j).getCell(col);
		            			cell.setCellValue(tb[0]);
			 	          	
			 	              break;
			 	              
			 	            case "00117138-02-RCAR":
			 	            	
			 	            	cell = sheet.getRow(j).getCell(col);
		            			cell.setCellValue(tb[1]);
						     	
						     		break;
			 	              
			 	            		case "00117137-02-RCAR":
					    	    	
			 	            			cell = sheet.getRow(j).getCell(col);
				            			cell.setCellValue(tb[2]);
			 		    	    	
			 			            				break;
			 			            				
			 	            		case "00117140-02-RCAR":
											
			 	            			cell = sheet.getRow(j).getCell(col);
				            			cell.setCellValue(tb[3]);
									
								 	
								 		break;
			 			            				
			 	            		case "00117139-02-RCAR":
								    		
			 	            			cell = sheet.getRow(j).getCell(col);
				            			cell.setCellValue(tb[4]);
							 	    	
							         	
							         		break;
			 	                  		
				        	         case "00128260-03-RCAR":
				        	        	 
				        	        	 cell = sheet.getRow(j).getCell(col);
					            			cell.setCellValue(tb[5]);
				        	        
				        	            	
			 	            		break;
			 	            		
				        	case "00129905-02-RCAR":
				        		
				        		cell = sheet.getRow(j).getCell(col);
		            			cell.setCellValue(tb[6]);
			 	    
			          	
			          		break;
			          		
				        	case "00130772-03-RCAR":
								
				        		cell = sheet.getRow(j).getCell(col);
		            			cell.setCellValue(tb[7]);
							
							
								break;
					        	              
				        case "00152697-01-RCAR":
				        	
				        	cell = sheet.getRow(j).getCell(col);
	            			cell.setCellValue(tb[8]);
			 	    	
			         	
			         		break;
			         		
									
							case "00152690-01-RCAR":
								
								cell = sheet.getRow(j).getCell(col);
		            			cell.setCellValue(tb[9]);
								
								
									break;
									
									
									case "00115581-02-RCAR":
										
										cell = sheet.getRow(j).getCell(col);
				            			cell.setCellValue(tb[10]);
										
								
									break;
			 
								case "00115583-02-RCAR":
									
									cell = sheet.getRow(j).getCell(col);
			            			cell.setCellValue(tb[11]);
									
							
											break;
							
								case "00115615-02-RCAR":
								
									cell = sheet.getRow(j).getCell(col);
			            			cell.setCellValue(tb[12]);
								
						
							break;
							
								case "00115614-02-RCAR":
									
									cell = sheet.getRow(j).getCell(col);
			            			cell.setCellValue(tb[13]);
									
							
								break;
								
								case "00116436-02-RCAR":
									
									cell = sheet.getRow(j).getCell(col);
			            			cell.setCellValue(tb[14]);
									
							
								break;
								
								case "00117321-02-RCAR":
									
									cell = sheet.getRow(j).getCell(col);
			            			cell.setCellValue(tb[15]);
									
							
								break;
				        	            		
				        	            case "00128256-02-RCAR":
				        	            	
				        	            	cell = sheet.getRow(j).getCell(col);
					            			cell.setCellValue(tb[16]);
					            			
					            			break;
					
								case "00115647-01-RCAR":
								
									cell = sheet.getRow(j).getCell(col);
			            			cell.setCellValue(tb[17]);
								
						
							break;
							
								case "00117258-02-RCAR":
								
									cell = sheet.getRow(j).getCell(col);
			            			cell.setCellValue(tb[18]);
								
						
							break;
							
								case "00116418-02-RTRO":
									
									cell = sheet.getRow(j).getCell(col);
			            			cell.setCellValue(tb[19]);
									
							
								break;
								
									case "00117312-02-RTRO":
									
									cell = sheet.getRow(j).getCell(col);
			            			cell.setCellValue(tb[20]);
									
							
								break;
						
							case "00115642-01-RTRO":
								
								cell = sheet.getRow(j).getCell(col);
		            			cell.setCellValue(tb[21]);
								
						
							break;
							
								case "00115644-01-RTRO":
								
									cell = sheet.getRow(j).getCell(col);
			            			cell.setCellValue(tb[22]);
						
							break;
							

								case "00115645-01-RTRO":
									
									cell = sheet.getRow(j).getCell(col);
			            			cell.setCellValue(tb[23]);
						
							break;
							
								case "00116411-02-RCAR":
									
									cell = sheet.getRow(j).getCell(col);
			            			cell.setCellValue(tb[24]);
							
								break;
								
								case "00128391-02-RCAR":
									
									cell = sheet.getRow(j).getCell(col);
			            			cell.setCellValue(tb[25]);
							
								break;
								
								case "00116416-03-RCAR":
									
									cell = sheet.getRow(j).getCell(col);
			            			cell.setCellValue(tb[26]);
							
								break;
								
								case "00117305-02-RCAR":
									
									cell = sheet.getRow(j).getCell(col);
			            			cell.setCellValue(tb[27]);
									
							
								break;
								
								case "00128392-03-RCAR":
									
									cell = sheet.getRow(j).getCell(col);
			            			cell.setCellValue(tb[28]);
								break;
									
									case "00117310-03-RCAR":
									
										cell = sheet.getRow(j).getCell(col);
				            			cell.setCellValue(tb[29]);
								break;	
								
									case "00128424-02-RCAR":
										
										cell = sheet.getRow(j).getCell(col);
				            			cell.setCellValue(tb[30]);
								
									break;
									
										case "00116432-02-RCAR":
										
											cell = sheet.getRow(j).getCell(col);
					            			cell.setCellValue(tb[31]);
								
									break;
									
										case "00128425-02-RCAR":
											
											cell = sheet.getRow(j).getCell(col);
					            			cell.setCellValue(tb[32]);
									
										break;
										
										case "00117317-02-RCAR":
											
											cell = sheet.getRow(j).getCell(col);
					            			cell.setCellValue(tb[33]);
									
										break;
										
										case "00115670-02-0000":
											
											cell = sheet.getRow(j).getCell(col);
					            			cell.setCellValue(tb[34]);
									
										break;
										
										case "00115556-02-RCAR":
											
											cell = sheet.getRow(j).getCell(col);
					            			cell.setCellValue(tb[35]);
									
										break;
										
										case "00115558-02-RCAR":
											
											cell = sheet.getRow(j).getCell(col);
					            			cell.setCellValue(tb[36]);
									
										break;
										
										case "00115622-02-RCAR":
											
											cell = sheet.getRow(j).getCell(col);
					            			cell.setCellValue(tb[37]);
									
										break;
										
											case "00171660-02-0000":
											
												cell = sheet.getRow(j).getCell(col);
						            			cell.setCellValue(tb[38]);
									
										break;
										
											case "00171670-01-T122":
												
												cell = sheet.getRow(j).getCell(col);
						            			cell.setCellValue(tb[39]);
										
											break;
											
											case "00171670-01-RCAR":
												
												cell = sheet.getRow(j).getCell(col);
						            			cell.setCellValue(tb[40]);
											break;
											
												case "00171670-01-S950":
												
													cell = sheet.getRow(j).getCell(col);
							            			cell.setCellValue(tb[41]);
												
										
											break;
											
												case "00115549-02-RCAR":
													
													cell = sheet.getRow(j).getCell(col);
							            			cell.setCellValue(tb[42]);
											
												break;
												
												case "00115554-02-RCAR":
													
													cell = sheet.getRow(j).getCell(col);
							            			cell.setCellValue(tb[43]);
													
											
												break;
												
												case "00115553-02-RCAR":
													
													cell = sheet.getRow(j).getCell(col);
							            			cell.setCellValue(tb[44]);
											
												break;
												
												case "00171658-02-T122":
													
													cell = sheet.getRow(j).getCell(col);
							            			cell.setCellValue(tb[45]);
											
												break;
												
												case "00171658-02-RCAR":
													
													cell = sheet.getRow(j).getCell(col);
							            			cell.setCellValue(tb[46]);
											
												break;
												
												case "00171658-02-S950":
													
													cell = sheet.getRow(j).getCell(col);
							            			cell.setCellValue(tb[47]);
													
											
												break;
												
												case "00171657-02-RCAR":
													
													cell = sheet.getRow(j).getCell(col);
							            			cell.setCellValue(tb[48]);
											
												break;
												
												case "00171659-02-0000":
													
													cell = sheet.getRow(j).getCell(col);
							            			cell.setCellValue(tb[49]);
											
												break;
												
												case "00128398-02-S864":
				    	        	            	
													cell = sheet.getRow(j).getCell(col);
							            			cell.setCellValue(tb[50]);
						    	        	          
						    	        	            break;
												
												case "00117248-02-RCAR":
													 
													cell = sheet.getRow(j).getCell(col);
							            			cell.setCellValue(tb[51]);
														
															break;
															
													case "00117249-03-RCAR":
													 
														cell = sheet.getRow(j).getCell(col);
								            			cell.setCellValue(tb[52]);
														
														
															break;
						    	        	            
												case "00116417-02-RTRO":
													
													cell = sheet.getRow(j).getCell(col);
							            			cell.setCellValue(tb[53]);
													
											
												break;
												
												case "00117311-02-RTRO":
													
													cell = sheet.getRow(j).getCell(col);
							            			cell.setCellValue(tb[54]);
													
											
												break;
												
												case "00116419-02-RTRO":
													
													cell = sheet.getRow(j).getCell(col);
							            			cell.setCellValue(tb[55]);
													
											
												break;
												
												case "00117314-02-RTRO":
													
													cell = sheet.getRow(j).getCell(col);
							            			cell.setCellValue(tb[56]);
													
											
												break;
												
												case "00117255-03-RCAR":
													
													cell = sheet.getRow(j).getCell(col);
							            			cell.setCellValue(tb[57]);
													
											
												break;
												
												case "00115654-02-RCAR":
						    	        	    	  
													cell = sheet.getRow(j).getCell(col);
							            			cell.setCellValue(tb[58]);
						    	        	    
						        	            	
						        	            		break;
						        	            		
						    	        	  case "00115653-01-RCAR":
						    	        		  
						    	        		  cell = sheet.getRow(j).getCell(col);
							            			cell.setCellValue(tb[59]);
					    	        	    
						        	            	
						        	            		break;
						        	            		
						    	        	  		case "00115665-02-RCAR":
						    						
						    	        	  			cell = sheet.getRow(j).getCell(col);
								            			cell.setCellValue(tb[60]);
						    						
						    				
						    					break;
												
												case "00115748-02-0000":
													
													cell = sheet.getRow(j).getCell(col);
							            			cell.setCellValue(tb[61]);
													
											
												break;
												
												case "00127662-01-0000":
													
													cell = sheet.getRow(j).getCell(col);
							            			cell.setCellValue(tb[62]);
													
											
												break;
												
												case "00127663-01-0000":
													
													cell = sheet.getRow(j).getCell(col);
							            			cell.setCellValue(tb[63]);
													
											
												break;
												
												case "00127664-01-0000":
													
													cell = sheet.getRow(j).getCell(col);
							            			cell.setCellValue(tb[64]);
													
											
												break;
												
												case "00116424-02-0000":
													
													cell = sheet.getRow(j).getCell(col);
							            			cell.setCellValue(tb[65]);
													
											
												break;
												
												case "00117316-02-0000":
													
													cell = sheet.getRow(j).getCell(col);
							            			cell.setCellValue(tb[66]);
													
											
												break;
												case "00171679-02-T122":
													
													cell = sheet.getRow(j).getCell(col);
							            			cell.setCellValue(tb[67]);
													
											
												break;
											
		                                        case "00171679-02-RCAR":
													
		                                        	cell = sheet.getRow(j).getCell(col);
		    				            			cell.setCellValue(tb[68]);
													
											
												break;
		                                       
		                                        case "00171679-02-S950":
													
		                                        	cell = sheet.getRow(j).getCell(col);
		    				            			cell.setCellValue(tb[69]);
													
											
												break;
												default:
			 	        	             
			 	        	          }
				 }
			 }
			

			 public int getDebut3() {
					return debut3;
				}

				public void setDebut3(int debut3) {
					this.debut3 = debut3;
				}

				public int getDebut1() {
					return debut1;
				}

				public void setDebut1(int debut1) {
					this.debut1 = debut1;
				}

				public int getFin1() {
					return fin1;
				}

				public void setFin1(int fin1) {
					this.fin1 = fin1;
				}

				public int getDebut2() {
					return debut2;
				}

				public void setDebut2(int debut2) {
					this.debut2 = debut2;
				}

				public int getFin2() {
					return fin2;
				}

				public void setFin2(int fin2) {
					this.fin2 = fin2;
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
			    
			    public int getFin3() {
					return fin3;
				}

				public void setFin3(int fin3) {
					this.fin3 = fin3;
				}

			public int[] getTable() {
				return table;
			}

			public void setTable(int table[]) {
				this.table = table;
			}

			public SimpleDateFormat getFormater() {
				return formater;
			}

			public void setFormater(SimpleDateFormat formater) {
				this.formater = formater;
			}

			public int[] getTableQAD() {
				return tableQAD;
			}

			public void setTableQAD(int tableQAD[]) {
				this.tableQAD = tableQAD;
			}

			public void iniTable(){
				for(int i=0;i<67;i++){
					table[i]=0;
				}
			}

			public UploadedFile getFileL3ps() {
				return fileL3ps;
			}

			public void setFileL3ps(UploadedFile fileL3ps) {
				this.fileL3ps = fileL3ps;
			}

			public UploadedFile getFileExtraction() {
				return fileExtraction;
			}

			public void setFileExtraction(UploadedFile fileExtraction) {
				this.fileExtraction = fileExtraction;
			}
			
			public UploadedFile getFileQAD() {
				return fileQAD;
			}

			public void setFileQAD(UploadedFile fileQAD) {
				this.fileQAD = fileQAD;
			}

			public String getDd() {
				return dd;
			}

			public void setDd(String dd) {
				this.dd = dd;
			}

			public String getDd1() {
				return dd1;
			}

			public void setDd1(String dd1) {
				this.dd1 = dd1;
			}

			public String getDd2() {
				return dd2;
			}

			public void setDd2(String dd2) {
				this.dd2 = dd2;
			}

			public Date getDate() {
				return date;
			}

			public void setDate(Date date) {
				this.date = date;
			}
		
			
}






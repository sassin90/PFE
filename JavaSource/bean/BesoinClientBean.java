package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;



@RequestScoped
@ManagedBean( name = "consomation" )
public class BesoinClientBean {
	
	
	private SimpleDateFormat formater = null;
	
	private Date today = new Date();
	
	private Date date1 = today;  
    
    private Date date2 = today;  
      
    private Date date3 = today;  
   
    private int table[] = new int[67];

	 public void extract(Date date){//17
	     	
	      	try {
	        	   
	      		FileInputStream file = new FileInputStream(new File("C:/Users/Yassin/Desktop/Extract 0503 (5).xlsx")); 
	      		
	        	    XSSFWorkbook workbook = new XSSFWorkbook(file);
	        	
	        	    Sheet sheet = workbook.getSheetAt(2);
	        	   
	        	    		
	        	    		for (int j = 1; j < sheet.getLastRowNum(); j++){
	        	    			
	        	    		
	        	    		Row row = sheet.getRow(j);
	        	           
	        	    		Cell cell = row.getCell(11);
   	        
   	        	    		if(cell.getDateCellValue().equals(date)){
   	        	    			
   	        	    			cell = row.getCell(2);
   	        	    		
	        	    		 String CellValue = cell.getStringCellValue();
	    	        	              
	    	        	              
	    	        	      getRef(17, table, CellValue, row);
	    	        	            
	        	    		}
	        	             
	        	          // file.close();
	        	 
	        	    		}	
	        	} catch (FileNotFoundException e) {
	        	    e.printStackTrace();
	        	} catch (IOException e) {
	        	    e.printStackTrace();
	        	}
			
		 }
	
	 public void extractQAD(){//17
	     	
	      	try {
	        	   
	      		FileInputStream file = new FileInputStream(new File("C:/Users/Yassin/Desktop/QAD.xls")); 
	      		
	        	    HSSFWorkbook workbook = new HSSFWorkbook(file);
	        	
	        	    Sheet sheet = workbook.getSheetAt(2);
	        	   
	        	    		
	        	    		for (int j = 6; j < sheet.getLastRowNum()-1; j++){
	        	    			
	        	    		
	        	    		Row row = sheet.getRow(j);
	        	           
	        	    		Cell cell = row.getCell(2);
	        	    		
	        	    		 String CellValue = cell.getStringCellValue();
	    	        	              
	    	        	      getRef(8, table, CellValue, row);
	    	        	   
	        	             
	        	          // file.close();
	        	 
	        	    		}	
	        	} catch (FileNotFoundException e) {
	        	    e.printStackTrace();
	        	} catch (IOException e) {
	        	    e.printStackTrace();
	        	}
			
		 }
	
	 
			public  void pieceConsomme() {
				
	
	      	try {
	      		
	      		FileInputStream file = new FileInputStream(new File("C:/Users/Yassin/Desktop/planification.xls"));

		           HSSFWorkbook wb = new HSSFWorkbook(file);
		            
		           HSSFSheet sheet = wb.getSheetAt(2);
		           
		            Cell cell,cell1,cell2 = null;
		   
		            formater = new SimpleDateFormat("'Etat du stock de ' dd/MM/yyyy 'à' hh:mm",Locale.FRANCE);
		            
		            cell = sheet.getRow(0).getCell(2);
        			
		            cell.setCellValue(formater.format(today));
		            
		            extractQAD();
		           
		            for(int i=6;i<73;i++){
            			
            			cell = sheet.getRow(i).getCell(8);
            			cell.setCellValue(table[i-6]);
            			
               
            }
		            iniTable();
		          
		           extract(getDate1());
		            
		            setFormater(new SimpleDateFormat("EEEE, d MMM yyyy",Locale.FRANCE));
		            
		            cell = sheet.getRow(4).getCell(9);
        			
		            cell.setCellValue(formater.format(getDate1()));
        			
		            for(int i=6;i<73;i++){
		            			
		            			cell = sheet.getRow(i).getCell(9);
		            			cell.setCellValue(table[i-6]);
		            			
		            			cell = sheet.getRow(i).getCell(10);
			            		 cell1 = sheet.getRow(i).getCell(9);
			            		cell2 = sheet.getRow(i).getCell(8);
			 		            cell.setCellValue(cell2.getNumericCellValue() - cell1.getNumericCellValue());
		            }
		         
		            //2
		            	iniTable();
		            	
		            	  extract(getDate2());
		            	  
		            	  cell = sheet.getRow(4).getCell(12);
	            			
		            	  cell.setCellValue(formater.format(getDate2()));
				            
				            for(int i=6;i<73;i++){
				         
				            	cell = sheet.getRow(i).getCell(12);
		            			cell.setCellValue(table[i-6]);
		            			
		            			cell = sheet.getRow(i).getCell(13);
			            		 cell1 = sheet.getRow(i).getCell(12);
			            		cell2 = sheet.getRow(i).getCell(10);
			 		            cell.setCellValue(cell2.getNumericCellValue() - cell1.getNumericCellValue());
							      
				            }
				            
				           //3
				            iniTable();
				            	 
				            	  extract(getDate3());
				            	  
				            	  cell = sheet.getRow(4).getCell(15);
			            			
				            	  cell.setCellValue(formater.format(getDate3()));
						            
						            for(int i=6;i<73;i++){
								          
						            	cell = sheet.getRow(i).getCell(15);
				            			cell.setCellValue(table[i-6]);
				            			
				            			cell = sheet.getRow(i).getCell(16);
					            		 cell1 = sheet.getRow(i).getCell(15);
					            		cell2 = sheet.getRow(i).getCell(13);
					 		            cell.setCellValue(cell2.getNumericCellValue() - cell1.getNumericCellValue());
						            }
						        

		           file.close();

		            FileOutputStream outFile =new FileOutputStream(new File("C:/Users/Yassin/Desktop/test4.xls"));
		            wb.write(outFile);
		            outFile.close();

	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }   
					
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


			public void iniTable(){
				for(int i=0;i<67;i++){
					table[i]=0;
				}
			}
			
			public void getRef(int col,int table[],String CellValue,Row row){//17
		     	
 	           
	    		Cell cell ;
	    		
	    		switch(CellValue) {
        	         
        	            case "00115625-02-RCAR":
        	            	
        	            //cell.setCellType(Cell.CELL_TYPE_NUMERIC);
        	            cell = row.getCell(col);
        	            table [0] = (int) cell.getNumericCellValue();
        	            	
        	            	
        	              break;
        	              
        	            case "00117138-02-RCAR":
					    	
					    	//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
					    	cell = row.getCell(col);
				     table [1] = (int) cell.getNumericCellValue();
				
				     	
				     		break;
        	              
        	            		case "00117137-02-RCAR":
    		    	    	
        			    	    	cell = row.getCell(col);
        			    	    	table [2] = (int) cell.getNumericCellValue();
        		    	    	
        			            				break;
        			            				
        	            		case "00117140-02-RCAR":
									
									//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
									cell = row.getCell(col);
									table [3] = (int) cell.getNumericCellValue();
							
						 	
						 		break;
        			            				
        	            		case "00117139-02-RCAR":
    					    		
						    		cell = row.getCell(col);
						    		table [4] = (int) cell.getNumericCellValue();
					 	    	
					         	
					         		break;
        	                  		
    	        	         case "00128260-03-RCAR":
    	        	        	 
    	        	        	//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
    	        	        	cell = row.getCell(col);
    	        	            table [5] = (int) cell.getNumericCellValue();
    	        	        
    	        	            	
        	            		break;
        	            		
    	        	case "00129905-02-RCAR":
    	        		
    	        	//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
    	        	cell = row.getCell(col);
 	            table [6] = (int) cell.getNumericCellValue();
        	    
 	            	
 	            		break;
 	            		
    	        	case "00130772-03-RCAR":
						
						//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
						cell = row.getCell(col);
				     table [7] = (int) cell.getNumericCellValue();
					
					
						break;
    		        	              
    	        case "00152697-01-RCAR":
    	        	
    	        	//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
    	        	cell = row.getCell(col);
	            table [8] = (int) cell.getNumericCellValue();
        	    	
	            	
	            		break;
	            		
							
					case "00152690-01-RCAR":
						
							//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
							cell = row.getCell(col);
					     table [9] = (int) cell.getNumericCellValue();
						
						
							break;
							
							
							case "00115581-02-rcar":
								
								//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
								cell = row.getCell(col);
						          table [10] = (int) cell.getNumericCellValue();
								
						
							break;
	    
						case "00115583-02-rcar":
							
							//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
							cell = row.getCell(col);
					        table [11] = (int) cell.getNumericCellValue();
							
					
									break;
					
						case "00115615-02-rcar":
						
						//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
						cell = row.getCell(col);
				        table [12] = (int) cell.getNumericCellValue();
						
				
					break;
					
						case "00115614-02-rcar":
							
							//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
							cell = row.getCell(col);
					        table [13] = (int) cell.getNumericCellValue();
							
					
						break;
						
						case "00116436-02-rcar":
							
							//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
							cell = row.getCell(col);
					        table [14] = (int) cell.getNumericCellValue();
							
					
						break;
						
						case "00117321-02-rcar":
							
							//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
							cell = row.getCell(col);
					        table [15] = (int) cell.getNumericCellValue();
							
					
						break;
    	        	 
						case "00201498-01-RCAR":
   	        	        	 
    	        	        	cell = row.getCell(col);
    	        	            table [16] += (int) cell.getNumericCellValue();
    	        	        	 
    	        	            	
    	        	              break;
    	        	              
    	        	            case "00201496-01-RCAR":
    	        	            	
    	        	            cell = row.getCell(col);
    	        	            table [16] += (int) cell.getNumericCellValue();
    	        	            	
    	        	            
    		        	              break;
    		        	              
    	        	            case "00201499-01-RCAR":
    	        	            	
    	        	            cell = row.getCell(col);
    	        	            table [16] += (int) cell.getNumericCellValue();
    	        	            
    	        	            
    	        	            	break;
    		        	              
    	        	            case "00201500-01-RCAR":
    	        	            	
    	        	            cell = row.getCell(col);
    	        	            table [16] += (int) cell.getNumericCellValue();
    	        	            	
    	        	            	
    		        	              break;
    		        	              
    	        	            case "00201497-01-RCAR":
    	        	            	
    	        	            cell = row.getCell(col);
    	        	            table [16] += (int) cell.getNumericCellValue();
    	        	            	
    	        	            	
    		        	              break;
    		        	              
    	        	            case "00201501-01-RCAR":
    	        	            	
    	        	            cell = row.getCell(col);
    	        	            table [16] += (int) cell.getNumericCellValue();
    	        	            	
    	        	            	
    	        	            		break;
    	        	            		
    	        	            case "00201495-01-RCAR":
    	        	            	
    	        	            cell = row.getCell(col);
    	        	            table [16] += (int) cell.getNumericCellValue();
    	        	            	
    	        	            	
    	        	            		break;
    	        	            		
    	        	            case "00128256-02-RCAR":
    	        	            	
    	        	            	cell = row.getCell(col);
        	        	            table [16] += (int) cell.getNumericCellValue();
			
						case "00115647-01-rcar":
						
						//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
						cell = row.getCell(col);
				        table [17] = (int) cell.getNumericCellValue();
						
				
					break;
					
						case "00117258-02-rcar":
						
						//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
						cell = row.getCell(col);
				        table [18] = (int) cell.getNumericCellValue();
						
				
					break;
					
						case "00116418-02-rtro":
							
							//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
							cell = row.getCell(col);
					        table [19] = (int) cell.getNumericCellValue();
							
					
						break;
						
							case "00117312-02-rtro":
							
							//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
							cell = row.getCell(col);
					         table [20] = (int) cell.getNumericCellValue();
							
					
						break;
				
					case "00115642-01-rtro":
						
						//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
						cell = row.getCell(col);
				        table [21] = (int) cell.getNumericCellValue();
						
				
					break;
					
						case "00115644-01-rtro":
						
						//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
						cell = row.getCell(col);
				        table [22] = (int) cell.getNumericCellValue();
						
				
					break;
					

						case "00115645-01-rtro":
						
						//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
						cell = row.getCell(col);
				        table [23] = (int) cell.getNumericCellValue();
						
				
					break;
					
						case "00116411-02-rcar":
							
							//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
							cell = row.getCell(col);
					        table [24] = (int) cell.getNumericCellValue();
							
					
						break;
						
						case "00128391-02-rcar":
							
							//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
							cell = row.getCell(col);
					        table [25] = (int) cell.getNumericCellValue();
							
					
						break;
						
						case "00116416-03-rcar":
							
							//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
							cell = row.getCell(col);
					        table [26] = (int) cell.getNumericCellValue();
							
					
						break;
						
						case "00117305-02-rcar":
							
							//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
							cell = row.getCell(col);
					       table [27] = (int) cell.getNumericCellValue();
							
					
						break;
						
						case "00128392-03-rcar":
							
							//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
							cell = row.getCell(col);
					        table [28] = (int) cell.getNumericCellValue();
							
					
						break;
							
							case "00117310-03-rcar":
							
							//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
							cell = row.getCell(col);
					         table [29] = (int) cell.getNumericCellValue();
							
					
						break;	
						
							case "00128424-02-rcar":
								
								//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
								cell = row.getCell(col);
						        table [30] = (int) cell.getNumericCellValue();
								
						
							break;
							
								case "00116432-02-rcar":
								
								//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
								cell = row.getCell(col);
						         table [31] = (int) cell.getNumericCellValue();
								
						
							break;
							
								case "00128425-02-rcar":
									
									//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
									cell = row.getCell(col);
							        table [32] = (int) cell.getNumericCellValue();
									
							
								break;
								
								case "00117317-02-rcar":
									
									//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
									cell = row.getCell(col);
							      table [33] = (int) cell.getNumericCellValue();
									
							
								break;
								
								case "00115670-02-0000":
									
									//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
									cell = row.getCell(col);
							           table [34] = (int) cell.getNumericCellValue();
									
							
								break;
								
								case "00115556-02-rcar":
									
									//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
									cell = row.getCell(col);
							        table [35] = (int) cell.getNumericCellValue();
									
							
								break;
								
								case "00115558-02-rcar":
									
									//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
									cell = row.getCell(col);
							        table [36] = (int) cell.getNumericCellValue();
									
							
								break;
								
								case "00115622-02-rcar":
									
									//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
									cell = row.getCell(col);
							       table [37] = (int) cell.getNumericCellValue();
									
							
								break;
								
									case "00171660-02-0000":
									
									//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
									cell = row.getCell(col);
							        table [38] = (int) cell.getNumericCellValue();
									
							
								break;
								
									case "00171670-01-T122":
										
										//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
										cell = row.getCell(col);
								         table [39] = (int) cell.getNumericCellValue();
										
								
									break;
									
									case "00171670-01-RCAR":
										
										//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
										cell = row.getCell(col);
								        table [40] = (int) cell.getNumericCellValue();
										
								
									break;
									
										case "00171670-01-S950":
										
										//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
										cell = row.getCell(col);
								        table [41] = (int) cell.getNumericCellValue();
										
								
									break;
									
										case "00115549-02-rcar":
											
											//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
											cell = row.getCell(col);
									        table [42] = (int) cell.getNumericCellValue();
											
									
										break;
										
										case "00115554-02-rcar":
											
											//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
											cell = row.getCell(col);
									        table [43] = (int) cell.getNumericCellValue();
											
									
										break;
										
										case "00115553-02-rcar":
											
											//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
											cell = row.getCell(col);
									        table [44] = (int) cell.getNumericCellValue();
											
									
										break;
										
										case "00171658-02-T122":
											
											//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
											cell = row.getCell(col);
									        table [45] = (int) cell.getNumericCellValue();
											
									
										break;
										
										case "00171658-02-RCAR":
											
											//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
											cell = row.getCell(col);
									        table [46] = (int) cell.getNumericCellValue();
											
									
										break;
										
										case "00171658-02-S950":
											
											//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
											cell = row.getCell(col);
									        table [47] = (int) cell.getNumericCellValue();
											
									
										break;
										
										case "00171657-02-RCAR":
											
											//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
											cell = row.getCell(col);
									       table [48] += (int) cell.getNumericCellValue();
											
									
										break;
										
										case "00171659-02-0000":
											
											//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
											cell = row.getCell(col);
									        table [49] += (int) cell.getNumericCellValue();
											
									
										break;
										
										case "00128398-02-S864":
		    	        	            	
				    	        	            cell = row.getCell(col);
				    	        	            table [50] += (int) cell.getNumericCellValue();
				    	        	          
				    	        	            break;
										
										case "00117248-02-RCAR":
											 
												cell = row.getCell(col);
											   table [51] += (int) cell.getNumericCellValue();
												
													break;
													
											case "00117249-03-RCAR":
											 
												cell = row.getCell(col);
											   table [52] += (int) cell.getNumericCellValue();
												
												
													break;
				    	        	            
										case "00116417-02-rtro":
											
											//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
											cell = row.getCell(col);
									        table[53] += (int) cell.getNumericCellValue();
											
									
										break;
										
										case "00117311-02-rtro":
											
											//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
											cell = row.getCell(col);
									       table [54] += (int) cell.getNumericCellValue();
											
									
										break;
										
										case "00116419-02-rtro":
											
											//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
											cell = row.getCell(col);
									       table [55] += (int) cell.getNumericCellValue();
											
									
										break;
										
										case "00117314-02-rtro":
											
											//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
											cell = row.getCell(col);
									        table [56] += (int) cell.getNumericCellValue();
											
									
										break;
										
										case "00117255-03-rcar":
											
											//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
											cell = row.getCell(col);
											table [57] += (int) cell.getNumericCellValue();
											
									
										break;
										
										case "00115654-02-RCAR":
				    	        	    	  
				    	        	    	//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
				    	        	    	cell = row.getCell(col);
			 	        	            table [58] += (int) cell.getNumericCellValue();
				    	        	    
				        	            	
				        	            		break;
				        	            		
				    	        	  case "00115653-01-RCAR":
				    	        		  
				    	        		//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
				    	        		cell = row.getCell(col);
				        	            table [59] += (int) cell.getNumericCellValue();
			    	        	    
				        	            	
				        	            		break;
				        	            		
				    	        	  		case "00115665-02-RCAR":
				    						
				    	        	  			cell = row.getCell(col);
				    				            table [60] += (int) cell.getNumericCellValue();
				    						
				    				
				    					break;
										
										case "00115748-02-0000":
											
											//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
											cell = row.getCell(col);
									         table [61] += (int) cell.getNumericCellValue();
											
									
										break;
										
										case "00127662-01-0000":
											
											//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
											cell = row.getCell(col);
									        table [62] += (int) cell.getNumericCellValue();
											
									
										break;
										
										case "00127663-01-0000":
											
											//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
											cell = row.getCell(col);
									        table [63] += (int) cell.getNumericCellValue();
											
									
										break;
										
										case "00115653-01-rcar":
											
											//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
											cell = row.getCell(col);
									        table [64] += (int) cell.getNumericCellValue();
											
									
										break;
										
										case "00116424-02-0000":
											
											//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
											cell = row.getCell(col);
									        table [65] = (int) cell.getNumericCellValue();
											
									
										break;
										
										case "00117316-02-0000":
											
											//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
											cell = row.getCell(col);
									        table [66] = (int) cell.getNumericCellValue();
											
									
										break;
										
										case "00115542-03-RCAR":
										//  case "681000643R":
											  
											  cell = row.getCell(col);
											  
					        	            	table[12]+= (int) cell.getNumericCellValue();
					        	            	table[13]+= (int) cell.getNumericCellValue();
					        	            	table[21]+= (int) cell.getNumericCellValue();
					        	            	table[22]+= (int) cell.getNumericCellValue();
					        	            	table[23]+= (int) cell.getNumericCellValue();
					        	            	table[34]+= (int) cell.getNumericCellValue();
					        	            	table[42]+= (int) cell.getNumericCellValue();
					        	            	table[44]+= (int) cell.getNumericCellValue();
					        	            	table[61]+= (int) cell.getNumericCellValue();
					        	            	table[62]+= (int) cell.getNumericCellValue();
					        	            	table[63]+= (int) cell.getNumericCellValue();
					        	            	table[64]+= (int) cell.getNumericCellValue();
					        	             
					        	            	break;
					        	              
										case "00115546-03-RCAR":
					        	            //case "681003901R":
					        	            	
					        	            	cell = row.getCell(col);
					        	            	
					        	            	table[21]+= (int) cell.getNumericCellValue();
					        	            	table[22]+= (int) cell.getNumericCellValue();
					        	            	table[23]+= (int) cell.getNumericCellValue();
					        	            	table[34]+= (int) cell.getNumericCellValue();
					        	            	table[35]+= (int) cell.getNumericCellValue();
					        	            	table[36]+= (int) cell.getNumericCellValue();
					        	            	table[37]+= (int) cell.getNumericCellValue();
					        	            	table[42]+= (int) cell.getNumericCellValue();
					        	            	table[43]+= (int) cell.getNumericCellValue();
					        	            	table[61]+= (int) cell.getNumericCellValue();
					        	            	table[62]+= (int) cell.getNumericCellValue();
					        	            	table[63]+= (int) cell.getNumericCellValue();
					        	            	table[64]+= (int) cell.getNumericCellValue();
					        	            	
					        	              break;
					        	              
										case "00115541-04-RCAR":
					        	           // case "681004426R":
					        	            	
					        	            	cell = row.getCell(col);
					        	            	
					        	            	table[21]+= (int) cell.getNumericCellValue();
					        	            	table[22]+= (int) cell.getNumericCellValue();
					        	            	table[23]+= (int) cell.getNumericCellValue();
					        	            	table[34]+= (int) cell.getNumericCellValue();
					        	            	table[37]+= (int) cell.getNumericCellValue();
					        	            	table[42]+= (int) cell.getNumericCellValue();
					        	            	table[44]+= (int) cell.getNumericCellValue();
					        	            	table[61]+= (int) cell.getNumericCellValue();
					        	            	table[62]+= (int) cell.getNumericCellValue();
					        	            	table[63]+= (int) cell.getNumericCellValue();
					        	            	table[64]+= (int) cell.getNumericCellValue();
					        	            	
						        	              break;
						        	              
					        	            
										case "00115543-03-RCAR":
									//case "681005017R":
					        	            	
					        	            	cell = row.getCell(col);
					        	            	
					        	            	table[10]+= (int) cell.getNumericCellValue();
					        	            	table[11]+= (int) cell.getNumericCellValue();
					        	            	table[12]+= (int) cell.getNumericCellValue();
					        	            	table[13]+= (int) cell.getNumericCellValue();
					        	            	table[21]+= (int) cell.getNumericCellValue();
					        	            	table[22]+= (int) cell.getNumericCellValue();
					        	            	table[23]+= (int) cell.getNumericCellValue();
					        	            	table[34]+= (int) cell.getNumericCellValue();
					        	            	table[42]+= (int) cell.getNumericCellValue();
					        	            	table[44]+= (int) cell.getNumericCellValue();
					        	            	table[61]+= (int) cell.getNumericCellValue();
					        	            	table[62]+= (int) cell.getNumericCellValue();
					        	            	table[63]+= (int) cell.getNumericCellValue();
					        	            	table[64]+= (int) cell.getNumericCellValue();
					        	            	
					        	            	break;
						        	              
					        	           // case "681006313R":
										case "00115545-02-RCAR":
					        	            	
					        	            	cell=row.getCell(col);
					        	            	
					        	            	table[12]+= (int) cell.getNumericCellValue();
					        	            	table[13]+= (int) cell.getNumericCellValue();
					        	            	table[17]+= (int) cell.getNumericCellValue();
					        	            	table[21]+= (int) cell.getNumericCellValue();
					        	            	table[22]+= (int) cell.getNumericCellValue();
					        	            	table[23]+= (int) cell.getNumericCellValue();
					        	            	table[34]+= (int) cell.getNumericCellValue();
					        	            	table[35]+= (int) cell.getNumericCellValue();
					        	            	table[36]+= (int) cell.getNumericCellValue();
					        	            	table[42]+= (int) cell.getNumericCellValue();
					        	            	table[43]+= (int) cell.getNumericCellValue();
					        	            	table[61]+= (int) cell.getNumericCellValue();
					        	            	table[62]+= (int) cell.getNumericCellValue();
					        	            	table[63]+= (int) cell.getNumericCellValue();
					        	            	table[64]+= (int) cell.getNumericCellValue();
					        	            	
						        	              break;
						        	              
					        	            //case "681007344R":
										case "00115544-02-RCAR":
					        	            	
					        	            	cell = row.getCell(col);
					        	            	
					        	            	table[17]+= (int) cell.getNumericCellValue();
					        	            	table[21]+= (int) cell.getNumericCellValue();
					        	            	table[22]+= (int) cell.getNumericCellValue();
					        	            	table[23]+= (int) cell.getNumericCellValue();
					        	            	table[34]+= (int) cell.getNumericCellValue();
					        	            	table[35]+= (int) cell.getNumericCellValue();
					        	            	table[36]+= (int) cell.getNumericCellValue();
					        	            	table[37]+= (int) cell.getNumericCellValue();
					        	            	table[42]+= (int) cell.getNumericCellValue();
					        	            	table[43]+= (int) cell.getNumericCellValue();
					        	            	table[61]+= (int) cell.getNumericCellValue();
					        	            	table[62]+= (int) cell.getNumericCellValue();
					        	            	table[63]+= (int) cell.getNumericCellValue();
					        	            	table[64]+= (int) cell.getNumericCellValue();
					        	            	
						        	              break;
						        	              
					        	           // case "681007582R":
										case "00128248-02-RCAR":
					        	            	
					        	            	cell = row.getCell(col);
					        	            	
					        	            	table[12]+= (int) cell.getNumericCellValue();
					        	            	table[13]+= (int) cell.getNumericCellValue();
					        	            	table[21]+= (int) cell.getNumericCellValue();
					        	            	table[22]+= (int) cell.getNumericCellValue();
					        	            	table[23]+= (int) cell.getNumericCellValue();
					        	            	table[34]+= (int) cell.getNumericCellValue();
					        	            	table[35]+= (int) cell.getNumericCellValue();
					        	            	table[36]+= (int) cell.getNumericCellValue();
					        	            	table[42]+= (int) cell.getNumericCellValue();
					        	            	table[43]+= (int) cell.getNumericCellValue();
					        	            	table[61]+= (int) cell.getNumericCellValue();
					        	            	table[62]+= (int) cell.getNumericCellValue();
					        	            	table[63]+= (int) cell.getNumericCellValue();
					        	            	table[64]+= (int) cell.getNumericCellValue();
					        	            	
						        	              break;
						        	              
					        	           // case "681002974R":
										case "00128247-02-RCAR":
					        	            	
					        	            	cell = row.getCell(col);
					        	            	
					        	            	table[10]+= (int) cell.getNumericCellValue();
					        	            	table[11]+= (int) cell.getNumericCellValue();
					        	            	table[12]+= (int) cell.getNumericCellValue();
					        	            	table[13]+= (int) cell.getNumericCellValue();
					        	            	table[17]+= (int) cell.getNumericCellValue();
					        	            	table[21]+= (int) cell.getNumericCellValue();
					        	            	table[22]+= (int) cell.getNumericCellValue();
					        	            	table[23]+= (int) cell.getNumericCellValue();
					        	            	table[34]+= (int) cell.getNumericCellValue();
					        	            	table[42]+= (int) cell.getNumericCellValue();
					        	            	table[44]+= (int) cell.getNumericCellValue();
					        	            	table[61]+= (int) cell.getNumericCellValue();
					        	            	table[62]+= (int) cell.getNumericCellValue();
					        	            	table[63]+= (int) cell.getNumericCellValue();
					        	            	table[64]+= (int) cell.getNumericCellValue();
					        	            	
					        	            		break;
					        	            		
					        	           // case "681001430R":
					        	            	
											case "00128246-02-RCAR":
											
					        	            	cell = row.getCell(col);
					        	            	
					        	            	table[12]+= (int) cell.getNumericCellValue();
					        	            	table[13]+= (int) cell.getNumericCellValue();
					        	            	table[17]+= (int) cell.getNumericCellValue();
					        	            	table[21]+= (int) cell.getNumericCellValue();
					        	            	table[22]+= (int) cell.getNumericCellValue();
					        	            	table[23]+= (int) cell.getNumericCellValue();
					        	            	table[34]+= (int) cell.getNumericCellValue();
					        	            	table[42]+= (int) cell.getNumericCellValue();
					        	            	table[44]+= (int) cell.getNumericCellValue();
					        	            	table[61]+= (int) cell.getNumericCellValue();
					        	            	table[62]+= (int) cell.getNumericCellValue();
					        	            	table[63]+= (int) cell.getNumericCellValue();
					        	            	table[64]+= (int) cell.getNumericCellValue();
					        	            
					        	            		break;
					        	            		
					        	            case "681004861R":// n'est pas trouvee 
					        	            	
					        	            	cell = row.getCell(col);
					        	            	
					        	            	table[17]+= (int) cell.getNumericCellValue();
					        	            	table[21]+= (int) cell.getNumericCellValue();
					        	            	table[22]+= (int) cell.getNumericCellValue();
					        	            	table[23]+= (int) cell.getNumericCellValue();
					        	            	table[34]+= (int) cell.getNumericCellValue();
					        	            	table[37]+= (int) cell.getNumericCellValue();
					        	            	table[42]+= (int) cell.getNumericCellValue();
					        	            	table[44]+= (int) cell.getNumericCellValue();
					        	            	table[61]+= (int) cell.getNumericCellValue();
					        	            	table[62]+= (int) cell.getNumericCellValue();
					        	            	table[63]+= (int) cell.getNumericCellValue();
					        	            	table[64]+= (int) cell.getNumericCellValue();
					        	            	
					        	            		break;
					        	            		
					        	            case "00116332-03-RCAR":
					        	            	
					        	            	cell = row.getCell(col);
			    	        	            	table[28]+= (int) cell.getNumericCellValue();
			    	        	            	table[29]+= (int) cell.getNumericCellValue();
			    	        	            	table[66]+= (int) cell.getNumericCellValue();
			    	        	            	
			    	        	              break;
			    	        	              
			    	        	            case "00116335-03-RCAR":
			    	        	            	
			    	        	            	cell=row.getCell(col);
			    	        	            	
			    	        	            	table[27]+= (int) cell.getNumericCellValue();
			    	        	            	table[29]+= (int) cell.getNumericCellValue();
			    	        	            	table[54]+= (int) cell.getNumericCellValue();
			    	        	            	table[66]+= (int) cell.getNumericCellValue();
			    	        	            	
			    	        	              break;
			    	        	              
			    	        	            case "00116337-03-RCAR":
			    	        	            	
			    	        	            	cell=row.getCell(col);
			    	        	            	
			    	        	            	table[27]+= (int) cell.getNumericCellValue();
			    	        	            	table[20]+= (int) cell.getNumericCellValue();
			    	        	            	table[29]+= (int) cell.getNumericCellValue();
			    	        	            	table[66]+= (int) cell.getNumericCellValue();
			    	        	            
			    		        	              break;
			    		        	              
			    	        	            case "00116340-02-RCAR":
			    	        	            	
			    	        	            	cell = row.getCell(col);
			    	        	            	
			    	        	            	table[27]+= (int) cell.getNumericCellValue();
			    	        	            	table[29]+= (int) cell.getNumericCellValue();
			    	        	            	table[56]+= (int) cell.getNumericCellValue();
			    	        	            	table[66]+= (int) cell.getNumericCellValue();
			    	        	            
			    	        	            	break;
			    		        	              
			    	        	            case "00128397-02-RCAR":
			    	        	            	
			    	        	            	cell = row.getCell(col);
			    	        	            	
			    	        	            	table[15]+= (int) cell.getNumericCellValue();
			    	        	            	table[32]+= (int) cell.getNumericCellValue();
			    	        	            	table[54]+= (int) cell.getNumericCellValue();
			    	        	            	
			    		        	              break;
			    		        	              
			    	        	            case "00116348-02-RCAR":
			    	        	            	
			    	        	            	cell = row.getCell(col);
			    	        	            	
			    	        	            	table[15]+= (int) cell.getNumericCellValue();
			    	        	            	table[20]+= (int) cell.getNumericCellValue();
			    	        	            	table[32]+= (int) cell.getNumericCellValue();  	        	            	
			    		        	           
			    	        	            	break;
			    		        	              
			    	        	            case "00116344-01-RCAR":
			    	        	            	
			    	        	            	cell = row.getCell(col);
			    	        	            	
			    	        	            	table[15]+= (int) cell.getNumericCellValue();
			    	        	            	table[33]+= (int) cell.getNumericCellValue();
			    	        	            	
			    	        	            	break;
			    		        	              
			    	        	            case "00195729-01-RCAR":
			    	        	            	
			    	        	            	cell = row.getCell(col);
			    	        	            	
			    	        	            	table[18]+= (int) cell.getNumericCellValue();
			    	        	            	table[57]+= (int) cell.getNumericCellValue();
			    	        	            	
			    	        	            		break;
			    	        	            		
			    	        	            case "00117254-03-RCAR":
			    	        	            	
			    	        	            	cell = row.getCell(col);
			    	        	            	
			    	        	            	table[57]+= (int) cell.getNumericCellValue();
			    	        	            	
			    	        	            		break;
			    	        	            		
			    	        	            case "00116336-03-RCAR":
			    	        	            	
			    	        	            	cell = row.getCell(col);
			    	        	            	
	 	   	    	        	            	table[24]+= (int) cell.getNumericCellValue();
	 	   	    	        	            	table[26]+= (int) cell.getNumericCellValue();
	 	   	    	        	            	table[53]+= (int) cell.getNumericCellValue();
	 	   	    	        	            	table[65]+= (int) cell.getNumericCellValue();
	 	   	    	        	            	
	 	   	    	        	              break;
	 	   	    	        	              
	 	   	    	        	            case "00116341-02-RCAR":
	 	   	    	        	            	
	 	   	    	        	            	cell = row.getCell(col);
	 	   	    	        	            	
	 	   	    	        	            	table[24]+= (int) cell.getNumericCellValue();
	 	   	    	        	            	table[26]+= (int) cell.getNumericCellValue();
	 	   	    	        	            	table[55]+= (int) cell.getNumericCellValue();
	 	   	    	        	            	table[65]+= (int) cell.getNumericCellValue();
	 	   	    	        	            	
	 	   	    	        	              break;
	 	   	    	        	              
	 	   	    	        	         case "00116338-03-RCAR":
	 	   	    	        	        	 
	 	   	    	        	        	 cell = row.getCell(col);
	 	   	    	        	        	 
	 	   	    	        	        	 	table[19]+= (int) cell.getNumericCellValue();
	 	   	    	        	        	 	table[24]+= (int) cell.getNumericCellValue();
	 	   	    	        	        	 	table[26]+= (int) cell.getNumericCellValue();
	 	   	    	        	        	 	table[65]+= (int) cell.getNumericCellValue();
	 	   	    	        	            	
	 	   	    	        	              break;
	 	   	    	        	              
	 	   	    	        	            case "00116333-02-RCAR":
	 	   	    	        	            	
	 	   	    	        	            	cell = row.getCell(col);
	 	   	    	        	            	
	 	   	    	        	            	table[25]+= (int) cell.getNumericCellValue();
	 	   	    	        	            	table[26]+= (int) cell.getNumericCellValue();
	 	   	    	        	            	table[65]+= (int) cell.getNumericCellValue();
	 	   	    	        	            
	 	   	    		        	              break;
	 	   	    		        	              
	 	   	    	        	            case "00116343-05-RCAR":
	 	   	    	        	            	
	 	   	    	        	            	cell = row.getCell(col);
	 	   	    	        	            	
	 	   	    	        	            	table[24]+= (int) cell.getNumericCellValue();
	 	   	    	        	            	table[26]+= (int) cell.getNumericCellValue();
	 	   	    	        	            	table[55]+= (int) cell.getNumericCellValue();
	 	   	    	        	            	table[65]+= (int) cell.getNumericCellValue();
	 	   	    	        	            
	 	   	    	        	            	break;
	 	   	    		        	              
	 	   	    	        	            case "00117256-01-RCAR":
	 	   	    	        	            	
	 	   	    	        	            	cell = row.getCell(col);
	 	   	    	        	            	
	 	   	    	        	            	table[57]+= (int) cell.getNumericCellValue();
	 	   	    	        	            	table[18]+= (int) cell.getNumericCellValue();
	 	   	    	        	            	
	 	   	    		        	              break;
	 	   	    		        	              
	 	   	    	        	            case "00128396-02-RCAR":
	 	   	    	        	            	
	 	   	    	        	            	cell = row.getCell(col);
	 	   	    	        	            	
	 	   	    	        	            	table[14]+= (int) cell.getNumericCellValue();
	 	   	    	        	            	table[30]+= (int) cell.getNumericCellValue();
	 	   	    	        	            	table[53]+= (int) cell.getNumericCellValue();
	 	   	    	        	            	
	 	   	    		        	              break;
	 	   	    		        	              
	 	   	    	        	            case "00195727-01-RCAR":
	 	   	    	        	            	
	 	   	    	        	            	cell = row.getCell(col);
	 	   	    	        	            	
	 	   	    	        	            	table[57]+= (int) cell.getNumericCellValue();
	 	   	    	        	            	
	 	   	    	        	            		break;
	 	   	    	        	            		
	 	   	    	        	            case "00116345-01-RCAR":
	 	   	    	        	            	
	 	   	    	        	            	cell = row.getCell(col);
	 	   	    	        	            	table[14]+= (int) cell.getNumericCellValue();
	 	   	    	        	            	table[31]+= (int) cell.getNumericCellValue();
	 	   	    	        	            	
	 	   	    	        	            		break;
	 	   	    	        	            		
	 	   	    	        	         case "00195728-01-RCAR":
	 	   	    	        	        	 
	 	   	    	        	        	 cell = row.getCell(col);
	 	   	    	        	        	 
	 	   	    	        	        	 table[57]+= (int) cell.getNumericCellValue();
	 	   	    	        	            	
	 	    	        	            		break;
	 	    	        	            		
	 	   	    	        	      case "00116349-03-RCAR":
	 	   	    	        	    	  
	 	   	    	        	    	  cell = row.getCell(col);
	 	   	    	        	    	  
	 	   	    	        	    	  table[14]+= (int) cell.getNumericCellValue();
	 	   	    	        	    	  table[19]+= (int) cell.getNumericCellValue();
	 	   	    	        	    	  table[30]+= (int) cell.getNumericCellValue();
	 	    	        	            	
	 	    	        	            		break;
										
										default:
	    	        	             
	    	        	          }
	    		
	    					}
					}







package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;







import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;


@RequestScoped
@ManagedBean( name = "readExcelBean" )
public class ReadExcelBean {
	
	private int debut;
	private int fin;
	
	        public  void readExcel() throws IOException {
	        	
	        	//JFileChooser fileChooser = new JFileChooser();
	        	
	        	//int returnValue = fileChooser.showOpenDialog(null);
	        	
	        	//if(returnValue==JFileChooser.APPROVE_OPTION){
	       
	        	/*
				
					try {
					//Workbook workbook = new XSSFWorkbook(new FileInputStream(fileChooser.getSelectedFile()));
					
					Workbook workbook = new XSSFWorkbook(new FileInputStream("C:/Users/Yassin/Desktop/test1.xlsx"));
						
						//XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream("foo.xslx"));
						
					Sheet sheet = workbook.getSheetAt(0);
						 
			        	 for(Iterator<Row> rit= sheet.rowIterator();rit.hasNext();){
			        		
			        	Row row = rit.next();
			        		
			        	 for(Iterator<Cell> cit = row.cellIterator();cit.hasNext();){	        	
			        			
			        			 Cell cell = cit.next();
			        	 
			        			 cell.setCellType(Cell.CELL_TYPE_STRING);
			        			 
			        			 if(!cell.getStringCellValue().equals("koko")) System.out.println("walo ma zda9ti");
			        			 
			        			 else  System.out.println("hanta wa3er");
			        			 
			        		 }
			        		 
			        	 }
					} catch (FileNotFoundException e) {
		
						e.printStackTrace();
					
			        	  } catch (IOException e) {
					
						e.printStackTrace();
					}
					
	        	//}*/
	        	
	        	
	  /*    	try {
	        	     
	        	    FileInputStream file = new FileInputStream(new File("C:/Users/Yassin/Desktop/test.xlsx"));
	        	     
	        	  
	        	    XSSFWorkbook workbook = new XSSFWorkbook(file);
	        	 
	        	    Sheet sheet = workbook.getSheetAt(0);
	        	
                   // System.out.print(sheet.getLastRowNum() + 1 + "\t\t");
                    
	        	    	//for (int j=0; j< sheet.getLastRowNum() + 1; j++){
                    
                    debut=3;
	        	    		
	        	    		for (int j=0; j< sheet.getLastRowNum() + 1; j++){
	        	    		
	        	    		Row row = sheet.getRow(j);
	        	            Cell cell = row.getCell(0);
	        	    	
	        
	        	            
	        	            cell.setCellType(Cell.CELL_TYPE_STRING);
	        	
	        	           
	        	                    System.out.print(cell.getStringCellValue() + "\t\t");
	        	      
	        	        System.out.println("");
	        	  }
	            
	        	} catch (FileNotFoundException e) {
	        	    e.printStackTrace();
	        	} catch (IOException e) {
	        	    e.printStackTrace();
	        	}
	        	
	        	    
					
	        	}

			public int getDebut() {
				return debut;
			}

			public void setDebut(int debut) {
				this.debut = debut;
			}

			public int getFin() {
				return fin;
			}

			public void setFin(int fin) {
				this.fin = fin;
			}
*/
	        	
	        
	        	FileInputStream file = new FileInputStream(new File("C:/Users/Yassin/Desktop/test.xlsx"));
	        	   // FileInputStream fis = new FileInputStream(excel);

	        	
	              XSSFWorkbook wb = new XSSFWorkbook(file);
	             // XSSFSheet ws = wb.getSheet("Input");
	              XSSFSheet ws = wb.getSheetAt(0);
	              int rowNum = ws.getLastRowNum() + 1;
	              int colNum = ws.getRow(0).getLastCellNum();
	              String [][] data = new String [rowNum] [colNum];

	             // for(int i = 0; i <rowNum; i++){
	            	  for(int i = 0; i <3; i++){
	                  XSSFRow row = ws.getRow(i);
	                     // for (int j = 0; j < colNum; j++){
	                    	  for (int j = 0; j < 3; j++){
	                          XSSFCell cell = row.getCell(j);
	                          
	                         
	                          
	                          cell.setCellType(Cell.CELL_TYPE_STRING);
	                         // String value = cell.toString();
	                          String value =cell.getStringCellValue();
	                          if(value=="") value="";
	                          data[i][j] = value;
		        	          System.out.print("row  "+rowNum+"col  "+ colNum);
	                          System.out.println ("the value is " + value);
	                      }
	              }

	          }
	      
	        	    }



	        	
	       



package bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;  
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;  
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;  
  





import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.event.ItemSelectEvent;  
import org.primefaces.model.chart.CartesianChartModel;  
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel; 


@RequestScoped
@ManagedBean( name = "chartBean" )
public class StaticBean implements Serializable {  
	  
	    private CartesianChartModel categoryModel;  
	  
	    private PieChartModel pieModel;  
	  
	    public StaticBean() {  
	        createCategoryModel();  
	        createPieModel();  
	    }  
	  
	    public void itemSelect(ItemSelectEvent event) {  
	        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",  
	                        "Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());  
	  
	        FacesContext.getCurrentInstance().addMessage(null, msg);  
	    }  
	  
	    public CartesianChartModel getCategoryModel() {  
	        return categoryModel;  
	    }  
	  
	    public PieChartModel getPieModel() {  
	        return pieModel;  
	    }  
	  
	    private void createCategoryModel() {  
	    	
	    	FileInputStream file;
	    	 categoryModel = new CartesianChartModel();  
		        ChartSeries boys = new ChartSeries();  
		        boys.setLabel("Boys");
		        
			try {
				file = new FileInputStream(new File("C:/Users/Yassin/Desktop/test.xlsx"));
				XSSFWorkbook workbook = new XSSFWorkbook(file);
				Sheet sheet = workbook.getSheetAt(0);
				for (int j = 0; j < sheet.getLastRowNum()+1; j++){
    	  			
	    	    	Row	 row = sheet.getRow(j);
	    	           
	    	    		Cell cell = row.getCell(0);
	    	    			
	    	    			int i= (int) cell.getNumericCellValue();
	    	    			
	    	    			cell = row.getCell(1);
	    	    			
	    	    			int k= (int) cell.getNumericCellValue();
	        	    		 
	    	    			boys.set(Integer.toString(i) , k); 
	}
			} catch (IOException e) {
				
				e.printStackTrace();
			} 
    
	  
	        categoryModel.addSeries(boys);  
	        
	    }  
	  
	    private void createPieModel() {  
	        pieModel = new PieChartModel();  
	  
	        pieModel.set("Brand 1", 540);  
	        pieModel.set("Brand 2", 325);  
	        pieModel.set("Brand 3", 702);  
	        pieModel.set("Brand 4", 421);  
	    }  
	    
		public void tableauPlanification() throws IOException{
		
	       
	      		FileInputStream file = new FileInputStream(new File("C:/Users/Yassin/Desktop/test.xlsx")); 
	      		
	        	    XSSFWorkbook workbook = new XSSFWorkbook(file);
	        	
	        	    Sheet sheet = workbook.getSheetAt(0);
	        	  
	        	   		
    	    	for (int j = 0; j < sheet.getLastRowNum()+1; j++){
	        	  			
	        	    	Row	 row = sheet.getRow(j);
	        	           
	        	    		Cell cell = row.getCell(0);
	        	    			
	        	    			int i= (int) cell.getNumericCellValue();
	        	    			
	        	    			cell = row.getCell(1);
	        	    			
	        	    			int k= (int) cell.getNumericCellValue();
		        	    		 
		        	    		System.out.println("i"+i);
		        	    		System.out.println("k"+k);
	}  

	      	}
		}

 

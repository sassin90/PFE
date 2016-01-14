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

import util.PieceConverter;


@RequestScoped
@ManagedBean( name = "tb" )
public class tbBean {
	
	private int table[] = new int[67];
	
	private int tableDispo[] = new int[67];
	
	private int tbDispo[] = new int[67];
	
	private int pos[] = new int[67];
	
	private String tableM[] = new String [67];
	
	private String tableMachine[] = new String [67];
	
	private String machine[] = new String[67];
	
	private String piecePos[] = new String[67];
	
	private String p_h[] = new String[67];
	
	private int tablePos[] = new int[67];
	
	private int tableH [] = {22,23,24,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21};
	
	private String piece[]= new String [67];
	
	private String pieceBesoin[]= new String [67];
	
	private int besoin[] = new int [67];
	
	private int heure=0;
	
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
		
		iniMachine();
		
		 tableauPlanification(10,getDate1());

			try {
		  		
		  		FileInputStream file = new FileInputStream(new File("C:/Users/Yassin/Desktop/Tableau Planification.xlsx"));

		        XSSFWorkbook wb = new XSSFWorkbook(file);
		      
		      XSSFSheet sheet = wb.getSheet("test");
		      
		     
		       
		    //  writePlannig(file ,sheet,getDatePos(getDate1()));  
		     
		    //  writePlannig(file ,sheet,getDatePos(getDate1(),getTimeP(getBesoinP(getTime(besoin[j],tbDispo[j],2)*(-1),6,2))));
		    // for(int i=0;i<67;i++){
		    	// if(tablePos[i]!=0) {
		    		// System.out.println(tablePos[i]);
		     /* for(int j=0;j<67;j++){
	        		if(tablePos[j]!=0){
	        		 System.out.println("pos:"+tablePos[j]);
		        	   System.out.println("mach:"+tableMachine[j]);
		        	   System.out.println("piece:"+p_h[j]);}
	        	}*/
		    		 writePlannig(file ,sheet);
		    		// }
		    	// }
		    /* for(int j=0;j<9;j++){
		    	 
		    		 System.out.println(machine[j]);
		    		
		    	 }*/
		      //  tableauPlanification(13,getDate2());
		        
		       // writePlannig(file ,sheet,6); 
		        
		      //  tableauPlanification(16,getDate3());
		        
		      //  writePlannig(file ,sheet,9);
		  
		    		 FileOutputStream outFile =new FileOutputStream(new File("C:/Users/Yassin/Desktop/koko.xlsx"));
		           
		    		 wb.write(outFile);
		    		 outFile.close();

		    } catch (FileNotFoundException e) {
		        e.printStackTrace();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		  
				
	    	
	  	}
	  
						  public void iniTable(){
								for(int i=0;i<67;i++){
									table[i]=-1;
								}
							}
						  
						  public void iniMachine(){
								for(int i=0;i<9;i++){
									machine[i]="";
								}
							}
					
						  
						 /* public void getProjet(){
							  
							  String PLS[]={"J56","J51","J2","J52","J58","J57","J9","J10"};
							  
							  for(int i=0;i<;i++){
								  
							  }
						  }*/
						  
						  public void getInfo(String ma,String p_h,int pos) {//xerka m3a function getPos
							 
								
		    		    		switch(ma) {
		    	        	         
		    	        	            case "ENGL 1000":
		    	        	            
		    	        	    			machine[0] += p_h +"h";//hna 7al
		    	        	    			
		    	        	            	
		    	        	            	
		    	        	              break;
		    	        	              
		    	        	            case "ENGL 1500":
		    	        	            	
		    	        	            	machine[1] += p_h +"h";
		    	        	            	
		        	        	            	
		        	        	            	
		        	        	              break;
		        	        	              
											case "ENGL 700":
																    	        	            	
												machine[2] += p_h +"h";
												
																        	        	            	
																        	        	            	
											break;
																        	        	              
											 case "KM 2000":
																 	
												 machine[3] += p_h +"h";
												
																     	
										 break;
																       
											 case "KM 1000":
																 	
												 machine[4] += p_h +"h"; 
											
																     	
											 break;
																       
											 case "ENGL 2000":
																 	
												 machine[5] += p_h +"h";
											
																     	
																     	
											break;
																       
										 case "SAND 1500":
																 	
											 machine[6] += p_h +"h";
											
																     	
																     	
									 break;
																       
										 case "KM 1300":
																 	
											 machine[7] += p_h +"h";
											 
																     	
																     	
									 break;
									 
										 case "KM 800":
											 	
											 machine[8] += p_h +"h";
											
																		     	
																		     	
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
						        	    			
						        	    		//	int min=0;
						        	    		
						        	    		Row row = sheet.getRow(j);
						        	           
						        	    		Cell cell = row.getCell(col);
						        	    		//System.out.println("j"+j);
						        	    		
						        	    		if(cell.getNumericCellValue()<0){
						        	    			
						        	    			cell = row.getCell(7);
							        	    		 
							        	    		 while(cell.getStringCellValue().equals("")){
							        	    			
							        	    			 j--;
							        	    			 i++;
							        	    			 
							        	    			 row = sheet.getRow(j);
							        	    			 cell = row.getCell(7);
							        	    			 
							        	    		 }j=j+i;
							        	    		 
							        	    		 piece[j-14]= cell.getStringCellValue();
							        	    		 row = sheet.getRow(j);
						        	    			 cell = row.getCell(10);
						        	    			 table[j-14]=(int) cell.getNumericCellValue();
						        	    			 cell = row.getCell(9);
						        	    			 tableDispo[j-14]=(int) cell.getNumericCellValue();
						        	    			
						        	    			 cell = row.getCell(0);
						        	    			 i=0;
							        	    		 while(cell.getStringCellValue().equals("")){
								        	    			
							        	    			 j--;
							        	    			 i++;
							        	    			 
							        	    			 row = sheet.getRow(j);
							        	    			 cell = row.getCell(0);
							        	    			 
							        	    		 }
							        	    		 j=j+i;
							        	    		 tableM[j-14]=cell.getStringCellValue();
							        	    		 
							        	    		
							        	    		 }
						        	    		
						        	    		}
						        	    		String ss="";
						        	    		int nn=-1;
						        	    		for(int i=14;i<73;i++) {
						        	    			
						        	    			if(piece[i-14]!=null){
						        	    			
							        	    			//nn=table[i-14];
							        	    			
						        	    			if(ss.equals(piece[i-14])){
						        	    				
						        	    				ss=piece[i-14];
						        	    				if(nn>=table[i-14]) {nn=table[i-14];
						        	    				show(i);}
						        	    			}
						        	    			else {
						        	    				ss=piece[i-14];
						        	    			
						        	    			nn=table[i-14];
						        	    				show(i);}
						        	    			
						        	    			//System.out.println(i+":"+nn);
						        	    		}
						        	    			
						        	    		}
						        	   
						        	    		file = new FileInputStream(new File("C:/Users/Yassin/Desktop/Tableau Planification.xlsx"));

							    		        XSSFWorkbook wb = new XSSFWorkbook(file);
							    		         
							    		        sheet = wb.getSheet("test");
						        	    		
						        	    		for(int j=0;j<67;j++) {
						        	    	
						        	    	if(pieceBesoin[j]!=null && besoin[j]!=0 && tbDispo[j]!=0  ){
						        	    		while(pieceBesoin[j].equals(pieceBesoin[j+1])){
						        	    			if(besoin[j]<besoin[j+1]) besoin[j+1]=besoin[j];
						        	    			j++;
						        	    		}
						        	    		
						        	    	
						        	    		
						        	    		//System.out.println(getBesoinP(getTime(besoin[j],tbDispo[j],2)*(-1),6,2));
						        	    	
						        	    	 p_h[j]=" "+pieceBesoin[j]+" "+getTime(besoin[j],tbDispo[j],2);
						        	    	
						        	    	 tablePos[j] = getDatePos(dd,getTimeP(getBesoinP(getTime(besoin[j],tbDispo[j],2)*(-1),6,2)));
						        	    	 
						        	    	// getInfo(tableMachine[j],p_h[j],tablePos[j]);
						        	  
						        	    	
						        	    	}
						        	    }
						        	
						        	    
						        	} catch (FileNotFoundException e) {
						        	    e.printStackTrace();
						        	} catch (IOException e) {
						        	    e.printStackTrace();
						        	}
								
							 }
							int j=0;
							public void show(int i){
								
								/*if(!piece[i-14].equals(piece[i-13])) {System.out.println(i+":"+table[i-14]);
								System.out.println(i+"pic:"+piece[i-14]);}
								else if(piece[i-14]!=null || piece[i-14]!=null)
									System.out.println(i+":"+table[i-14]);System.out.println(i+"pic:"+piece[i-14]);*/
								
								//if(!piece[i-14].equals(piece[i-13]) && piece[i-14]!=null ) 
								pieceBesoin[j]=piece[i-14];
								besoin[j]=table[i-14];
								tableMachine[j]=tableM[i-14];
								tbDispo[j]=tableDispo[i-14];
								j++;
								//else if(!piece[i-14].equals(piece[i-13])) System.out.println(i+":"+table[i-14]); 	
								
							}
							
							public void writePlannig(FileInputStream file , Sheet sheet) throws IOException{
							
								Cell cell;
								int aa=0,bb=0,cc=0,dd=0,ee=0,ff=0,gg=0,hh=0;
								
		    		    	for(int i=0;i<67;i++){
		    		    		
		    		    		if(tablePos[i]!=0){
        	            	
        	    			switch(tableMachine[i]) {
   	        	         
	        	            case "ENGL 1000":
	        	            	
	        	            	cell = sheet.getRow(4).getCell(tablePos[i]);
	        	    			cell.setCellValue(p_h[i]);
	        	    		
	        	              break;
	        	              
	        	            case "ENGL 1500":
	        	            	
	        	            	cell = sheet.getRow(5).getCell(tablePos[i]);
	        	    			cell.setCellValue(p_h[i]);
	        	            	
	        	    			
    	        	              break;
    	        	              
								case "ENGL 700":
									
									cell = sheet.getRow(6).getCell(tablePos[i]);
		        	    			cell.setCellValue(p_h[i]);
									
		        	    			
								break;
													        	        	              
								 case "KM 2000":
									 
									 cell = sheet.getRow(7).getCell(tablePos[i]);
									 cell.setCellValue(p_h[i]);	
									 
			        	    			
								break;
													       
								 case "KM 1000":
									 
									 cell = sheet.getRow(8).getCell(tablePos[i]);
									 cell.setCellValue(p_h[i]);	
									 
													     	
								 break;
													       
								 case "ENGL 2000":
									 
									 cell = sheet.getRow(9).getCell(tablePos[i]);
									 cell.setCellValue(p_h[i]);
								 
								break;
													       
							 case "SAND 1500":
													 	
								 cell = sheet.getRow(10).getCell(tablePos[i]);
								 cell.setCellValue(p_h[i]);		
								
													     	
								 break;
													       
							 case "KM 1300":
													 	
								 cell = sheet.getRow(11).getCell(tablePos[i]);
								 cell.setCellValue(p_h[i]);	
													     	
								 break;
						 
							 case "KM 800":
								 	
								 cell = sheet.getRow(12).getCell(tablePos[i]);
								 cell.setCellValue(p_h[i]);	
								 
															     	
								 break;
	        	          
							 default:
								 System.out.println("erreur");
		        	            	
								 
		    		}
		    		    		}	
		    		    	}
        	            
	
						file.close();
							}
							
						/*	public int getHeurePos(int heure){
								
								int pos=-1;
								
								if(heure>22 && heure<=6) pos =0;
								else if((heure>6 && heure<=2)) pos=1;
								else 
							}*/
							
							public int getDatePos(Date dd,int time){
								
								SimpleDateFormat formater = new SimpleDateFormat("EEEE",Locale.FRANCE);
								
								int posDate;
							
								 switch(formater.format(dd)) {
        	         
								 case "vendredi":
        	            	
									 posDate= 3+time;
									
									 break;
        	              
								 case "samedi":
									 
									 posDate= 6+time;//posDate=6+time
			        	            	
									 break;
									 
								 case "dimanche":
									 
									 posDate= 9+time;
			        	            	
									 break;
									 
								 case "lundi":
									 
									 posDate= 12+time;
			        	            	
									 break;
									 
								 case "mardi":
									 
									 posDate= 15+time;
			        	            	
									 break;
									 
								 case "mercredi":
									 
									 posDate= 18+time;
			        	            	
									 break;
									 
								 case "jeudi":
									 
									 posDate= 21+time;
			        	            	
									 break;

						default:
							
							posDate= -1;
								 }
								return posDate;
								
							}
							
							public int getBesoinP(int dispo,int nbr_eqp, int eqp_h){
							
								if((eqp_h*8)>=dispo){
									
									switch(nbr_eqp){
									
									case 2: 
										
										return tableH[dispo];
										
									case 3: 
										
										return tableH[dispo+8];
										
									case 4: 
										
										return tableH[dispo+16];
										
									case 5: 
										
										return tableH[dispo];
										
									case 6: 
										
										if(dispo<8) return tableH[dispo];
										
										else return tableH[dispo+7];
										
									case 7: 
									
										return tableH[dispo+8];
										
									case 9: 
										
										return tableH[dispo];
										
									default:
										
										
									}
									
								}
								return -1;
							}
							
							public int getTimeP(int time){
								
								if(time>=6 && time <14) return 1;
								else if(time>=14 && time <22) return 2;
								else return 0;
							}
							
							public int getTime(int nbrB,int nbrD,int nbr_eqp){
								
								return nbrB/(nbrD/(nbr_eqp*8));	
							}
							
						public int getA() {
							return a;
						}
						public void setA(int a) {
							this.a = a;
						}
						public String[] getTableM() {
							return tableM;
						}
						public void setTableM(String[] tableM) {
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
						public int[] getTableH() {
							return tableH;
						}
						public void setTableH(int tableH[]) {
							this.tableH = tableH;
						}
						public int getHeure() {
							return heure;
						}
						public void setHeure(int heure) {
							this.heure = heure;
						}	
						public int[] getBesoin() {
							return besoin;
						}
						public void setBesoin(int besoin[]) {
							this.besoin = besoin;
						}
						public String[] getPieceBesoin() {
							return pieceBesoin;
						}
						public void setPieceBesoin(String pieceBesoin[]) {
							this.pieceBesoin = pieceBesoin;
						}
						public String[] getTableMachine() {
							return tableMachine;
						}
						public void setTableMachine(String tableMachine[]) {
							this.tableMachine = tableMachine;
						}
						public int[] getTableDispo() {
							return tableDispo;
						}
						public void setTableDispo(int tableDispo[]) {
							this.tableDispo = tableDispo;
						}
						public int[] getTbDispo() {
							return tbDispo;
						}
						public void setTbDispo(int[] tbDispo) {
							this.tbDispo = tbDispo;
						}
						public int[] getTablePos() {
							return tablePos;
						}
						public void setTablePos(int tablePos[]) {
							this.tablePos = tablePos;
						}
						public String[] getPiecePos() {
							return piecePos;
						}
						public void setPiecePos(String piecePos[]) {
							this.piecePos = piecePos;
						}
						public int[] getPos() {
							return pos;
						}
						public void setPos(int pos[]) {
							this.pos = pos;
						}
}

package bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



@RequestScoped
@ManagedBean( name = "paceboard" )
public class PaceboardBean {
	
	private int table[] = new int[100];
	
	private String ref[] = new String[6];
	
	private String des[] = new String[6];
	
	private int tableStock[] = new int[100];
	
	private int tbStock[] = new int[100];
	
	private int tableDispo[] = new int[100];
	
	private int tbDispo[] = new int[100];
	
	private int pos[] = new int[100];
	
	private String tableM[] = new String [100];
	
	private String tableMachine[] = new String [100];
	
	private String machine[] = new String[100];
	
	private String piecePos[] = new String[100];
	
	private String p_h[] = new String[100];
	
	private int tablePos[] = new int[100];
	
	private int tableCap[] = new int[100];
	
	private int tbCap[] = new int[100];
	
	private int pieceSort[] = new int[100];
	
	private int casePos[][] = new int [9][24];
	
	private int tableH [] = {22,23,24,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21};
	
	private String piece[]= new String [100];
	
	private String pieceBesoin[]= new String [100];
	
	private int besoin[] = new int [100];
	
	private String tableProjet[]= new String[100];
	
	private String tbProjet[]= new String[100];
	
	private int heure=0;
	
	private Date today = new Date();
	
	private Date date1 = today;  
    
    private Date date2 = today;  
      
    private Date date3 = today; 
	
    private List<String> selectedOptions; 
    
    private int nbr_eqp;
    
    private int eqp_h;
  
	private int a=0;
	
			
	
	public  void tablePlanning() {
		
		//iniMachine();
		
		 tableauPlanification(10,getDate1());

			/*try {
		  		
		  		FileInputStream file = new FileInputStream(new File("C:/Users/Yassin/Desktop/Tableau Planification.xlsx"));

		        XSSFWorkbook wb = new XSSFWorkbook(file);
		      
		      XSSFSheet sheet = wb.getSheet("test");
		    
		     
		
		   //   writePlannig(file ,sheet);
	
		  
		    		// FileOutputStream outFile =new FileOutputStream(new File("C:/Users/Yassin/Desktop/koko.xlsx"));
		           
		    		// wb.write(outFile);
		    		// outFile.close();

		    } catch (FileNotFoundException e) {
		        e.printStackTrace();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }*/
		  
				
	    	
	  	}
	  
						  public void iniTable(){
								for(int i=0;i<100;i++){
									table[i]=-1;
								}
							}
						  
						  public void iniRef(){
								for(int i=0;i<6;i++){
									ref[i]="";
									des[i]="";
								}
							}
					
					
							public void tableauPlanification(int col,Date dd){
								
						      	try {
						       
						      		FileInputStream file = new FileInputStream(new File("C:/Users/Yassin/Desktop/test4.xlsx")); 
						      		
						        	    XSSFWorkbook workbook = new XSSFWorkbook(file);
						        	
						        	    Sheet sheet = workbook.getSheet("etat du stock");
						        	    
						        	    iniTable();
						        	    
						        	  
						        	   		
				        	    	for (int j = 14; j < sheet.getLastRowNum(); j++){
						        	  
						        	    			int i=0;
						        	    		
						        	    	Row	 row = sheet.getRow(j);
						        	           
						        	    		Cell cell = row.getCell(col);
						        	    		
						        	    		if(cell.getNumericCellValue()<0){
						        	    			
						        	    			tableDispo[j-14]=(int) cell.getNumericCellValue();
						        	    			
						        	    			cell = row.getCell(7);
							        	    		 
							        	    		 while(cell.getStringCellValue().equals("")){
							        	    			
							        	    			 j--;
							        	    			 i++;
							        	    			 
							        	    			 row = sheet.getRow(j);
							        	    			 cell = row.getCell(7);
							        	    			 
							        	    		 }j=j+i;
							        	    		 
							        	    		 piece[j-14]= cell.getStringCellValue();
							        	    		 row = sheet.getRow(j);
						        	    			 cell = row.getCell(9);
						        	    			 table[j-14]=(int) cell.getNumericCellValue();
						        	    			 cell = row.getCell(8);
						        	    			 tableStock[j-14]=(int) cell.getNumericCellValue();
						        	    		
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
						        	    			 
						        	    			 cell = row.getCell(3);
						        	    			 i=0;
							        	    		 while(cell.getStringCellValue().equals("")){
								        	    			
							        	    			 j--;
							        	    			 i++;
							        	    			 
							        	    			 row = sheet.getRow(j);
							        	    			 cell = row.getCell(3);
							        	    			 
							        	    		 }
							        	    		 j=j+i;
							        	    		 tableProjet[j-14]=cell.getStringCellValue();
						        	    			
							        	    		 }
						        	    		
						        	    		}
						        	    		String ss="";
						        	    		int nn=-1;
						        	    		for(int i=14;i<sheet.getLastRowNum();i++) {
						        	    			
						        	    			if(piece[i-14]!=null){
						        	    			
						        	    			if(ss.equals(piece[i-14])){
						        	    				
						        	    				ss=piece[i-14];
						        	    				if(nn>=tableDispo[i-14]) {
						        	    				
						        	    				nn=tableDispo[i-14];
							        	    		
							        	    			show(i);
						        	    				}
						        	    			}
						        	    			else {
						        	    				
						        	    				ss=piece[i-14];
						        	    				nn=tableDispo[i-14];
							        	    		 
							        	    			show(i);
						        	    				}
						        	    			
						        	    		}
						        	    			
						        	    		}
						        	    	
						        	    		for(int j=0;j<100;j++) {
						        	    	
						        	    	if(pieceBesoin[j]!=null && besoin[j]!=0 && tbProjet[j]!=null  ){
						        	    		while(pieceBesoin[j].equals(pieceBesoin[j+1])){
						        	    			if(besoin[j]<besoin[j+1]) besoin[j+1]=besoin[j];
						        	    			j++;
						        	    		}
						        	    		 System.out.println(j);
						        	    		 iniRef();
						        	    		 getCodeArticle(pieceBesoin[j]);
						        	    		paceBoard(pieceBesoin[j],tableMachine[j],pieceBesoin[j]);
						        	    	 System.out.println(pieceBesoin[j]);
						        	    	// System.out.println("b:"+besoin[j]); 
						        	    	//System.out.println("s:" +tbStock[j]);
						        	    	//System.out.println("m: "+tableMachine[j]);

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
								
								pieceBesoin[j]=piece[i-14];
								besoin[j]=table[i-14];
								tableMachine[j]=tableM[i-14];
								tbStock[j]=tableStock[i-14];
								tbProjet[j]=tableProjet[i-14];
								tbDispo[j]=tableDispo[i-14];
								//tbCap[j]=tableCap[i-14];
								j++;
								
							}
							
					/*	public void test(String[] koko){
							System.out.println(des[0]);
							System.out.println(des[1]);
						}*/
					
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
								 
								 System.out.println("erreur");
		        	            	
								 
		    		
		    		    		}	
		    		    
						
							}
							
							
							public  void paceBoard(String piece,String machine,String nom) {
								
									try {
								  		
								  		FileInputStream file = new FileInputStream(new File("C:/Users/Yassin/Desktop/Paceboard hassan.xlsx"));

								        XSSFWorkbook wb = new XSSFWorkbook(file);
								      
								      XSSFSheet sheet = wb.getSheetAt(0);
								    
								
								     Cell cell = sheet.getRow(7).getCell(4);
			        	    			cell.setCellValue(piece);
			        	    			
			        	    			cell = sheet.getRow(3).getCell(27);
			        	    			cell.setCellValue(machine);
							
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
								  
								    		 FileOutputStream outFile =new FileOutputStream(new File("C:/Users/Yassin/Desktop/koko/"+nom+".xlsx"));
								           
								    		 wb.write(outFile);
								    		 outFile.close();

								    } catch (FileNotFoundException e) {
								        e.printStackTrace();
								    } catch (IOException e) {
								        e.printStackTrace();
								    }
								  
										
							    	
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
						public int[][] getCasePos() {
							return casePos;
						}
						public void setCasePos(int casePos[][]) {
							this.casePos = casePos;
						}
						public String[] getTableProjet() {
							return tableProjet;
						}
						public void setTableProjet(String tableProjet[]) {
							this.tableProjet = tableProjet;
						}
						public String[] getTbProjet() {
							return tbProjet;
						}
						public void setTbProjet(String tbProjet[]) {
							this.tbProjet = tbProjet;
						}
						public int[] getPieceSort() {
							return pieceSort;
						}
						public void setPieceSort(int pieceSort[]) {
							this.pieceSort = pieceSort;
						}
						public int[] getTableCap() {
							return tableCap;
						}
						public void setTableCap(int tableCap[]) {
							this.tableCap = tableCap;
						}
						public int[] getTbCap() {
							return tbCap;
						}
						public void setTbCap(int tbCap[]) {
							this.tbCap = tbCap;
						}
						 public int[] getTable() {
								return table;
							}
							public void setTable(int[] table) {
								this.table = table;
							}

							public List<String> getSelectedOptions() {
								return selectedOptions;
							}

							public void setSelectedOptions(List<String> selectedOptions) {
								this.selectedOptions = selectedOptions;
							}
							
							  
						    public int getNbr_eqp() {
								return nbr_eqp;
							}

							public void setNbr_eqp(int nbr_eqp) {
								this.nbr_eqp = nbr_eqp;
							}

							public int getEqp_h() {
								return eqp_h;
							}

							public void setEqp_h(int eqp_h) {
								this.eqp_h = eqp_h;
							}

							public int[] getTableStock() {
								return tableStock;
							}

							public void setTableStock(int tableStock[]) {
								this.tableStock = tableStock;
							}

							public int[] getTbStock() {
								return tbStock;
							}

							public void setTbStock(int tbStock[]) {
								this.tbStock = tbStock;
							}

							public int[] getTableDispo() {
								return tableDispo;
							}

							public void setTabledispo(int tableDispo[]) {
								this.tableDispo = tableDispo;
							}

							public int[] getTbDispo() {
								return tbDispo;
							}

							public void setTbDispo(int tbDispo[]) {
								this.tbDispo = tbDispo;
							}
}


							
							
					
							
						
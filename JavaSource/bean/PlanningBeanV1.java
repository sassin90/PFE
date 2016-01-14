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
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



@RequestScoped
@ManagedBean( name = "planningv1" )
public class PlanningBeanV1 {
	
	private int table[] = new int[100];
	
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
		
		iniMachine();
		
		 tableauPlanification(10,getDate1());

			try {
		  		
		  		FileInputStream file = new FileInputStream(new File("C:/Users/Yassin/Desktop/Tableau Planification.xlsx"));

		        XSSFWorkbook wb = new XSSFWorkbook(file);
		      
		      XSSFSheet sheet = wb.getSheet("test");
		    
		
		      writePlannig(file ,sheet);
	
		  
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
								for(int i=0;i<100;i++){
									table[i]=-1;
								}
							}
						  
						  public void iniMachine(){
								for(int i=0;i<9;i++){
									machine[i]="";
								}
							}
					
					
							public void tableauPlanification(int col,Date dd){
								
						      	try {
						       
						      		FileInputStream file = new FileInputStream(new File("C:/Users/Yassin/Desktop/test4.xlsx")); 
						      		
						        	    XSSFWorkbook workbook = new XSSFWorkbook(file);
						        	
						        	    Sheet sheet = workbook.getSheet("etat du stock");
						        	    
						        	    iniTable();
						        	    
						        	    getInfoEquip();
						        	   		
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
						        	    	
						        	    		file = new FileInputStream(new File("C:/Users/Yassin/Desktop/Tableau Planification.xlsx"));

							    		        XSSFWorkbook wb = new XSSFWorkbook(file);
							    		         
							    		        sheet = wb.getSheet("test");
						        	    		
						        	    		for(int j=0;j<100;j++) {
						        	    	
						        	    	if(pieceBesoin[j]!=null && besoin[j]!=0 && tbProjet[j]!=null  ){
						        	    		while(pieceBesoin[j].equals(pieceBesoin[j+1])){
						        	    			if(besoin[j]<besoin[j+1]) besoin[j+1]=besoin[j];
						        	    			j++;
						        	    		}
						        	    	
						        	    	 p_h[j]=" "+pieceBesoin[j]+" - "+getTime(besoin[j],tbStock[j])+"h";
						        	    	// p_h[j]=" "+pieceBesoin[j];
						        	    	
						        	    	 tablePos[j] = getDatePos(dd,tbProjet[j],getTimeP(getBesoinP(getTime(besoin[j],tbStock[j]))));
						        	    	
						        	    	 pieceSort[j]=getTime(besoin[j],tbStock[j]);
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
						      	 
						      	tbSort();
						      
							 }
							
							public void tbSort(){
								int min=0;
								String minS="";
								for(int i=0;i<100;i++){
									if(tbProjet[i]!=null){
										
									for(int j=0;j<100;j++){
										if(tbProjet[j]!=null){
										if(tbProjet[i].equals("PLS")) {
											
											 minS = tbProjet[i];
											 tbProjet[i]=tbProjet[j];
											 tbProjet[j]=minS;
											
											 min=pieceSort[i];
												pieceSort[i]=pieceSort[j];
												pieceSort[j]=min;
												
												minS=p_h[i];
												p_h[i]=p_h[j];
												p_h[j]=minS;
												
												minS=tableMachine[i];
												tableMachine[i]=tableMachine[j];
												tableMachine[j]=minS;
												
												min=tablePos[i];
												tablePos[i]=tablePos[j];;
												tablePos[j]=min;
												
												min=besoin[i];
												besoin[i]=besoin[j];
												besoin[j]=min;
												
												min =tbStock[i];
												tbStock[i]=tbStock[j];
												tbStock[j]=min;
										}
									}
								}
									}
							}
							
								 min=0;
								 minS="";
								for(int i=0;i<100;i++){
									if(tbProjet[i]!=null  ){
					
										for(int j=0;j<100;j++){
											if(tbProjet[j]!=null  ){
					
                   if(pieceSort[i]<pieceSort[j] && ((tbProjet[i].equals("PLS") && tbProjet[j].equals("PLS")) 
                		   || (!tbProjet[i].equals("PLS") && !tbProjet[j].equals("PLS")))){
                    
                    	  					min = pieceSort[i];
											 pieceSort[i]=pieceSort[j];
											 pieceSort[j]=min;	
											 
											 	minS=p_h[i];
												p_h[i]=p_h[j];
												p_h[j]=minS;
												
												minS=tableMachine[i];
												tableMachine[i]=tableMachine[j];
												tableMachine[j]=minS;
												
												min=tablePos[i];
												tablePos[i]=tablePos[j];;
												tablePos[j]=min;
												
												min=besoin[i];
												besoin[i]=besoin[j];
												besoin[j]=min;
												
												min =tbStock[i];
												tbStock[i]=tbStock[j];
												tbStock[j]=min;
									}
					}
								}
				}
							}
								/*for(int i=0;i<67;i++){
									if(tbDispo[i]!=0){
									
						      		pieceSort[i]=getTime(besoin[i],tbDispo[i],2);
						      		//System.out.println(pieceSort[i]);
						      	}
									}*/
								//Arrays.sort(pieceSort);
								/*for(int i=0;i<100;i++){
									for(int j=0;j<100;j++){
										if(pieceSort[i]<pieceSort[j]) {
											min=pieceSort[i];
											pieceSort[i]=pieceSort[j];
											pieceSort[j]=min;
											
											minS=p_h[i];
											p_h[i]=p_h[j];
											p_h[j]=minS;
											
											minS=tableMachine[i];
											tableMachine[i]=tableMachine[j];
											tableMachine[j]=minS;
											
											min=tablePos[i];
											tablePos[i]=tablePos[j];;
											tablePos[j]=min;
											
											minS=tbProjet[i];
											tbProjet[i]=tbProjet[j];
											tbProjet[j]=minS;
											
											min=besoin[i];
											besoin[i]=besoin[j];
											besoin[j]=min;
											
											min =tbStock[i];
											tbStock[i]=tbStock[j];
											tbStock[j]=min;
										}
									}
								}*/
									/*for(int i=0;i<100;i++){
										if(tbProjet[i]!=null){
									System.out.println(pieceSort[i]);
									System.out.println("m: "+tableMachine[i]);
									System.out.println("p: "+p_h[i]);
									System.out.println("pr: "+tbProjet[i]);
									System.out.println("pos: "+tablePos[i]);
									
									//System.out.println("pos2 :"+getBesoinP(getTime(besoin[i],tbDispo[i])*(-1)));
									//System.out.println("pos1 :"+getTimeP(getBesoinP(getTime(besoin[i],tbDispo[i])*(-1))));
									}
								}*/
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
							
							public void writePlannig(FileInputStream file , Sheet sheet) throws IOException{
							
								Cell cell;
								
		    		    	for(int i=0;i<100;i++){
		    		    		
		    		    		if(tablePos[i]!=0 ){
		    		    			
        	    			switch(tableMachine[i]) {
   	        	         
	        	            case "ENGL 1000":
	        	            	
	        	            	while(casePos[0][tablePos[i]]==1){
	        	            		if(tablePos[i]<3) {
	        	            			if(tbProjet[i].equals("PLS")) tablePos[i]=23;
	        	            			else tablePos[i]=22;
	        	            			}
	        	            		else {
	        	            			if(tbProjet[i].equals("PLS")) tablePos[i]-=3;
	        	            			else tablePos[i]--;
	        	            		}
	        	            	}
	        	            	
	        	            	if(tablePos[i]==(tablePos[i]%3)-1 && !tbProjet[i].equals("PLS")) tablePos[i]--;//hna zidta 
	        	            	cell = sheet.getRow(4).getCell(tablePos[i]);
	        	    			cell.setCellValue(p_h[i]);
	        	    			casePos[0][tablePos[i]]=1;
	        	              break;
	        	              
	        	            case "ENGL 1500":
	        	            	
	        	            	while(casePos[1][tablePos[i]]==1){
	        	            		if(tablePos[i]<3) {
	        	            			if(tbProjet[i].equals("PLS")) tablePos[i]=23;
	        	            			else tablePos[i]=22;
	        	            			}
	        	            		else {
	        	            			if(tbProjet[i].equals("PLS")) tablePos[i]-=3;
	        	            			else tablePos[i]--;
	        	            		}
	        	            	}
	        	            	
	        	            	if(tablePos[i]==(tablePos[i]%3)-1 && !tbProjet[i].equals("PLS")) tablePos[i]--;
	        	            	cell = sheet.getRow(5).getCell(tablePos[i]);
	        	    			cell.setCellValue(p_h[i]);
	        	    			casePos[1][tablePos[i]]=1;
	        	    			
    	        	              break;
    	        	              
								case "ENGL 700":
									
									while(casePos[2][tablePos[i]]==1){
										if(tablePos[i]<3) {
		        	            			if(tbProjet[i].equals("PLS")) tablePos[i]=23;
		        	            			else tablePos[i]=22;
		        	            			}
		        	            		else {
		        	            			if(tbProjet[i].equals("PLS")) tablePos[i]-=3;
		        	            			else tablePos[i]--;
		        	            		}
		        	            	}
									
									if(tablePos[i]==(tablePos[i]%3)-1 && !tbProjet[i].equals("PLS")) tablePos[i]--;
		        	            	cell = sheet.getRow(6).getCell(tablePos[i]);
		        	    			cell.setCellValue(p_h[i]);
		        	    			casePos[2][tablePos[i]]=1;
		        	    			
								break;
													        	        	              
								 case "KM 2000":
									
									 while(casePos[3][tablePos[i]]==1){
											if(tablePos[i]<3) {
			        	            			if(tbProjet[i].equals("PLS")) tablePos[i]=23;
			        	            			else tablePos[i]=22;
			        	            			}
			        	            		else {
			        	            			if(tbProjet[i].equals("PLS")) tablePos[i]-=3;
			        	            			else tablePos[i]--;
			        	            		}
			        	            	}
			        	            	
									 	if(tablePos[i]==(tablePos[i]%3)-1 && !tbProjet[i].equals("PLS")) tablePos[i]--;
									 	cell = sheet.getRow(7).getCell(tablePos[i]);
			        	    			cell.setCellValue(p_h[i]);
			        	    			casePos[3][tablePos[i]]=1;	
								break;
													       
								 case "KM 1000":
									 
									 while(casePos[4][tablePos[i]]==1){
											if(tablePos[i]<3) {
			        	            			if(tbProjet[i].equals("PLS")) tablePos[i]=23;
			        	            			else tablePos[i]=22;
			        	            			}
			        	            		else {
			        	            			if(tbProjet[i].equals("PLS")) tablePos[i]-=3;
			        	            			else tablePos[i]--;
			        	            		}
			        	            	}
			        	            	
									 	if(tablePos[i]==(tablePos[i]%3)-1 && !tbProjet[i].equals("PLS")) tablePos[i]--;
									 	cell = sheet.getRow(8).getCell(tablePos[i]);
			        	    			cell.setCellValue(p_h[i]);
			        	    			casePos[4][tablePos[i]]=1;				     	
								 break;
													       
								 case "ENGL 2000":
									 
									 while(casePos[5][tablePos[i]]==1){
											if(tablePos[i]<3) {
			        	            			if(tbProjet[i].equals("PLS")) tablePos[i]=23;
			        	            			else tablePos[i]=22;
			        	            			}
			        	            		else {
			        	            			if(tbProjet[i].equals("PLS")) tablePos[i]-=3;
			        	            			else tablePos[i]--;
			        	            		}
			        	            	}
			        	            	
									 	if(tablePos[i]==(tablePos[i]%3)-1 && !tbProjet[i].equals("PLS")) tablePos[i]--;
									 	cell = sheet.getRow(9).getCell(tablePos[i]);
			        	    			cell.setCellValue(p_h[i]);
			        	    			casePos[5][tablePos[i]]=1;
			        	    			
								break;
													       
							 case "SAND 1500":
								
								 while(casePos[6][tablePos[i]]==1){
										if(tablePos[i]<3) {
		        	            			if(tbProjet[i].equals("PLS")) tablePos[i]=23;
		        	            			else tablePos[i]=22;
		        	            			}
		        	            		else {
		        	            			if(tbProjet[i].equals("PLS")) tablePos[i]-=3;
		        	            			else tablePos[i]--;
		        	            		}
		        	            	}
								 	if(tablePos[i]==(tablePos[i]%3)-1 && !tbProjet[i].equals("PLS")) tablePos[i]--;
		        	            	cell = sheet.getRow(10).getCell(tablePos[i]);
		        	    			cell.setCellValue(p_h[i]);
		        	    			casePos[6][tablePos[i]]=1;				     	
								 break;
													       
							 case "KM 1300":
								
								 while(casePos[7][tablePos[i]]==1){
										if(tablePos[i]<3) {
		        	            			if(tbProjet[i].equals("PLS")) tablePos[i]=23;
		        	            			else tablePos[i]=22;
		        	            			}
		        	            		else {
		        	            			if(tbProjet[i].equals("PLS")) tablePos[i]-=3;
		        	            			else tablePos[i]--;
		        	            		}
		        	            	}
								 
								 if(tablePos[i]==(tablePos[i]%3)-1 && !tbProjet[i].equals("PLS")) tablePos[i]--;
		        	            	cell = sheet.getRow(11).getCell(tablePos[i]);
		        	    			cell.setCellValue(p_h[i]);
		        	    			casePos[7][tablePos[i]]=1;
													     	
								 break;
						 
							 case "KM 800":
								
								 while(casePos[8][tablePos[i]]==1){
										if(tablePos[i]<3) {
		        	            			if(tbProjet[i].equals("PLS")) tablePos[i]=23;
		        	            			else tablePos[i]=22;
		        	            			}
		        	            		else {
		        	            			if(tbProjet[i].equals("PLS")) tablePos[i]-=3;
		        	            			else tablePos[i]--;
		        	            		}
		        	            	}
								 if(tablePos[i]==(tablePos[i]%3)-1 && !tbProjet[i].equals("PLS")) tablePos[i]--;
		        	            	
								 	cell = sheet.getRow(12).getCell(tablePos[i]);
		        	    			cell.setCellValue(p_h[i]);
		        	    			casePos[8][tablePos[i]]=1;	
		        	    			
								 break;
	        	          
							 default:
								 System.out.println("erreur");
		        	            	
								 
		    		}
		    		    		}	
		    		    	}
        	            
	
						file.close();
							}
					
							
							public int getDatePos(Date dd,String projet,int time){
								
								SimpleDateFormat formater = new SimpleDateFormat("EEEE",Locale.FRANCE);
								
								int posDate;
							
								 switch(formater.format(dd)) {
        	         
								 case "vendredi":
        	            	if(projet.equals("PLS")) posDate= 23;
        	            	else {
								 
								  posDate = 4-time;
									 }
									
									 break;
        	              
								 case "samedi":
									 
									 if(projet.equals("PLS")) posDate= 5;
									 else {
										
										 posDate = 7-time;
											 }
									 
									 break;
									 
								 case "dimanche":
									 
									 if(projet.equals("PLS")) posDate= 8;
									 else {
										
									 posDate = 10-time;
											 }
			        	            	
									 break;
									 
								 case "lundi":
									 
									 if(projet.equals("PLS")) posDate= 11;
									 else {
									
										 posDate = 13-time;
											 }
			        	            	
									 break;
									 
								 case "mardi":
									 
									 if(projet.equals("PLS")) posDate= 14;
									 else {
									
										 posDate = 16-time;
											 }
			        	            	
									 break;
									 
								 case "mercredi":
									 
									 if(projet.equals("PLS")) posDate= 17;
									 else {
							
										  posDate = 19-time;
											 }
									 
									 break;
									 
								 case "jeudi":
									 
									 if(projet.equals("PLS")) posDate= 20;
									 else {
									
										 posDate = 22-time;
											 }
			        	            	
									 break;

						default:
							
							posDate= -1;
								 }
								return posDate;
								
							}
							
							public int getBesoinP(int dispo){
							
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
								
								if(time>6 && time <=14) return 1;
								else if(time>14 && time <=22) return 0;
								else return 2;
							}
							
							public int getTime(int nbrB,int nbrS){// ta9sim 0 besoin et stock s8ir mn 1
								if(nbrB<(eqp_h*8)) return nbrS;
								else{
								if((nbrS/(nbrB/(eqp_h*8)))<1) return 1;
								
								else return nbrS/(nbrB/(eqp_h*8));	}
							}
							
							public void getInfoEquip(){
									
									switch(selectedOptions.toString()){
									
									case "[Option 1]": 
										
										nbr_eqp=2;
										eqp_h=1;
										
										break;		
									case "[Option 2]": 
										
										nbr_eqp=3;
										eqp_h=1;
										
										break;
									case "[Option 3]": 
										
										nbr_eqp=4;
										eqp_h=1;
										
										break;
									case "[Option 1, Option 2]": 
										
										nbr_eqp=5;
										eqp_h=2;
										
										break;
									case "[Option 1, Option 3]": 
										
										nbr_eqp=6;
										eqp_h=2;
										
										break;
									case "[Option 2, Option 3]": 
									
										nbr_eqp=7;
										eqp_h=2;
										
										break;
									case "[Option 1, Option 2, Option 3]": 
										
										nbr_eqp=9;
										eqp_h=3;
										
										break;
									default:
										
										System.out.println("Erreur");
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


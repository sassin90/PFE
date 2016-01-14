package bean;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


import javax.servlet.ServletContext;

import org.primefaces.model.DefaultStreamedContent;





import model.Fichiers;

@ManagedBean(name = "testBean")
@ViewScoped
public class tableBean {
    
	private List<Fichiers> files;
	private List<Fichiers> filteredfiles;
    private Fichiers selectedFile;
    private DefaultStreamedContent download;

    public tableBean() throws IOException  {
    	///
    	// Path jdkPath = Paths.get("D:/Projets");
    	ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();  
	    String newFileName = servletContext.getRealPath("") + File.separator + "Methode" + File.separator + "Dossier"+ File.separator +"ATD";
	   // Path jdkPath = Paths.get(newFileName);
	    
		 // DirectoryStream<Path> stream = Files.newDirectoryStream(jdkPath);
		  files = new ArrayList<Fichiers>();
		  //SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		 // final File folder = new File(newFileName);
		 // getInfo(folder);*/
		  
	  
		 
		 /*  for (final File fileEntry : folder.listFiles()) {
		        if (fileEntry.isDirectory()) {
		           // getInfo(fileEntry);
		        } else {
		        	files.add(new Fichiers(i, fileEntry.getName(), fileEntry.getParentFile().getName(), sdf.format(fileEntry.lastModified()),fileEntry.getAbsolutePath()));
		            System.out.println(fileEntry.getAbsolutePath());
		            i++;
		        }
		    }*/
		  final File folder = new File(newFileName);
		  getInfo(folder);
		  
    	///
       /* cars = new ArrayList<Car>();
        cars.add(new Car("Test", 2013, "Toyo", "Blue"));
        cars.add(new Car("Test1", 2013, "Toyo", "Red"));*/
        
   }
    
    public void prepDownload() throws Exception {
	    File file = new File(selectedFile.getUrl().toString());
	    InputStream input = new FileInputStream(file);
	    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	    setDownload(new DefaultStreamedContent(input, externalContext.getMimeType(file.getName()), file.getName()));
	   
	}  
    
    public void getInfo(final File folder) throws IOException{
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
    	
    	for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            getInfo(fileEntry);
	        } else {
	        	files.add(new Fichiers(fileEntry.getName(), fileEntry.getParentFile().getName(), sdf.format(fileEntry.lastModified()), fileEntry.getAbsolutePath()));
	 		      
	        }
	    }
    	
    	/*SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy"); 
    	int i=1;
    	
    	 try { 
 		    Iterator<Path> iterator = stream.iterator();
 		    while(iterator.hasNext()) {
 		      
 		      Path p = iterator.next();
 		      if(p.toFile().isDirectory()) getInfo(stream);
 		      else{ files.add(new Fichiers(i, p.getFileName(), p.toFile().getParentFile().getName(), sdf.format(p.toFile().lastModified()), p));
 		      i++;}
 		    }
 		  } finally { 
 		    stream.close(); 
 		  }*/
}
      
    
   
    public void showw() throws IOException {
    	 
    	 String[] command = {"cmd", "/c", selectedFile.getUrl().toString()};
    	    Runtime.getRuntime().exec(command);
    	    
    	   /* ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();  
    	    String newFileName = servletContext.getRealPath("") + File.separator + "photocam" + File.separator + "koko.png";
    	    System.out.println(newFileName);*/
    }
    
    public void setDownload(DefaultStreamedContent download) {
	    this.download = download;
	}

	public DefaultStreamedContent getDownload() {  
	    return download;
	}

    public List<Fichiers> getFiles() {
        return files;
    }

    public void setFiles(List<Fichiers> files) {
        this.files = files;
    }

	public Fichiers getSelectedFile() {
		return selectedFile;
	}

	public void setSelectedFile(Fichiers selectedFile) {
		this.selectedFile = selectedFile;
	}

	public List<Fichiers> getFilteredfiles() {
		return filteredfiles;
	}

	public void setFilteredfiles(List<Fichiers> filteredfiles) {
		this.filteredfiles = filteredfiles;
	}
}
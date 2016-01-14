package bean;

/*import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
 
@ManagedBean(name="fileUploadController")
public class UploaderBB {
  // private String destination="D:\\tmp\\";
   private String destination="";
   private UploadedFile file;
   /* public void upload() {  
        FacesMessage msg = new FacesMessage("Success! ", file.getFileName() + " is uploaded.");  
        FacesContext.getCurrentInstance().addMessage(null, msg);
        // copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
		System.out.println(destination + file.getFileName());

    }  */
  /* public void upload() {  
       if(file != null) {  
          
           System.out.println(file.getFileName());
       }  
   }

    public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public void copyFile(String fileName, InputStream in) {
        
             
                FileUploadEvent event = null;
              //  upload(event);
				System.out.println(destination + event.getFile().getFileName());
                
    }
}*/



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.apache.commons.io.FilenameUtils;
import org.primefaces.event.FileUploadEvent;
 
@ManagedBean(name="fileUploadController")
public class UploaderBB {
	

    
    private String destination="D:\\temp\\";
	//private String destination="";

    public void upload(FileUploadEvent event) {  
        FacesMessage msg = new FacesMessage("Success! ", event.getFile().getFileName() + " is uploaded.");  
        FacesContext.getCurrentInstance().addMessage(null, msg);
        // Do what you want with the file 
        System.out.println(FilenameUtils.getName(event.getFile().getFileName()));
        try {
            copyFile(FilenameUtils.getName(event.getFile().getFileName()), event.getFile().getInputstream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }  

    public void copyFile(String fileName, InputStream in) {
           try {
             
             
                // write the inputStream to a FileOutputStream
                OutputStream out = new FileOutputStream(new File(destination + fileName));
            
                int read = 0;
                byte[] bytes = new byte[1024];
             
                while ((read = in.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
             
                in.close();
                out.flush();
                out.close();
             
                System.out.println("New file created!");
                } catch (IOException e) {
                System.out.println(e.getMessage());
                }
    }
}
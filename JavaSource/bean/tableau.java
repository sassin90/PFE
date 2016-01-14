package bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultStreamedContent;

@RequestScoped
@ManagedBean( name = "tableau" )
public class tableau {

	private DefaultStreamedContent download;
	
	public void setDownload(DefaultStreamedContent download) {
	    this.download = download;
	}

	public DefaultStreamedContent getDownload() throws Exception {
	    System.out.println("GET = " + download.getName());
	    return download;
	}

	public void prepDownload() throws Exception {
	    File file = new File("D:\\Projets\\Excel new.xlsx");
	    InputStream input = new FileInputStream(file);
	    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	    setDownload(new DefaultStreamedContent(input, externalContext.getMimeType(file.getName()), file.getName()));
	    System.out.println("PREP = " + download.getName());
	}}

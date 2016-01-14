package bean;

import java.io.Serializable;  
import java.util.HashMap;  
import java.util.List;  
import java.util.Map;  

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
  
@SessionScoped
@ManagedBean( name = "test" )
public class testFichiers implements Serializable {  
  
    private List<String> selectedMovies;  
  
    private List<String> selectedOptions;  
      
    private String[] selectedOptions2;  
  
    private Map<String,String> movies;  
  
    public testFichiers() {  
        movies = new HashMap<String, String>();  
        movies.put("Scarface", "Scarface");  
        movies.put("Goodfellas", "Goodfellas");  
        movies.put("Godfather", "Godfather");  
        movies.put("Carlito's Way", "Carlito's Way");  
        movies.put("The Lord of the Rings", "The Lord of the Rings");  
        movies.put("The Avengers", "The Avengers");  
    }  
  
    public List<String> getSelectedMovies() {  
        return selectedMovies;  
    }  
    public void setSelectedMovies(List<String> selectedMovies) {  
        this.selectedMovies = selectedMovies;  
    }  
  
    public List<String> getSelectedOptions() {  
        return selectedOptions;  
    }  
    public void setSelectedOptions(List<String> selectedOptions) {  
        this.selectedOptions = selectedOptions;  
    }  
  
    public String[] getSelectedOptions2() {  
        return selectedOptions2;  
    }  
    public void setSelectedOptions2(String[] selectedOptions2) {  
        this.selectedOptions2 = selectedOptions2;  
    }  
  
    public Map<String, String> getMovies() {  
        return movies;  
    }  
    public void displayLocation() {  
       
  System.out.println(selectedOptions2.toString());
         
    }
}
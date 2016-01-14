package util;  
  
 
import java.util.List;  

import javax.faces.application.FacesMessage;  
  
import javax.faces.component.UIComponent;  
import javax.faces.context.FacesContext;  
import javax.faces.convert.Converter;  
import javax.faces.convert.ConverterException;  
import javax.faces.convert.FacesConverter;


import model.Piece;
  
@FacesConverter(value="pieceConverter", forClass=Piece.class) 
public class PieceConverter implements Converter {

	public static List<Piece> piece;
	
	
	
	
	@Override
	 public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {  
	        if (submittedValue.trim().equals("")) {  
	            return null;  
	        } else {  
	            try {  
	                int number = Integer.parseInt(submittedValue);  
	  
	                for (Piece p : piece) {  
	                    if (p.getId() == number) {  
	                        return p;  
	                    }  
	                }  
	                  
	            } catch(NumberFormatException exception) {  
	                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid player"));  
	            }  
	        }  
	  
	        return null;  
	    }  
	@Override
	    public String getAsString(FacesContext facesContext, UIComponent component, Object value) {  
	        if (value == null || value.equals("")) {  
	            return "";  
	        } else {  
	            return String.valueOf(((Piece) value).getId());  
	        }  
	    }    
  
  
    
  
    
}  
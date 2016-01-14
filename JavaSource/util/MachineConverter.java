package util;  
  
 
import java.util.List;  

import javax.faces.application.FacesMessage;  
  
import javax.faces.component.UIComponent;  
import javax.faces.context.FacesContext;  
import javax.faces.convert.Converter;  
import javax.faces.convert.ConverterException;  
import javax.faces.convert.FacesConverter;

import model.Machine;
  
@FacesConverter(value="machineConverter", forClass=Machine.class) 
public class MachineConverter implements Converter {

	public static List<Machine> machine2;
	
	
	
	
	@Override
	 public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {  
	        if (submittedValue.trim().equals("")) {  
	            return null;  
	        } else {  
	            try {  
	                int number = Integer.parseInt(submittedValue);  
	  
	                for (Machine p : machine2) {  
	                    if (p.getId() == number) {  
	                        return p;  
	                    }  
	                }  
	                  
	            } catch(NumberFormatException exception) {  
	                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid machine"));  
	            }  
	        }  
	  
	        return null;  
	    }  
	@Override
	    public String getAsString(FacesContext facesContext, UIComponent component, Object value) {  
	        if (value == null || value.equals("")) {  
	            return "";  
	        } else {  
	            return String.valueOf(((Machine) value).getId());  
	        }  
	    }    
  
  
    
  
    
}  
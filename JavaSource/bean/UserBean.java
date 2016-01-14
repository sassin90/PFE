package bean;


import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;

import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

import dao.UserDAO;
import dao.MachineDAO;
import model.User;
import model.Machine;

@SessionScoped
@ManagedBean( name = "userBean" )
public class UserBean implements Serializable {

    private static final long  serialVersionUID = 1L;
    private List<User>         users;
	private String             ancienPassword;
    private String             nvPassword;
    public String getAncienPassword() {
		return ancienPassword;
	}

	public void setAncienPassword(String ancienPassword) {
		this.ancienPassword = ancienPassword;
	}

	public String getNvPassword() {
		return nvPassword;
	}

	public void setNvPassword(String nvPassword) {
		this.nvPassword = nvPassword;
	}


	private List<Machine> machine2;
	public static final String INJECTION_NAME   = "#{userBean}";


    @EJB( name = "UserDAO" )
    private UserDAO            userDAO;
    @EJB( name = "MachineDAO" )
    private MachineDAO            machineDAO;
    private User selectedUser;
    private List<User> filteredUser;
    private List<User> selectedUsers;
    private User newUser = new User();
    
    private User user; 
 

	public User getNewUser() {
		return newUser;
	}
	
	  public User isValidLogin( String username, String password ) {

	    	
	        User user = userDAO.findUserByEmail( username );

	        if ( user == null || !user.getPassword().equals( password ) ) {
	            return null;
	        }

	        return user;
	    }

	public void setNewUser(User newUser) {
		this.newUser = newUser;
	}

	public UserBean() {

    }
    
    @SuppressWarnings("unchecked")
	@PostConstruct
    public void init() {
        userDAO.beginTransaction();
        users = userDAO.findWithNamedQuery( "User.populateUsers" );
        
    }
    
  
    // sup 
    @SuppressWarnings("unchecked")
	public void doDeleteUsers(ActionEvent actionEvent) {
    	

        userDAO.deleteItems( selectedUsers );
        users = userDAO.findWithNamedQuery( "User.populateUsers" );
        
        

    }
    
    
    
    
    
    @SuppressWarnings("unchecked")
	public void createUser()
    {
    	//System.out.println("Ville : " + newUser.getMachine());
    	RequestContext context = RequestContext.getCurrentInstance();  
        FacesMessage msg = null;  
        boolean userCreated = false; 
       // System.out.println("test : "+newUser.getUsername());
        User user = userDAO.findUserByUsername(newUser.getEmail());
      
        
        if(user == null) {  
        	userCreated = true;  
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Utilisateur créé avec succès", null); 
            userDAO.create(newUser);
            users = userDAO.findWithNamedQuery("User.populateUsers");
            
            
        } else {  
        	userCreated = false;  
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Username déjà existe", null);  
        }  
          
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("userCreated", userCreated);  
        
        newUser = new User();
            
        
    }
    
    @SuppressWarnings("unchecked")
	public List<Machine> complete2 () {  
        machine2 = machineDAO.findWithNamedQuery("Machine.populateMachine");
         
        return machine2;  
    }  
      
    
    public void onEdit(RowEditEvent event) { 
    	FacesMessage msg = null;
    	User aux = (User) event.getObject();
    	User user = userDAO.findUserByEU( aux.getEmail(), aux.getId() );

    	if ( user == null ) {
    		userDAO.update(aux);
    		msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Utilisateur modifié avec succès", null);
            FacesContext.getCurrentInstance().addMessage(null, msg); 
    	 }
    	else
    	{
    		 msg = new FacesMessage( FacesMessage.SEVERITY_ERROR, "Email existe déjà.",
                     null );
             FacesContext.getCurrentInstance().addMessage( null, msg );
            
    	}
    	 
    }  
      
    public void onCancel(RowEditEvent event) {  
      
    }  
    
    
    
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	   public User getSelectedUser() {
			return selectedUser;
		}

		public void setSelectedUser(User selectedUser) {
			this.selectedUser = selectedUser;
		}

		public List<User> getFilteredUser() {
			return filteredUser;
		}

		public List<User> getSelectedUsers() {
			return selectedUsers;
		}

		public void setSelectedUsers(List<User> selectedUsers) {
			this.selectedUsers = selectedUsers;
		}

		public void setFilteredUser(List<User> filteredUser) {
			this.filteredUser = filteredUser;
		}

		public List<Machine> getMachine2() {
			return machine2;
		}

		public void setMachine2(List<Machine> machine2) {
			this.machine2 = machine2;
		}

		public MachineDAO getMachineDAO() {
			return machineDAO;
		}

		public void setMachineDAO(MachineDAO machineDAO) {
			this.machineDAO = machineDAO;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		} 
		 
		 
		public void doUpdateUserParams( ActionEvent actionEvent ) {
	        FacesMessage msg = null;

	        User user2 = userDAO.findUserByEmail( user.getEmail());

	        if ( ancienPassword.isEmpty() )
	        {
	            msg = new FacesMessage( FacesMessage.SEVERITY_INFO, "Modification effectuée avec succés !", null );
	            FacesContext.getCurrentInstance().addMessage( "form:success", msg );
	            userDAO.update( user );
	        }
	        else if ( ( (String) user2.getPassword() ).equals( ancienPassword ) )
	        {
	            if ( nvPassword.isEmpty() )
	            {
	                msg = new FacesMessage( FacesMessage.SEVERITY_ERROR, "Veuillez saisir un mot de passe.",
	                        null );
	                FacesContext.getCurrentInstance().addMessage( "form:nvpassword", msg );
	                return;

	            }
	            else if ( nvPassword.length() < 6 )
	            {
	                msg = new FacesMessage( FacesMessage.SEVERITY_ERROR,
	                        "Le mot de passe doit contenir au moins 6 caractères.",
	                        null );
	                FacesContext.getCurrentInstance().addMessage( "form:nvpassword", msg );
	                return;
	            }

	            msg = new FacesMessage( FacesMessage.SEVERITY_INFO, "Modification effectuée avec succés !", null );
	            FacesContext.getCurrentInstance().addMessage( "form:success", msg );

	           getUser().setPassword( nvPassword );
	            userDAO.update(getUser() );
	            nvPassword = "";
	            ancienPassword = "";

	        }
	        else
	        {
	            msg = new FacesMessage( FacesMessage.SEVERITY_ERROR, "Mot de passe incorrect.",
	                    null );
	            FacesContext.getCurrentInstance().addMessage( "form:password", msg );
	        }
	    }

		 

    

}
package cast.cruise.ui.user;

import cast.cruise.contacts.Address;
import cast.cruise.contacts.CardElements;
import cast.cruise.datastore.UserDS;
import cast.cruise.domain.User;
import cast.cruise.memory.UserMemory;


public class NewUserPresenter {
	private NewUserView view;
    private User user = new User();
    private UserDS userds;
    private boolean idCommon;
    
    public NewUserPresenter(NewUserView view) {
        this.view = view;
        userds = new UserMemory();
    }


    public void setUser(User user) {
        this.user = user;
      
    }
    
    public boolean IdCommon(){
    	return idCommon;
    }


    public User getUser() {
        return user;
    }
    
    public void start() {
        view.setPresenter(this);        
        view.open();
        
    }
    
    
  
    
    public void save() {
    	int id = view.getUserId();
    	User u = new User();
    	u = userds.find(id);
    	if(u==null){
    		idCommon = false;
    		user.setUserId(id);
    		user.setLastName(view.getLastName());
    		user.setFirstName(view.getFirstName());
    		Address a = view.getAddress();
    		
    		if(a!=null){
    			user.setAddress(a);
    			user.setEmail(view.getEmail());
    			user.setPassword(view.getPassword());
    			CardElements c = view.getCard();
    			
    			if(c!=null){
    				user.setCard(c);
    				user.setTelephone(view.getTelephone());
    				idCommon = false;
    				userds.save(user);
    				view.close();
    			}
    			else{
    				idCommon = true;
        			view.showError("Invalid card.You must insert number,expire date,name,CV");
    			}
    		}
    		else{
    			idCommon = true;
    			view.showError("Invalid address.You must insert street,number,city,Zip code,country");
    		}
    	}
    	
    	else{
    		idCommon = true;
    		view.showError("User id must be unique!");
    	}
    	
    }
    
    public void cancel() {
        view.close();
    }
    
   

}

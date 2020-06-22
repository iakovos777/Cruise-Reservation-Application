package cast.cruise.ui.user;

import cast.cruise.datastore.UserDS;
import cast.cruise.domain.User;
import cast.cruise.memory.UserMemory;


public class UserLoginPresenter {
	private UserLoginView view;
    private boolean userExist;
    private User user;
    private UserDS userds;
    
   
    public UserLoginPresenter(UserLoginView view) {
        this.view = view;
        userds = new UserMemory();
    }
    
   
    public boolean isUserExist() {
        return userExist;
    }
    
    
    public User getUser() {
        return user;
    }
    
   
    public void start() {
        view.setPresenter(this);
        view.open();       
    }
    
    
    public void cancel() {
        view.close();
    }
    
   
    public void verifyUser() {
       user = userds.Login(view.getEmail(), view.getPassword());
        
        if (user==null) {
            userExist = false;
            view.showError("User not found");
        } else {
        	userExist = true;
            view.showInfo("Successful login");
        }
           
    } 
    
   
}

package cast.cruise.ui.user;

import cast.cruise.contacts.EmailAddress;
import cast.cruise.ui.View;


public interface UserLoginView extends View {
	
	void setPresenter(UserLoginPresenter presenter);
    
    
    String getPassword();
   EmailAddress getEmail();

}

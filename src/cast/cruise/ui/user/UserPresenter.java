package cast.cruise.ui.user;

import cast.cruise.domain.User;

public class UserPresenter {
	private UserView view;
    private User user = new User();
    
    public UserPresenter(UserView view) {
        this.view = view;
        
    }
    
    public void start() {
        view.setPresenter(this);
        view.open();
    }

	public void setUser(User user) {
		this.user=user;
		
	}
	public User getUser(){
		return user;
	}
}

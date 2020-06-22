package cast.cruise.ui;



import cast.cruise.contacts.EmailAddress;

import cast.cruise.ui.user.UserLoginPresenter;
import cast.cruise.ui.user.UserLoginView;

public class UserLoginViewStub extends ViewStub implements UserLoginView  {

	

	private UserLoginPresenter presenter;
	private String pwd;
	private EmailAddress email;
	

	@Override
	public void setPresenter(UserLoginPresenter presenter) {
		this.presenter = presenter;
		
	}
	
	public UserLoginPresenter getPresenter(){
		return presenter;
	}

	@Override
	public String getPassword() {
		
		return pwd;
	}
	
	public void setPassword(String pwd){
		this.pwd = pwd;
	}

	@Override
	public EmailAddress getEmail() {
		
		return email;
	}
	
	public void setEmail(EmailAddress email){
		this.email = email;
	}

}

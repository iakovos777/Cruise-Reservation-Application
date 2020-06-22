package cast.cruise.ui;


import cast.cruise.ui.user.UserPresenter;
import cast.cruise.ui.user.UserView;

public class UserViewStub extends ViewStub implements UserView {
	private UserPresenter presenter;
	

	@Override
	public void setPresenter(UserPresenter presenter) {
		this.presenter = presenter;
		
	}
	
	public UserPresenter getPresenter(){
		return presenter;
	}

}

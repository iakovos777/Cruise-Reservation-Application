package cast.cruise.ui;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cast.cruise.contacts.EmailAddress;
import cast.cruise.datastore.Data;
import cast.cruise.memory.DataMemory;

import cast.cruise.ui.user.UserLoginPresenter;

public class UserLoginPresenterTest {

	private Data dataHelper;
    private UserLoginPresenter presenter;
    private UserLoginViewStub loginView;
    
    @Before
    public void setUp() {
        dataHelper = new DataMemory();
        dataHelper.readData();        
        loginView = new UserLoginViewStub();
        presenter = new UserLoginPresenter(loginView);
    }

    
    
    
    
    @Test
    public void wiring() {  
        presenter.start();
        Assert.assertTrue(loginView.isOpened());
        Assert.assertSame(presenter, loginView.getPresenter());
        Assert.assertFalse(presenter.isUserExist());
       
    }
    
    
    @Test
    public void cancel() {
        presenter.start();
        presenter.cancel();
        Assert.assertFalse(loginView.isOpened());
    }
    
    
    
    @Test
    public void verifyHostExist() {
    	loginView.setPassword("123");
    	EmailAddress email = new EmailAddress("p123@gmail.com");
    	loginView.setEmail(email);
        presenter.start();
        presenter.verifyUser();
        Assert.assertTrue(presenter.isUserExist());
        
       
        Assert.assertTrue(loginView.getInfoCount() > 0);
    }
    
    
    @Test
    public void hostDoesNotExist() {
    	loginView.setPassword("232555444");
    	EmailAddress email = new EmailAddress("p1ijj@gmail.com");
    	loginView.setEmail(email);
        presenter.start();
        presenter.verifyUser();
        Assert.assertFalse(presenter.isUserExist());
       
        Assert.assertTrue(loginView.getErrorCount() > 0);
    }

}

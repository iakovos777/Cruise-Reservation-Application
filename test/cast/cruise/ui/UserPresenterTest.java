package cast.cruise.ui;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import cast.cruise.ui.user.UserPresenter;

public class UserPresenterTest {

	
    private UserPresenter presenter;
    private UserViewStub userView;
    
    @Before
    public void setUp() {
        
               
        userView = new UserViewStub();
        presenter = new UserPresenter(userView);
    }

    
    
    
    
    @Test
    public void wiring() {  
        presenter.start();
        Assert.assertTrue(userView.isOpened());
        Assert.assertSame(presenter, userView.getPresenter());
      
       
    }
    
    
   

}

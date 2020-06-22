package cast.cruise.ui;




import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cast.cruise.datastore.Data;
import cast.cruise.memory.DataMemory;
import cast.cruise.ui.host.HostLoginPresenter;




public class HostLoginPresenterTest {

	private Data dataHelper;
    private HostLoginPresenter presenter;
    private HostLoginViewStub loginView;
    
    @Before
    public void setUp() {
        dataHelper = new DataMemory();
        dataHelper.readData();        
        loginView = new HostLoginViewStub();
        presenter = new HostLoginPresenter(loginView);
    }

    
    
    
    
    @Test
    public void wiring() {  
        presenter.start();
        Assert.assertTrue(loginView.isOpened());
        Assert.assertSame(presenter, loginView.getPresenter());
        Assert.assertFalse(presenter.ishostExist());
       
    }
    
    
    @Test
    public void cancel() {
        presenter.start();
        presenter.cancel();
        Assert.assertFalse(loginView.isOpened());
    }
    
    
    
    @Test
    public void verifyHostExist() {
    	loginView.setPwd("1");
    	loginView.setCompanyName("Blue star");
        presenter.start();
        Assert.assertTrue(presenter.verifyHost());
        Assert.assertTrue(presenter.ishostExist());
       
        Assert.assertTrue(loginView.getInfoCount() > 0);
    }
    
    
    @Test
    public void hostDoesNotExist() {
    	loginView.setPwd("14343");
    	loginView.setCompanyName("Blue star");
        presenter.start();
        Assert.assertFalse(presenter.verifyHost());
        Assert.assertFalse(presenter.ishostExist());
       
        Assert.assertTrue(loginView.getErrorCount() > 0);
    }
    

    

    
    
    
    
   

}

package cast.cruise.ui;



import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import cast.cruise.datastore.Data;

import cast.cruise.memory.DataMemory;

import cast.cruise.ui.cruise.CruiseListPresenter;


public class CruiseListPresenterTest {

	private Data dataHelper;
    private CruiseListPresenter presenter;
    private CruiseListViewStub cruiseListView;
    private CruiseViewStub cruiseViewStub;
    
    @Before
    public void setUp() {
        dataHelper = new DataMemory();
        dataHelper.readData();        
        
        cruiseListView = new CruiseListViewStub();
        cruiseViewStub = new CruiseViewStub();
        
        ViewRegistry.setCruiseView(cruiseViewStub);
        
        presenter = new CruiseListPresenter(cruiseListView);
        
        cruiseListView.setPresenter(presenter);
        cruiseListView.open();
    }
    
    @After
    public void tearDown() {
        ViewRegistry.resetForHost();
    }
    
    
	@Test
    public void wiring() {
        presenter.start();
        Assert.assertTrue(cruiseListView.isOpened());	       
        Assert.assertEquals(2, presenter.getCruises().size());
       
    }
    
	
         
    

}

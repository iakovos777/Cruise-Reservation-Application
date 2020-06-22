package cast.cruise.ui;




import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import cast.cruise.datastore.CruiseDS;
import cast.cruise.datastore.Data;

import cast.cruise.datastore.ReservationDS;
import cast.cruise.datastore.UserDS;
import cast.cruise.domain.Cruise;

import cast.cruise.domain.User;
import cast.cruise.memory.CruiseMemory;
import cast.cruise.memory.DataMemory;

import cast.cruise.memory.ReservationMemory;
import cast.cruise.memory.UserMemory;
import cast.cruise.ui.user.CruiseListUserPresenter;


public class CruiseListUserPresenterTest {
	 	private Data dataHelper;
	    private CruiseListUserPresenter presenter;
	    private CruiseListUserViewStub cruiseListView;
	    private Cruise cruise;
	    private User user = new User();
	    
	    
	    @Before
	    public void setUp() {
	        dataHelper = new DataMemory();
	        dataHelper.readData();        
	        
	       
	        cruiseListView = new CruiseListUserViewStub();      
	        presenter = new CruiseListUserPresenter(cruiseListView);
	        
	        cruiseListView.setPresenter(presenter);
	        cruiseListView.open();
	        
	    }
	    
	   
	    
	    @Test
	    public void wiring() {
	        presenter.start();
	        Assert.assertTrue(cruiseListView.isOpened());
	        Assert.assertSame(cruiseListView.getPresenter(), presenter);
	        
	        Assert.assertEquals(2, presenter.getCruises().size());
	        Assert.assertEquals(2, cruiseListView.getCruises().size());
	        
	    }
	    
	    
	    
	    @Test
	    public void cancel() {
	        presenter.start();
	        presenter.cancel();
	        Assert.assertFalse(cruiseListView.isOpened());
	    }
	    
	    @Test
	    public void setPositionsWhenFieldIsNull() {
	    	cruiseListView.setPositions(0);
	        presenter.start();
	        
	        Assert.assertEquals(0, cruiseListView.getPositions());
	       
	       
	    }
	    
	    @Test
	    public void setPositionsWhenFieldIsNotNull() {
	    	cruiseListView.setPositions(3);
	        presenter.start();
	       
	        Assert.assertEquals(3, cruiseListView.getPositions());
	        Assert.assertFalse(0== cruiseListView.getPositions() );
	        
	    }
	    
	    @Test
	    public void userExists(){
	    	
	    	
	    	presenter.setUser(user);
	    	User user = presenter.getUser();
	    	Assert.assertNotSame(null, presenter.getUser() );
	    	Assert.assertNotSame(null, user );
	    }
	    
	    @Test
	    public void userNotExists(){
	    	
	    	presenter.setUser(null);
	    	User user = presenter.getUser();
	    	Assert.assertSame(null, presenter.getUser() );
	    	Assert.assertSame(null, user );
	    }
	    
	    @Test
	    public void performReservation(){
	    	ReservationDS resds = new ReservationMemory();
	    	int i = resds.findAll().size();
		    cruise =  new Cruise();
		    CruiseDS crds =  new CruiseMemory();
		    cruise = crds.find(1);
	    	cruiseListView.setPositions(3);
	    	cruiseListView.setSelectedCruise(cruise);
	    	Assert.assertNotSame(null, cruiseListView.getSelectedCruise() );
	    	Assert.assertSame(cruise, cruiseListView.getSelectedCruise() );
	        presenter.start();
	        UserDS usrds = new UserMemory();
	        user = usrds.find(2);
	    	presenter.setUser(user);
	    	Assert.assertNotSame(null, presenter.getUser() );        
	    	Assert.assertSame(user, presenter.getUser() );       	        
	        
	    	Assert.assertTrue(presenter.reservation());
	        
	        Assert.assertEquals(i+1, resds.findAll().size());
	        
	        Assert.assertEquals(1, cruiseListView.getSelectedCruise().getReserve().size());
	        Assert.assertEquals(1, presenter.getUser().getReserve().size());
	        Assert.assertTrue(cruiseListView.getInfoCount()>0 );
	        Assert.assertEquals(0,cruiseListView.getErrorCount() );
	    } 
	    @Test
	    public void invalidReservation(){
	    	ReservationDS resds = new ReservationMemory();
	    	int i = resds.findAll().size();
		    cruise =  new Cruise();
		    CruiseDS crds =  new CruiseMemory();
		    cruise = crds.find(1);
	    	cruiseListView.setPositions(0);
	    	
	    	cruiseListView.setSelectedCruise(null);
	    	Assert.assertSame(null, cruiseListView.getSelectedCruise() );
	    	Assert.assertNotSame(cruise, cruiseListView.getSelectedCruise() );
	       UserDS usrds = new UserMemory();
	        user = usrds.find(2);
	    	presenter.start();
	       	presenter.setUser(user);
	    	Assert.assertNotSame(null, presenter.getUser() );        
	    	Assert.assertSame(user, presenter.getUser() );       	        
	        
	    	Assert.assertFalse(presenter.reservation());
	        
	        Assert.assertEquals(i, resds.findAll().size());
	        
	       
	        Assert.assertEquals(0, presenter.getUser().getReserve().size());
	        Assert.assertTrue(cruiseListView.getErrorCount()>0 );
	        Assert.assertEquals(0,cruiseListView.getInfoCount() );
	    }
	  
}

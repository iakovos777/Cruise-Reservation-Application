package cast.cruise.ui;



import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cast.cruise.contacts.EmailAddress;
import cast.cruise.datastore.CruiseDS;
import cast.cruise.datastore.Data;
import cast.cruise.datastore.HostDS;
import cast.cruise.domain.Cruise;
import cast.cruise.domain.Host;
import cast.cruise.memory.CruiseMemory;
import cast.cruise.memory.DataMemory;
import cast.cruise.memory.HostMemory;
import cast.cruise.ui.host.CruiseListHostPresenter;



public class CruiseListHostPresenterTest {

	 	private Data dataHelper;
	    private CruiseListHostPresenter presenter;
	    private CruiseListHostViewStub cruiseListHostView;
	    private CruiseViewStub cruiseViewStub;
	    
	    @Before
	    public void setUp() {
	        dataHelper = new DataMemory();
	        dataHelper.readData();        
	        
	        cruiseListHostView = new CruiseListHostViewStub();
	        cruiseViewStub = new CruiseViewStub();
	        
	        ViewRegistry.setCruiseView(cruiseViewStub);
	        
	        presenter = new CruiseListHostPresenter(cruiseListHostView);
	        
	        cruiseListHostView.setPresenter(presenter);
	        cruiseListHostView.open();
	    }
	    
	    @After
	    public void tearDown() {
	        ViewRegistry.resetForEval();
	    }
	    
	    
		@Test
	    public void wiring() {
	        presenter.start();
	        Assert.assertTrue(cruiseListHostView.isOpened());	       
	        Assert.assertEquals(0, presenter.getCruises().size());
	       
	    }
		@Test
		public void cancel(){
			presenter.start();
	        presenter.cancel();
	        Assert.assertFalse(cruiseListHostView.isOpened());
		}
	    
		@Test
	    public void editSelected() {
	 
	    	Cruise cruise = new Cruise();
	    	Host host = new Host();
	    	HostDS hostds = new HostMemory();
	        host = hostds.find(1);
	        
	        cruise.setCruiseId(999);
	        cruise.setCost(1000);
	        cruise.setArrivalDate("12/07/2017");
	        cruise.setDepartureDate("2/07/2017");
	        cruise.setDuration(10);
	        cruise.setDescription("AMAZING");
	        cruise.setHost(host);
	        cruise.setDestination("Marseille");
	        EmailAddress email = new EmailAddress("p09090@yahoo.com");
	        cruise.setEmail(email);
	        
	        cruise.setStart("Rafina");
	        cruise.setPositions(600);
	        cruise.setPrePaidAll(false);
	        cruise.setPrePaidAmount(500);
	    	
	    	cruiseListHostView.setSelectedCruise(cruise);
	            
	        presenter.start();
	        presenter.setHost(host);
	        presenter.editSelected();
	    
	        Assert.assertTrue(cruiseViewStub.isOpened());
	        
	        Assert.assertEquals(cruise.getCruiseId(), 
	        		cruiseViewStub.getCruiseId());
	        
	        Assert.assertEquals(cruise.getPositions(), 
	        		cruiseViewStub.getPositions());
	        
	        Assert.assertEquals(cruise.getStart(), 
	        		cruiseViewStub.getStart());
	        Assert.assertEquals(cruise.getEmail(), 
	        		cruiseViewStub.getEmail());
	        Assert.assertEquals(cruise.getPrePaidAll(), 
	        		cruiseViewStub.getPrePaidAll());
	        Assert.assertEquals(cruise.getDuration(), 
	        		cruiseViewStub.getDuration());
	        Assert.assertEquals(cruise.getArrivalDate(), 
	        		cruiseViewStub.getArrivalDate());
	        Assert.assertEquals(cruise.getDepartureDate(), 
	        		cruiseViewStub.getDepartureDate());
	        Assert.assertEquals(cruise.getDestination(), 
	        		cruiseViewStub.getDestination());
	        Assert.assertEquals(cruise.getDescription(), 
	        		cruiseViewStub.getDescription());

	    }
	    
	    

		@Test
	    public void add() {
	        
	        presenter.start();
	        presenter.addCruise();
	        
	        Assert.assertTrue(cruiseViewStub.isOpened());
	        Assert.assertEquals(0, cruiseViewStub.getCruiseId());
	        
	    }
	    
		@Test
	    public void refresh() {
			Host host = new Host();
			 HostDS hostds = new HostMemory();
		     host = hostds.find(1);
		     presenter.setHost(host);
		     presenter.start();
	         Assert.assertEquals(1, presenter.getCruises().size());
	         
		   
	         CruiseDS cruiseds = new CruiseMemory();
	         Cruise cruise = new Cruise();
	         
		        host.setCompanyName("Star");
		        host.setHostId(12);
		        host.setPwd("1234");
		        cruise.setCruiseId(999);
		        cruise.setCost(1000);
		        cruise.setArrivalDate("12/07/2017");
		        cruise.setDepartureDate("2/07/2017");
		        cruise.setDuration(10);
		        cruise.setDescription("AMAZING");
		        cruise.setHost(host);
		        cruise.setDestination("Marseille");
		        EmailAddress email = new EmailAddress("p09090@yahoo.com");
		        cruise.setEmail(email);
		        
		        cruise.setStart("Rafina");
		        cruise.setPositions(600);
		        cruise.setPrePaidAll(false);
		        cruise.setPrePaidAmount(500);
	         
	         cruiseds.save(cruise);
	         
	         presenter.refresh();
	         Assert.assertEquals(2, presenter.getCruises().size());
	         Assert.assertEquals(2, cruiseListHostView.getCruises().size());
	         
	    }

}

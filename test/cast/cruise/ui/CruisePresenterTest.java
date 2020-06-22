package cast.cruise.ui;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



import cast.cruise.contacts.EmailAddress;
import cast.cruise.datastore.CruiseDS;
import cast.cruise.datastore.Data;
import cast.cruise.domain.Cruise;
import cast.cruise.domain.Host;
import cast.cruise.memory.CruiseMemory;
import cast.cruise.memory.DataMemory;
import cast.cruise.ui.cruise.CruisePresenter;

public class CruisePresenterTest {

	  	private Data dataHelper;
	    private CruisePresenter presenter;
	    private CruiseViewStub cruiseView;
	    private Cruise cruise;
	    private CruiseDS cruiseds;
	    private Host host;
	  
	    @Before
	    public void setUp() {
	        cruise = new Cruise();
	        host = new Host();
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
	        
	        
	        dataHelper = new DataMemory();
	        dataHelper.readData();        
	        
	        cruiseds = new CruiseMemory();
	        
	        cruiseView = new CruiseViewStub();
	        presenter = new CruisePresenter(cruiseView);
	       
	    }
	    

	    @Test
	    public void wiring() {
	    	 
	        presenter.start();
	        Assert.assertSame(presenter, cruiseView.getPresenter());
	    }
	    
	    @Test
	    public void setCruiseAndSave() {
	        
	        presenter.setCruise(cruise);        
	        
	        presenter.start();
	        assertCruise(cruise.getCruiseId(), 
	        		cruise.getPositions(),
	        		cruise.getDepartureDate(),
	        		cruise.getArrivalDate(),
	        		cruise.getStart(),
	        		cruise.getDestination(),
	        		cruise.getEmail(),
	        		cruise.getDescription(),
	        		cruise.getDuration(),
	        		cruise.getCost(),
	        		cruise.getPrePaidAmount(),
	        		cruise.getPrePaidAll());
	        		
	        		
	        
	        presenter.save();
	        
	        int allCruises = cruiseds.findAll().size();
	        Assert.assertEquals(3, allCruises);
	    }

	    
	    @Test
	    public void setCruiserAndCancel() {
	        presenter.setCruise(cruise);  
	        presenter.start();
	        presenter.cancel();
	        
	        int allCruises = cruiseds.findAll().size();
	        Assert.assertEquals(2, allCruises);
	    }
	    
	    @Test
	    public void changeCruiseInfoAndSave() {
	        
	    	cruise = cruiseds.find(1);
	    	
	    	
	        presenter.setCruise(cruise);
	        presenter.start();
	        
	        cruiseView.setPositions(300);
	        cruiseView.setStart("Piraeus");
	        
	        presenter.save();
	        
	        cruise = cruiseds.find(1);
	        
	        Assert.assertEquals(300, cruise.getPositions());
	        Assert.assertEquals("Piraeus", cruise.getStart());
	        
	        
	    }
	    

	    private void assertCruise(int id, int positions, String depDate, String arrDate, String start, String destination, EmailAddress email, String description, int duration, int cost, int ammount, boolean all) {
	    	Assert.assertEquals(id, cruiseView.getCruiseId());
	    	Assert.assertEquals(positions, cruiseView.getPositions());
	    	Assert.assertEquals(depDate, cruiseView.getDepartureDate());
	    	Assert.assertEquals(arrDate, cruiseView.getArrivalDate());
	    	Assert.assertEquals(start, cruiseView.getStart());
	    	Assert.assertEquals(destination, cruiseView.getDestination());
	    	Assert.assertEquals(email, cruiseView.getEmail());
	    	Assert.assertEquals(description, cruiseView.getDescription());
	    	Assert.assertEquals(duration, cruiseView.getDuration());
	    	Assert.assertEquals(cost, cruiseView.getCost());
	    	Assert.assertEquals(ammount, cruiseView.getPrePaidAmount());
	    	Assert.assertEquals(all, cruiseView.getPrePaidAll());
	    	
	    }

}

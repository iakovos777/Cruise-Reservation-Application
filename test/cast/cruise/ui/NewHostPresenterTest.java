package cast.cruise.ui;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cast.cruise.contacts.Address;
import cast.cruise.contacts.EmailAddress;
import cast.cruise.datastore.Data;
import cast.cruise.datastore.HostDS;
import cast.cruise.domain.Host;
import cast.cruise.memory.DataMemory;
import cast.cruise.memory.HostMemory;
import cast.cruise.ui.host.NewHostPresenter;



public class NewHostPresenterTest {
	 private Data dataHelper;
	    private NewHostPresenter presenter;
	    private NewHostViewStub hostView;
	    private HostDS hostds ;
	    private Host host;
	    
	    @Before
	    public void setUp() {
	    	
	        
	        dataHelper = new DataMemory();
	        dataHelper.readData(); 
	        hostds = new HostMemory();
	        hostView = new NewHostViewStub();
	        presenter = new NewHostPresenter(hostView);
	        hostView.setPresenter(presenter);
	        hostView.open();
	        
	    }
	          
	        
	                
	        
	       
	    	
	    	
	 

	    
	    @Test
	    public void wiring() {  
	        presenter.start();
	        Assert.assertFalse(presenter.IdCommon());
	        
	        Assert.assertSame(hostView.getPresenter(), presenter);
	        Assert.assertTrue(hostView.isOpened());
	       
	    }
	    
	    
	    @Test
	    public void cancel() {       
	        presenter.start();
	        presenter.cancel();
	        Assert.assertFalse(hostView.isOpened());
	    }
	    
	    
	   
	    

	    
	    
	    
	    @Test
	    public void setNewHostAndSave() {
	    	host = new Host();
	    	host.setHostId(13);
	    	 Assert.assertEquals(null,hostds.find(hostView.getHostId()));
	    	
	    	
	    	 Address address = new Address();
	    	
			address.setStreet("Agias Lauras");
			address.setNumber("15");
			address.setCity("Maroussi");
			address.setCountry("Greece");
			address.setZipCode("12122");
	    	Assert.assertNotEquals(null, address);
	        hostView.setCompanyAddress(address);
	       
	        hostView.setCompanyName("Seaways");
	        EmailAddress email = new EmailAddress("seaways@gmail.com");
	        Assert.assertNotEquals(null, email);
	        hostView.setCompanyEmail(email);
	        hostView.setPwd("123");
	        presenter.setHost(host);
	                    
	        
	        presenter.start();
	        
	        		
	        
	        presenter.save();
	        assertHost(host.getHostId(),
	        		host.getCompanyName(),
	        		host.getCompanyAddress(),
	        		host.getCompanyEmail(),
	        		host.getPwd());
	        Assert.assertFalse(presenter.IdCommon());
	        int allHosts = hostds.findAll().size();
	        Assert.assertEquals(3, allHosts);
	        
	        
	      }  
 
	       
	        		
	        		
	        
	       
	    

	    
	   










		@Test
	    public void setNewHostAndCancel() {
	          
	        presenter.start();
	        host = new Host();
	        hostView.setHostId(13);
	    	Address a = new Address("Agias Lauras, 15, Maroussi , 12122, Greece");
	    	hostView.setCompanyAddress(a);
	    	hostView.setCompanyName("Seaways");
	        EmailAddress email = new EmailAddress("seaways@gmail.com");
	        hostView.setCompanyEmail(email);
	        hostView.setPwd("123");
	        presenter.cancel();
	        
	        int allHosts = hostds.findAll().size();
	        
	        Assert.assertEquals(2, allHosts);
	    }
	    
	   
		 private void assertHost(int hostId, String companyName, Address address, EmailAddress email,
					String pwd) {
			 Assert.assertEquals(hostId, hostView.getHostId());
			 Assert.assertEquals(companyName, hostView.getCompanyName());
			 Assert.assertEquals(address, hostView.getCompanyAddress());
			 Assert.assertEquals(email, hostView.getCompanyEmail());
			 Assert.assertEquals(pwd, hostView.getPwd());
				
			}
	    
	    	
	}
	    
	    


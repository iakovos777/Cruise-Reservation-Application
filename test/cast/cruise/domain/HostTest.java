package cast.cruise.domain;





import org.junit.Assert;
import org.junit.Test;

import cast.cruise.contacts.Address;


public class HostTest {

	
	@Test
    public void testAddress() {
        Address address = new Address();
        address.setCity("Athens");
        
        Host host = new Host();
        host.setCompanyAddress(address);
        
        Assert.assertNotSame(address, host.getCompanyAddress());
        Assert.assertEquals(address, host.getCompanyAddress());
        
        address.setCity("Patra");
        
        Assert.assertFalse(address.equals(host.getCompanyAddress()) );
        
        Address newAddress = host.getCompanyAddress();
        Assert.assertNotSame(newAddress, host.getCompanyAddress());
        Assert.assertTrue(newAddress.equals(host.getCompanyAddress()) );
        
        Assert.assertTrue(newAddress.getCity().equals(host.getCompanyAddress().getCity()) );
        newAddress.setCity("Patra");
        
        Assert.assertFalse(newAddress.getCity().equals(host.getCompanyAddress().getCity()) );
        
        
    }
	 @Test
	    public void addNullForCruise() {
	        Host host = new Host();                    
	        host.addCruise(null);
	        Assert.assertEquals(0,host.getCruises().size());
	        cruiseBidirectionalAssociationInvariant(host);        
	    }
	    
	    

		@Test
	    public void addCruise() {
			Host host = new Host();
	        Cruise cruise = new Cruise();
	        host.addCruise(cruise);
	        Assert.assertEquals(1, host.getCruises().size());
	        Assert.assertTrue(host.getCruises().contains(cruise));
	        cruiseBidirectionalAssociationInvariant(host);        
	    }
	    
	    
	    @Test
	    public void removeNullForCruise() {
	    	Host host = new Host();
	        Cruise cruise = new Cruise();       
	        host.addCruise(cruise);
	        host.removeCruise(null);
	        Assert.assertEquals(1, host.getCruises().size());
	        cruiseBidirectionalAssociationInvariant(host); 
	    }
	    
	    @Test
	    public void removeCruise() {
	    	Host host = new Host();
	        Cruise cruise = new Cruise();
	        host.addCruise(cruise);
	        cruiseBidirectionalAssociationInvariant(host); 
	        host.removeCruise(cruise);
	        Assert.assertEquals(0, host.getCruises().size());
	        cruiseBidirectionalAssociationInvariant(host); 
	    }
	    
	    
	    
	    private void cruiseBidirectionalAssociationInvariant(Host host) {
	        for(Cruise cruise : host.getCruises()) {
	            Assert.assertTrue((cruise.getHost()).equals(host));            
	        }
	    }

}

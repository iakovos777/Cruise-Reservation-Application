package cast.cruise.domain;



import org.junit.Assert;
import org.junit.Test;

import cast.cruise.contacts.Address;

public class UserTest {
	
	  @Test
	    public void testAddress() {
	        Address address = new Address();
	        address.setCity("Athens");
	        address.setStreet("Sintagma");
	        address.setNumber("4");
	        address.setCountry("Greece");
	        address.setZipCode("15030");
	        User user = new User();
	        user.setAddress(address);
	        
	        Assert.assertNotSame(address, user.getAddress());
	        Assert.assertEquals(address, user.getAddress());
	        
	        address.setCity("Patra");
	        
	        Assert.assertFalse(address.equals(user.getAddress()) );
	        
	        Address newAddress = user.getAddress();
	        Assert.assertNotSame(newAddress, user.getAddress());
	        Assert.assertTrue(newAddress.equals(user.getAddress()) );
	        
	        Assert.assertTrue(newAddress.getCity().equals(user.getAddress().getCity()) );
	        newAddress.setCity("Patra");
	        
	        Assert.assertFalse(newAddress.getCity().equals(user.getAddress().getCity()) );
	        
	        
	    }
	@Test
    public void addNullForReserve() {
        User user = new User();                    
        user.addReserve(null);
        Assert.assertEquals(0,user.getReserve().size());
        reserveBidirectionalAssociationInvariant(user);        
    }
    
    

	@Test
    public void addReserve() {
		User user = new User();
		Reservation reserve = new Reservation(); 
        user.addReserve(reserve);
        Assert.assertEquals(1, user.getReserve().size());
        Assert.assertTrue(user.getReserve().contains(reserve));
        reserveBidirectionalAssociationInvariant(user);        
    }
    
    
    @Test
    public void removeNullForReserve() {
    	User user = new User();
        Reservation reserve = new Reservation();       
        user.addReserve(reserve);
        user.cancelReserve(null);
        Assert.assertEquals(1, user.getReserve().size());
        reserveBidirectionalAssociationInvariant(user); 
    }
    
    @Test
    public void removeReserve() {
    	User user = new User();
    	Reservation reserve = new Reservation(); 
        user.addReserve(reserve);
        reserveBidirectionalAssociationInvariant(user); 
        user.cancelReserve(reserve);
        Assert.assertEquals(0, user.getReserve().size());
        reserveBidirectionalAssociationInvariant(user); 
    }
    
    
    
    private void reserveBidirectionalAssociationInvariant(User user ) {
        for(Reservation reserve : user.getReserve()) {
            Assert.assertTrue((reserve.getUser()).equals(user));            
        }
    }


}

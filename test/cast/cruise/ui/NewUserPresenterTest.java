package cast.cruise.ui;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cast.cruise.contacts.Address;
import cast.cruise.contacts.CardElements;
import cast.cruise.contacts.EmailAddress;
import cast.cruise.datastore.Data;

import cast.cruise.datastore.UserDS;

import cast.cruise.domain.User;
import cast.cruise.memory.DataMemory;

import cast.cruise.memory.UserMemory;

import cast.cruise.ui.user.NewUserPresenter;

public class NewUserPresenterTest {

	private Data dataHelper;
    private NewUserPresenter presenter;
    private NewUserViewStub userView;
    private UserDS userds ;
    private User user;
    
    @Before
    public void setUp() {
    	
        
        dataHelper = new DataMemory();
        dataHelper.readData(); 
        userds = new UserMemory();
        userView = new NewUserViewStub();
        presenter = new NewUserPresenter(userView);
        userView.setPresenter(presenter);
        userView.open();
        
    }
          
        
                
        
       
    	
    	
 

    
    @Test
    public void wiring() {  
        presenter.start();
        Assert.assertFalse(presenter.IdCommon());
        
        Assert.assertSame(userView.getPresenter(), presenter);
        Assert.assertTrue(userView.isOpened());
       
    }
    
    
    @Test
    public void cancel() {       
        presenter.start();
        presenter.cancel();
        Assert.assertFalse(userView.isOpened());
    }
    
    
   
    

    
    
    
    @Test
    public void setNewUserAndSave() {
    	user = new User();
    	userView.setUserId(13);
    	 Assert.assertEquals(null,userds.find(userView.getUserId()));
    	
    	
    	 Address address = new Address();
    	
		address.setStreet("Agias Lauras");
		address.setNumber("15");
		address.setCity("Maroussi");
		address.setCountry("Greece");
		address.setZipCode("12122");
    	Assert.assertNotEquals(null, address);
    	userView.setAddress(address);
    	userView.setLastName("Albert");
    	userView.setFirstName("Jack");
        EmailAddress email = new EmailAddress("jack@gmail.com");
        Assert.assertNotEquals(null, email);
        userView.setEmail(email);
        userView.setPassword("123");
        CardElements crd = new CardElements();
        crd.setCV("098");
        crd.setExpireDate("05/2019");
        crd.setName("Jack Albert");
        crd.setNumberCard("0900909090907897");
        userView.setCard(crd);
        userView.setTelephone(2108787878);
        presenter.setUser(user);
                    
        
        presenter.start();
        
        		
        
        presenter.save();
        
        assertUser(user.getUserId(),
        		user.getFirstName(),
        		user.getLastName(),
        		user.getAddress(),
        		user.getEmail(),
        		user.getPassword(),
        		user.getCard(),
        		user.getTelephone());
        Assert.assertFalse(presenter.IdCommon());
        int allUsers = userds.findAll().size();
        Assert.assertEquals(3, allUsers);
        
        
      }  

       
        		
        		
        
       
    

    
   










	@Test
    public void setNewHostAndCancel() {
          
        presenter.start();
        user = new User();
        userView.setUserId(13);
    	Address a = new Address("Agias Lauras, 15, Maroussi , 12122, Greece");
    	userView.setAddress(a);
    	userView.setLastName("Albert");
    	userView.setFirstName("Jack");
        EmailAddress email = new EmailAddress("jack@gmail.com");
        Assert.assertNotEquals(null, email);
        userView.setEmail(email);
        userView.setPassword("123");
        CardElements crd = new CardElements();
        crd.setCV("098");
        crd.setExpireDate("05/2019");
        crd.setName("Jack Albert");
        crd.setNumberCard("0900909090907897");
        userView.setCard(crd);
        userView.setTelephone(2108787878);
        
        
        presenter.cancel();
        
        int allUsers = userds.findAll().size();
        
        Assert.assertEquals(2, allUsers);
    }
    
   
	 private void assertUser(int userId, String fn, String ln, Address address, EmailAddress email,
				String pwd, CardElements card, int tel) {
		 Assert.assertEquals(userId, userView.getUserId());
		 Assert.assertEquals(fn, userView.getFirstName());
		 Assert.assertEquals(ln, userView.getLastName());
		 Assert.assertEquals(address, userView.getAddress());
		 Assert.assertEquals(email, userView.getEmail());
		 Assert.assertEquals(pwd, userView.getPassword());
		 Assert.assertEquals(card, userView.getCard());
		 Assert.assertEquals(tel, userView.getTelephone());
			
		}

}

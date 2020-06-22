package cast.cruise.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;




import cast.cruise.util.SystemDateStub;
import cast.cruise.exception.*;
import cast.cruise.contacts.EmailMessage;
import cast.cruise.datastore.CruiseDS;
import cast.cruise.datastore.Data;
import cast.cruise.datastore.UserDS;
import cast.cruise.domain.Cruise;
import cast.cruise.domain.User;
import cast.cruise.memory.CruiseMemory;
import cast.cruise.memory.DataMemory;
import cast.cruise.memory.UserMemory;

public class NotificationServiceTest {
    
    
    private EmailProviderTest provider;
    
 
    
    @Before
    public void setUp() {
        provider = new EmailProviderTest();
        
        Data dataHelper = new DataMemory();
        dataHelper.readData();
     
    }
    
    @After
    public void tearDown() {
        SystemDateStub.reset();
    }
    
    @Test(expected=CruiseException.class)
    public void serviceWhenNotifierIsNull() {
        NotificationService service = new NotificationService();
        service.setProvider(null);
        service.notifyUser();
    }
    
    
    
    @Test
    public void sendMessageNotPrePay() {
    	 ReservationService service = new ReservationService();
         service.findUser(1);
         Cruise cr = new Cruise();
         CruiseDS crds = new CruiseMemory();
         cr=crds.find(1);
         cr.available();
         service.reserve(1,1);

        
    	                    
        NotificationService service2 = new NotificationService();        
        service2.setProvider(provider);                        
        service2.notifyUser();
        
        UserDS userds = new UserMemory();
        
        User user = userds.find(1);        
        Assert.assertEquals(1,provider.allMessages.size());
        EmailMessage message = provider.getallEmails().get(0);
        Assert.assertEquals(user.getEmail() , message.getTo());
        
    }
    
    
    
    
    
	
    
    
    
    
    
   
    
}

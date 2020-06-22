package cast.cruise.domain;




import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cast.cruise.util.SimpleCalendar;
import cast.cruise.util.SystemDateStub;

public class PaymentTest {
SimpleCalendar nowStub;
 Payment pay;
    @Before 
    public void setUpTests() {
    	
        nowStub = new SimpleCalendar(2017,5,10);
        SystemDateStub.setStub(nowStub);
        Payment pay = new Payment();
        pay.setFinalDayPrePayment(nowStub);
    }
    
    @After
    public void resetTests() {
        SystemDateStub.reset();
        
    }
    
    @Test
	public void isPrePaidtest() {
		Payment pay = new Payment();
		SimpleCalendar date =  new SimpleCalendar(2017,5,5);
		pay.setFinalDayPrePayment(date);
		String depDate = "17/7/2017";			
		Assert.assertFalse(pay.isPrePaidValid(depDate));
		  date =new SimpleCalendar(2017,7,7);
		  pay.setFinalDayPrePayment(date);
	        Assert.assertTrue(pay.isPrePaidValid(depDate));
	      
	}
	
	
	@Test
	public void isPaidtest() {
		Payment pay = new Payment();
		String date = "5/5/2017";			
		Assert.assertFalse(pay.isPaidValid(date));
		  date = "7/7/2017";
	        Assert.assertTrue(pay.isPaidValid(date));
	      
	}

}

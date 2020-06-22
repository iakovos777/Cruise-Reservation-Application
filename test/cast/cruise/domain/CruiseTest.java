package cast.cruise.domain;




import org.junit.Assert;
import org.junit.Test;

import cast.cruise.exception.CruiseException;
import cast.cruise.util.SimpleCalendar;
import cast.cruise.util.SystemDate;

public class CruiseTest {

	@Test
	public void getState() {
        Cruise cruise = new Cruise();
        Assert.assertEquals(CruiseState.AVAILABLE, cruise.getState());
    }
	
	@Test
    public void reserve() {
        User user = new User();
        Cruise cruise = new Cruise();
        Reservation res = new Reservation();
        Assert.assertNotNull(user);
        Assert.assertEquals(CruiseState.AVAILABLE, cruise.getState());
        cruise.setPositions(100);
        cruise.available();
        cruise.setDepartureDate("10/7/2017");
        cruise.setArrivalDate("29/8/2017");
             
               
        res = cruise.reserveCruise(user,3);
        Assert.assertNotNull(res.getEvaluation()); 
        Assert.assertNotNull(res);        
        SimpleCalendar now = SystemDate.now();
        Assert.assertEquals(CruiseState.AVAILABLE, cruise.getState());        
        Assert.assertEquals(now, res.getReservationDate());
        Assert.assertEquals(3,res.getPositionsReserved());
        Assert.assertSame(user, res.getUser());
        Assert.assertSame(cruise, res.getCruise());        
    }
	
	 @Test
	    public void fromAavailableToFull() {
		 Cruise cruise = new Cruise();
	        Assert.assertEquals(CruiseState.AVAILABLE, cruise.getState());
	        cruise.full();
	        Assert.assertEquals(CruiseState.FULL, cruise.getState());
	    }
	    
	  
	    @Test
	    public void fromAvailableToStart() {
	    	Cruise cruise = new Cruise();
	        Assert.assertEquals(CruiseState.AVAILABLE, cruise.getState());
	        cruise.start();
	        Assert.assertEquals(CruiseState.START, cruise.getState());
	    
	    }
	    @Test
	    public void fromStartToFinish() {
	    	Cruise cruise = new Cruise();
	    	cruise.start();
	        Assert.assertEquals(CruiseState.START, cruise.getState());
	        cruise.finish();
	        Assert.assertEquals(CruiseState.FINISH, cruise.getState());
	    }
	    
	    @Test(expected=CruiseException.class)
	    public void fromAvailableToFinish() {
	    	  
	          Cruise cruise = new Cruise();
	        cruise.available();
	        Assert.assertEquals(CruiseState.AVAILABLE, cruise.getState());
	         cruise.finish();       
	        
	       
	     
	    }
	    
	    @Test(expected=CruiseException.class)
	    public void fromFullToAvailable() {
	    	Cruise cruise = new Cruise();
	        cruise.full();
	        Assert.assertEquals(CruiseState.FULL, cruise.getState());
	         cruise.available();  
	    }
	    
	    
	    @Test
	    public void countEvaluations(){
	    	User user = new User();
	        Cruise cruise = new Cruise();
	        Reservation res = new Reservation();
	        Assert.assertNotNull(user);
	        Assert.assertEquals(CruiseState.AVAILABLE, cruise.getState());
	        cruise.setPositions(100);
	        cruise.setDepartureDate("10/7/2017");
	        cruise.setArrivalDate("29/8/2017");
	        cruise.available();                    
	               
	        res = cruise.reserveCruise(user,3);
	        Assert.assertNotNull(res); 
	        
	        User user1 = new User();
	        
	        
	        Assert.assertNotNull(user1);
	        Assert.assertEquals(CruiseState.AVAILABLE, cruise.getState());
	        cruise.setPositions(100);
	        cruise.setDepartureDate("10/7/2017");
	        cruise.setArrivalDate("29/8/2017");
	        cruise.available();
	        Reservation res1 = cruise.reserveCruise(user1,3);
	        
	        User user2 = new User();
	       
	        Reservation res2 = new Reservation();
	        Assert.assertNotNull(user);
	        Assert.assertEquals(CruiseState.AVAILABLE, cruise.getState());
	        cruise.setPositions(100);
	        cruise.setDepartureDate("10/7/2017");
	        cruise.setArrivalDate("29/8/2017");
	        cruise.available();
	        res2 = cruise.reserveCruise(user2,3);
	        int count = cruise.countEval();
	        Assert.assertEquals(3,count);
	    }
	    
	    @Test
	    public void sumEvaluations(){
	    	User user = new User();
	        Cruise cruise = new Cruise();
	        Reservation res = new Reservation();
	        Assert.assertNotNull(user);
	        Assert.assertEquals(CruiseState.AVAILABLE, cruise.getState());
	        cruise.setPositions(100);
	        cruise.setDepartureDate("10/7/2017");
	        cruise.setArrivalDate("29/8/2017");
	        cruise.available();                    
	               
	        res = cruise.reserveCruise(user,3);
	        Assert.assertNotNull(res); 
	        
	        User user1 = new User();
	        
	        Reservation res1 = new Reservation();
	        Assert.assertNotNull(user1);
	        Assert.assertEquals(CruiseState.AVAILABLE, cruise.getState());
	        cruise.setPositions(100);
	        cruise.setDepartureDate("10/7/2017");
	        cruise.setArrivalDate("29/8/2017");
	        cruise.available();
	        res1 = cruise.reserveCruise(user1,3);
	        
	        User user2 = new User();
	       
	        Reservation res2 = new Reservation();
	        Assert.assertNotNull(user);
	        Assert.assertEquals(CruiseState.AVAILABLE, cruise.getState());
	        cruise.setPositions(100);
	        cruise.setDepartureDate("10/7/2017");
	        cruise.setArrivalDate("29/8/2017");
	        cruise.available();
	        res2 = cruise.reserveCruise(user2,3);
	        int count = cruise.countEval();
	        Assert.assertEquals(3,count);
	        res.getEvaluation().setRating(6);
	        res1.getEvaluation().setRating(7);
	        res2.getEvaluation().setRating(8);
	        int rate = cruise.getEvaluations();
	        Assert.assertEquals(7,rate);
	    }

}

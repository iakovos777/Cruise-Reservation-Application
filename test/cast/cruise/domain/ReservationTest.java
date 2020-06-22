package cast.cruise.domain;



import org.junit.Assert;


import cast.cruise.util.SimpleCalendar;
import cast.cruise.util.SystemDate;

import org.junit.Test;

public class ReservationTest {
	
	Reservation res = new Reservation();
	Cruise cruise = new Cruise();
	
	
	@Test
	public void setters(){
		res.setCruise(cruise);
		Assert.assertEquals(cruise, res.getCruise());
		res.setReservationDate(SystemDate.now());
		Assert.assertEquals(SystemDate.now(), res.getReservationDate());
	}
	@Test
	public void testFinalDay() {
		SimpleCalendar now = SystemDate.now();
		res.setReservationDate(SystemDate.now());
		User user = new User();
		res.setUser(user);
		Assert.assertTrue(now.equals(res.getReservationDate()));
		now = now.addDays(10);
		SimpleCalendar today = new SimpleCalendar(2017,6,15);
		Assert.assertTrue(today.equals(now));
		Assert.assertTrue(today.equals(res.getFinalDay()));
		
	}
	
	@Test
	public void testPaid() {
		
		res.setCruise(cruise);
		res.getCruise().setDepartureDate("17/7/2017");
		System.out.println(res.isPaidValid());
		Assert.assertTrue(res.isPaidValid());
		cruise.setDepartureDate("2/4/2017");
		Assert.assertFalse(res.isPaidValid());
		
	}
	
	@Test
	public void testPrePaid() {
		Payment pay ;
		res.setCruise(cruise);
		res.setReservationDate(SystemDate.now());
		res.setPayment();
		pay = res.getPayment();
		pay.setFinalDayPrePayment(SystemDate.now().addDays(10));
		User user = new User();
		res.setUser(user);
		
		Assert.assertFalse(res.isPrePaidValid());
		
	}
	
	public void cancel(){
		User user = new User();
		res.setUser(user);
		res.setCruise(cruise);
		res.getUser().cancelReserve(res);
		Assert.assertTrue(res.getUser().equals(null));
		Assert.assertTrue(res.equals(null));
	}
	
	public void canEval(){
		User user = new User();
		res.setUser(user);
		res.setCruise(cruise);
		res.getCruise().finish();
		Assert.assertTrue(res.getCruise().getState().equals(CruiseState.FINISH));
		
		
	}

}

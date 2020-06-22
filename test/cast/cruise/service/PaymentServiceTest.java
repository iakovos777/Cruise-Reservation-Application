package cast.cruise.service;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cast.cruise.datastore.CruiseDS;
import cast.cruise.datastore.Data;
import cast.cruise.datastore.ReservationDS;
import cast.cruise.datastore.UserDS;
import cast.cruise.domain.Cruise;
import cast.cruise.domain.Reservation;
import cast.cruise.domain.User;
import cast.cruise.memory.CruiseMemory;
import cast.cruise.memory.DataMemory;
import cast.cruise.memory.ReservationMemory;
import cast.cruise.memory.UserMemory;
import cast.cruise.util.SimpleCalendar;
import cast.cruise.util.SystemDateStub;
import cast.cruise.exception.*;


public class PaymentServiceTest {

	@Before
    public void setUp() {
        Data dataHelper = new DataMemory();
        dataHelper.readData();
    }

    @After
    public void restoreSystemDate() {
        SystemDateStub.reset();
    }
    
    @Test(expected=CruiseException.class)
    public void returnWhenNoReservationExist() {
        PaymentService service = new PaymentService();
        service.Prepay();
    }
    
    @Test
    public void notPrePay() {
    	Cruise cruise = new Cruise();
        CruiseDS cruiseds = new CruiseMemory();
        cruise = cruiseds.find(1);
        cruise.start();
        ReservationDS resds = new ReservationMemory();
    	User user = new User();
    	UserDS userds = new UserMemory();
        user = userds.find(1);
        SimpleCalendar date = new SimpleCalendar(2017,6,5);
        Reservation res = new Reservation(date,cruise,2,user);
        res.setReservationId(1);
        res.setHasPrePay(true);
        resds.save(res);
        
    	PaymentService ps = new PaymentService();
    	ps.findReserve(1);
    	ps.findUser(1);
    	int p = ps.Prepay();
        Assert.assertSame(0,p);
        
    }
    
    
    @Test
    public void prePay(){
    	Cruise cruise = new Cruise();
        CruiseDS cruiseds = new CruiseMemory();
        cruise = cruiseds.find(1);
        ReservationDS resds = new ReservationMemory();
    	User user = new User();
    	UserDS userds = new UserMemory();
        user = userds.find(1);
        SimpleCalendar date = new SimpleCalendar(2017,6,5);
        Reservation res = new Reservation(date,cruise,2,user);
        res.setReservationId(1);
        resds.save(res);
        
    	PaymentService ps = new PaymentService();
    	ps.findReserve(1);
    	ps.findUser(1);
    	int p = ps.Prepay();
        Assert.assertNotSame(0,p);
        Assert.assertTrue(p>0);
        
    }
    
    
    @Test
    public void notPay(){
    	Cruise cruise = new Cruise();
        CruiseDS cruiseds = new CruiseMemory();
        cruise = cruiseds.find(1);
        ReservationDS resds = new ReservationMemory();
    	User user = new User();
    	UserDS userds = new UserMemory();
        user = userds.find(1);
        SimpleCalendar date = new SimpleCalendar(2017,6,5);
        Reservation res = new Reservation(date,cruise,2,user);
        res.setReservationId(1);
       
        resds.save(res);
        
    	PaymentService ps = new PaymentService();
    	ps.findReserve(1);
    	ps.findUser(1);
    	int p = ps.pay();
        Assert.assertSame(0,p);
        Assert.assertFalse(p>0);
       
    }
    
     @Test
    public void pay(){
    	 Cruise cruise = new Cruise();
         CruiseDS cruiseds = new CruiseMemory();
         cruise = cruiseds.find(1);
         ReservationDS resds = new ReservationMemory();
     	User user = new User();
     	UserDS userds = new UserMemory();
         user = userds.find(1);
         SimpleCalendar date = new SimpleCalendar(2017,6,5);
         Reservation res = new Reservation(date,cruise,2,user);
         res.setReservationId(1);
         res.setHasPrePay(true);
         resds.save(res);
         
     	PaymentService ps = new PaymentService();
     	ps.findReserve(1);
     	ps.findUser(1);
     	int p = ps.pay();
         Assert.assertNotSame(0,p);
         Assert.assertTrue(p>0);
        
    } 
    
    
   

}

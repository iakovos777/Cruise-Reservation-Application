package cast.cruise.ui;



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

import cast.cruise.ui.reservation.ReservationListPresenter;
import cast.cruise.util.SimpleCalendar;

public class ReservationListPresenterTest {

	private Data dataHelper;
    private ReservationListPresenter presenter;
    private ReservationListViewStub reserveView;
    private EvaluationViewStub evalViewStub;
    private Reservation res;
    private User user;
    private Cruise cruise;
    
    @Before
    public void setUp() {
        dataHelper = new DataMemory();
        dataHelper.readData();        
        
        reserveView = new ReservationListViewStub();
        evalViewStub = new EvaluationViewStub();
        
        ViewRegistry.setEvaluationView(evalViewStub);
        
        presenter = new ReservationListPresenter(reserveView);
        
        reserveView.setPresenter(presenter);
        reserveView.open();
    }
    
    @After
    public void tearDown() {
        ViewRegistry.resetForHost();
    }
    
    
	@Test
    public void wiring() {
        presenter.start();
        Assert.assertTrue(reserveView.isOpened());	       
        Assert.assertEquals(0, presenter.getReservations().size());
        Assert.assertEquals(0, reserveView.getReservations().size());
       
    }
	
	@Test
    public void cancel() {
        presenter.start();
        presenter.cancel();
        Assert.assertFalse(reserveView.isOpened());
    }
    
	@Test
    public void SuccessfulprePay() {
		
        cruise = new Cruise();
        CruiseDS cruiseds = new CruiseMemory();
        cruise = cruiseds.find(1);
        ReservationDS resds = new ReservationMemory();
    	user = new User();
    	UserDS userds = new UserMemory();
        user = userds.find(1);
        SimpleCalendar date = new SimpleCalendar(2017,6,5);
        res = new Reservation(date,cruise,2,user);
        resds.save(res);
        
    	
    	reserveView.setSelectedReserve(res);
    	
            
        presenter.start();
        presenter.setUser(user);
        Assert.assertNotSame(null,reserveView.getSelectedReserve());
        Assert.assertNotSame(null,presenter.getUser());
        presenter.prePay();
        Assert.assertTrue(reserveView.getSelectedReserve().getHasPrePay());
        Assert.assertTrue(reserveView.getInfoCount()>0);
    }
    
	@Test
    public void UnsuccessfulprePay() {
		
        cruise = new Cruise(3,150,200,50,"15/05/2017","25/05/2017",15,"Crete","Corfu","Amazing cruise",false,null,null,0);
        cruise.available();
        
        CruiseDS cruiseds = new CruiseMemory();
        cruiseds.save(cruise);
        ReservationDS resds = new ReservationMemory();
    	user = new User();
    	UserDS userds = new UserMemory();
        user = userds.find(1);
        SimpleCalendar date = new SimpleCalendar(2017,6,5);
        res = new Reservation(date,cruise,2,user);
        resds.save(res);
        int i = resds.findAll().size();
    	
    	reserveView.setSelectedReserve(res);
    	
            
        presenter.start();
        presenter.setUser(user);
        Assert.assertNotSame(null,reserveView.getSelectedReserve());
        Assert.assertNotSame(null,presenter.getUser());
        presenter.prePay();
        Assert.assertFalse(reserveView.getSelectedReserve().getHasPrePay());
        Assert.assertTrue(reserveView.getErrorCount()>0);
        Assert.assertEquals(i-1,resds.findAll().size() );
    }
    

	@Test
    public void CanPay() {
        
    	cruise = new Cruise();
        CruiseDS cruiseds = new CruiseMemory();
        cruise = cruiseds.find(1);
        ReservationDS resds = new ReservationMemory();
    	user = new User();
    	UserDS userds = new UserMemory();
        user = userds.find(1);
        SimpleCalendar date = new SimpleCalendar(2017,6,5);
        res = new Reservation(date,cruise,2,user);
        res.setHasPrePay(true);
        resds.save(res);
        
    	
    	reserveView.setSelectedReserve(res);
    	
            
        presenter.start();
        presenter.setUser(user);
        Assert.assertNotSame(null,reserveView.getSelectedReserve());
        Assert.assertNotSame(null,presenter.getUser());
        presenter.pay();
        Assert.assertTrue(reserveView.getSelectedReserve().getHasPay());
        Assert.assertTrue(reserveView.getInfoCount()>0);
        
    }
    @Test
    public void CannotPay() {
        
    	 cruise = new Cruise(3,150,200,50,"15/05/2017","25/05/2017",15,"Crete","Corfu","Amazing cruise",false,null,null,0);
         cruise.available();
         
         CruiseDS cruiseds = new CruiseMemory();
         cruiseds.save(cruise);
         ReservationDS resds = new ReservationMemory();
     	user = new User();
     	UserDS userds = new UserMemory();
         user = userds.find(1);
         SimpleCalendar date = new SimpleCalendar(2017,6,5);
         res = new Reservation(date,cruise,2,user);
         res.setHasPrePay(true);
         resds.save(res);
         int i = resds.findAll().size();
     	
     	reserveView.setSelectedReserve(res);
     	
             
         presenter.start();
         presenter.setUser(user);
         Assert.assertNotSame(null,reserveView.getSelectedReserve());
         Assert.assertNotSame(null,presenter.getUser());
         presenter.pay();
         Assert.assertFalse(reserveView.getSelectedReserve().getHasPay());
         Assert.assertTrue(reserveView.getErrorCount()>0);
         
         Assert.assertEquals(i-1,resds.findAll().size() );
        
    }
	
    
    @Test
    public void PrePayAmmountZero() {
    	cruise = new Cruise();
        CruiseDS cruiseds = new CruiseMemory();
        cruise = cruiseds.find(1);
        cruise.setPrePaidAmount(0);
        ReservationDS resds = new ReservationMemory();
    	user = new User();
    	UserDS userds = new UserMemory();
        user = userds.find(1);
        SimpleCalendar date = new SimpleCalendar(2017,6,5);
        res = new Reservation(date,cruise,2,user);
        
        resds.save(res);
        
    	
    	reserveView.setSelectedReserve(res);
    	
            
        presenter.start();
        presenter.setUser(user);
        Assert.assertNotSame(null,reserveView.getSelectedReserve());
        Assert.assertNotSame(null,presenter.getUser());
        presenter.prePay();
        Assert.assertTrue(reserveView.getSelectedReserve().getHasPrePay());
        Assert.assertTrue(reserveView.getInfoCount()>0);
    	
    
    
    }
   
   
	@Test
	public void canEvaluate(){
		cruise = new Cruise();
        CruiseDS cruiseds = new CruiseMemory();
        cruise = cruiseds.find(1);
        cruise.start();
        cruise.finish();
        ReservationDS resds = new ReservationMemory();
    	user = new User();
    	UserDS userds = new UserMemory();
        user = userds.find(1);
        SimpleCalendar date = new SimpleCalendar(2017,6,5);
        res = new Reservation(date,cruise,2,user);
        res.setHasPrePay(true);
        resds.save(res);
        reserveView.setSelectedReserve(res);	
        	presenter.start();
	        presenter.setUser(user);
	        presenter.evaluate();
	    
	        Assert.assertTrue(evalViewStub.isOpened());
	        
	        
	        

	}
	
	@Test
	public void cannotEvaluate(){
		cruise = new Cruise();
        CruiseDS cruiseds = new CruiseMemory();
        cruise = cruiseds.find(1);
        cruise.start();
       
        ReservationDS resds = new ReservationMemory();
    	user = new User();
    	UserDS userds = new UserMemory();
        user = userds.find(1);
        SimpleCalendar date = new SimpleCalendar(2017,6,5);
        res = new Reservation(date,cruise,2,user);
        res.setHasPrePay(true);
        resds.save(res);
        reserveView.setSelectedReserve(res);	
        	presenter.start();
	        presenter.setUser(user);
	        presenter.evaluate();
	    
	        Assert.assertFalse(evalViewStub.isOpened());
	        
	        
	        

	}
    
	
	@Test
    public void refresh() {
		cruise = new Cruise();
        CruiseDS cruiseds = new CruiseMemory();
        cruise = cruiseds.find(1);
       
       
        ReservationDS resds = new ReservationMemory();
        
        user = new User();
    	UserDS userds = new UserMemory();
        user = userds.find(2);
        SimpleCalendar date = new SimpleCalendar(2017,6,5);
        res = new Reservation(date,cruise,2,user);
        Assert.assertEquals(0, resds.findWithSameUser(user).size());
        resds.save(res);
        reserveView.setSelectedReserve(res);
        presenter.setUser(user); 
        presenter.start();
	      
        Assert.assertEquals(1, presenter.getReservations().size());
         
	   
         
        
    	
        
        Reservation res2 = new Reservation(date,cruise,2,user);
         
         resds.save(res2);
         
         presenter.refresh();
         Assert.assertEquals(2, presenter.getReservations().size());
         Assert.assertEquals(2, reserveView.getReservations().size());
         
    }

}

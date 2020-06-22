package cast.cruise.ui;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cast.cruise.datastore.CruiseDS;
import cast.cruise.datastore.Data;
import cast.cruise.datastore.EvaluationDS;
import cast.cruise.datastore.ReservationDS;
import cast.cruise.datastore.UserDS;
import cast.cruise.domain.Cruise;
import cast.cruise.domain.Reservation;
import cast.cruise.domain.User;
import cast.cruise.memory.CruiseMemory;
import cast.cruise.memory.DataMemory;
import cast.cruise.memory.EvaluationMemory;
import cast.cruise.memory.ReservationMemory;
import cast.cruise.memory.UserMemory;
import cast.cruise.ui.reservation.EvaluationPresenter;

import cast.cruise.util.SimpleCalendar;

public class EvaluationPresenterTest {

	private Data dataHelper;
    private EvaluationPresenter presenter;
    
    private EvaluationViewStub evalView;
    private Reservation res;
    private User user;
    private Cruise cruise;
    
    @Before
    public void setUp() {
        dataHelper = new DataMemory();
        dataHelper.readData();        
        evalView = new EvaluationViewStub();
        
       
        
        presenter = new EvaluationPresenter(evalView);
        
        evalView.setPresenter(presenter);
        evalView.open();
    }
    
   
    
    
	@Test
    public void wiring() {
        presenter.start();
        Assert.assertTrue(evalView.isOpened());	       
        
       
    }
	
	@Test
    public void cancel() {
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
        presenter.setReservation(res);
    	EvaluationDS evalds = new EvaluationMemory();
        presenter.start();
        presenter.cancel();
        int allEvaluations = evalds.findAll().size();
        Assert.assertEquals(0,allEvaluations);
        Assert.assertFalse(evalView.isOpened());
    }
	
	@Test
    public void canEvaluate() {
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
	        resds.save(res);
	        EvaluationDS evalds = new EvaluationMemory();
	        presenter.setReservation(res);
	    	presenter.start();
	    	evalView.setRating("6");
	    	presenter.evaluate();
	    	int allEvaluations = evalds.findAll().size();
	        Assert.assertEquals(1,allEvaluations);
	    	Assert.assertTrue(evalView.getInfoCount()>0);
        
       
    }
	
	@Test
    public void cannotEvaluate() {
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
	        resds.save(res);
	        EvaluationDS evalds = new EvaluationMemory();
	        presenter.setReservation(res);
	    	presenter.start();
	    	evalView.setRating("6");
	    	presenter.evaluate();
	    	int allEvaluations = evalds.findAll().size();
	        Assert.assertEquals(0,allEvaluations);
	    	Assert.assertTrue(evalView.getErrorCount()>0);
        
       
    }
	@Test
	public void manyEvaluations(){
		cruise = new Cruise();
		
        CruiseDS cruiseds = new CruiseMemory();
        cruise = cruiseds.find(1);
        cruise.available();
       
        ReservationDS resds = new ReservationMemory();
    	user = new User();
    	UserDS userds = new UserMemory();
        user = userds.find(1);
        
        res = cruise.reserveCruise(user, 2);
        Reservation res1 = cruise.reserveCruise(user, 2);
        
        Reservation res2 = cruise.reserveCruise(user, 2);
        Reservation res3 = cruise.reserveCruise(user, 2);
        resds.save(res);
        resds.save(res1);
        resds.save(res2);
        resds.save(res3);
        cruise.start();
        cruise.finish();
        int c = cruise.getReserve().size();
        Assert.assertEquals(4, c);
        EvaluationDS evalds = new EvaluationMemory();
        presenter.setReservation(res);
        evalView.setRating("6");
    	presenter.start();
      	presenter.evaluate();
    	int allEvaluations = evalds.findAll().size();
    	Assert.assertEquals(6, res.getEvaluation().getRating());
    	presenter.setReservation(res1);
        evalView.setRating("7");
    	presenter.start();
      	presenter.evaluate();
      	presenter.setReservation(res2);
        evalView.setRating("8");
    	presenter.start();
      	presenter.evaluate();
      	presenter.setReservation(res3);
        evalView.setRating("9");
    	presenter.start();
      	presenter.evaluate();
      	Assert.assertEquals(7, cruise.getEvaluations());
        Assert.assertEquals(1,allEvaluations);
    	Assert.assertTrue(evalView.getInfoCount()>0);
	}

}

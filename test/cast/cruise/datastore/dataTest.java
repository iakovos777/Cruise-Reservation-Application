package cast.cruise.datastore;

import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



import cast.cruise.contacts.Address;
import cast.cruise.contacts.EmailAddress;
import cast.cruise.domain.Cruise;
import cast.cruise.domain.Evaluation;
import cast.cruise.domain.Host;
import cast.cruise.domain.Reservation;
import cast.cruise.domain.User;
import cast.cruise.memory.CruiseMemory;
import cast.cruise.memory.DataMemory;
import cast.cruise.memory.EvaluationMemory;
import cast.cruise.memory.HostMemory;
import cast.cruise.memory.ReservationMemory;
import cast.cruise.memory.UserMemory;
import cast.cruise.util.SimpleCalendar;

public class dataTest{
	private HostDS hostDs;
	private UserDS userDs;
	private CruiseDS cruiseDs;
	private ReservationDS reservationDs;
	private EvaluationDS evaluationDs;
	
	
	private static final int INITIAL_HOST_COUNT = 2;
	private static final int INITIAL_USER_COUNT = 2;
	private static final int INITIAL_CRUISE_COUNT = 2;
	
	private static final int ITEM_NEW_EVALUATION=0;
	private static final int INITIAL_EVALUATION_COUNT=0;
	private static final int INITIAL_RESERVATION_COUNT=0;
	
	@Before
    public void setUp() {                
    	Data dataHelper = new DataMemory();
    	dataHelper.readData();
        hostDs = new HostMemory();
        userDs = new UserMemory();
        cruiseDs = new CruiseMemory();
        reservationDs = new ReservationMemory();
        evaluationDs = new EvaluationMemory();
    }
	
	
	@Test
	public void findExistingHost(){
		Host host = hostDs.find(2);
		Assert.assertEquals("Crystal",host.getCompanyName());
	}
	
	@Test
	public void findNonExistingHost(){
		Host host = hostDs.find(4711);
		Assert.assertNull(host);
	}
	
	
	
	@Test
	public void listAllHost(){
		List<Host> allHosts = hostDs.findAll();
		Assert.assertEquals(INITIAL_HOST_COUNT,allHosts.size());
	}
	
	
	@Test
	public void saveHost(){
		hostDs = new HostMemory();
		EmailAddress email = new EmailAddress("louis@gmail.com");
		Address address = new Address();
		address.setCity("Athens");
		address.setStreet("Strournari");
		address.setCountry("Greece");
		address.setNumber("12");
		address.setZipCode("12231");
		Host host = new Host(5000,"Louis",address,email,"1453");
		hostDs.save(host);
		Assert.assertEquals(INITIAL_HOST_COUNT+1,hostDs.findAll().size());
		Assert.assertNotNull(hostDs.find(host.getHostId()));
		Assert.assertTrue(hostDs.findAll().contains(host));
		
	}
	
	
	
	
	@Test
	public void deleteHost(){
		List<Host> allHosts = hostDs.findAll();
		Host host = allHosts.get(0);
		hostDs.delete(host);
		allHosts = hostDs.findAll();
		Assert.assertEquals(INITIAL_HOST_COUNT-1,allHosts.size());
		Assert.assertNull(hostDs.find(host.getHostId()));
		
		
	}
	
	@Test
	public void findExistingUser(){
		User user = userDs.find(2);
		Assert.assertEquals("Petropoulos",user.getLastName());
	}
	
	@Test
	public void findNonExistingUser(){
		User user = userDs.find(4711);
		Assert.assertNull(user);
	}
	
	
	
	
	@Test
	public void listAllUser(){
		List<User> allUsers = userDs.findAll();
		Assert.assertEquals(INITIAL_USER_COUNT,allUsers.size());
	}
	
	
	
	@Test
	public void saveUser(){
		User user = new User(3,"Stefanos","Baloutas",2109877,null,null,null,"1821");
		userDs.save(user);
		Assert.assertEquals(INITIAL_USER_COUNT+1,userDs.findAll().size());
		Assert.assertNotNull(userDs.find(user.getUserId()));
		Assert.assertTrue(userDs.findAll().contains(user));
		
	}
	
	
	
	
	@Test
	public void deleteUser(){
		List<User> allUsers = userDs.findAll();
		User user = allUsers.get(0);
		userDs.delete(user);
		allUsers = userDs.findAll();
		Assert.assertEquals(INITIAL_USER_COUNT-1,allUsers.size());
		Assert.assertNull(userDs.find(user.getUserId()));
			
	}
	
	
	@Test
	public void findExistingCruise(){
		int EXPECTED_CRUISE= 1;
		
		Cruise cruise = cruiseDs.find(1);
		Assert.assertEquals(EXPECTED_CRUISE,cruise.getCruiseId());
	}
	
	
	
	@Test
	public void ListAllCruise(){
		List<Cruise> allCruises= cruiseDs.findAll();
		Assert.assertEquals(INITIAL_CRUISE_COUNT,allCruises.size());
	}
	
	@Test
	public void setEvaluation(){
		Evaluation evaluation = new Evaluation();
		evaluation.setEvalId(1);
		evaluationDs.save(evaluation);
		List<Evaluation> allevaluations= evaluationDs.findAll();
		Assert.assertEquals(INITIAL_EVALUATION_COUNT+1,allevaluations.size());
		Assert.assertNotNull(evaluationDs.find(ITEM_NEW_EVALUATION+1));
	}
	
	
	@Test
	public void findNonExistingReservation(){
		Reservation reservation = reservationDs.find(4711);
		Assert.assertNull(reservation);
	}
	
	@Test
	public void listAllReservation(){
		List<Reservation> allReservations = reservationDs.findAll();
		Assert.assertEquals(INITIAL_RESERVATION_COUNT,allReservations.size());
	}
	
	
	@Test
	public void saveReservation(){
		SimpleCalendar d = new SimpleCalendar(2017,5,14);
        Cruise cr = new Cruise();
        User u1 = new User();
		Reservation reservation = new Reservation(d,cr,2,u1);
		reservationDs.save(reservation);
		Assert.assertEquals(INITIAL_RESERVATION_COUNT+1,reservationDs.findAll().size());
		Assert.assertNotNull(reservationDs.find(reservation.getReservationId()));
		Assert.assertTrue(reservationDs.findAll().contains(reservation));
		
	}
	

	
	
	
	
	
}
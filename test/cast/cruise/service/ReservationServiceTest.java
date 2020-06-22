package cast.cruise.service;


import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cast.cruise.datastore.Data;
import cast.cruise.datastore.ReservationDS;
import cast.cruise.domain.CruiseState;
import cast.cruise.domain.Reservation;
import cast.cruise.memory.DataMemory;
import cast.cruise.memory.ReservationMemory;
import cast.cruise.exception.*;


public class ReservationServiceTest {

	@Before
    public void setUp()  {        
        Data dataHelper = new DataMemory();
        dataHelper.readData();
    }


    @Test(expected=CruiseException.class)
    public void noBorrower() {
        ReservationService resService = new ReservationService();
        resService.findUser(99999);
        resService.reserve(1,1);
    }
    
    
    @Test
    public void testReserve() {
        ReservationService resService = new ReservationService();
        resService.findUser(1);
        Assert.assertNotNull(resService.reserve(1,1));
        
        ReservationDS resds = new ReservationMemory();
        List<Reservation> resList= resds.findAll();
        Reservation reserve = resList.get(0);
        
        Assert.assertTrue(reserve.isPrePaidValid());
        Assert.assertEquals(1, reserve.getPositionsReserved());
        Assert.assertEquals(CruiseState.AVAILABLE, reserve.getCruise().getState());
        
        
    }
    
    @Test
    public void reserveMemoryDataBase() {        
        ReservationService resService = new ReservationService();
        resService.findUser(1);
        
        Assert.assertNotNull(resService.reserve(1,1));
        Assert.assertNotNull(resService.reserve(2,1));
           
    }    

}

package cast.cruise.service;




import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cast.cruise.datastore.CruiseDS;
import cast.cruise.datastore.Data;
import cast.cruise.datastore.EvaluationDS;
import cast.cruise.datastore.ReservationDS;
import cast.cruise.domain.Cruise;

import cast.cruise.domain.Evaluation;
import cast.cruise.domain.Reservation;
import cast.cruise.memory.CruiseMemory;
import cast.cruise.memory.DataMemory;
import cast.cruise.memory.EvaluationMemory;
import cast.cruise.memory.ReservationMemory;

import cast.cruise.exception.*;


public class EvaluationServiceTest {

	@Before
    public void setUp() {
        Data dataHelper = new DataMemory();
        dataHelper.readData();
    }

   
    
    @Test(expected=CruiseException.class)
    public void evaluateWhenNoReserveExist() {
        EvaluationService service = new EvaluationService();
        service.evaluate();
    }
    
    
    @Test
    public void confirmEvaluation() {
               
        EvaluationService service = new EvaluationService();
        
        Reservation res = new Reservation();
        Cruise cr = new Cruise();
        CruiseDS crds = new CruiseMemory();
        cr=crds.find(1);
        cr.start();
        cr.finish();
        res.setCruise(cr);
        ReservationDS resds = new ReservationMemory();
        res.setReservationId(1);
        resds.save(res);
        
        service.findReserve(1);
        service.findUser(1);
        service.evaluate(); 
        EvaluationDS evalds = new EvaluationMemory();
        
        List<Evaluation> evalList = evalds.findAll();                
        
        Assert.assertTrue(evalList.size()>0);      
        
            
    }
    
     
    
    


    
    
   

}

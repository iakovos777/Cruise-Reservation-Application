package cast.cruise.service;


import cast.cruise.datastore.EvaluationDS;
import cast.cruise.datastore.ReservationDS;
import cast.cruise.datastore.UserDS;


import cast.cruise.domain.Evaluation;
import cast.cruise.domain.Reservation;
import cast.cruise.domain.User;
import cast.cruise.exception.CruiseException;

import cast.cruise.memory.EvaluationMemory;
import cast.cruise.memory.ReservationMemory;
import cast.cruise.memory.UserMemory;

public class EvaluationService {
	private User user;
	private Reservation res;

    
    public Boolean findUser(int userNo) {
        UserDS userdata = new UserMemory();
        user = userdata.find(userNo);
        return user != null;
    }
    
    public Boolean findReserve(int resNo){
    	ReservationDS resdata = new ReservationMemory();
    	res = resdata.reservesCruiseEnd(resNo);
    	if(res==null){
    		return false;
    	}
    	else
    		return res!=null;
    }
    
    public Evaluation evaluate(){
    	
    	if (user == null) {
            throw new CruiseException();
        }
    	if(res==null){
    		throw new CruiseException();
    	}
        if(!res.canEvaluate()){
        	return null;
        }
        
        
        
       
        
        
        Evaluation evaluation = res.eval();
        EvaluationDS evaldata = new EvaluationMemory();
        evaldata.save(evaluation);        
        return evaluation;
        
    }

}

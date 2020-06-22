package cast.cruise.service;




import cast.cruise.datastore.CruiseDS;
import cast.cruise.datastore.ReservationDS;
import cast.cruise.datastore.UserDS;
import cast.cruise.domain.Cruise;
import cast.cruise.domain.CruiseState;
import cast.cruise.domain.Reservation;
import cast.cruise.domain.User;
import cast.cruise.exception.CruiseException;
import cast.cruise.memory.CruiseMemory;
import cast.cruise.memory.ReservationMemory;
import cast.cruise.memory.UserMemory;
import cast.cruise.util.SimpleCalendar;

public class ReservationService {
	private User user;

    
    public Boolean findUser(int userNo) {
        UserDS userdata = new UserMemory();
        user = userdata.find(userNo);
        return user != null;
    }

    
    public SimpleCalendar reserve(int cruiseNo,int pos) {
    	        
    	
         if (user == null) {
            throw new CruiseException();
        }
        if(pos==0){
        	return null;
        }
        CruiseDS cruiseds = new CruiseMemory();
        Cruise cruise = cruiseds.find(cruiseNo);
        if(cruise.getPositions()<pos){
        	return null;
        }
        if (cruise.getState()!=CruiseState.AVAILABLE) {
            return null;
        }
        
        Reservation reserve = cruise.reserveCruise(user,pos);
        SimpleCalendar rd = new SimpleCalendar(2017,6,13);
        reserve.setReservationDate(rd);
        
        ReservationDS reserveds = new ReservationMemory();
        reserveds.save(reserve);
        return reserve.getFinalDay() ;
    }

}

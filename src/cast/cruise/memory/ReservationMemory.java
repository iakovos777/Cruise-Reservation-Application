package cast.cruise.memory;

import java.util.ArrayList;
import java.util.List;



import cast.cruise.datastore.ReservationDS;
import cast.cruise.domain.Cruise;
import cast.cruise.domain.CruiseState;
import cast.cruise.domain.Reservation;
import cast.cruise.domain.User;

public class ReservationMemory implements ReservationDS {
	
	protected static List<Reservation> entities = new ArrayList<Reservation>();
	
	 @Override
	public Reservation find(int reserveNo) {
		for(Reservation reserve : entities) {
            if (reserve.getReservationId() == reserveNo ) {
                return reserve;
            }
        }
		
		return null;
	}
	 
	 @Override
	 public Reservation reservesWithSameUser(int reserveNo, User u) {
			
		 for(Reservation reserve : entities) {
	            if (reserve.getReservationId() == reserveNo &&
	            		reserve.getUser().equals(u)) {
	                return reserve;
	            }
	        }
		return null;
	}
	 
	 @Override
	 public Reservation reservesWithSameCruise(int reserveNo,Cruise c) {
			
		 for(Reservation reserve : entities) {
	            if (reserve.getReservationId() == reserveNo &&
	            		reserve.getCruise().equals(c)) {
	                return reserve;
	            }
	        }
		return null;
	}
	 

	@Override
	public Reservation reservesCruiseEnd(int reserveNo) {
		
		 for(Reservation reserve : entities) {
	            if (reserve.getReservationId() == reserveNo &&
	            		reserve.getCruise().getState().equals(CruiseState.FINISH)) {
	                return reserve;
	            }
	        }
		return null;
	}

	@Override
	public void save(Reservation entity) {
		if (! entities.contains(entity)) {
            entities.add(entity);    
        } 

	}

	@Override
	public void delete(Reservation entity) {
		entities.remove(entity);

	}

	@Override
	public List<Reservation> findAll() {
		return new ArrayList<Reservation>(entities);
	}
	
	@Override
	public List<Reservation> findWithSameUser(User u) {
		List<Reservation> allReserves = findAll();
        List<Reservation> reserveUser = new ArrayList<Reservation>();
        
        for(Reservation reserve : allReserves) {
            if (reserve.getUser()==u) {
            	reserveUser.add(reserve);
            }
        }
        
        return reserveUser;
	}
	
	@Override
	public List<Reservation> findWithSameCruise(Cruise c) {
		List<Reservation> allReserves = findAll();
        List<Reservation> reserveCruise = new ArrayList<Reservation>();
        
        for(Reservation reserve : allReserves) {
            if (reserve.getCruise()==c) {
            	reserveCruise.add(reserve);
            }
        }
        
        return reserveCruise;
	}

	@Override
	public List<Reservation> reservesFindAllCruiseEnd() {
		List<Reservation> allReserves = findAll();
        List<Reservation> cruiseEnd = new ArrayList<Reservation>();
        
        for(Reservation reserve : allReserves) {
            if (reserve.getCruise().getState().equals(CruiseState.FINISH)) {
            	cruiseEnd.add(reserve);
            }
        }
        
        return cruiseEnd;
		
	}

}

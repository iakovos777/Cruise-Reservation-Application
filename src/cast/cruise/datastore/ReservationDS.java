package cast.cruise.datastore;

import java.util.List;

import cast.cruise.domain.Cruise;
import cast.cruise.domain.Reservation;
import cast.cruise.domain.User;

public interface ReservationDS {
	Reservation find(int reserveNo);
    Reservation reservesCruiseEnd(int reserveNo);
    Reservation reservesWithSameUser(int reserveNo,User u);
    Reservation reservesWithSameCruise(int reserveNo,Cruise c);
    
    void save(Reservation entity);
    
    
    void delete(Reservation entity);
    
    
    List<Reservation> findAll();
    List<Reservation> reservesFindAllCruiseEnd();
    List<Reservation> findWithSameCruise(Cruise c);
    List<Reservation> findWithSameUser(User u);
}

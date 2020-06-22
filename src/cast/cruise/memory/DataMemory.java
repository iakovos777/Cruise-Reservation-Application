package cast.cruise.memory;

import java.util.List;

import cast.cruise.datastore.*;
import cast.cruise.domain.*;

public class DataMemory extends Data {

	@Override
	protected void eraseData() {
		List<Cruise> cruises = getCruiseDS().findAll();        
        for(Cruise cruise : cruises) {
            getCruiseDS().delete(cruise);
        }
        List<Host> hosts = getHostDS().findAll();        
        for(Host host : hosts) {
            getHostDS().delete(host);
        }
        List<Reservation> reserves = getReservationDS().findAll();        
        for(Reservation reserve : reserves) {
            getReservationDS().delete(reserve);
        }
        List<User> users = getUserDS().findAll();        
        for(User user : users) {
            getUserDS().delete(user);
        }
        List<Evaluation> evaluate = getEvaluationDS().findAll();        
        for(Evaluation eval : evaluate) {
            getEvaluationDS().delete(eval);
        }

	}

	@Override
	protected CruiseDS getCruiseDS() {
		return new CruiseMemory();
		
	}

	@Override
	protected HostDS getHostDS() {
		return new HostMemory();
		
	}

	@Override
	protected UserDS getUserDS() {
		return new UserMemory();
		
	}

	@Override
	protected ReservationDS getReservationDS() {
		return new ReservationMemory();
	}

	@Override
	protected EvaluationDS getEvaluationDS() {
		return new EvaluationMemory();
	}

}

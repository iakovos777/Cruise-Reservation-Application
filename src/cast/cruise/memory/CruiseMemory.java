package cast.cruise.memory;

import java.util.ArrayList;
import java.util.List;

import cast.cruise.datastore.CruiseDS;
import cast.cruise.domain.Cruise;
import cast.cruise.domain.Host;




public class CruiseMemory implements CruiseDS {
	protected static List<Cruise> entities = new ArrayList<Cruise>();
	@Override
	public Cruise find(int cruiseNo) {
		for(Cruise cruise : entities) {
            if (cruise.getCruiseId() == cruiseNo ) {
                return cruise;
            }
        }
		return null;
	}

	@Override
	public void save(Cruise entity) {
		if (! entities.contains(entity)) {
            entities.add(entity);    
        } 

	}

	@Override
	public void delete(Cruise entity) {
		entities.remove(entity);

	}

	@Override
	public List<Cruise> findAll() {
		return new ArrayList<Cruise>(entities);
	}

	@Override
	public Cruise findWithSameHost(int cruiseNo, Host h) {
		 for(Cruise cruise : entities) {
	            if (cruise.getCruiseId() == cruiseNo &&
	            		cruise.getHost().equals(h)) {
	                return cruise;
	            }
	        }
		return null;
	}

	@Override
	public List<Cruise> findWithHost(Host h) {
		List<Cruise> allReserves = findAll();
        List<Cruise> cruiseHost = new ArrayList<Cruise>();
        
        for(Cruise cruise : allReserves) {
            if (cruise.getHost()==h) {
            	cruiseHost.add(cruise);
            }
        }
        
        return cruiseHost;
	}

}

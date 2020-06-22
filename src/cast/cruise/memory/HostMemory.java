package cast.cruise.memory;

import java.util.ArrayList;
import java.util.List;



import cast.cruise.datastore.HostDS;
import cast.cruise.domain.Host;


public class HostMemory implements HostDS {
	 protected static List<Host> entities = new ArrayList<Host>();
	
	@Override
	public Host find(int hostNo) {
		for(Host host : entities) {
            if (host.getHostId() == hostNo ) {
                return host;
            }
        }
        return null;
    
	}
	
	@Override
	public Host login(String compname, String pwd){
		for(Host host : entities) {
            if ((host.getCompanyName().equals(compname))&&( host.getPwd().equals(pwd) )){
            	
            		return host;
            	
            }
        }
		
        return null;
	}

	@Override
	public void save(Host entity) {
		if (! entities.contains(entity)) {
            entities.add(entity);    
        } 

	}

	@Override
	public void delete(Host entity) {
		entities.remove(entity);

	}

	@Override
	public List<Host> findAll() {
		return new ArrayList<Host>(entities);
	}

	

}

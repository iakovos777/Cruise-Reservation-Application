package cast.cruise.datastore;
import java.util.List;
import cast.cruise.domain.Cruise;
import cast.cruise.domain.Host;


public interface CruiseDS {
	
	Cruise find(int cruiseNo);
    Cruise findWithSameHost(int cruiseNo, Host h);
    
    void save(Cruise entity);
    
    
    void delete(Cruise entity);
    
   
    List<Cruise> findAll();
    List<Cruise> findWithHost(Host h);

}

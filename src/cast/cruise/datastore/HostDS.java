package cast.cruise.datastore;

import java.util.List;

import cast.cruise.domain.Host;

public interface HostDS {
	Host find(int hostNo);
    
    Host login(String compname, String pwd);
    
    void save(Host entity);
    
    
    void delete(Host entity);
    
   
    List<Host> findAll();

}

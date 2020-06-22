package cast.cruise.ui.host;



import cast.cruise.datastore.HostDS;
import cast.cruise.domain.Host;

import cast.cruise.memory.HostMemory;


public class HostLoginPresenter {
	private HostLoginView view;
    private boolean hostExist;
    private Host host;
    private HostDS hostds;
    
   
    public HostLoginPresenter(HostLoginView view) {
        this.view = view;
        hostds = new HostMemory();
    }
    
   
    public boolean ishostExist() {
        return hostExist;
    }
    
    
    public Host getHost() {
        return host;
    }
    
   
    public void start() {
        view.setPresenter(this);
        view.open();       
    }
    
    
    public void cancel() {
        view.close();
    }
    
   
    public boolean verifyHost() {
        host = hostds.login(view.getCompanyName(), view.getPwd());
        
        if (host==null) {
            hostExist = false;
            view.showError("Host not found");
            
        } else {
        	hostExist = true;
            view.showInfo("Successful login");
        }
         return hostExist;  
    } 
    
    
          
	

}

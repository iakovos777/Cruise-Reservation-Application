package cast.cruise.ui.host;

import cast.cruise.contacts.Address;
import cast.cruise.datastore.HostDS;
import cast.cruise.domain.Host;

import cast.cruise.memory.HostMemory;

public class NewHostPresenter {
	private NewHostView view;
    private Host host = new Host();
    private HostDS hostds;
    private boolean idCommon;
    
    public NewHostPresenter(NewHostView view) {
        this.view = view;
        hostds = new HostMemory();
    }


    public void setHost(Host host) {
        this.host = host;
        
    }
    
    public boolean IdCommon(){
    	return idCommon;
    }


    public Host getHost() {
        return host;
    }
    
    public void start() {
        view.setPresenter(this);
        
        view.open();
        
    }
    
    
   
    
    public void save() {
    	int id  = view.getHostId();
    	Host u = new Host();
    	
    	u = hostds.find(id);
    	if(u==null){
    		host.setHostId(id);
    		host.setCompanyName(view.getCompanyName());
    		Address a = view.getCompanyAddress();
    		
    		if(a!=null){
    			host.setCompanyAddress(a);
    			
    			host.setCompanyEmail(view.getCompanyEmail());
    			host.setPwd(view.getPwd());
    			idCommon = false;
    			hostds.save(host);
    			
    		}
    		else{
    			idCommon = true;
    			view.showError("Invalid address.You must insert street,number,city,Zip code,country");
    		}
    	}
    	else{
    		idCommon = true;
    		view.showError("Host id must be unique!");
    	}
    }
    
    public void cancel() {
        view.close();
    }
}

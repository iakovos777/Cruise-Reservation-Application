package cast.cruise.ui.host;


import java.util.List;

import cast.cruise.datastore.CruiseDS;
import cast.cruise.domain.Cruise;
import cast.cruise.domain.Host;
import cast.cruise.memory.CruiseMemory;
import cast.cruise.ui.ViewRegistry;

import cast.cruise.ui.cruise.CruisePresenter;
import cast.cruise.ui.cruise.CruiseView;

public class CruiseListHostPresenter {
	private CruiseListHostView view;
    private List<Cruise> cruises;
   
    private CruiseDS cruiseds;
    private Host host =  new Host();
    
    public CruiseListHostPresenter(CruiseListHostView view) {
        this.view = view;
        cruiseds = new CruiseMemory();
    }
    
    public void start() {
        view.setPresenter(this);
        getCruiseList();
        view.open();
    }

	private void getCruiseList() {
		cruises = cruiseds.findWithHost(getHost());
		
		view.setCruises(cruises);	
	}
	
	
    
    public List<Cruise> getCruises() {
    	
    	return cruises;
    }
    
    public void editSelected() {
        CruiseView cruiseView = ViewRegistry.getCruiseView();
        CruisePresenter cruisePresenter = new  CruisePresenter(cruiseView);
        cruisePresenter.setCruise(view.getSelectedCruise());
        cruisePresenter.start();
        refresh();
    }
    
    public void addCruise() {
    	CruiseView cruiseView = ViewRegistry.getCruiseView();
    	CruisePresenter cruisePresenter = new  CruisePresenter(cruiseView);
    	cruisePresenter.setCruise(new Cruise());
    	cruisePresenter.setHost(getHost());
        cruisePresenter.start();
        refresh();
    }
    
   
    
    public void cancel(){
    	view.close();
    }
    public void refresh() {
        getCruiseList();
    }
    
    public void setHost(Host host){
    	this.host = host;
    }
	public Host getHost() {
		
		return host;
	}

}

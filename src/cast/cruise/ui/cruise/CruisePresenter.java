package cast.cruise.ui.cruise;


import cast.cruise.datastore.CruiseDS;
import cast.cruise.domain.Cruise;
import cast.cruise.domain.Host;
import cast.cruise.memory.CruiseMemory;

public class CruisePresenter {
	private CruiseView view;
    private Cruise cruise = new Cruise();
    private CruiseDS cruiseds;
    private Host host = new Host();
    
    public CruisePresenter(CruiseView view) {
        this.view = view;
        cruiseds = new CruiseMemory();
    }


    public void setCruise(Cruise cruise) {
        this.cruise = cruise;
        if(cruise != null){
        	updateView();
        }
    }


    public Cruise getCruise() {
        return cruise;
    }
    
    public void start() {
        view.setPresenter(this);
        updateView();
        view.open();
        
    }
    
    public void setHost(Host host){
    	this.host = host;
    }
  
    private Host getHost(){
    	return host;
    }
    
    private void updateView() {
    	view.setCruiseId(cruise.getCruiseId());
        view.setPositions(cruise.getPositions());
        view.setDepartureDate(cruise.getDepartureDate());
        view.setArrivalDate(cruise.getArrivalDate());
        view.setStart(cruise.getStart());
        view.setDestination(cruise.getDestination());
        view.setEmail(cruise.getEmail());
        view.setDescription(cruise.getDescription());
        view.setDuration(cruise.getDuration());
        view.setCost(cruise.getCost());        
        view.setPrePaidAll(cruise.getPrePaidAll());
        view.setPrePaidAmount(cruise.getPrePaidAmount());
    }
    
    public void save() {
    	
    	cruise.setCruiseId(view.getCruiseId());
    	cruise.setPositions(view.getPositions());
    	cruise.setDepartureDate(view.getDepartureDate());
    	cruise.setArrivalDate(view.getArrivalDate());
    	cruise.setStart(view.getStart());
    	cruise.setDestination(view.getDestination());
    	cruise.setEmail(view.getEmail());
    	cruise.setDescription(view.getDescription());
    	cruise.setDuration(view.getDuration());
    	cruise.setCost(view.getCost()); 
    	cruise.setHost(getHost());
    	cruise.setPrePaidAll(view.getPrePaidAll());
    	cruise.setPrePaidAmount(view.getPrePaidAmount());
        
    	getHost().addCruise(cruise);
    	cruiseds.save(cruise);
        view.close();
    }
    
    
    
    public void cancel() {
        view.close();
    }
    
}

package cast.cruise.ui.user;

import java.util.List;


import cast.cruise.datastore.CruiseDS;
import cast.cruise.datastore.ReservationDS;

import cast.cruise.domain.Cruise;

import cast.cruise.domain.Reservation;
import cast.cruise.domain.User;
import cast.cruise.memory.CruiseMemory;
import cast.cruise.memory.ReservationMemory;


public class CruiseListUserPresenter {
	private CruiseListUserView view;
    private List<Cruise> cruises;
    private CruiseDS cruiseds;
   
    private User user = new User();
    private ReservationDS resds;
    
    public CruiseListUserPresenter(CruiseListUserView view) {
        this.view = view;
        cruiseds = new CruiseMemory();
        resds = new ReservationMemory();
    }
    
    public void start() {
        view.setPresenter(this);
        getCruiseList();
        view.open();
        
    }
    
    

	private void getCruiseList() {
		cruises = cruiseds.findAll();
        view.setCruises(cruises);
	}
    
    public List<Cruise> getCruises() {
        return cruises;
    }
    
   
    
    
    
    
    public void setUser(User user) {
		this.user=user;
		
	}
    
    public User getUser(){
    	return user;
    }
    
  
    
    public boolean reservation(){
    	int p = view.getPositions();
    	boolean isFill;
    	if(p==0){
    		
    		isFill = false;
    		view.setPositions(0);
    		
    		
    	}          
         else {
        	 
            isFill = true;
            view.setPositions(p);
             
            
        }

    	Cruise cruise = view.getSelectedCruise();
    	
    	if(cruise == null){
    		view.showError("You don't select a cruise for reservation");
    		return false;
    	}
    	if(!isFill){
    		view.showError("Positions are equal to zero");
    		return false;
    	}
    	if(view.getPositions()>cruise.getPositions()){
    		view.showError("You request more positions that it is available for this cruise ");
    		return false;
    	}
    	else{
    		
    		
    		if(String.valueOf(cruise.getState()).equals("AVAILABLE")){
    			user = this.getUser();
    			if(user==null){
    				view.showError("There is no user");
    				return false;
    			}
    			
    			
    			Reservation res = cruise.reserveCruise(user, view.getPositions());
    			
    			if(res==null){
    				view.showError("Problem with reservation "+String.valueOf(cruise.getState()));
    			
    				return false;
    			}
    			else{
    				
    				
    				resds.save(res);
    				view.showInfo("Successful reservation");
    				
    				return true;
    			}
    		}
    		else{
    			view.showError("You cannot make a reservation for this cruise");
    			return false;
    		}
    	}
    }
    
    public void refresh(){
    	getCruiseList();
    }
    
    public void cancel(){
    	view.close();
    }
    
}

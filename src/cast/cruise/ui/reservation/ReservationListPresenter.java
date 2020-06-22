package cast.cruise.ui.reservation;

import java.util.List;



import cast.cruise.datastore.ReservationDS;
import cast.cruise.domain.Cruise;
import cast.cruise.domain.Reservation;
import cast.cruise.domain.User;
import cast.cruise.memory.ReservationMemory;
import cast.cruise.ui.ViewRegistry;

public class ReservationListPresenter {
	private ReservationListView view;
    private List<Reservation> reserves;
    private ReservationDS reserveds;
    private Reservation res;
    private User user = new User();
    
    public ReservationListPresenter(ReservationListView view) {
        this.view = view;
        reserveds = new ReservationMemory();
    }
    
    public void start() {
        view.setPresenter(this);
        getReservationList();
        view.open();
    }

	private void getReservationList() {
		reserves = reserveds.findWithSameUser(this.getUser());
        view.setReservations(reserves);
	}
    
    public List<Reservation> getReservations() {
        return reserves;
    }
    
   
    public void evaluate(){
    	if(view.getSelectedReserve().canEvaluate()){
    		EvaluationView evalView = ViewRegistry.getEvaluationView();
    		EvaluationPresenter evalPresenter = new  EvaluationPresenter(evalView);
    		evalPresenter.setReservation(view.getSelectedReserve());
    		evalPresenter.start();
    	}
    	else{
    		view.showError("You cannot evaluate for this reservation because cruise isn't finished");
    	}
    }
   
    public void pay(){
    	res = view.getSelectedReserve();
    	if(res.getHasPrePay()==true){
    		if(res.getHasPay()==false){
    			if(res.isPaidValid()){
    				res.setHasPay(true);
    				view.showInfo("Successful  payment");
    			}
    			else{
    				res.setHasPay(false);
    				view.showError("You cannot  pay. Your reservation has canceled");
    				res.cancelation();
    				reserveds.delete(res);
    				refresh();
    			}
    		}
    		else{
    			view.showInfo("You have already pay ");
    		}
    	}
    	else{
    		view.showError("You cannot  pay. You must first pre pay ");
    	}
    	
    }
    
    public void prePay(){
    	res = view.getSelectedReserve();
    	if(res==null){
    		view.showError("You don't select a reservation");
    		
    	}
    	else{
    		Cruise cruise = res.getCruise();
    		
    		if(res.getHasPrePay()==false){
    			
    			if(cruise.getPrePaidAmount()>0){
    				
    				if(res.isPrePaidValid()){
    					res.setHasPrePay(true);
    					view.showInfo("Successful pre payment");
    					if(cruise.getPrePaidAll()){
    						res.setHasPay(true);
    					}
    				}
    				else{
    					res.setHasPrePay(false);
    					view.showError("You cannot pre pay. Your reservation has canceled");
    					res.cancelation();
    					reserveds.delete(res);
    					refresh();
    				}
    			}
    			else{
    				view.showInfo("It is not need to be pre pay");
    				res.setHasPrePay(true);
    			}
    		}
    		else{
    			view.showInfo("You have already pre-pay ");
    		}
    	}
    }
    
    public void cancel(){
    	view.close();
    }
    public void refresh() {
        getReservationList();
    }

	public void setUser(User user) {
		this.user = user;
		
	}
	public User getUser(){
		return user;
	}
   
}

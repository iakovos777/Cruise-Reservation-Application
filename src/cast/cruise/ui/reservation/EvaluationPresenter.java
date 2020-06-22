package cast.cruise.ui.reservation;





import cast.cruise.datastore.EvaluationDS;
import cast.cruise.domain.Cruise;
import cast.cruise.domain.Evaluation;
import cast.cruise.domain.Reservation;
import cast.cruise.memory.EvaluationMemory;

public class EvaluationPresenter {
	private EvaluationView view;
    
    private Evaluation eval ;
    private Reservation res ;
    private EvaluationDS evalds;


    public EvaluationPresenter( EvaluationView view) {
        this.view = view;
       evalds = new  EvaluationMemory();
    }

   
    
   
    
    
   
    public void start() {
        view.setPresenter(this);
        view.open();       
    }
    
    public void setReservation(Reservation reserve) {
        this.res = reserve;
        
    }


    public Reservation getReservation() {
        return res;
    }
    
    
    public void cancel() {
        view.close();
    }
    
   
    public void evaluate() {
    	res = getReservation();
    	
    	eval = res.getEvaluation();
    	
    	int rate =Integer.parseInt(view.getRating());
    	
    	if(view.getRating()!=null){
    		
    		eval.setRating(rate);
    		if(view.getComment()!=null){
    			eval.setComment(view.getComment());
    		}
    		
    		Cruise cruise = res.getCruise();
    		if(res.canEvaluate()){
    			
    			
    			if(res.getEvaluation()==null){
    				res.getEvaluation().setHasEvaluated(true);
    				
    				res.setEvaluation(eval);
    				evalds.save(eval);
    				cruise.getEvaluations();
    				view.showInfo("Successful evaluation");
    				view.close();
    			}
    			else{
    				if(res.getEvaluation().getHasEvaluated()==true){
    					view.showError("You already have evaluated for this cruise");
    					view.close();
    				}
    				else{
    					res.getEvaluation().setHasEvaluated(true);
        				
        				res.setEvaluation(eval);
        				evalds.save(eval);
        				cruise.getEvaluations();
        				view.showInfo("Successful evaluation");
        				view.close();
    				}
    			}
    		}
    		else{
    			view.showError("You cannot evaluate for this reservation because cruise isn't finished");
    		}
    	}else{
    		view.showError("You must rate the cruise");
    	}
    	
    }
}

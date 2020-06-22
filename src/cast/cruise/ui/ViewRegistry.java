package cast.cruise.ui;

import cast.cruise.ui.cruise.CruiseJFrame;
import cast.cruise.ui.cruise.CruiseListJFrame;
import cast.cruise.ui.cruise.CruiseListView;
import cast.cruise.ui.cruise.CruiseView;
import cast.cruise.ui.host.CruiseListHostJFrame;
import cast.cruise.ui.host.CruiseListHostView;
import cast.cruise.ui.reservation.EvaluationJFrame;
import cast.cruise.ui.reservation.EvaluationView;
import cast.cruise.ui.reservation.ReservationListJFrame;
import cast.cruise.ui.reservation.ReservationListView;


public class ViewRegistry {
	private static CruiseListView cruiseListViewStub;
	private static CruiseView cruiseViewStub;
	
	
	
	
	private static EvaluationView evalViewStub;
	private static ReservationListView resListViewStub;
	
	
	private static CruiseListHostView cruiseListHostViewStub;
	
	public static void setCruiseListView(CruiseListView cruiseListView) {
		cruiseListViewStub = cruiseListView;
	}
	
	public static void setCruiseView(CruiseView cruiseView) {
		cruiseViewStub = cruiseView;
	}
	
    public static CruiseListView getCruiseListView() {
        return cruiseListViewStub == null ? new CruiseListJFrame() 
        	: cruiseListViewStub ;
    }
    
    public static CruiseView getCruiseView() {
    	return cruiseViewStub == null ? new CruiseJFrame() 
    		: cruiseViewStub;
    }

    public static void reset() {
    	cruiseListViewStub = null;
    	cruiseViewStub=null;
    }
    
    
    
    /*----------------------------------*/
    public static void setEvaluationView(EvaluationView evalView) {
		evalViewStub = evalView;
	}
	
	
	
    public static EvaluationView getEvaluationView() {
        return evalViewStub == null ? new EvaluationJFrame() 
        	: evalViewStub ;
    }
    
    public static void setReservationListView(ReservationListView resListView) {
		resListViewStub = resListView;
	}
	
	
	
    public static ReservationListView getReservationListView() {
        return resListViewStub == null ? new ReservationListJFrame() 
        	: resListViewStub ;
    }
    
  
    
   

    public static void resetForEval() {
    	evalViewStub = null;
    	resListViewStub = null;
    	
    }
    
    /*----------------------------------*/

    public static void setCruiseListHostView(CruiseListHostView cruiseListHostView) {
		cruiseListHostViewStub = cruiseListHostView;
	}
	
	
	
    public static CruiseListHostView getCruiseListHostView() {
        return cruiseListHostViewStub == null ? new CruiseListHostJFrame() 
        	: cruiseListHostViewStub ;
    }
    
  
    
   

    public static void resetForHost() {
    	cruiseListHostViewStub = null;
    	cruiseViewStub=null;
    	
    } 
    
}

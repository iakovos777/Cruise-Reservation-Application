package cast.cruise.domain;

import cast.cruise.util.SimpleCalendar;
import cast.cruise.util.SystemDate;
import cast.cruise.contacts.*;
import cast.cruise.domain.Host;
import cast.cruise.domain.User;

import java.util.HashSet;
import java.util.Set;
import cast.cruise.exception.CruiseException;

/**
 * Η κρουαζιέρα .
 */

public class Cruise{
	
	private int cruiseId;
	private int positions;
	private int cost;
	private int prePaidAmount;
	private String departureDate;
	private String arrivalDate;
	private int  duration;
	private String start;
	private String destination;
	private String description;
	private boolean prePaidAll;
	private EmailAddress infoMail;
	private Host host;
	private int evalCruise;
	private CruiseState state = CruiseState.AVAILABLE;
	
    private Set<Reservation> reserves = new HashSet<Reservation>();
	
	
	public Cruise(){}
	
	public Cruise( int cruiseId, int positions, int cost, int prePaidAmount, String departureDate, String arrivalDate, int  duration, String start, String destination, String description, boolean prePaidAll, EmailAddress infoMail, Host host, int evalCruise ){
		this.cruiseId = cruiseId;
		this.positions = positions;
		this.cost = cost;
		this.prePaidAmount = prePaidAmount;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.duration = duration;
		this.start = start;
		this.destination = destination;
		this.description = description;
		this.prePaidAll = prePaidAll;
		this.infoMail = infoMail;
		this.host = host;
		this.evalCruise = 0;
	}
	
	public void setCruiseId(int cruiseId) {
        this.cruiseId = cruiseId;
    }
	
	public void setEvalCruise(int evalCruise){
		this.evalCruise = evalCruise;
	}
	
	public int getEvalCruise(){
		return evalCruise;
	}
    
    public int getCruiseId() {
        return cruiseId;
    }
	
	public void setPositions(int positions) {
        this.positions = positions;
    }

    
    public int getPositions() {
        return positions;
    }
	
	public void setCost(int cost) {
        this.cost = cost;
    }

    
    public int getCost() {
        return cost;
    }
	
	public void setDuration(int duration) {
        this.duration = duration;
    }

    
    public int getDuration() {
        return duration;
    }
	
	public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    
    public String getDepartureDate() {
        return departureDate;
    }
	
	public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    
    public String getArrivalDate() {
        return arrivalDate;
    }
	public void setStart(String start) {
        this.start = start;
    }

    
    public String getStart() {
        return start;
    }
	
	public void setDestination(String destination) {
        this.destination = destination;
    }

    
    public String getDestination() {
        return destination;
    }
	
	public void setDescription(String description) {
        this.description = description;
    }

    
    public String getDescription() {
        return description;
    }
	
	public void setPrePaidAll(boolean prePaidAll) {
        this.prePaidAll = prePaidAll;
    }

    
    public boolean getPrePaidAll() {
        return prePaidAll;
    }
	
	public void setPrePaidAmount(int prePaidAmount) {
        this.prePaidAmount = prePaidAmount;
    }

    
    public int getPrePaidAmount() {
        return prePaidAmount;
    }
	public void setEmail(EmailAddress infoMail) {
        this.infoMail = infoMail;
    }

    
    public EmailAddress getEmail() {
        return infoMail;
    }
	
	public void setHost(Host host) {
         if (this.host != null) {
            this.host.AllCruises().remove(this);
        }
        this.host = host;
        if (this.host != null) {
            this.host.AllCruises().add(this);
        }
		
    }

    
    public Host getHost() {
        return host;
    }
	
	public CruiseState getState() {
        return state;
    }


    
    protected void setState(CruiseState state) {
        this.state = state;
    }
    
    public Set<Reservation> getReserve() {
        return new HashSet<Reservation>(reserves);
    }
	
	Set<Reservation> AllReservations() {
        return reserves;
    }
	
	
	public void State(){
		setState(this.getState());
		String date = this.getDepartureDate();
		String[] parts = date.split("/");
		int y = Integer.parseInt(parts[2]);
		int d = Integer.parseInt(parts[0]);
		int m = Integer.parseInt(parts[1]);
		SimpleCalendar date2 = new SimpleCalendar(y,m,d);
		int i = date2.compareTo(SystemDate.now());
		
		date = this.getArrivalDate();
	    parts = date.split("/");
		 y = Integer.parseInt(parts[2]);
		 d = Integer.parseInt(parts[0]);
		 m = Integer.parseInt(parts[1]);
		SimpleCalendar date3 = new SimpleCalendar(y,m,d);
		int k = date3.compareTo(SystemDate.now());
		
		if(this.getPositions()==0){
			setState(CruiseState.FULL);
		}
		if(i<=0){
			setState(CruiseState.START);
		}
		if(k<=0){
			setState(CruiseState.FINISH);
		}
		
		
	}
	
	 public Reservation reserveCruise(User user, int pos) {
        
		 
		 
		 if (user == null) {
            return null;
        }
		
		if(pos==0){
			return null;
		}
		
		this.State();
	
        if (!getState().equals(CruiseState.AVAILABLE) ) {
            return null;
        }
        
        Reservation reserve = new Reservation();
        
        
       
        reserve.setCruise(this);
        
        reserve.setUser(user);
        
        reserve.setReservationDate(SystemDate.now());
        
		reserve.setPositionsReserved(pos);
		reserve.setPayment();
		
        this.setPositions(this.getPositions()-pos);
        
        
		if(this.getPositions()==0){
			setState(CruiseState.FULL);
		}
		
		this.AllReservations().add(reserve);
		
        return reserve;
    }
	
	public void available(){
		
		 if (getState().equals(CruiseState.FULL)) {
            throw new CruiseException();
        }
        if (getState().equals(CruiseState.FINISH)) {
            throw new CruiseException();
        }
		 if (getState().equals(CruiseState.START)) {
            throw new CruiseException();
        }
		setState(CruiseState.AVAILABLE);
	}
	
	public void full(){
		setState(CruiseState.FULL);
	}
	
	public void finish(){
		if (!getState().equals(CruiseState.START)) {
            throw new CruiseException();
        }
        if (getState().equals(CruiseState.AVAILABLE)) {
            throw new CruiseException();
        }
		 
		setState(CruiseState.FINISH);
	}
	
	public void start(){
		
        if (getState().equals(CruiseState.FINISH)) {
            throw new CruiseException();
        }
		 if ((!getState().equals(CruiseState.AVAILABLE))||(getState().equals(CruiseState.FULL))) {
            throw new CruiseException();
        }
		setState(CruiseState.START);
	}
	public int countEval(){
		int countEval = 0;
		for(Reservation reserve : reserves){
			if(reserve!=null){
				if(reserve.getEvaluation()!=null){
					countEval++;
				}
			}
		}	
		return countEval;
	}
	public int getEvaluations(){
		int grade = 0;
		for(Reservation reserve : reserves){
			grade +=reserve.getEvaluation().getRating();
		}
		if(countEval()!=0){
			grade = grade/countEval();
		}
		this.setEvalCruise(grade);
		return grade;
	}
	
	@Override
    public String toString() {
        return String.valueOf(cruiseId);
    }
	
	
}



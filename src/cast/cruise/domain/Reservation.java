package cast.cruise.domain;
import cast.cruise.util.SimpleCalendar;
import cast.cruise.util.SystemDate;
import cast.cruise.exception.CruiseException;
import cast.cruise.domain.Evaluation;
import cast.cruise.domain.Payment;
import cast.cruise.domain.User;
/**
 * Η κράτηση.
 */
public class Reservation{
	private static int count = 0;
	private int reservationId;
	private SimpleCalendar reserveDate = SystemDate.now();
	private int positionsReserved;
	private Cruise cruise;
	private User user;
	private boolean hasPay;
	private boolean hasPrePay;
	private Payment pay = new Payment();
	private Evaluation eval = new Evaluation() ;
	
	
	
	public Reservation(){
		this.reservationId= count++;
		this.hasPay = false;
		this.hasPrePay =  false;
	}

	public Reservation(SimpleCalendar reserveDate,Cruise cruise,int positionsReserved,User user){
		this.reserveDate = reserveDate;
		this.cruise = cruise;
		if(this.getCruise().getPositions()>=this.positionsReserved){
			this.positionsReserved = positionsReserved;
			
		}
		else{
			throw new CruiseException("There aren't so many available positions for the cruise!!!");
		}
		
		this.user = user;
		this.reservationId= count++;
		pay.setAmount(this.cruise.getCost());
		pay.setPrePaidAll(this.cruise.getPrePaidAll());
		pay.setFinalDayPrePayment(getFinalDay());
		pay.setPrePaidAmmount(this.cruise.getPrePaidAmount());
		this.hasPay = false;
		this.hasPrePay =  false;
	}	
	
	
	public Payment getPayment(){
		return pay ;
	}
	
	public Evaluation getEvaluation(){
		return eval;
	}
	
	public void setReservationId(int reservationId){
		this.reservationId = reservationId;
	}
	
	public SimpleCalendar getFinalDay(){
		if (this.getReservationDate() == null) {
            return null;
        }

        if (this.getUser() == null) {
            return null;
        }
		SimpleCalendar date= this.getReservationDate().addDays(10);
		return date;
	}
	
	public void setEvaluation(Evaluation eval){
		this.eval = eval;
	}
	
	
	
	public void setHasPrePay(boolean hasPrePay){
		this.hasPrePay = hasPrePay;
	}
	
	public boolean getHasPrePay(){
		return hasPrePay;
	}
	
	public void setHasPay(boolean hasPay){
		this.hasPay = hasPay;
	}
	
	public boolean getHasPay(){
		return hasPay;
	}
	
	public void setPayment(){
		pay.setAmount(this.cruise.getCost());
		pay.setPrePaidAll(this.cruise.getPrePaidAll());
		pay.setFinalDayPrePayment(this.getFinalDay());
		pay.setPrePaidAmmount(this.cruise.getPrePaidAmount());
	}
    
    public int getReservationId() {
        return reservationId;
    }
	
	public int getPositionsReserved(){
		return positionsReserved;
	}
	
	public void setPositionsReserved(int positionsReserved){
		if(this.getCruise().getPositions()>=this.positionsReserved){
			this.positionsReserved = positionsReserved;
			
		}
		else{
			throw new CruiseException("There aren't so many available positions for the cruise!!!");
		}
	}
	
	public SimpleCalendar getReservationDate(){
		return reserveDate;
	}
	public Cruise getCruise(){
		return cruise;
	}
	public User getUser(){
		return user;
	}
	
	public void setReservationDate(SimpleCalendar reserveDate){
		this.reserveDate = reserveDate;
	}
	
	public void setCruise(Cruise cruise){
		this.cruise = cruise;
	}
	
	public void setUser(User user){
		if (this.user != null) {
            this.user.AllReservations().remove(this);
        }
        this.user = user;
        if (user != null) {
            this.user.AllReservations().add(this);
        }
		
	}
	
	
	
	
	public boolean isPrePaidValid(){
		if(getFinalDay() == null){			
			return false;
		}
		if(pay==null){
			return false;
		}
		if(this.cruise==null){
			return false;
		}
		if(this.cruise.getDepartureDate()==null){
			return false;
		}
		
		return pay.isPrePaidValid(this.cruise.getDepartureDate());
	}
	
	public boolean isPaidValid(){
		if(pay==null){
			return false;
		}
		if(this.cruise==null){
			return false;
		}
		if(this.cruise.getDepartureDate()==null){
			return false;
		}
	   return pay.isPaidValid(this.cruise.getDepartureDate());
	}
	
	public void cancelation(){
		int p = this.getCruise().getPositions();
		int pbefore = this.getPositionsReserved();
		this.getCruise().setPositions(p+pbefore);
		this.getUser().cancelReserve(this);
		
	}
	
	public boolean canEvaluate(){
		this.getCruise().State();
		if(this.getCruise().getState().equals(CruiseState.FINISH)){
			return true;
		}
		return false;
	}
	
	public Evaluation eval(){
		if(!this.canEvaluate()){
			return null;
		}
		Evaluation eval = new Evaluation();        	
		this.setEvaluation(eval);
        return eval;
	}
	
	
	
	@Override
	public String toString() {
        return String.valueOf(reservationId);
    }
}
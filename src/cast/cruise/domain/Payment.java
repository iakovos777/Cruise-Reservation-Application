package cast.cruise.domain;
import cast.cruise.util.SimpleCalendar;
import cast.cruise.util.SystemDate;
/**
 * Η πληρωμή.
 */
public class Payment{
	private static int count = 0;
	private String payId;
	private int amount;
	private boolean prePaidAll;
	private int prePaidAmmount;
	
	private SimpleCalendar finalDayPrePayment;
	
	
	public Payment(){
		this.payId ="#AB"+Integer.toString(count++);
		
	}
	
	public Payment(int amount, boolean prePaidAll, int prePaidAmmount, SimpleCalendar finalDayPrePayment){
		this.payId ="#AB"+Integer.toString(count++);
		this.amount= amount;
		this.prePaidAll = prePaidAll;
		this.prePaidAmmount = prePaidAmmount;
		this.finalDayPrePayment = finalDayPrePayment;
		
	}
	
	public void setAmount(int amount){
		this.amount =  amount;
	}
	
	public int getAmount(){
		return amount;
	}
	
	public String getPayId(){
		return payId;
	}
	
	public void setPayId(String payId){
		this.payId = payId;
	}
	

	
	public void setPrePaidAll(boolean prePaidAll){
		this.prePaidAll = prePaidAll;
	}
	
	public boolean getPrePaidAll(){
		return prePaidAll;
	}
	
	public void setPrePaidAmmount(int prePaidAmmount) {
        this.prePaidAmmount = prePaidAmmount;
    }

    
    public int getPrePaidAmmount() {
        return prePaidAmmount;
    }
	
	public void setFinalDayPrePayment(SimpleCalendar finalDayPrePayment){
		this.finalDayPrePayment = finalDayPrePayment;
	}
	
	public SimpleCalendar getFinalDayPrePayment(){
		return finalDayPrePayment;
	}
	
	public boolean isPrePaidValid(String depDate){
		if(this.getFinalDayPrePayment() == null){
			
			return false;
		}
		if(depDate== null){
			return false;
		}
		
		String[] parts = depDate.split("/");
		int y = Integer.parseInt(parts[2]);
		int d = Integer.parseInt(parts[0]);
		int m = Integer.parseInt(parts[1]);
		SimpleCalendar date2 = new SimpleCalendar(y,m,d);
		int k = date2.compareTo(SystemDate.now());
		
		int i = this.getFinalDayPrePayment().compareTo(SystemDate.now());
	
		if(i<0){
			return false;
			
			
		}
		if(k<=0){
			return false;
		}
		return true;
		
	}
	
	public boolean isPaidValid(String date){
		if(date== null){
			return false;
		}
		
		String[] parts = date.split("/");
		int y = Integer.parseInt(parts[2]);
		int d = Integer.parseInt(parts[0]);
		int m = Integer.parseInt(parts[1]);
		SimpleCalendar date2 = new SimpleCalendar(y,m,d);
		int i = date2.compareTo(SystemDate.now());
		if(i<=0){
			return false;
		}
		return true;
	
	}
}


package cast.cruise.service;


import cast.cruise.datastore.ReservationDS;
import cast.cruise.datastore.UserDS;

import cast.cruise.domain.Payment;
import cast.cruise.domain.Reservation;
import cast.cruise.domain.User;
import cast.cruise.exception.CruiseException;

import cast.cruise.memory.ReservationMemory;
import cast.cruise.memory.UserMemory;

public class PaymentService {
	private User user;
	private Reservation res;
    
    public Boolean findUser(int userNo) {
        UserDS userdata = new UserMemory();
        user = userdata.find(userNo);
        return user != null;
    }
    
    public Boolean findReserve(int resNo){
    	ReservationDS resdata = new ReservationMemory();
    	res = resdata.find(resNo);
    	return res!=null;
    }
    
public int pay(){
	ReservationDS resdata = new ReservationMemory();
    	if (user == null) {
            throw new CruiseException();
        }
    	if(res==null){
    		throw new CruiseException();
    	}
    	Payment payment = res.getPayment();
    	if(res.getHasPrePay()==true){
    		if(res.getHasPay()==false){
    			if(res.isPaidValid()){
    				res.setHasPay(true);
    				System.out.println("Successful  payment");
    				
        			return payment.getAmount();
    			}
    			else{
    				res.setHasPay(false);
    				System.out.println("You cannot  pay. Your reservation has canceled");
    				res.cancelation();
    				resdata.delete(res);
    				return 0;
    			}
    		}
    		else{
    			System.out.println("You have already pay ");
    			return 0;
    		}
    	}
    	else{
    		System.out.println("You cannot  pay. Your reservation has canceled ");
    		return 0;
    	}
        
    }

public int Prepay(){
	ReservationDS resdata = new ReservationMemory();
    	if (user == null) {
            throw new CruiseException();
        }
    	if(res==null){
    		throw new CruiseException();
    	}
    	Payment payment = res.getPayment();
    	if(res.getHasPrePay()==false){
    		if(res.isPrePaidValid()){
    			res.setHasPrePay(true);
    			payment.setAmount(payment.getAmount()-payment.getPrePaidAmmount());
    			return payment.getPrePaidAmmount();
    		}
    		else{
    			res.setHasPay(false);
    			System.out.println("You cannot  pay. Your reservation has canceled");
				res.cancelation();
				resdata.delete(res);
				return 0;
    		}
    	}
    	else{
    		return 0;
    	}
}
    
}

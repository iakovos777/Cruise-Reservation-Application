package cast.cruise.datastore;

import cast.cruise.contacts.Address;
import cast.cruise.contacts.CardElements;
import cast.cruise.contacts.EmailAddress;
import cast.cruise.datastore.CruiseDS;
import cast.cruise.datastore.EvaluationDS;
import cast.cruise.datastore.HostDS;
import cast.cruise.datastore.ReservationDS;
import cast.cruise.datastore.UserDS;
import cast.cruise.domain.Cruise;
import cast.cruise.domain.Host;

import cast.cruise.domain.User;


/**
 * Κλάση που αναλαμβάνει να αρχικοποιήσει τα δεδομένα της "βάσης δεδομένων"<p>
 * Βοηθητική κλάση που παρέχει δεδομένα για τα παραδείγματα και τις δοκιμασίες ελέγχου<p>
 
 */

public abstract class Data  {
    
   
    protected abstract void eraseData();
    
    
  
    
    public void readData() {
       
        eraseData();
        Address a = new Address();
        CardElements c = new CardElements();
        EmailAddress e = new EmailAddress("p123@gmail.com");
        c.setName("Papadopoulos");
        c.setCV("079");
        c.setExpireDate("06/19");
        c.setNumberCard("120812810821982");
        a.setCity("Pefki");
        a.setStreet("SKRA");
        a.setCountry("Greece");
        a.setNumber("5");
        a.setZipCode("14242");
        User u1 = new User(1,"Giorgos","Papadopoulos",2105668698,a,e,c,"123");
        User u2 = new User(2,"Takis","Petropoulos",2105668698,a,e,c,"165265162");
       
        
        a.setCity("Maroussi");
        a.setStreet("Lauriou");
        a.setCountry("Greece");
        a.setNumber("5");
        a.setZipCode("13232");
        e = new EmailAddress("p31@gmail.com");
        Host h1 = new Host(1,"Blue star",a,e,"17678676");
        
        a.setCity("Athens");
        a.setStreet("Strournari");
        a.setCountry("Greece");
        a.setNumber("12");
        a.setZipCode("12231");
        e = new EmailAddress("p3186hj@gmail.com");
        Host h2 = new Host(2,"Crystal",a,e,"712817bbh");
        
        e = new EmailAddress("cruise@gmail.com");
        Cruise cr1 = new Cruise(1,300,500,100,"25/06/2017","10/07/2017",15,"Rhodes","Venice","Beautiful cruise",false,e,h1,0);
        cr1.setHost(h1);
        e = new EmailAddress("fine@gmail.com");
        Cruise cr2 =  new Cruise(2,150,200,200,"15/06/2017","25/06/2017",1,"Crete","Corfu","Amazing cruise",true,e,h2,0);
        cr2.setHost(h2);
        cr1.available();
        cr2.available();
        h1.addCruise(cr1);
        h2.addCruise(cr2);
        
       
        
        getCruiseDS().save(cr1);
        getCruiseDS().save(cr2);
    	getHostDS().save(h1);
    	getHostDS().save(h2);
    	getUserDS().save(u1);
    	getUserDS().save(u2);
        
        
                                 
    }    
    
    
    protected abstract CruiseDS getCruiseDS();
	protected abstract HostDS getHostDS();
	protected abstract UserDS getUserDS();
	protected abstract ReservationDS getReservationDS();
	protected abstract EvaluationDS getEvaluationDS();
    
}

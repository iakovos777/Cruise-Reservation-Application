package cast.cruise.domain;

import java.util.HashSet;
import java.util.Set;

import cast.cruise.contacts.*;

/**
 * Ο διοργανωτής.
 */

public class Host {
	private int hostId;
    private String companyName;
	private Address companyAddress;
	private EmailAddress companyEmail;
	private String pwd;
	private Set<Cruise> cruises = new HashSet<Cruise>();
	

   
   public Host() { }

    
    public Host(int hostId,String companyName,  Address companyAddress, EmailAddress companyEmail, String pwd) {
        this.hostId =hostId;
    	this.companyName = companyName;
		this.companyAddress = companyAddress == null ? null : new Address(companyAddress);
		this.companyEmail = companyEmail;
		this.pwd = pwd ;
		
    }

    public void setHostId(int hostId) {
        this.hostId = hostId;
    }

   
    public int getHostId() {
        return hostId;
    }
    
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

   
    public String getPwd() {
        return pwd;
    }
    
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

   
    public String getCompanyName() {
        return companyName;
    }

    
   
	
	
	public void setCompanyAddress(Address companyAddress) {
        this.companyAddress = companyAddress == null ? null : new Address(companyAddress);
    }

    
    public Address getCompanyAddress() {
        return companyAddress == null ? null : new Address(companyAddress);
    }
	
	public void setCompanyEmail(EmailAddress companyEmail) {
        this.companyEmail = companyEmail;
    }

    
    public EmailAddress getCompanyEmail() {
        return companyEmail;
    }
	
	public Set<Cruise> getCruises() {
        return new HashSet<Cruise>(cruises);
    }
	
	 public void addCruise(Cruise cruise) {
        if (cruise != null) {
            cruise.setHost(this);
        }
    }

    
    public void removeCruise(Cruise cruise) {
        if (cruise != null) {
            cruise.setHost(null);
        }
    }
	Set<Cruise> AllCruises() {
        return cruises;
    }
}
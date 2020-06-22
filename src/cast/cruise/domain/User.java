package cast.cruise.domain;
import java.util.HashSet;
import java.util.Set;
import cast.cruise.contacts.*;
/**
 * Ο χρήστης
 */

public class User {
	private int userId;
	private String firstName;
	private String lastName;
	private int telephone;
	private Address address;
	private EmailAddress email;
	private CardElements card;
	private String password;
	private Set<Reservation> reserve = new HashSet<Reservation>();

	public User() {
	}

	public User(int userId,String firstName, String lastName, int telephone, Address address, EmailAddress email,
			CardElements card,String password) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephone = telephone;
		this.address = address == null ? null : new Address(address);
		this.email = email;
		this.card = card;
		this.password = password;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
	
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setAddress(Address address) {
		this.address = address == null ? null : new Address(address);
	}

	public Address getAddress() {
		return address == null ? null : new Address(address);
	}

	public void setEmail(EmailAddress email) {
		this.email = email;
	}

	public EmailAddress getEmail() {
		return email;
	}

	public void setCard(CardElements card) {
		this.card = card;
	}

	public CardElements getCard() {
		return card;
	}

	public Set<Reservation> getReserve() {
		return new HashSet<Reservation>(reserve);
	}

	public void addReserve(Reservation reservation) {
		if (reservation != null) {
			reservation.setUser(this);
			
		}
	}
	
	

	public void cancelReserve(Reservation reservation) {
		if (reservation != null) {
			reservation.setUser(null);
			reservation.setCruise(null);
		}
	}

	Set<Reservation> AllReservations() {
		return reserve;
	}

}
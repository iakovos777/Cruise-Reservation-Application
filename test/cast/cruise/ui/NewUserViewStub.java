package cast.cruise.ui;



import cast.cruise.contacts.Address;
import cast.cruise.contacts.CardElements;
import cast.cruise.contacts.EmailAddress;

import cast.cruise.ui.user.NewUserPresenter;
import cast.cruise.ui.user.NewUserView;

public class NewUserViewStub extends ViewStub implements NewUserView {

	private NewUserPresenter presenter ;
	private int usNo;
	private String firstname;
	private String lastname;
	private Address address;
	private EmailAddress email;
	private String pass;
	private CardElements crd;
	private int tel;

	@Override
	public void setPresenter(NewUserPresenter presenter) {
		this.presenter = presenter;
		
	}
	
	public NewUserPresenter getPresenter(){
		return presenter;
	}

	@Override
	public int getUserId() {
		return usNo;
	}

	@Override
	public void setUserId(int usNo) {
		this.usNo = usNo;
		
	}

	@Override
	public String getFirstName() {
		return firstname;
	}

	@Override
	public void setFirstName(String firstname) {
		this.firstname = firstname;
		
	}

	@Override
	public String getLastName() {
		
		return lastname;
	}

	@Override
	public void setLastName(String lastname) {
		this.lastname = lastname;
		
	}

	@Override
	public Address getAddress() {
		return address;
	}

	@Override
	public void setAddress(Address address) {
		this.address = address;
		
	}

	@Override
	public EmailAddress getEmail() {
		
		return email;
	}

	@Override
	public void setEmail(EmailAddress email) {
		this.email = email;
		
	}

	@Override
	public String getPassword() {
		
		return pass;
	}

	@Override
	public void setPassword(String pass) {
		this.pass = pass;
		
	}

	@Override
	public CardElements getCard() {
		return crd;
	}

	@Override
	public void setCard(CardElements crd) {
		this.crd = crd;
		
	}

	@Override
	public void setTelephone(int tel) {
		this.tel = tel;
		
	}

	@Override
	public int getTelephone() {
		return tel;
	}

}

package cast.cruise.ui;



import cast.cruise.contacts.Address;
import cast.cruise.contacts.EmailAddress;
import cast.cruise.ui.host.NewHostPresenter;
import cast.cruise.ui.host.NewHostView;

public class NewHostViewStub extends ViewStub implements NewHostView {

	private NewHostPresenter presenter ;
	private int HostNo;
	private String companyName;
	private EmailAddress email;
	private Address address;
	private String pwd;

	@Override
	public void setPresenter(NewHostPresenter presenter) {
		this.presenter = presenter;
		
	}
	
	public NewHostPresenter getPresenter(){
		return presenter;
	}

	@Override
	public int getHostId() {
		return HostNo;
	}

	@Override
	public void setHostId(int HostNo) {
		this.HostNo = HostNo;
		
	}

	@Override
	public String getCompanyName() {
		return companyName;
	}

	@Override
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
		
	}

	@Override
	public Address getCompanyAddress() {
		return address;
	}

	@Override
	public void setCompanyAddress(Address address) {
		this.address = address;
		
	}

	@Override
	public EmailAddress getCompanyEmail() {
		return email;
	}

	@Override
	public void setCompanyEmail(EmailAddress email) {
		this.email = email;
		
	}

	@Override
	public String getPwd() {
		return pwd;
	}

	@Override
	public void setPwd(String pwd) {
		this.pwd = pwd;
		
	}

}

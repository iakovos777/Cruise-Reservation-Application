package cast.cruise.ui;





import cast.cruise.contacts.EmailAddress;
import cast.cruise.ui.cruise.CruisePresenter;
import cast.cruise.ui.cruise.CruiseView;

public class CruiseViewStub extends ViewStub implements CruiseView {
	private CruisePresenter presenter;
	private int cruiseNo;
	private int positions;
	private String ap;
	private String dp;
	private String st;
	private String dst;
	private String dsc;
	private int cst;
	private int ppa;
	private int drt;
	private EmailAddress mail;
	private boolean all;
	
	@Override
	public void setPresenter(CruisePresenter presenter) {
		this.presenter=presenter;
		
	}
	
	public CruisePresenter getPresenter() {
		return presenter;
	}

	@Override
	public int getCruiseId() {
		
		return cruiseNo;
	}

	@Override
	public void setCruiseId(int cruiseNo) {
		this.cruiseNo = cruiseNo;
		
	}

	@Override
	public int getPositions() {
		
		return positions;
	}

	@Override
	public void setPositions(int positions) {
		this.positions = positions ;
		
	}

	@Override
	public String getDepartureDate() {
		return dp;
	}

	@Override
	public void setDepartureDate(String dp) {
		this.dp = dp;
		
	}

	@Override
	public String getArrivalDate() {
		return ap;
	}

	@Override
	public void setArrivalDate(String ap) {
		this.ap = ap;
		
	}

	@Override
	public String getStart() {
		return st;
	}

	@Override
	public void setStart(String st) {
		this.st = st;
		
	}

	@Override
	public String getDestination() {
		return dst;
	}

	@Override
	public void setDestination(String dst) {
		this.dst = dst;
		
	}

	@Override
	public String getDescription() {
		return dsc;
	}

	@Override
	public void setDescription(String dsc) {
		this.dsc = dsc;
		
	}

	@Override
	public int getCost() {
		return cst;
	}

	@Override
	public void setCost(int cst) {
		this.cst = cst;
		
	}

	@Override
	public int getPrePaidAmount() {
		return ppa;
	}

	@Override
	public void setPrePaidAmount(int ppa) {
		this.ppa = ppa;
		
	}

	@Override
	public int getDuration() {
		return drt;
	}

	@Override
	public void setDuration(int drt) {
		this.drt = drt ;
		
	}

	@Override
	public EmailAddress getEmail() {
		
		return mail;
	}

	@Override
	public void setEmail(EmailAddress mail) {
		this.mail = mail;
		
	}

	@Override
	public boolean getPrePaidAll() {
		return all ;
	}

	@Override
	public void setPrePaidAll(boolean all) {
		this.all = all;
		
	}

	
}

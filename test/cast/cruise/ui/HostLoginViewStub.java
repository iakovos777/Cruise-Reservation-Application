package cast.cruise.ui;





import cast.cruise.ui.host.HostLoginPresenter;
import cast.cruise.ui.host.HostLoginView;

public class HostLoginViewStub extends ViewStub implements HostLoginView  {
	private HostLoginPresenter presenter;
	private String pwd;
	private String cname;
	

	@Override
	public void setPresenter(HostLoginPresenter presenter) {
		this.presenter = presenter;
		
	}
	
	public HostLoginPresenter getPresenter(){
		return presenter;
	}

	@Override
	public String getPwd() {
		
		return pwd;
	}
	
	public void setPwd(String pwd){
		this.pwd = pwd;
	}

	@Override
	public String getCompanyName() {
		
		return cname;
	}
	
	public void setCompanyName(String cname){
		this.cname = cname;
	}

}

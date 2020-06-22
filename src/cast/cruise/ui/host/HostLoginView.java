package cast.cruise.ui.host;


import cast.cruise.ui.View;

public interface HostLoginView  extends View {
	
	 void setPresenter(HostLoginPresenter presenter);
     
	    
	    String getPwd();
	    String getCompanyName();

}

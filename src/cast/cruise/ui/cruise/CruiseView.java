package cast.cruise.ui.cruise;

import cast.cruise.contacts.EmailAddress;
import cast.cruise.ui.View;


public interface CruiseView extends View {
	void setPresenter(CruisePresenter presenter);
    int getCruiseId();
    void setCruiseId(int cruiseNo);
    int getPositions();
    void setPositions(int positions);
    String getDepartureDate();
    void setDepartureDate(String dp);
    String getArrivalDate();
    void setArrivalDate(String ap);
    String getStart();
    void setStart(String st);
    String getDestination();
    void setDestination(String dst);
    String getDescription();
    void setDescription(String dsc);
    int getCost();
    void setCost(int cst);
    int getPrePaidAmount();
    void setPrePaidAmount(int ppa);
    int getDuration();
    void setDuration(int drt);
    EmailAddress getEmail();
    void setEmail(EmailAddress mail);
    boolean getPrePaidAll();
    void setPrePaidAll(boolean all);
	
	
	
	
	
	
	
	
}

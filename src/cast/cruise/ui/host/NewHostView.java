package cast.cruise.ui.host;

import cast.cruise.contacts.Address;
import cast.cruise.contacts.EmailAddress;
import cast.cruise.ui.View;

public interface NewHostView extends View {
	void setPresenter(NewHostPresenter presenter);
    int getHostId();
    void setHostId(int HostNo);
    String getCompanyName();
    void setCompanyName(String companyName);
    Address getCompanyAddress();
    void setCompanyAddress(Address address);
    EmailAddress getCompanyEmail();
    void setCompanyEmail(EmailAddress email);
    String getPwd();
    void setPwd(String pwd);

}

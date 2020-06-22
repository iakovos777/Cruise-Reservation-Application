package cast.cruise.ui.user;

import cast.cruise.contacts.Address;
import cast.cruise.contacts.CardElements;
import cast.cruise.contacts.EmailAddress;
import cast.cruise.ui.View;
import cast.cruise.ui.user.NewUserPresenter;

public interface NewUserView extends View {
	void setPresenter(NewUserPresenter presenter);
    int getUserId();
    void setUserId(int usNo);
    String getFirstName();
    void setFirstName(String firstname);
    String getLastName();
    void setLastName(String lastname);
    Address getAddress();
    void setAddress(Address address);
    EmailAddress getEmail();
    void setEmail(EmailAddress email);
    String getPassword();
    void setPassword(String pass);
    CardElements getCard();
    void setCard(CardElements crd);
    void setTelephone(int tel);
    int getTelephone();

}

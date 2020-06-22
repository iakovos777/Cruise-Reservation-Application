package cast.cruise.datastore;

import java.util.List;

import cast.cruise.contacts.EmailAddress;
import cast.cruise.domain.User;

public interface UserDS {
	User find(int userNo);
    
    User Login(EmailAddress email, String pass );
    void save(User entity);
    
    
    void delete(User entity);
    
   
    List<User> findAll();

}

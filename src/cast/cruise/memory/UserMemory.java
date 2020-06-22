package cast.cruise.memory;

import java.util.ArrayList;
import java.util.List;

import cast.cruise.contacts.EmailAddress;
import cast.cruise.datastore.UserDS;

import cast.cruise.domain.User;

public class UserMemory implements UserDS {
	protected static List<User> entities = new ArrayList<User>();
	
	@Override
	public User find(int userNo) {
		for(User user : entities) {
            if (user.getUserId() == userNo ) {
                return user;
            }
        }
		return null;
	}

	@Override
	public void save(User entity) {
		if (! entities.contains(entity)) {
            entities.add(entity);    
        } 

	}
	
	@Override
	public User Login(EmailAddress email, String pass){
		for(User user : entities) {
            if ((user.getEmail().toString().equals(email.toString())  ) && (user.getPassword().equals(pass) )  ) {
                return user;
            }
        }
		return null;
	}

	@Override
	public void delete(User entity) {
		entities.remove(entity);

	}

	@Override
	public List<User> findAll() {
		
		return new ArrayList<User>(entities);
	}

}

package co.dev.dao;
import java.util.List;

import co.dev.beans.User;
public interface UserDao {
	
		public void saveUser ( User user );
		public List<User> getUsers();

		

}

package co.dev.dao;
import java.util.List;

import co.dev.beans.User;
public interface UserDao {
	
		public void saveUser (User user);
		public List<User> getUsers();
		public void editUser (User user);
		public void deleteUser (int id);
	
		public User getUserById(int id);

}

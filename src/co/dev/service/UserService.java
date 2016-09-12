package co.dev.service;

import java.util.List;

import co.dev.beans.User;

public interface UserService {
	  public void addUser(User user);
	    public List<User> getUsers();
	    public void editUser (User user);
		public void deleteUser (int id);
		public User getUserById(int id);
}

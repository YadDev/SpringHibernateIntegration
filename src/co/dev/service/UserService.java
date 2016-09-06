package co.dev.service;

import java.util.List;

import co.dev.beans.User;

public interface UserService {
	  public void addUser(User user);
	    public List<User> getUsers();

}

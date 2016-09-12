package co.dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.dev.beans.User;
import co.dev.dao.UserDao;


@Service
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	@Override
	public void addUser(User user) {
		userDao.saveUser(user);
		
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userDao.getUsers();
	}

	@Override
	public void editUser(User user) {
				userDao.editUser(user);
		
	}
 
	@Override
	public void deleteUser(int id) {
		userDao.deleteUser(id);
		
	}

	@Override
	public User getUserById(int id) {
		
		return userDao.getUserById(id);
	}

}

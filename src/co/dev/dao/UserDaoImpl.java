package co.dev.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.dev.beans.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory session;
	
	
	@Override
	@Transactional
	public void saveUser(User user) {
		session.getCurrentSession().saveOrUpdate(user);
	}

	@Override
	public List<User> getUsers() {
		@SuppressWarnings("unchecked")
		List<User> listUser=session.getCurrentSession().createCriteria(User.class).list();
	
		return listUser;
	}
	

}

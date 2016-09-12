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
		session.getCurrentSession().save(user);
	}

	@Override
	public List<User> getUsers() {
		@SuppressWarnings("unchecked")
		List<User> listUser=session.getCurrentSession().createCriteria(User.class).list();
	
		return listUser;
	}

	@Override
	@Transactional
	public void editUser(User user) {
		try{
			System.out.println("In Update Query");
			session.getCurrentSession().update(user);	
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteUser(int id) {
		session.getCurrentSession().createQuery("DELETE FROM User WHERE user_id ="+id).executeUpdate();
	}

	@Override
	public User getUserById(int id) {
		User user=(User) session.getCurrentSession().get(User.class,id);
		return user;
	}

	

	
	

}

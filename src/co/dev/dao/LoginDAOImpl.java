package co.dev.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.dev.beans.Login;

@Repository
public class LoginDAOImpl implements LoginDAO {
	
	
	@Autowired
	private SessionFactory session;
	
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public boolean userAuth(String uName, String pass) {
		
		//String hql="from Login where username='"+uName+"' and password='"+pass+"'";
		System.out.println("Form data on Login DAO Impl Page is: "+ uName+" and password: "+pass);
		//Login users = new Login();	
		List<Login> listUser=session.getCurrentSession().createQuery("from Login").list();
			System.out.println("Data is: "+listUser.size());
			if(listUser.size()>0)
			{
				System.out.println("User Name from Database is :" +listUser.get(0).getuName()+" and password is : "+listUser.get(0).getPass());
			
				if(uName.equals(listUser.get(0).getuName()) && pass.equals(listUser.get(0).getPass()))
				{
					
					return true;
				}
				else 
				{
					return false;
				}
				
			}
			else 
			{
				return false;
			}
	}

}

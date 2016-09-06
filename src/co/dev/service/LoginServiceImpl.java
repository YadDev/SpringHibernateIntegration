package co.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.dev.dao.LoginDAO;

@Service
@Transactional

public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDAO loginDao;

	@Override
	
	@Transactional
	public boolean userAuth(String uName, String pass) {
		System.out.println("Form data on Login Service Impl Page is: "+ uName+" and password: "+pass);
		return loginDao.userAuth(uName, pass);
	}
}

package co.dev.service;

import co.dev.beans.RegisterUser;

public interface LoginService {
	public boolean userAuth(String uName,String pass);
	public void registerUser (RegisterUser register);
	public int activateUser (String userid,String pass);
}

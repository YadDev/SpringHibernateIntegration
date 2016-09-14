package co.dev.dao;

import co.dev.beans.RegisterUser;



public interface LoginDAO {
	public boolean userAuth(String uName,String pass);
	public void registerUser (RegisterUser register);
	public int activateUser (String userid,String pass);
}

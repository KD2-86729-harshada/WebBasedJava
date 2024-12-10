package com.sunbeam.bean;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImpl;
import com.sunbeam.entities.User;

public class LoginBean {
	private String email;
	private String password;
	private User user;

	public LoginBean() {
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void authenticate() {
		try(UserDao userdao = new UserDaoImpl())
		{
			User dbUser = userdao.findByEmail(this.email);
			if(dbUser != null && dbUser.getPassword().equals(this.password)) 
			{
				this.user = dbUser;
			}
			else {
				this.user = null;
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}


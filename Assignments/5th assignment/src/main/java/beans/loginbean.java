package beans;

import daos.UserDao;
import daos.UserDaoImpl;
import entities.User;

public class loginbean {
	private String email;
	private String passwd;
	private User user;
	
	public loginbean() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public void authenticate() {
		try(UserDao userDao = new UserDaoImpl()) {
			User dbUser = userDao.findByEmail(this.email);
			if(dbUser != null && dbUser.getPassword().equals(this.passwd))
				this.user = dbUser;
			else
				this.user = null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}

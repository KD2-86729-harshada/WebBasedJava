package beans;

import java.sql.Date;

import daos.UserDao;
import daos.UserDaoImpl;
import entities.User;

public class registerbin {
   private String fname;
   private String lname;
   private String email;
   private String pass;
   private int status;
   private String dob;
   private String role;
   private int result;
   
   

public registerbin() {
	
	
}


public registerbin(int status, String role) {
	this.status=0;
	this.role="voter";
}


public registerbin(String fname, String lname, String email, String pass, String dob, int result) {
	super();
	this.fname = fname;
	this.lname = lname;
	this.email = email;
	this.pass = pass;
	this.dob = dob;
	this.result = result;
}


public String getFname() {
	return fname;
	
}
public void setFname(String fname) {
	this.fname = fname;
	
}
public String getLname() {
	return lname;
	
}

public void setLname(String lname) {
	this.lname = lname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
public String getDob() {
	return dob;
}

public void setDob(String dob) {
	this.dob = dob;
}

   



public int getResult() {
	return result;
}
public void setResult(int result) {
	this.result = result;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}


public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}


public void adddata() {
	
	Date d=Date.valueOf(dob);
	
	
   try(UserDao u=new UserDaoImpl() ){

		User us = new User(0, fname, lname, email, pass, d, status, role);
		this.result = u.save(us);
		
   } catch (Exception e) {
	
	e.printStackTrace();
}

}
   
   
}

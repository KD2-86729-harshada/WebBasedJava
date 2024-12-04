package com.sunbeam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.startup.PasswdUserDatabase;

import com.sunbeam.dao.UserDaoImpl;
import com.sunbeam.entities.User;
import com.sunbeam.dao.UserDao;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("inside do get");
		processRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("inside do post");
		processRequest(req, resp);
	}
	
	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String FirstName = req.getParameter("firstName");
		String LastName = req.getParameter("lastName");
		String Email = req.getParameter("email");
		String password = req.getParameter("password");
		String DateOfBirth = req.getParameter("DOB");
		Date DOB = Date.valueOf(DateOfBirth);
		int Status = 0;
		String Role = "voter";
		int count = 0;
		
		User user = new User(0, FirstName, LastName, Email, password, DOB, Status, Role);
//		System.out.println(user);
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Registeration Page</title>");
		out.println("</head>");
		out.println("<body>");
		
		try(UserDao userdao = new UserDaoImpl()){
				
					if(FirstName.length()==0) {
						out.println("<p>First name cannot be blanck</p>");
					}
					else if(LastName.length()==0) {
						out.println("<p>Last name cannot be blanck</p>");
					}
					else if(Email.length()==0) {
						out.println("<p>Email cannot be blanck</p>");
					}
					else if(password.length()==0) {
						out.println("<p>Password cannot be blanck</p>");
					}
					else if(DateOfBirth.length()==0) {
						out.println("<p>Date of birth cannot be blanck</p>");
					}
					
					count = userdao.save(user);
					System.out.println(count+"details");
					if(count > 0) {
					
						out.println("<h2>User added successfully!!! Sign In here to see candidate list</h2>");
					
					out.println("<p><a href='index.html'>Sign In</a></p>");	
			}
			else {
				out.println("<h2>Registeration Failed</h2>");
				out.println("<p>Sorry, something gets wrong</p>");
				out.println("<p><a href ='newuser.html'> Register-Again</a></p>");
				out.println("</body>");
				out.println("</html>");
			}
		}
		catch(Exception e){
			e.printStackTrace();
			throw new ServletException();
		}
		
	}
}

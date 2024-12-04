package com.sunbeam.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImpl;
import com.sunbeam.entities.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("inside do get of login");
		processRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String password = req.getParameter("passwd");
		
		try (UserDao userdao = new UserDaoImpl()){
			User dbUser = userdao.findByEmail(email);
			if(dbUser != null && dbUser.getPassword().equals(password)) {
				
				Cookie c1 = new Cookie("uname", dbUser.getFirstName());
				c1.setMaxAge(4000);
				resp.addCookie(c1);
				
				Cookie c2 = new Cookie("urole", dbUser.getRole());
				c2.setMaxAge(4000);
				resp.addCookie(c2);
				
				if(dbUser.getRole().equals("admin")) {
//					resp.sendRedirect("result");
					RequestDispatcher rd = req.getRequestDispatcher("result");
					rd.forward(req, resp);
				}
				else {
					resp.sendRedirect("candlist");
				}
			}
			else {
				resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Login Page</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h2>Login Failed</h2>");
				out.println("<p>Sorry, Invalid name or password</p>");
				out.println("<p><a href ='index.html'> Login-Again</a></p>");
				out.println("</body>");
				out.println("</html>");
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}

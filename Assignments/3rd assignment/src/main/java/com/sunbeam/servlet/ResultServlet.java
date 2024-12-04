package com.sunbeam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.dao.CandidateDao;
import com.sunbeam.dao.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

@WebServlet("/result")
public class ResultServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		processRequest(req, resp);
	};
	
	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		
		List<Candidate> list = new ArrayList<Candidate>();
		
		try(CandidateDao candao = new CandidateDaoImpl()){
			
			list = candao.findAll();
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		ServletContext cont = this.getServletContext();
		String color = cont.getInitParameter("app.color");
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Result</title>");
		out.println("</head>");
		out.printf("<body bgcolor='%s'>",color);
		
		ServletContext app = this.getServletContext();
		String appTitle = app.getInitParameter("app.title");
		out.printf("<h1>%s</h1>", appTitle);
		
		Cookie [] arr = req.getCookies();
		String username =" ", role =" ";
		if(arr != null) {
			for(Cookie c : arr) {
				if(c.getName().equals("uname")){
					username = c.getValue();
				}
				if(c.getName().equals("urole")) {
					role = c.getValue();
				}
			}
		}
		out.printf("Hello, %s(%s)<hr>\n", username, role);
		
		ServletContext ctx = this.getServletContext();
		String ann = (String) ctx.getAttribute("announcement");
		if(ann != null)
			out.println("<p style='color:red'> NOTE: " + ann + "</p>");
		
		out.println("<h2>Voting Result</h2>");
		out.println("<table border='1'>");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th>Id</th>");
		out.println("<th>Name</th>");
		out.println("<th>Party</th>");
		out.println("<th>Votes</th>");
		out.println("<th>Action</th>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");
		
		for(Candidate c : list) {
			out.println("<tr>");
			out.printf("<td>%d</td>\n", c.getId());
			out.printf("<td>%s</td>\n", c.getName());
			out.printf("<td>%s</td>\n", c.getParty());
			out.printf("<td>%d</td>\n", c.getVotes());
//			out.printf("<td></td>\n");
			out.printf("<td>\n");
			
//			out.printf("<a href='editcand?id=%d'>Edit</a>\n", c.getId());
//			out.printf("<a href='delcand?id=%d'>Delete</a>\n", c.getId());
			
			out.printf("<a href='editcand?id=%d'><img src='images/edit.png' alt='Edit' width='24' height='24'/></a>\n", c.getId());
			out.printf("<a href='delcand?id=%d'><img src='images/delete.png' alt='Delete' width='24' height='24'/></a>\n", c.getId());
			
			out.printf("</td>\n");
			out.println("</tr>");
		
		}
		out.println("</tbody>");
		out.println("</table>");
		String message = (String)req.getAttribute("msg");
		
		if(message != null)
			out.println("<p>" + message + "</p>");
		
		out.println("<p><a href='newcandidate.html'>Add-candidate</a></p>");
//		out.println("<p><a href='logout'>Sign Out</a></p>");
		out.println("<p><a href='announcment.html'>Announcment</a> | <a href='logout'>Sign Out</a></p>");
		out.println("</body>");
		out.println("</html>");
		}
}

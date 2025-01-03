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

@WebServlet("/candlist")
public class CandidateServletList extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		
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
		out.println("<title>Candidate List</title>");
		out.println("</head>");
		out.printf("<body bgcolor='%s'>",color);
		
		ServletContext app = this.getServletContext();
		String appTitle = app.getInitParameter("app.title");
		out.printf("<h1>%s</h1>", appTitle);
		
		Cookie [] arr = req.getCookies();
		String username =" ", role=" ";
		if(arr != null) {
			for(Cookie c: arr) {
				if(c.getName().equals("uname"))
						username = c.getValue();
				if(c.getName().equals("urole"))
						role = c.getValue();
			}
		}
		out.printf("Hello, %s (%s)<hr/>\n", username, role);
		
		ServletContext ctx = this.getServletContext();
		String ann = (String) ctx.getAttribute("announcement");
		if(ann != null)
			out.println("<p style='color:red'> NOTE: " + ann + "</p>");
		
		out.println("<h2>Candidate List</h2>");
		out.println("<form method='post' action='vote'>");
		for(Candidate c : list) {
			out.printf("<input type='radio' name='candidate', value='%d'/> %s <br/>\n", c.getId(), c.getName());
		}
		out.println("<br/> <input type='submit', value='vote'/>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
	}
}

package com.sunbeam.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.dao.CandidateDao;
import com.sunbeam.dao.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

@WebServlet("/add-candidate")
public class AddCandidateServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String party = req.getParameter("party");
		
		Candidate can = new Candidate(0,name, party, 0);
		System.out.println(can+"canidate details");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>add-candidate</title>");
		out.println("</head>");
		out.println("<body>");
	
		try(CandidateDao candao = new CandidateDaoImpl()){
			int count = candao.save(can);
			if(count > 0) {
				out.println("<h1> Candidate added successfully </h1>");
			}
			else {
				out.println("<h2>Adding candidate failed</h2>");
				out.println("<p>Something went wrong!! try again!!</p>");
				out.println("<a href='add-candidate'>Add-candidate</a>");
				out.println("</body>");
				out.println("</html>");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new ServletException();
		}
//		out.println("<p>click here to see candidate List</p>");
//		out.println("<p><a href='candlist'>candidate-list</a></p>");
		
	}
}

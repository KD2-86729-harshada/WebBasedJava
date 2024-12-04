package com.sunbeam.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.dao.CandidateDao;
import com.sunbeam.dao.CandidateDaoImpl;

@WebServlet("/delcand")
public class DeleteCandidateServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String canId = req.getParameter("id");
		int id = Integer.parseInt(canId);
		
		try(CandidateDao candao = new CandidateDaoImpl()){
			int count = candao.deleteById(id);
			String message = "Candidates Deleted: " + count;
			req.setAttribute("msg", message);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("result");
		rd.forward(req, resp);
	}
}

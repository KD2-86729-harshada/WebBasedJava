package assign1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Profile</title>");
		out.println("</head>");
//		out.println("<style text-align='center'></style>");
		out.println("<body text-align='center', bgcolor='pink'>");
		out.println("<h1>Profile</h1>");
		out.println("<p>First Name: Harshada</p>");
		out.println("<p>Last Name: Patil</p>");
		out.println("<p>Qualification : B.tech</p>");
		out.println("<p>Collage : Bharti Vidyapeeth Collage of Engineering Kolhapur</p>");
		out.println("<p>Birth Date : 29/10/2002</p>");
	}
}

package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.Friend;
import Services.Message;

public class Search extends HttpServlet{
	
	public Search() {}
	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
	{
		// nom prenom login password
		String login = request.getParameter("mot");
		response.setContentType("application/json");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		out.print(Friend.search(login));
		out.flush();
		
	}
}

package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.User;

public class Logout extends HttpServlet{
	public Logout() {}
	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
	{
		String login = request.getParameter("login");
		String key = request.getParameter("clef");
		response.setContentType("application/json");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		out.print(User.logout(login, key));
		out.flush();
		
	}
}

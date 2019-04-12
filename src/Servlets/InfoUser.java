package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Services.User;
import Tools.UserTools;
	
public class InfoUser extends HttpServlet{
	public InfoUser() {}
	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
	{
		String login = request.getParameter("login");
		response.setContentType("application/json");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		out.print(UserTools.InfoUsers(login));
		out.flush();
			
	}
}
	


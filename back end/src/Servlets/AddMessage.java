package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.Friend;
import Services.Message;

public class AddMessage extends HttpServlet{
	public AddMessage() {}
	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
	{
		// nom prenom login password
		String myLogin = request.getParameter("My_login");
		String key = request.getParameter("key");
		String message = request.getParameter("message");
		response.setContentType("application/json");
		PrintWriter out = null;
		try { 
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		out.print(Message.addMessage(myLogin, key, message));
		out.flush();
		
	}
}

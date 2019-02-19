package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.Friend;
import Services.Message;

public class ListFriends extends HttpServlet{
	
	public ListFriends() {}
	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
	{
		// nom prenom login password
		String login = request.getParameter("Login");
		String key = request.getParameter("key");
		response.setContentType("application/json");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		out.print(Friend.listFriends(login));
		out.flush();
		
	}
}


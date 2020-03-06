package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.Friend;
import Services.Message;

public class DeleteMessage extends HttpServlet{
	public DeleteMessage() {}
	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
	{
		// nom prenom login password
		String myLogin = request.getParameter("My_login");
		String key = request.getParameter("key");
		String MessageId = request.getParameter("MessageId");
		response.setContentType("application/json");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		out.print(Message.deleteMessage(myLogin, key, MessageId));
		out.flush();
		
	}
}

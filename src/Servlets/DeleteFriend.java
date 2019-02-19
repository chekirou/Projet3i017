package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.Friend;

public class DeleteFriend extends HttpServlet{
	public DeleteFriend() {}
	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
	{
		// nom prenom login password
		String myLogin = request.getParameter("My_login");
		String key = request.getParameter("key");
		String hisLogin = request.getParameter("His_Login");
		response.setContentType("application/json");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		out.print(Friend.unFriend(myLogin, key, hisLogin));
		out.flush();
		
	}
}
